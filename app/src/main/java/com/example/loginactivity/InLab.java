package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.nio.file.Path;
import java.util.ArrayList;

import static com.example.loginactivity.MyAdapter.*;

public class InLab extends AppCompatActivity {
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    ListView listView ;
    ArrayList<BrokenPhone>arrayList=new ArrayList<>();
    MyAdapter<BrokenPhone> arrayAdapter;
    FirebaseAuth Mauth;
    FirebaseDatabase database;
    BrokenPhone belal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_lab);
        Mauth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference(Mauth.getCurrentUser().getUid());
        databaseReference2=databaseReference.child("phones");
        listView=(ListView) findViewById(R.id.listview);
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 belal=  ((BrokenPhone)adapterView.getAdapter().getItem(i));
                databaseReference2.child(belal.getId()).setValue(belal);
                opendialog();

            }
        });

    }
    public void opendialog(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.popupshow);
        dialog.setCancelable(false);
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
        prs.setText(prs.getText()+" : "+belal.getPassword());
        dn.setText(dn.getText()+" : "+belal.isDone());
        id.setText(id.getText()+" : "+belal.getId());



        dialog.show();
    }
}
