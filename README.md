# 🛒 Mini E-Commerce Backend

A Java-based backend application that simulates the core fundamentals of an e-commerce system. It allows users to manage products by performing CRUD (Create, Read, Update, Delete) operations using object-oriented programming principles.

## 📊 Project Status

**Current Phase:** Core Development (Phase 1 - Backend Foundation)

**Progress:** ~60% Complete

The project now implements product management, a customer model, a cart system, and order placement functionality through an interactive CLI. Recent development has added robust order placement, bill calculation, stock validation, and comprehensive cart management with per-customer isolation.

---

## ✅ Features Implemented

### Product Management
- ✓ Full Product CRUD operations (Create, Read, Update, Delete)
- ✓ Comprehensive inventory management with stock tracking
- ✓ Search products by name
- ✓ Update product stock by product ID
- ✓ Product data model with getters/setters

### Customer Management
- ✓ Customer model and CRUD utilities
- ✓ Email validation for customer creation
- ✓ Customer-specific cart operations
- ✓ Persistent customer tracking

### Shopping Cart & Orders
- ✓ Cart model and CartService (add to cart, display cart)
- ✓ Customer-specific cart display and removal operations
- ✓ Order model and OrderService for processing purchases
- ✓ Place order from customer's cart with validation
- ✓ Automatic bill calculation and order ID generation
- ✓ Real-time stock reduction when orders are placed

### Error Handling & Validation
- ✓ Custom exceptions:
  - `ProductNotFoundException` - when product is not found
  - `CustomerNotFoundException` - when customer is not found
  - `InsufficientStockException` - when product stock is insufficient
  - `EmptyCartException` - when attempting operations on empty cart
- ✓ Try/catch handling in the CLI for seamless error management
- ✓ Input validation for user entries

### Architecture & UI
- ✓ CLI-based interactive user interface with menu-driven operations
- ✓ MVC-style separation of concerns (Models, Services, UI)
- ✓ Service layer pattern for business logic encapsulation

---

## 🎯 Recent Development Milestones

### Latest Updates
- ✅ Added CartItem model and CartService for flexible cart management
- ✅ Implemented customer-specific cart operations (add, view, remove by customer)
- ✅ Created Order model and OrderService with comprehensive `placeOrder()` method that:
  - Validates stock availability before order placement
  - Computes accurate total bill amounts
  - Automatically reduces product stock
  - Returns comprehensive order total
- ✅ Order ID generation with auto-incrementing system starting from 1000
- ✅ Email validation for customers with improved input handling
- ✅ Custom exception classes for clearer, more meaningful error messages
- ✅ Enhanced CLI menu with intuitive navigation and options
- ✅ MVC architecture for better code organization and maintainability

---

## 🎯 Planned Features (Next Phases)

### Phase 2: Customer & Order Management (In Progress)
- [ ] Persist orders in a data structure (order history)
- [ ] Link customers to orders with stronger data relationships
- [ ] Order status tracking (Pending, Confirmed, Shipped, Delivered)
- [ ] Order cancellation functionality

### Phase 3: Advanced Features
- [ ] Invoice generation with detailed billing information
- [ ] Payment processing integration
- [ ] Role-based authentication and user management (Admin, Customer, Guest)
- [ ] Discount and coupon system
- [ ] Product category management

### Phase 4: Persistence & API
- [ ] Database persistence (MySQL/PostgreSQL)
- [ ] Hibernate ORM integration for object-relational mapping
- [ ] REST API development with Spring Boot
- [ ] API documentation (Swagger/OpenAPI)
- [ ] Request validation and response formatting

### Phase 5: Quality & Testing
- [ ] Comprehensive Unit tests (JUnit 5)
- [ ] Integration tests for service layers
- [ ] Enhanced input validation and robust error handling
- [ ] Logging framework integration (Log4j/SLF4J)
- [ ] Performance monitoring and metrics

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java 8+ |
| **Architecture** | MVC Pattern |
| **UI** | CLI-based (Command Line Interface) |
| **Data Store** | In-memory ArrayLists (temporary) |
| **Planned** | Spring Boot, Hibernate, MySQL/PostgreSQL |

---

## 🚀 Getting Started

### Prerequisites
- **Java:** Version 8 or higher installed and configured in PATH
- **Maven** (optional): For advanced project management and dependencies
- **Gradle** (optional): Alternative build tool

### Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Dusthakarmonika/MiniCommerceBackend.git
   cd MiniCommerceBackend
   ```

2. **Compile the application:**
   ```bash
   javac -d bin src/**/*.java
   ```

3. **Run the application:**
   ```bash
   java -cp bin Main
   ```

### Important Notes
- 🔴 The application currently uses in-memory storage; all data is lost when the application exits
- 💾 Future phases will include database persistence
- 🧪 Use the CLI menu to interact with all features

---

## 📋 CLI Menu Options

The application provides an interactive menu with the following operations:

```
1. Add a Product              - Create a new product with details
2. Display Products           - View all products in the system
3. Search Product             - Search products by name
4. Update Product Stock       - Modify stock quantity for a product
5. Remove Product             - Delete a product from the system
6. Add Customer               - Register a new customer
7. Display Customers          - View all registered customers
8. Search Customer            - Search customers by details
9. Add to Cart                - Add items to customer's cart
10. Display Cart Items        - View items in customer's cart
11. Place Order               - Create an order from cart
12. Exit                      - Close the application
```

---

## 📁 Project Structure

```
MiniCommerceBackend/
├── src/
│   ├── models/              # Data models (Product, Customer, Cart, Order)
│   ├── services/            # Business logic (ProductService, CartService, OrderService)
│   ├── exceptions/          # Custom exception classes
│   ├── ui/                  # User interface (CLI)
��   └── Main.java           # Application entry point
├── bin/                     # Compiled classes (generated)
├── README.md               # This file
└── .gitignore              # Git ignore file
```

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

### Suggested Contributions
- 🧪 Add comprehensive unit tests (JUnit 5)
- 💾 Implement database persistence layer and migrations
- 🛡️ Improve error handling and input validation
- 🌐 Add REST API frontend with Spring Boot
- 📊 Enhance logging and monitoring capabilities
- 🎨 Improve UI with better user experience

### Contributing Workflow
1. **Fork** the repository
2. **Create a feature branch:** `git checkout -b feature/your-feature`
3. **Commit your changes:** `git commit -m "Add your feature description"`
4. **Push to your branch:** `git push origin feature/your-feature`
5. **Open a Pull Request** with detailed description of changes

### Code Standards
- Follow Java naming conventions and coding standards
- Add comments for complex logic
- Include unit tests for new features
- Update documentation as needed

---

## 📝 License

This project is open source. Refer to the LICENSE file for more details.

---

## 👤 Author

**Dusthakarmonika**

- GitHub: [@Dusthakarmonika](https://github.com/Dusthakarmonika)
- Project: [MiniCommerceBackend](https://github.com/Dusthakarmonika/MiniCommerceBackend)

Feel free to:
- 🐛 Report issues and bugs
- 💡 Suggest new features
- 🙋 Ask questions or seek clarification
- ✨ Contribute improvements

---

## 📞 Support & Questions

For questions, issues, or suggestions, please [open an issue](https://github.com/Dusthakarmonika/MiniCommerceBackend/issues) on the repository.

**Happy Coding!** 🚀
