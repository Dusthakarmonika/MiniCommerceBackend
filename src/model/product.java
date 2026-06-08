package model;

public class product {
    private int productID;
    private String productName;
    private int Price;
    private int Stock;

    public product(int productID, String productName, int Price, int Stock) {
        this.productID = productID;
        this.productName = productName;
        this.Price = Price;
        this.Stock = Stock;
    }
    public int getProductID(){
        return productID;
    }
    public String  getProductName(){
        return productName;
    }
    public int getPrice(){
        return Price;
    }
    public int getStock(){
        return Stock;
    }
    public void setProductID(int productID){
        this.productID = productID;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setPrice(int Price){
        this.Price = Price;
    }
    public void setStock(int Stock){
        this.Stock = Stock;
    }
    @Override
    public String toString(){
        return "Product { " +
                "Product ID : " + productID +
                ", Product Name : " + productName +
                ", Product Price : " + Price +
                ", Product Stock : " + Stock;
    }
}
