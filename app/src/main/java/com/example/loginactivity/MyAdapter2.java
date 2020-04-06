package com.example.loginactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter2<NewPhones> extends ArrayAdapter {
    private Context context;
    private List<NewPhones> list;
    com.example.loginactivity.NewPhones NP=new com.example.loginactivity.NewPhones();


    public MyAdapter2(Context con,  List <NewPhones> list){
        super(con,0,list);
        this.context=con;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem==null){
            listItem = LayoutInflater.from(context).inflate(R.layout.custom_row2,parent,false);
        }
        NP= (com.example.loginactivity.NewPhones) list.get(position);
        TextView NPbrand=(TextView) listItem.findViewById(R.id.newbrand);
        TextView NPcustomerPrice=(TextView) listItem.findViewById(R.id.customerprice);
        NPbrand.setText(NP.getCompany()+"");
        NPcustomerPrice.setText(NP.getCustomerPrice()+"");

        return listItem;
    }
}

