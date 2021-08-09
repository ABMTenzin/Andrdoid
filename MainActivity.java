package com.abmcollegeattenzin.nyima.messagepassing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentOne.FragmentOneBroadCast, FragmentTwo.FragmentTwoBroadCast {

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    Button page, fragA, fragB;
    EditText edt;
    TextView tv;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        i = getIntent();

        tv = findViewById(R.id.tv);
        edt = findViewById(R.id.edt);
        page = findViewById(R.id.newPage);
        fragA = findViewById(R.id.fragmentA);
        fragB = findViewById(R.id.fragmentB);

        tv.setText(i.getStringExtra("messageBack"));

        /*
        page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = edt.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("messageAct1", message);
                startActivity(intent);
            }
        });

         */

        page.setOnClickListener((View v) -> {
            String message = edt.getText().toString();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("messageAct1", message);
            startActivity(intent);
        });

        fragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout1, fragmentOne);
                ft.commit();
            }
        });

        fragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout2, fragmentTwo);
                ft2.commit();
            }
        });
    }

    @Override
    public void oneBroadCast(String message) {
        tv.setText(message);
        fragmentTwo.updateTextView(message);
    }

    @Override
    public void twoBroadCast(String message) {
        tv.setText(message);
        fragmentOne.updateTextView(message);
    }
}