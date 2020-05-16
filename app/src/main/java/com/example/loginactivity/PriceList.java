package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class PriceList extends AppCompatActivity {
    Button Celp;
    Button PP;
    Button AccP;
    WebView webview;
    ImageButton back;
////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_list);
        Celp=findViewById(R.id.CPrices);
        PP=findViewById(R.id.PartsPrices);
        AccP=findViewById(R.id.accPrices);
        webview=new WebView(this);
        back=findViewById(R.id.imagebuttonbackP);
       // setContentView(webview);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Celp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(webview);
                webview.loadUrl("https://www.zap.co.il/models.aspx?sog=e-cellphone");
                Toast.makeText(PriceList.this, "Cellphones",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        PP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(webview);
                webview.loadUrl("https://www.zap.co.il/models.aspx?sog=e-cellphoneservice");
                Toast.makeText(PriceList.this, "Labratory Prices",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        AccP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(webview);
                webview.loadUrl("https://www.zap.co.il/search.aspx?keyword=%D7%90%D7%91%D7%99%D7%96%D7%A8%D7%99%D7%9D%20%D7%9C%D7%A1%D7%9E%D7%90%D7%A8%D7%98%D7%A4%D7%95%D7%9F&pageinfo=4");
                Toast.makeText(PriceList.this, "Accessories",
                        Toast.LENGTH_SHORT).show();
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PriceList.this, "Home",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Home.class);
                startActivity(PL);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
    }
}
