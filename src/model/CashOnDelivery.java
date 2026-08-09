package model;

public class CashOnDelivery extends Payment{
    @Override
    public void makePayment(){
        System.out.println("Cash On Delivery successfull");
    }
}
