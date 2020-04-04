package com.example.loginactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.loginactivity.BrokenPhone;
import com.example.loginactivity.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter<BrokenPhone> extends ArrayAdapter {
    private Context context;
    private List<BrokenPhone> list;
    com.example.loginactivity.BrokenPhone bp=new com.example.loginactivity.BrokenPhone();


    public MyAdapter(Context con,  List <BrokenPhone> list){
        super(con,0,list);
        this.context=con;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem==null){
            listItem = LayoutInflater.from(context).inflate(R.layout.custom_row,parent,false);
        }
         bp= (com.example.loginactivity.BrokenPhone) list.get(position);
        TextView bpname=(TextView) listItem.findViewById(R.id.nameb);
        TextView bpbrand=(TextView) listItem.findViewById(R.id.brandb);
        bpname.setText(bp.getName());
        bpbrand.setText(bp.getBrand());

        return listItem;
    }
}
