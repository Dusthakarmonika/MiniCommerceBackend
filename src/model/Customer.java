package model;

public class Customer {
    private String customerID;
    private String customerName;
    private String email;

    public Customer(String customerID, String customerName, String email) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.email = email;
    }
    public Customer(){}

    public String getCustomerID(){
        return customerID;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getEmail(){
        return email;
    }
    public void setCustomerID(String customerID){
        this.customerID = customerID;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString(){
        return "  CustomerID : " + customerID +
                "\n Customer Name : " + customerName +
                "\n Email ID : " + email ;
    }
}
