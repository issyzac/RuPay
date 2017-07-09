package hackathon.gsma.com.rupay.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import hackathon.gsma.com.rupay.R;
import hackathon.gsma.com.rupay.adapter.StatementAdapter;
import hackathon.gsma.com.rupay.api.ApiServices;
import hackathon.gsma.com.rupay.datasets.StatementData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static hackathon.gsma.com.rupay.utils.Constants.BASE_URL;
import static hackathon.gsma.com.rupay.utils.Constants.HOST;

public class Statements extends AppCompatActivity {

    RecyclerView recyclerView;
    private String customerMSISDN = "688089603";
    private Handler dataBootstrapHandler;

    private ApiServices apiServices;

    StatementData statementData;

    //Network Constants
    private Retrofit retrofit;
    //Constants
    private String searchQuery = "";
    private static final String TAG = Statements.class.getSimpleName();


    ArrayList<StatementData> statementDataArrayList = new ArrayList<>();
    StatementAdapter statementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Creating Retrofit Instance



        getData();

        recyclerView = (RecyclerView)findViewById(R.id.list_item);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        statementAdapter = new StatementAdapter(this,statementDataArrayList);
        recyclerView.setAdapter(statementAdapter);


    }


    public void getData(){

//        Call<ResponseBody> getStatements = apiServices.getStatement(customerMSISDN);
//        getStatements.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if(response.isSuccessful()){
//                    try {
//                        initializeData(response.body().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }else{
//                    //
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });

        statementDataArrayList.clear();
        statementData = new StatementData("Tsh. 100", "MP170708C00114", "0780900745");
        statementDataArrayList.add(statementData);

        statementData = new StatementData("Tsh. 500", "MP170708C00113", "0780900745");
        statementDataArrayList.add(statementData);

        statementData = new StatementData("Tsh. 100", "MP170708C00112", "0780900745");
        statementDataArrayList.add(statementData);

    }





}
