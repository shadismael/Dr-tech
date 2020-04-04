package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cellphone extends AppCompatActivity {
    public Button btnCI;
    public Button btnOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cellphone);
        btnCI=findViewById(R.id.btnCI );
        btnOP=findViewById(R.id.btnOP);
        //////////////////////////////////////////////
        btnCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Cellphone.this, "Cellphones Invontory",
                        Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), com.example.loginactivity.CellphonesInventory.class);
                startActivity(intent);
            }
        });
        ////////////////////////////////////////////////
        btnOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Cellphone.this, "Order Phones",
                        Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), com.example.loginactivity.OrderPhones.class);
                startActivity(intent);
            }
        });
    }
}
