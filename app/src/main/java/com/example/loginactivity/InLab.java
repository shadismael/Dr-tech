package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class InLab extends AppCompatActivity {
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    ListView listView ;
    ArrayList<BrokenPhone>arrayList=new ArrayList<>();
    MyAdapter<BrokenPhone> arrayAdapter;
    public BrokenPhone obj;
    DatabaseReference finalref;
    ImageButton btnback;
    ImageButton btnhome;
    public String phone;
    String message="your phone is fixed";
    String message2="unfortunately your phone can't be fixed";
    SmsManager smsManager;
    ///////////////////////////////////////////////////////////////////////////////////////////////
    FirebaseAuth Mauth;
    FirebaseDatabase database;
    ///////////////////////////////////////////////////////////////////////////////////////////////
    BrokenPhone belal;
    Button fixed;
    Button totaloss;
    Button cancel;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_lab);
        btnback=findViewById(R.id.imagebuttonback3);
        btnhome=findViewById(R.id.imagebuttonhome2);
        smsManager=SmsManager.getDefault();
        ///////////////////////////////////////////////////////////////////////////////////////////
        Mauth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference(Mauth.getCurrentUser().getUid());
        databaseReference2=databaseReference.child("phones");
        ////////////////////////////////////////////////////////////////////////////////////////////
        smsManager=SmsManager.getDefault();
        ///////////////////////////////////////////////////////////////////////////////////////////
        listView=(ListView) findViewById(R.id.listview5);
        arrayAdapter=new MyAdapter<BrokenPhone>(this,arrayList);
        listView.setAdapter(arrayAdapter);
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot ds:dataSnapshot.getChildren()){
                        BrokenPhone value = ds.getValue(BrokenPhone.class);
                        arrayList.add(value);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 belal=  ((BrokenPhone)adapterView.getAdapter().getItem(i));
                 obj=belal;
                 phone=obj.getPhoneNumber();
                opendialog();

            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////

     ///////////////////////////////////////////////////////////////////////////////////////////////
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InLab.this, "Labratory",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Lab.class);
                startActivity(PL);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InLab.this, "Home",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Home.class);
                startActivity(PL);
            }
        });
     ////////////////////////////////////Fixed Button///////////////////////////////////////////////

       /////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////totaloss button//////////////////////////////////////////


        ////////////////////////////////////////////////////////////////////////////////////////////

           }
       /////////////////////////////////////////////////////////////////////////////////////////////
    public void opendialog(){
        dialog =new Dialog(this);
        dialog.setContentView(R.layout.popupshow);
        dialog.setCancelable(false);
        //////////////////////////////////////
        fixed=(Button) dialog.findViewById(R.id.btnFixed);
        totaloss=(Button) dialog.findViewById(R.id.btnRemove2);
        cancel=(Button) dialog.findViewById(R.id.btnCancel2);
        //////////////////////////////////////
        TextView cusname=(TextView)dialog.findViewById(R.id.nameview);
        TextView phnum=(TextView)dialog.findViewById(R.id.phonenumberview);
        TextView brnd=(TextView)dialog.findViewById(R.id.brandview);
        TextView pswrd=(TextView)dialog.findViewById(R.id.passwordview);
        TextView defect=(TextView)dialog.findViewById(R.id.defectview);
        TextView prs=(TextView)dialog.findViewById(R.id.priceview);
        TextView dn=(TextView)dialog.findViewById(R.id.doneview);
        TextView id=(TextView)dialog.findViewById(R.id.idview);
        cusname.setText(cusname.getText()+" : "+belal.getName());
        phnum.setText(phnum.getText()+" : "+belal.getPhoneNumber());
        brnd.setText(brnd.getText()+" : "+belal.getBrand());
        pswrd.setText(pswrd.getText()+" : "+belal.getPassword());
        defect.setText(defect.getText()+" : "+belal.getDefect());
        prs.setText(prs.getText()+" : "+belal.getPrice());
        dn.setText(dn.getText()+" : "+belal.isDone());
        id.setText(id.getText()+" : "+belal.getId());

        dialog.show();
        Toast.makeText(InLab.this, "opened",
                Toast.LENGTH_SHORT).show();
        ///////////////////////////////////////////////////
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Toast.makeText(InLab.this, "cancel",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ///////////////////////////////////////////////////////
        fixed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obj.setDone(true);
                databaseReference2.child(obj.getId()).setValue(null);
                obj.setId(null);
                databaseReference.child("done").push().setValue(obj).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(InLab.this, "successfully moved ",
                                Toast.LENGTH_SHORT).show();
                        databaseReference.child("done").addValueEventListener(new ValueEventListener() {
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
                }); smsManager.sendTextMessage(obj.getPhoneNumber(),null,message,null,null);
                Intent il=new Intent(getApplicationContext(), com.example.loginactivity.Lab.class);
                startActivity(il);
            }

        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        totaloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference2.child(obj.getId()).setValue(null);
                obj.setId(null);
                databaseReference.child("done").push().setValue(obj).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(InLab.this, "successfully added",
                                Toast.LENGTH_SHORT).show();
                        databaseReference.child("done").addValueEventListener(new ValueEventListener() {
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
                smsManager.sendTextMessage(obj.getPhoneNumber(),null,message2,null,null);
                Intent to=new Intent(getApplicationContext(), com.example.loginactivity.Lab.class);
                startActivity(to);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////

    }
    ////////////////new data reference and move to new data base and delete old one ////////////////










}
