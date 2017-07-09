package hackathon.gsma.com.rupay.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import hackathon.gsma.com.rupay.MainActivity;
import hackathon.gsma.com.rupay.R;
import hackathon.gsma.com.rupay.ui.Statements;

/**
 * Created by issy on 7/8/17.
 */

public class AccountFragment extends Fragment{

    EditText mName, mNumber, mPin;
    TextView mSave, mTitle,mTransaction;
    LinearLayout mTransactionBtn;

    ImageView mEditBtn, mCheckBtn;



    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView;
        rootView    = inflater.inflate(R.layout.fragment_account, container, false);

        setUpView(rootView);

        mName = (EditText)rootView.findViewById(R.id.fname);
        mNumber = (EditText)rootView.findViewById(R.id.number);
        mPin = (EditText)rootView.findViewById(R.id.pin);



        mName.setFocusableInTouchMode(false);
        mNumber.setFocusableInTouchMode(false);
        mPin.setFocusableInTouchMode(false);

        mName.setEnabled(false);
        mName.setFocusable(false);

        mNumber.setEnabled(false);
        mNumber.setFocusable(false);

        mPin.setEnabled(false);
        mPin.setFocusable(false);



        mEditBtn = (ImageView)rootView.findViewById(R.id.edit_icon);
        mCheckBtn = (ImageView)rootView.findViewById(R.id.check_icon);

        mEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mName.setEnabled(true);
                mName.setFocusable(true);

                mNumber.setEnabled(true);
                mNumber.setFocusable(true);

                mPin.setEnabled(true);
                mPin.setFocusable(true);

                mName.setFocusableInTouchMode(true);
                mNumber.setFocusableInTouchMode(true);
                mPin.setFocusableInTouchMode(true);
                mCheckBtn.setVisibility(rootView.VISIBLE);
                mEditBtn.setVisibility(rootView.INVISIBLE);
            }
        });

        mCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mName.setEnabled(false);
                mName.setFocusable(false);

                mNumber.setEnabled(false);
                mNumber.setFocusable(false);

                mPin.setEnabled(false);
                mPin.setFocusable(false);

                mName.setFocusableInTouchMode(false);
                mNumber.setFocusableInTouchMode(false);
                mPin.setFocusableInTouchMode(false);
                mCheckBtn.setVisibility(rootView.INVISIBLE);
                mEditBtn.setVisibility(rootView.VISIBLE);

            }
        });



        mTransactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Statements.class));
            }
        });

        return rootView;
    }

    public void setUpView(View v){


        mName = (EditText)v.findViewById(R.id.fname);
        mName.setTypeface(MainActivity.Avenir_Light);
        mNumber = (EditText)v.findViewById(R.id.number);
        mNumber.setTypeface(MainActivity.Avenir_Light);
        mPin = (EditText)v.findViewById(R.id.pin);
        mPin.setTypeface(MainActivity.Avenir_Light);

        mSave = (TextView)v.findViewById(R.id.save_btn);
        mSave.setTypeface(MainActivity.Avenir_Light);

        mTitle = (TextView)v.findViewById(R.id.title);
        mTitle.setTypeface(MainActivity.Avenir_Light);

        mTransaction = (TextView)v.findViewById(R.id.transac_btn);
        mTransaction.setTypeface(MainActivity.Avenir_Light);

        mTransactionBtn = (LinearLayout)v.findViewById(R.id.transac_layout_btn);


    }

}
