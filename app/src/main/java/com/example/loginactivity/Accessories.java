package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Accessories extends AppCompatActivity {
    public Button btnSA;
    public Button btnOA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories);
        btnSA=findViewById(R.id.btnSA);
        btnOA=findViewById(R.id.btnOA);
        //////////////////////////////////////////////
        btnSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Accessories.this, "Show Accessories",
                        Toast.LENGTH_SHORT).show();
                Intent sa=new Intent(getApplicationContext(), com.example.loginactivity.ShowAccessories.class);
                startActivity(sa);
            }
        });
        //////////////////////////////////////////////////////
        btnOA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Accessories.this, "Order Accessories",
                        Toast.LENGTH_SHORT).show();
                Intent OA=new Intent(getApplicationContext(), com.example.loginactivity.OrderAccessories.class);
                startActivity(OA);
            }
        });
        ////////////////////////////////////////////////////////
    }
}
