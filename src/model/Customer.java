package model;

public class Customer {
    private int customerID;
    private String customerName;
    private String email;

    public Customer(int customerID, String customerName, String email) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.email = email;
    }
    public Customer(){

    }

    public int getCustomerID(){
        return customerID;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getEmail(){
        return email;
    }
    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString(){
        return " CustomerID : " + customerID +
                "\n Customer Name : " + customerName +
                "\n Email ID : " + email ;
    }
}
