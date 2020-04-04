package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Lab extends AppCompatActivity {// the labratory with options => class
public Button btnAPTL;
public Button btnF;
public Button btnOP;
public Button btnIL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);
        //////////////////////////////////////////////////
        btnAPTL=findViewById(R.id.btnAPTL);
        btnF=findViewById(R.id.btnF);
        btnOP=findViewById(R.id.btnOP);
        btnIL=findViewById(R.id.btnIL);
        //////////////////////////////////////////////////
        btnAPTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Lab.this, "Add Phone To Labratory",
                        Toast.LENGTH_SHORT).show();
                Intent aptl=new Intent(getApplicationContext(), com.example.loginactivity.ADPTL.class);
                startActivity(aptl);
            }
        });
        //////////////////////////////////////////////////////
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Lab.this, "Fixed Phones",
                        Toast.LENGTH_SHORT).show();
                Intent fixed=new Intent(getApplicationContext(), com.example.loginactivity.Fixed.class);
                startActivity(fixed);
            }
        });
        ////////////////////////////////////////////////////////
        btnOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Lab.this, "Order Parts",
                        Toast.LENGTH_SHORT).show();
                Intent op=new Intent(getApplicationContext(), com.example.loginactivity.OrderParts.class);
                startActivity(op);
            }
        });
        /////////////////////////////////////////////////////////
        btnIL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Lab.this, "phones in lab",
                        Toast.LENGTH_SHORT).show();
                Intent il=new Intent(getApplicationContext(), com.example.loginactivity.InLab.class);
                startActivity(il);
            }
        });
        //////////////////////////////////////////////////////////////
    }

}
