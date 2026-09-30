package com.dusthakarmonika.minicommerce.services;

import org.springframework.stereotype.Service;
import com.dusthakarmonika.minicommerce.repository.OrderRepository;
import com.dusthakarmonika.minicommerce.repository.CartRepository;
import com.dusthakarmonika.minicommerce.model.Cart;
import com.dusthakarmonika.minicommerce.model.CartItem;
import com.dusthakarmonika.minicommerce.model.OrderItems;
import com.dusthakarmonika.minicommerce.Exception.CartNotFoundException;
import com.dusthakarmonika.minicommerce.repository.CartItemRepository;
import com.dusthakarmonika.minicommerce.model.CreateOrderRequest;
import com.dusthakarmonika.minicommerce.Exception.InsufficientStockException;
import java.util.List;
import java.util.ArrayList;
import com.dusthakarmonika.minicommerce.model.Customer;
import org.springframework.transaction.annotation.Transactional;



import java.util.ArrayList;

@Service 
public class OrderService{
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public OrderService(OrderRepository orderRepository,CartRepository cartRepository, CartItemRepository cartItemRepository){
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public Cart findCartId(int cartId) throws CartNotFoundException{
        return cartRepository.findById(cartId)
                             .orElseThrow(() -> new CartNotFoundException("Cart not found"));
        
    }
    public void validateCartItems(Cart cart){
        if(cart.getCartItems().isEmpty()){
            throw new RuntimeException("cart is empty");
        }
    }
    private List<CartItem> getSelectedCartItems(List<Integer> cartItemIds) {

    List<CartItem> selectedItems = new ArrayList<>();

    for (int cartItemId : cartItemIds) {

        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));

        selectedItems.add(cartItem);
    }

    return selectedItems;
}
private OrderItems createOrderItem(CartItem cartItem) {

    OrderItems orderItem = new OrderItems();

    orderItem.setProduct(cartItem.getProduct());
    orderItem.setQuantity(cartItem.getQuantity());

    return orderItem;
}
public ArrayLst<OrderItems> CreateOrderItems(ArrayList<CartItem> cartItems){
    ArrayList<OrderItems> orderItems = new ArrayList<>();
for(CartItem cartItem : cartItems){
    OrderItems orderItem = createOrderItem(cartItem);
    orderItems.add(orderItem);
}
return orderItems;
}
 public void addItemsToOrder(Order order, ArrayList<OrderItems> orderItems){
        for(OrderItems oderItem : orderItems){
            orderItem.setOrder(order);
            order.getItem().add(orderItem);
        }
    }
    public void validateStock(ArrayList<CartItem> selectedCartItems) throws InsufficientStockException{
        for(CartItem cartItem : selectedCartItems){
            int stock = cartItem.getProduct().getStock();
            if(cartItem.getQuantity > stock){
                throw new InsufficientStockException("Insufficient stock");
            }
        }
    }
    public double calculteAmount(ArrayList<CartItem> selectedCartItems){
        double total = 0;
        for(CartItem cartItem : selectedCartItems){
            double price = cartItem.getProduct().getPrice();
            int quantity = cartItem.getQuantity();

            total += price * quantity;

        }
        return total;
    }

    @Transactional
    public Order createOrder(CreateOrderRequest request) {
    Cart cart = findCart(request.getCartId());
    validateCartItems(cart);
    List<CartItem> selectedCartItems =
            getSelectedCartItems(request.getCartItemIds());
    double total = calculateTotal(selectedCartItems);
    validateStock(selectedCartItems);
    Customer customer = cart.getCustomer();
    Order order = new Order( 0, customer, new ArrayList<>(), total);
    List<OrderItems> orderItems = createOrderItems(selectedCartItems);
    addItemsToOrder(order, orderItems);
    reduceStock(selectedCartItems);
    removeCartItems(cart,selectedCartItems);
    return orderRepository.save(order); 
}
private void reduceStock(List<CartItem> selectedCartItems) {
for (CartItem cartItem : selectedCartItems) {
product Product = cartItem.getProduct();
int newStock = Product.getStock() - cartItem.getQuantity();
Product.setStock(newStock);
    }
}
public void removeCartItems(Cart cart, ArrayList<CartItem> selectedCartItems){
    cart.getCartItems().removeAll(selectedCartItems);
}
}



