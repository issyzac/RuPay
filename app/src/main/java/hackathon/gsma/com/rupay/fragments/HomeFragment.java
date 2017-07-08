package hackathon.gsma.com.rupay.fragments;

/**
 * Created by issy on 7/8/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.UUID;

import hackathon.gsma.com.rupay.MainActivity;
import hackathon.gsma.com.rupay.R;
import hackathon.gsma.com.rupay.api.ApiServices;
import hackathon.gsma.com.rupay.datasets.BalanceResponce;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static hackathon.gsma.com.rupay.utils.Constants.BASE_URL;
import static hackathon.gsma.com.rupay.utils.Constants.HOST;

/**
 * Created by issy on 9/28/16.
 */

public class HomeFragment extends Fragment{

    private TextView firstName, welcomeText, clicktoScan, clicktppay, mlipeTitle, mlipeName, amountTitle, pinTitle, balanceTitle,balanceAmount;
    private EditText amountValue;

    private IntentIntegrator qrScan;

    public static final String TAG = "GSMAHACKATHON";

    private LinearLayout issuePaymentWrap;
    private RelativeLayout welcomeWrap;

    //API Call Services Declaration
    private Retrofit retrofit;
    private ApiServices apiServices;

    //Mobile Money Accounts
    private String mechantAccountNumber;
    private String mechantName;
    private String customerMSISDN = "688089603";

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView;
        rootView    = inflater.inflate(R.layout.fragment_home, container, false);
        setUpView(rootView);
        upServices();

        String  uniqueID = UUID.randomUUID().toString();


        Call<BalanceResponce> getBalance = apiServices.getMsisdnBalance(customerMSISDN);
        getBalance.enqueue(new Callback<BalanceResponce>() {
            @Override
            public void onResponse(Call<BalanceResponce> call, Response<BalanceResponce> response) {
                try {
                    BalanceResponce balanceResponce = response.body();
                    balanceAmount.setText(balanceResponce.getAmount()+" "+balanceResponce.getCurrency());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<BalanceResponce> call, Throwable t) {

            }
        });

        //intializing scan object
        qrScan = new IntentIntegrator(HomeFragment.this.getActivity());

        clicktoScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicking");
                qrScan.setBeepEnabled(false).setBarcodeImageEnabled(true).forSupportFragment(HomeFragment.this).initiateScan();
            }
        });

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "handling results");
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            Log.d(TAG, "results not null");
            Log.d(TAG, "results"+result.getContents());
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(HomeFragment.this.getActivity(), "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    Log.d(TAG, obj.toString());
                    firstName.setText(obj.getString("name"));

                    setPaymentEnviroment();

                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(HomeFragment.this.getActivity(), result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void setPaymentEnviroment(){
        clicktoScan.setVisibility(View.GONE);
        clicktppay.setVisibility(View.VISIBLE);
        welcomeWrap.setVisibility(View.GONE);
        issuePaymentWrap.setVisibility(View.VISIBLE);
    }

    private void setUpView(View v){

        balanceTitle = (TextView) v.findViewById(R.id.balance_title);
        balanceTitle.setTypeface(MainActivity.Roboto_BoldCondensedItalic);

        balanceAmount = (TextView) v.findViewById(R.id.balance);
        balanceAmount.setTypeface(MainActivity.Avenir_Light);

        pinTitle = (TextView) v.findViewById(R.id.pin_title);
        pinTitle.setTypeface(MainActivity.Roboto_BoldCondensedItalic);

        mlipeTitle = (TextView) v.findViewById(R.id.mlipe_title);
        mlipeTitle.setTypeface(MainActivity.Roboto_BoldCondensedItalic);

        mlipeName = (TextView) v.findViewById(R.id.mlipe_names);
        mlipeName.setTypeface(MainActivity.Avenir_Light);

        amountTitle = (TextView) v.findViewById(R.id.kiasi_title);
        amountTitle.setTypeface(MainActivity.Roboto_BoldCondensedItalic);

        amountValue = (EditText) v.findViewById(R.id.mlipe_amount);
        amountValue.setTypeface(MainActivity.Avenir_Light);

        issuePaymentWrap = (LinearLayout) v.findViewById(R.id.issue_pay_wrap);
        issuePaymentWrap.setVisibility(View.GONE);
        welcomeWrap = (RelativeLayout) v.findViewById(R.id.welcome_wrap);
        welcomeWrap.setVisibility(View.VISIBLE);

        clicktppay = (TextView) v.findViewById(R.id.pay);
        clicktppay.setTypeface(MainActivity.Roboto_Condensed);
        clicktppay.setVisibility(View.GONE);

        firstName = (TextView) v.findViewById(R.id.fname);
        firstName.setTypeface(MainActivity.Avenir_Light);

        clicktoScan = (TextView) v.findViewById(R.id.scan_to_pay);
        clicktoScan.setTypeface(MainActivity.Roboto_Condensed);
        clicktoScan.setVisibility(View.VISIBLE);

        welcomeText = (TextView) v.findViewById(R.id.welcome_text);
        welcomeText.setTypeface(MainActivity.Avenir_Light);

    }

    private void upServices(){
        retrofit = new Retrofit.Builder()
                .baseUrl(HOST+BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiServices = retrofit.create(ApiServices.class);
    }

}
