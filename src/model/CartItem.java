package model;

public class CartItem {
    private product Product;
    private Customer customer;
    private int quantity;

    public CartItem(product Product, Customer customer, int quantity){
        this.Product = Product;
        this.customer = customer;
        this.quantity = quantity;
    }
    public CartItem(){

    }
    public product getProduct(){
        return Product;
    }
    public Customer getCustomer(){
        return customer;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setProduct(product Product){
        this.Product = Product;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public String toString(){
        return "  Product : " + Product.getProductName() +
                "\n Customer : " + customer.getCustomerName() +
                "\n Quantity : " + quantity;
    }
}
