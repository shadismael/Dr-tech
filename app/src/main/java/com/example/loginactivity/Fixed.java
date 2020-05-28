package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fixed extends AppCompatActivity {
    ListView listView2 ;
    FirebaseAuth myauth;
    FirebaseDatabase mydatabase;
    DatabaseReference myRef;
    DatabaseReference myRef2;
    MyAdapter<BrokenPhone> myarrayAdapter;
    ArrayList<BrokenPhone> myarrayList;
    BrokenPhone byan;
    public BrokenPhone obj2;
    Dialog dialog2;
    Button remove;
    Button cancel2;
    ImageButton btnback;
    ImageButton btnhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {// show the fixed phones from data base=> class
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed);
        myarrayList=new ArrayList<>();
       // ////////////////////////////////firebase///////////////////////////////////////////////////
        myauth=FirebaseAuth.getInstance();
        mydatabase=FirebaseDatabase.getInstance();
        myRef=FirebaseDatabase.getInstance().getReference(myauth.getCurrentUser().getUid());
        myRef2=myRef.child("done");
        /////////////////////////////////list view//////////////////////////////////////////////////
        listView2=(ListView) findViewById(R.id.listviewdone);
        myarrayAdapter=new MyAdapter<BrokenPhone>(this,myarrayList);
        listView2.setAdapter(myarrayAdapter);
        ////////////////////////////////////////////////////////////////////////////////////////////
        btnback=findViewById(R.id.imagebuttonback4);
        btnhome=findViewById(R.id.imagebuttonhome3);
        ////////////////////////////////////////////////////////////////////////////////////////////
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot ds:dataSnapshot.getChildren()){
                        BrokenPhone value = ds.getValue(BrokenPhone.class);
                        myarrayList.add(value);
                        myarrayAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //////////////////////////////////pop up show///////////////////////////////////////////////
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                byan=  ((BrokenPhone)adapterView.getAdapter().getItem(i));
                obj2=byan;
                opendialog2();

            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Fixed.this, "Labratory",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Lab.class);
                startActivity(PL);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Fixed.this, "Home",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.Home.class);
                startActivity(PL);
            }
        });
        ////////////////////////////////////Fixed Button///////////////////////////////////////////////

    }
    //////////////////////////////////////open dialog///////////////////////////////////////////////
    public void opendialog2(){
        dialog2 =new Dialog(this);
        dialog2.setContentView(R.layout.popupshow2);
        dialog2.setCancelable(false);
        ////////////////////////////////////////////////////////////////////////////////////////////
        TextView cusname=(TextView)dialog2.findViewById(R.id.nameview);
        TextView phnum=(TextView)dialog2.findViewById(R.id.phonenumberview);
        TextView brnd=(TextView)dialog2.findViewById(R.id.brandview);
        TextView pswrd=(TextView)dialog2.findViewById(R.id.passwordview);
        TextView defect=(TextView)dialog2.findViewById(R.id.defectview);
        TextView prs=(TextView)dialog2.findViewById(R.id.priceview);
        TextView dn=(TextView)dialog2.findViewById(R.id.doneview);
        TextView id=(TextView)dialog2.findViewById(R.id.idview);
        cusname.setText(cusname.getText()+" : "+byan.getName());
        phnum.setText(phnum.getText()+" : "+byan.getPhoneNumber());
        brnd.setText(brnd.getText()+" : "+byan.getBrand());
        pswrd.setText(pswrd.getText()+" : "+byan.getPassword());
        defect.setText(defect.getText()+" : "+byan.getDefect());
        prs.setText(prs.getText()+" : "+byan.getPassword());
        dn.setText(dn.getText()+" : "+byan.isDone());
        id.setText(id.getText()+" : "+byan.getId());
        ////////////////////////////////////////
        remove=dialog2.findViewById(R.id.btnRemove2);
        cancel2=dialog2.findViewById(R.id.btnCancel2);
        //////////////////////////////////////////
        dialog2.show();
        Toast.makeText(Fixed.this, "opened",
                Toast.LENGTH_SHORT).show();
        ////////////////////////////////////cancel button//close pop up show 2 /////////////////////
        cancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog2.cancel();

                Toast.makeText(Fixed.this, "closed",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ///////////////////////////////remove button////////////////////////////////////////////////
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("done").child(obj2.getId()).setValue(null);
                Toast.makeText(Fixed.this, "Removed",
                        Toast.LENGTH_SHORT).show();
                Intent m=new Intent(getApplicationContext(), com.example.loginactivity.Lab.class);
                startActivity(m);
            }
        });


        ///////////////////////////////////////////////dialog done////////////////////////////////////////////
    }
}
