# Mini E-Commerce Backend

A Java-based backend application that simulates the core fundamentals of an e-commerce system. It allows users to manage products by performing CRUD (Create, Read, Update, Delete) operations using object-oriented programming principles.

## 📊 Project Status

**Current Phase:** Core Development (Phase 1 - Backend Foundation)

**Progress:** ~60% Complete

The project now implements product management, a customer model, a cart, and basic order placement through a CLI. Recent development added order placement, bill calculation, stock validation, cart cleanup after order, and custom exceptions.

---

## ✅ Features Implemented

### Product Management
- ✓ Product CRUD operations (Create, Read, Update, Delete)
- ✓ Inventory management with stock tracking
- ✓ Search products by name
- ✓ Update product stock by product ID
- ✓ Product data model with getters/setters

### Customer
- ✓ Customer model and CRUD utilities
- ✓ Email validation for customer creation
- ✓ Customer-specific cart operations

### Cart & Orders
- ✓ Cart model and CartService (add to cart, display cart)
- ✓ Customer-specific cart display and removal
- ✓ Order model and OrderService
- ✓ Place order from customer's cart
- ✓ Bill calculation and order id generation
- ✓ Stock reduction when an order is placed

### Error handling
- ✓ Custom exceptions: ProductNotFoundException, CustomerNotFoundException, InsufficientStockException, EmptyCartException
- ✓ Try/catch handling in the CLI for common error cases

### UI & Architecture
- ✓ CLI-based user interface with menu options
- ✓ MVC-style separation between models, services, and UI

---

## 🎯 Recent Changes (high level)
- Added CartItem model and CartService to collect customer cart items.
- Made cart operations customer-specific and added display/remove cart items per customer.
- Created Order model and OrderService with placeOrder() that: validates stock, computes total bill, reduces product stock, and returns total.
- Added order id generation (incrementing id starting from 1000).
- Implemented email validation for customers and improved input handling in the CLI.
- Introduced custom exception classes and used them in services and the CLI to provide clearer error messages.
- Updated CLI menu to support adding to cart, viewing cart by customer, placing orders and exiting.

---

## 🎯 Planned Features (next phases)

### Phase 2: Customer & Order Management (in progress)
- [ ] Persist orders (order history)
- [ ] Link customers to orders more robustly

### Phase 3: Advanced Features
- [ ] Invoice generation
- [ ] Payment processing
- [ ] Role-based authentication and user management

### Phase 4: Persistence & API
- [ ] Database persistence (MySQL/PostgreSQL)
- [ ] Hibernate ORM setup
- [ ] REST API development with Spring Boot
- [ ] API documentation (Swagger/OpenAPI)

### Phase 5: Quality & Testing
- [ ] Unit tests (JUnit)
- [ ] Integration tests
- [ ] Input validation and more robust error handling
- [ ] Logging and monitoring

---

## 🛠️ Tech Stack
- Language: Java
- Architecture: MVC pattern
- Current UI: CLI-based
- Current data store: In-memory ArrayLists (temporary)
- Planned: Spring Boot, Hibernate, MySQL/PostgreSQL

---

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Maven or Gradle (optional)

### Run the application (from project root)

```bash
javac -d bin src/**/*.java
java -cp bin Main
```

Notes:
- The application currently uses in-memory storage; all data is lost when the application exits.
- Use the CLI menu to add products, create customers, add items to cart, view cart for a customer, place an order, and exit.

---

## ✅ CLI Menu (current)
- Add a Product
- Display Products
- Search Product
- Update Product Stock (by productId)
- Remove Product
- Add Customer
- Display Customers
- Search Customer
- Add to Cart (customer + product + quantity)
- Display Cart Items (by customer ID)
- Place Order (by customer ID)
- Exit

---

## Contributing
Contributions are welcome. Suggested ways to help:
- Add unit tests (JUnit)
- Implement DB persistence and migrations
- Improve error handling and input validation
- Add a REST API frontend with Spring Boot

Contributing workflow:
1. Fork the repository
2. Create a feature branch: git checkout -b feature/your-feature
3. Commit and push your changes
4. Open a pull request

---

## 📝 License
This project is open source. Refer to the LICENSE file for details.

---

## 👤 Author
**Dusthakarmonika**

Feel free to contribute or report issues!
