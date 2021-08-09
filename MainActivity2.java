package com.abmcollegeattenzin.nyima.messagepassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    TextView tv;
    Intent intent;
    Button backHome;
    EditText edtAct2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intent = getIntent();
        tv = findViewById(R.id.tvAct2);
        edtAct2 = findViewById(R.id.edtAct2);
        backHome = findViewById(R.id.buttonAct2);

        tv.setText(intent.getStringExtra("messageAct1"));

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String backMessage = edtAct2.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("messageBack", backMessage);
                startActivity(intent);
            }
        });

    }
}