package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class OrderAccessories extends AppCompatActivity {
    EditText email;
    EditText subject;
    EditText message;
    Button send;
    ImageButton back;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_accessories);
        ///////////////////////////////////////////////////////////////////////////////////////////
        email=findViewById(R.id.etEmail2);
        subject=findViewById(R.id.etSubject2);
        message=findViewById(R.id.etMessage2);
        send=findViewById(R.id.btnSend2);
        back=findViewById(R.id.imagebuttonBOA);
        home=findViewById(R.id.imagebuttonHOA);
        ////////////////////////////////////////////////////////////////////////////////////////////
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+email.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT,""+subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,""+message.getText().toString());
                startActivity(intent);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderAccessories.this, "Accessories",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Accessories.class);
                startActivity(PL);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderAccessories.this, "Home",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Home.class);
                startActivity(PL);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
    }
}
