package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OrderPhones extends AppCompatActivity {
    EditText email;
    EditText subject;
    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_phones);
        ///////////////////////////////////////////////////////////////////////////////////////////
        email=findViewById(R.id.etEmail3);
        subject=findViewById(R.id.etSubject3);
        message=findViewById(R.id.etMessage3);
        send=findViewById(R.id.btnSend3);
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
    }
}
