package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Accessories extends AppCompatActivity {
    public Button btnSA;
    public Button btnOA;
    ImageButton back;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories);
        btnSA=findViewById(R.id.btnSA);
        btnOA=findViewById(R.id.btnOA);
        webview=new WebView(this);
        back=findViewById(R.id.imagebuttonbackAcc);
        //////////////////////////////////////////////
        btnSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(webview);
                webview.loadUrl("https://www.zap.co.il/search.aspx?keyword=%D7%90%D7%91%D7%99%D7%96%D7%A8%D7%99%D7%9D%20%D7%9C%D7%A1%D7%9E%D7%90%D7%A8%D7%98%D7%A4%D7%95%D7%9F&pageinfo=4");
                Toast.makeText(Accessories.this, "Show Accessories",
                        Toast.LENGTH_SHORT).show();
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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Accessories.this, "Home",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Home.class);
                startActivity(PL);
            }
        });
        /////////////////////////////////////////////////////////////
    }
}
