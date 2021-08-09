package com.abmcollegeattenzin.nyima.messagepassing;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class FragmentOne extends Fragment {

    FragmentOneBroadCast fragmentOneBroadCast;

    TextView tv;
    EditText fragAedt;
    Button fragAbutton, fragAbutton2;

    public FragmentOne() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_one, container, false);

        tv = view.findViewById(R.id.tvFragA);
        fragAedt = view.findViewById(R.id.fragAeditText);
        fragAbutton = view.findViewById(R.id.fragAbutton);
        fragAbutton2 = view.findViewById(R.id.fragAbutton2);

        fragAbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message  = fragAedt.getText().toString();
                fragmentOneBroadCast.oneBroadCast(message);
            }
        });

        fragAbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message  = fragAedt.getText().toString();
                fragmentOneBroadCast.oneBroadCast(message);
            }
        });

        return view;
    }

    public void updateTextView(String msg)
    {
        tv.setText(msg);
    }

    public interface FragmentOneBroadCast{
        public void oneBroadCast(String message);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        fragmentOneBroadCast = (FragmentOne.FragmentOneBroadCast) activity;
    }


}