package com.example.loginactivity;

import android.widget.Adapter;

public class BrokenPhone  {
    private String Name;
    private Float PhoneNumber ;
    private String Brand;
    private String Password;
    private String Defect;
    private int Price;
    private boolean Done;
    private String Id ;


    public BrokenPhone(String name, Float phoneNumber, String brand, String password, String defect, int price) {
        Name = name;
        PhoneNumber = phoneNumber;
        Brand = brand;
        Password = password;
        Defect = defect;
        Price = price;
        Done=false;
        Id="";
    }
    public BrokenPhone(){

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Float getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Float phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDefect() {
        return Defect;
    }

    public void setDefect(String defect) {
        Defect = defect;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
    public boolean isDone() {
        return Done;
    }

    public void setDone(boolean done) {
        Done = done;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "BrokenPhone{" +
                "Name='" + Name + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", Brand='" + Brand + '\'' +
                ", Password=" + Password +
                ", Defect='" + Defect + '\'' +
                ", Price=" + Price +
                ", Done=" + Done +
                ", Id='" + Id + '\'' +
                '}';
    }
}


