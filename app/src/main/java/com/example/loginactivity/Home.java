package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    public Button btnRL;
    public Button btnCP;
    public Button btnACC;
    public Button btnPL;
    public TextView welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//home page => class
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //////////////////////////////////////////////////
        btnRL=findViewById(R.id.btnRL);
        btnCP=findViewById(R.id.btnCP);
        btnACC=findViewById(R.id.btnACC);
        btnPL=findViewById(R.id.btnPL);
        welcome=findViewById(R.id.welcome);
        //////////////////////////////////////////////////
        btnRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "Labratory",
                        Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), com.example.loginactivity.Lab.class);
                startActivity(intent);
            }
        });
        /////////////////////////////////////////////////////
        btnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( Home.this, "Cellphones",
                        Toast.LENGTH_SHORT).show();
                Intent cp=new Intent(getApplicationContext(), com.example.loginactivity.Cellphone.class);
                startActivity(cp);
            }
        });
        ///////////////////////////////////////////////////////
        btnACC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "Accessories",
                        Toast.LENGTH_SHORT).show();
                Intent ACC=new Intent(getApplicationContext(), com.example.loginactivity.Accessories.class);
                startActivity(ACC);
            }
        });
        ////////////////////////////////////////////////////////
        btnPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "Price List",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.PriceList.class);
                startActivity(PL);
            }
        });


        ///////////////////////////////////////////////////////


    }
}
