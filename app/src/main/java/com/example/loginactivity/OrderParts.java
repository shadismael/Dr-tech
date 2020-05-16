package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class OrderParts extends AppCompatActivity {
    EditText email;
    EditText subject;
    EditText message;
    Button send;
    ImageButton back;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {// order parts for the lab => class
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_parts);


        ///////////////////////////////////////////////////////////////////////////////////////////
        email=findViewById(R.id.etEmail);
        subject=findViewById(R.id.etSubject);
        message=findViewById(R.id.etMessage);
        send=findViewById(R.id.btnSend);
        home=findViewById(R.id.imagebuttonHOPS);
        back=findViewById(R.id.imagebuttonBOPS);
        ////////////////////////////////////////////////////////////////////////////////////////////
       send.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:"+email.getText().toString()));
               intent.putExtra(Intent.EXTRA_SUBJECT,""+subject.getText().toString());
               intent.putExtra(Intent.EXTRA_TEXT,""+message.getText().toString());
               startActivity(intent);
           }
       });
       //////////////////////////////////////////////////////////////////////////////////////////////
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderParts.this, "Labratory",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Lab.class);
                startActivity(PL);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderParts.this, "Home",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Home.class);
                startActivity(PL);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////
    }

    }

