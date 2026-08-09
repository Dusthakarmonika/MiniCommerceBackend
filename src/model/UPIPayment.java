package model;

public class UPIPayment extends Payment{
    @Override
    public void makePayment(){
        System.out.println("UPIPayment successful");
    }
}
