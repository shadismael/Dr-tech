package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

public class CellphonesInventory extends AppCompatActivity {
    ListView listView;
    FirebaseAuth myauth;
    FirebaseDatabase mydatabase;
    DatabaseReference myRef;
    DatabaseReference myRef2;
    MyAdapter2<NewPhones> myarrayAdapter;
    ArrayList<NewPhones> myarrayList;
    NewPhones byan;
    public NewPhones obj2;
    Dialog dialog;
    Button sold;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cellphones_inventory);
        myarrayList=new ArrayList<>();
        ///////////////////////////////////////////////////////////////////////////////////////////
        dialog =new Dialog(this);
        dialog.setContentView(R.layout.popupshow3);
        dialog.setCancelable(false);
        ////////////////////////////////firebase///////////////////////////////////////////////////
        myauth=FirebaseAuth.getInstance();
        mydatabase=FirebaseDatabase.getInstance();
        myRef=FirebaseDatabase.getInstance().getReference(myauth.getCurrentUser().getUid());
        myRef2=myRef.child("newPhone");
        /////////////////////////////////list view//////////////////////////////////////////////////
        listView=(ListView) findViewById(R.id.listview5);
        myarrayAdapter=new MyAdapter2<NewPhones>(this,myarrayList);
        listView.setAdapter(myarrayAdapter);
        ////////////////////////////////////////////////////////////////////////////////////////////
        sold=dialog.findViewById(R.id.btnSold);
        cancel=dialog.findViewById(R.id.btnCancel2);
        ////////////////////////////////////////////////////////////////////////////////////////////
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot ds:dataSnapshot.getChildren()){
                        NewPhones value = ds.getValue(NewPhones.class);
                        myarrayList.add(value);
                        myarrayAdapter.notifyDataSetChanged();
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
               NewPhones byan=  ((NewPhones)adapterView.getAdapter().getItem(i));
                obj2=byan;
                opendialog();

            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////
        sold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("newPhone").child(obj2.getId()).setValue(null);
                Toast.makeText(CellphonesInventory.this, "Sold",
                        Toast.LENGTH_SHORT).show();
                Intent m=new Intent(getApplicationContext(), com.example.loginactivity.CellphonesInventory.class);
                startActivity(m);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Toast.makeText(CellphonesInventory.this, "Closed",
                        Toast.LENGTH_SHORT).show();

            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void opendialog(){
        TextView comname=(TextView)dialog.findViewById(R.id.company2);
        TextView col=(TextView)dialog.findViewById(R.id.color2);
        TextView strg=(TextView)dialog.findViewById(R.id.storage2);
        TextView prc=(TextView)dialog.findViewById(R.id.price2);
        TextView cprc=(TextView)dialog.findViewById(R.id.customerprice2);
        comname.setText(comname.getText()+" : "+obj2.getCompany());
        col.setText(col.getText()+" : "+obj2.getColor());
        strg.setText(strg.getText()+" : "+obj2.getStorage());
        prc.setText(prc.getText()+" : "+obj2.getPrice());
        cprc.setText(cprc.getText()+" : "+obj2.getCustomerPrice());
        dialog.show();
        Toast.makeText(CellphonesInventory.this, "opened",
                Toast.LENGTH_SHORT).show();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
}
