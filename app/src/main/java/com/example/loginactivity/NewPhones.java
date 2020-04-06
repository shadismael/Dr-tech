package com.example.loginactivity;

public class NewPhones {
    private String Company;
    private String Color;
    private String Storage;
    private int Price;
    private int CustomerPrice;
    private String Id;

    public NewPhones(String company, String color, String storage, int price, int customerPrice,String id) {
        Company = company;
        Color = color;
        Storage = storage;
        Price = price;
        CustomerPrice = customerPrice;
        Id=id;
    }

    public NewPhones(){

    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getStorage() {
        return Storage;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getCustomerPrice() {
        return CustomerPrice;
    }

    public void setCustomerPrice(int customerPrice) {
        CustomerPrice = customerPrice;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "NewPhones{" +
                "Company='" + Company + '\'' +
                ", Color='" + Color + '\'' +
                ", Storage='" + Storage + '\'' +
                ", Price=" + Price +
                ", CustomerPrice=" + CustomerPrice +
                '}';
    }
}
