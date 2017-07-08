package hackathon.gsma.com.rupay.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hackathon.gsma.com.rupay.R;

/**
 * Created by issy on 7/8/17.
 */

public class SavedFragment extends Fragment{

    public SavedFragment() {
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
        rootView    = inflater.inflate(R.layout.fragment_saved, container, false);

        setUpView(rootView);

        return rootView;
    }

    public void setUpView(View v){

    }

}
