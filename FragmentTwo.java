package com.abmcollegeattenzin.nyima.messagepassing;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentTwo extends Fragment {

    FragmentTwoBroadCast fragmentTwoBroadCast;
    Button fragBbuttonActivity, fragBbuttonFragment;
    EditText frag2edt;

    TextView tv;

    public FragmentTwo() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        fragBbuttonActivity = (Button) view.findViewById(R.id.fragBbuttonActivity);
        fragBbuttonFragment = view.findViewById(R.id.fragBbuttonFragment);
        frag2edt = view.findViewById(R.id.fragBeditText);
        tv = view.findViewById(R.id.tvFragB);

        fragBbuttonActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = frag2edt.getText().toString();
                fragmentTwoBroadCast.twoBroadCast(message);
            }
        });

        fragBbuttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = frag2edt.getText().toString();
                fragmentTwoBroadCast.twoBroadCast(message);
            }
        });

        return view;
    }

    public interface FragmentTwoBroadCast{
        public void twoBroadCast(String message);
    }

    public void updateTextView(String message){
        tv.setText(message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        fragmentTwoBroadCast = (FragmentTwo.FragmentTwoBroadCast) activity;
    }

}