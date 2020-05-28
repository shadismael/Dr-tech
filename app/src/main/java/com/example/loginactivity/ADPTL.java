package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;

public class ADPTL extends AppCompatActivity {
    public EditText Name;
    public EditText PhoneNumber;
    public EditText Brand;
    public EditText Password;
    public EditText Defect;
    public EditText Price;
    public Button Fix;
    public ImageButton ImgBtn;
    public ImageButton ImgBtnhome;
    public BrokenPhone Iphone;
    public FirebaseDatabase database ;
    public FirebaseAuth mauth;
///////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {//adding phone to data base to fix => class
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_p_t_l);
        Name=findViewById(R.id.etCustomerName);
        PhoneNumber=findViewById(R.id.etPhoneNumber);
        Brand=findViewById(R.id.etPhoneBrand);
        Password=findViewById(R.id.etPhonePassword);
        Defect=findViewById(R.id.etDefect);
        Price=findViewById(R.id.etPrice);
        Fix=findViewById(R.id.btnADD);
        ImgBtn=findViewById(R.id.imgbtnback2);
        ImgBtnhome=findViewById(R.id.imagebuttonhome);
        Iphone=new BrokenPhone();
        database= FirebaseDatabase.getInstance();
        mauth=FirebaseAuth.getInstance();
        final DatabaseReference myRef = database.getReference(mauth.getCurrentUser().getUid());



        ///////////////////////////////////////////////////////////////////////////////////////////
        /*Iphone.setName(Name.getText().toString());
        Iphone.setPhoneNumber(Float.parseFloat(PhoneNumber.getText().toString()));
        Iphone.setBrand(Brand.getText().toString());
        Iphone.setPassword(Float.parseFloat(Password.getText().toString()));
        Iphone.setDefect(Defect.getText().toString());
        Iphone.setPrice(Integer.parseInt(Price.getText().toString()));

         */
        ///////////////////////////////////////////////////////////////////////////////////////////
        Fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fill();
                myRef.child("phones").push().setValue(Iphone).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ADPTL.this, "successfully added",
                                Toast.LENGTH_SHORT).show();
                        myRef.child("phones").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists()){
                                    for (DataSnapshot ds :dataSnapshot.getChildren()){
                                        ds.getRef().child("Id").setValue(ds.getKey());
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        Intent ACC=new Intent(getApplicationContext(), com.example.loginactivity.Lab.class);
                        startActivity(ACC);
                    }
                });


            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////
        ImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ADPTL.this, "Labratory",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Lab.class);
                startActivity(PL);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        ImgBtnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ADPTL.this, "Home",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Home.class);
                startActivity(PL);
            }
        });
////////////////////////////////////////////////////////////////////////////////////////////
    }
    public void fill (){
        if(Name.getText().toString().isEmpty()||Password.getText().toString().isEmpty()||Brand.getText().toString().isEmpty()||Price.getText().toString().isEmpty()||Defect.getText().toString().isEmpty()){
            Toast.makeText(ADPTL.this, "Fill the missing places",
                    Toast.LENGTH_SHORT).show();
        }else{
            Iphone.setName(Name.getText().toString());
            Iphone.setPhoneNumber((PhoneNumber.getText().toString()));
            Iphone.setBrand(Brand.getText().toString());
            Iphone.setPassword(Password.getText().toString());
            Iphone.setDefect(Defect.getText().toString());
            Iphone.setPrice(Integer.parseInt(Price.getText().toString()));
        }


    }

}
