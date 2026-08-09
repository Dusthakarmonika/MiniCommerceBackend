package model;

public class CardPayment extends Payment{
    @Override
    public void makePayment(){
        System.out.println("Card Payment Sucessfull");
    }
}
