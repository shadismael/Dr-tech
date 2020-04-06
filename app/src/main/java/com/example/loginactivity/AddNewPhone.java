package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddNewPhone extends AppCompatActivity {
    public EditText Company;
    public EditText Color;
    public EditText Storage;
    public EditText Price;
    public EditText CustomerPrice;
    public Button Add;
    public NewPhones Galaxy;
    public FirebaseDatabase database3 ;
    public FirebaseAuth MYauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_phone);
        ///////////////////////////////////////////////////////////////////////////////////////////
        Company=findViewById(R.id.Company1);
        Color=findViewById(R.id.etPcolor);
        Storage=findViewById(R.id.etPstorage);
        Price=findViewById(R.id.etPprice);
        CustomerPrice=findViewById(R.id.etPcPrice);
        Add=findViewById(R.id.btnANP);
        ///////////////////////////////////////////////////////////////////////////////////////////
        Galaxy=new NewPhones();
        ////////////////////////////////////////////////////////////////////////////////////////////
        database3= FirebaseDatabase.getInstance();
        MYauth=FirebaseAuth.getInstance();
        final DatabaseReference myRef3 = database3.getReference(MYauth.getCurrentUser().getUid());
        ////////////////////////////////////////////////////////////////////////////////////////////
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fill();
                myRef3.child("newPhone").push().setValue(Galaxy).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AddNewPhone.this, "successfully added",
                                Toast.LENGTH_SHORT).show();
                        myRef3.child("newPhone").addValueEventListener(new ValueEventListener() {
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
                    }
                });
                Intent a=new Intent(getApplicationContext(), com.example.loginactivity.Cellphone.class);
                startActivity(a);

            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
    }
    public void fill (){
        if(Company.getText().toString().isEmpty()||Color.getText().toString().isEmpty()||Storage.getText().toString().isEmpty()||Price.getText().toString().isEmpty()||CustomerPrice.getText().toString().isEmpty()){
            Toast.makeText(AddNewPhone.this, "Fill the missing places",
                    Toast.LENGTH_SHORT).show();
        }else{
            Galaxy.setCompany(Company.getText().toString());
            Galaxy.setColor(Color.getText().toString());
            Galaxy.setStorage(Storage.getText().toString());
            Galaxy.setPrice(Integer.parseInt(Price.getText().toString()));
            Galaxy.setCustomerPrice(Integer.parseInt(CustomerPrice.getText().toString()));
        }


    }
}
