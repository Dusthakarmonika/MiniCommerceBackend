# 🛒 Mini E-Commerce Backend

A Java-based backend application that simulates the core fundamentals of an e-commerce system. It allows users to manage products by performing CRUD (Create, Read, Update, Delete) operations using object-oriented programming principles.

## 📊 Project Status

**Current Phase:** Core Development (Phase 1-2 - Backend Foundation & Enhancement)

**Progress:** ~70% Complete

The project has evolved significantly with advanced cart management, comprehensive order processing, customer management, and interface-based architecture. Recent updates include cart quantity updates, product removal from cart, duplicate product handling, stock validation during cart operations, customer data management, and interface implementations for better code structure.

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
- ✓ Update customer details
- ✓ Delete customer records

### Shopping Cart & Orders
- ✓ Cart model and CartService (add to cart, display cart)
- ✓ CartItem model for flexible cart management
- ✓ Customer-specific cart display and removal operations
- ✓ Update product quantity in cart
- ✓ Handle duplicate products in cart (merge quantities)
- ✓ Stock validation when adding products to cart
- ✓ Remove products from cart with stock restoration
- ✓ Order model and OrderService for processing purchases
- ✓ Place order from customer's cart with validation
- ✓ Automatic bill calculation and order ID generation (starting from 1000)
- ✓ Real-time stock reduction when orders are placed
- ✓ Order history and order search functionality

### Error Handling & Validation
- ✓ Custom exceptions:
  - `ProductNotFoundException` - when product is not found
  - `CustomerNotFoundException` - when customer is not found
  - `InsufficientStockException` - when product stock is insufficient
  - `EmptyCartException` - when attempting operations on empty cart
- ✓ Try/catch handling in the CLI for seamless error management
- ✓ Input validation for user entries

### Architecture & Code Design
- ✓ CLI-based interactive user interface with menu-driven operations
- ✓ MVC-style separation of concerns (Models, Services, UI)
- ✓ Service layer pattern for business logic encapsulation
- ✓ Interface-based design for extensibility
- ✓ Abstract classes for payment framework (foundational structure)

---

## 🎯 Recent Development Milestones (as of August 22, 2026)

### Latest Updates
- ✅ **Cart Quantity Management**: Implemented ability to update product quantities in customer-specific carts
- ✅ **Cart Item Removal**: Added functionality to remove products from customer carts
- ✅ **Duplicate Product Handling**: Smart cart management that merges duplicate products and updates quantities
- ✅ **Stock Validation**: Compare stock availability while adding products to cart to prevent over-ordering
- ✅ **Customer Data Operations**: 
  - Delete customer details
  - Update customer information
- ✅ **Interface Implementation**: Implemented interfaces for better code abstraction and extensibility
- ✅ **Abstract Payment Class**: Created foundational abstract class for payment processing
- ✅ **Enhanced CLI Menu**: Intuitive menu with options for all cart and order operations
- ✅ **Bill Calculation & Order ID**: Auto-incrementing order IDs and accurate bill calculations
- ✅ **Email Validation**: Robust customer email validation
- ✅ **Custom Exception Handling**: Comprehensive error management with meaningful messages

---

## 🎯 Planned Features (Next Phases)

### Phase 2: Customer & Order Management (In Progress)
- [ ] Persist orders in a data structure (order history) - *In Progress*
- [ ] Link customers to orders with stronger data relationships
- [ ] Order status tracking (Pending, Confirmed, Shipped, Delivered)
- [ ] Order cancellation functionality
- [ ] Order tracking and status updates

### Phase 3: Advanced Features
- [ ] Invoice generation with detailed billing information
- [ ] Payment processing integration (implement Payment interface)
- [ ] Multiple payment methods support (Credit Card, Debit Card, UPI, etc.)
- [ ] Role-based authentication and user management (Admin, Customer, Guest)
- [ ] Discount and coupon system
- [ ] Product category management
- [ ] Wishlist functionality

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
| **Architecture** | MVC Pattern + Interface-based Design |
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
11. Update Cart Quantity      - Change product quantity in cart
12. Remove from Cart          - Remove products from customer's cart
13. Place Order               - Create an order from cart
14. Display Orders            - View order history
15. Search Order              - Find specific orders
16. Update Customer           - Modify customer details
17. Delete Customer           - Remove customer from system
18. Exit                      - Close the application
```

---

## 📁 Project Structure

```
MiniCommerceBackend/
├── src/
│   ├── models/              # Data models (Product, Customer, Cart, CartItem, Order)
│   ├── services/            # Business logic (ProductService, CartService, OrderService, CustomerService)
│   ├── exceptions/          # Custom exception classes
│   ├── interfaces/          # Interface definitions
│   ├── ui/                  # User interface (CLI)
│   └── Main.java            # Application entry point
├── bin/                     # Compiled classes (generated)
├── README.md                # This file
└── .gitignore               # Git ignore file
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
- 💳 Implement payment processing interfaces

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
- Use meaningful commit messages

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
