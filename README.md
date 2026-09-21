# 🛒 Mini E-Commerce Backend

A Java-based mini e-commerce backend that demonstrates product, customer, cart, order, and payment workflows. The project began as an interactive command-line application and has recently been migrated toward a Spring Boot REST API.

## 📊 Project Status

**Current phase:** Spring Boot API migration and backend enhancement

The core business services remain available through the CLI, while the project now includes a Spring Boot application entry point, REST controllers, Maven build configuration, and initial MySQL/JPA integration.

> **Data note:** Product and customer data is currently held in memory by the service layer. The MySQL configuration is in place, but database entities, repositories, and full persistence are still planned.

## ✅ Features

### Product management

- Create, list, search, update stock, and remove products
- Track product prices and stock levels
- Validate missing products and insufficient stock

### Customers, carts, and orders

- Create, search, update, and delete customers
- Validate customer email addresses
- Maintain customer-specific carts
- Add products to carts with quantity and stock validation
- Merge duplicate cart items
- Update cart quantities and remove cart items
- Restore stock when items are removed from a cart
- Place orders with bill calculation and automatic order IDs
- Support UPI, card, and cash-on-delivery payment models
- Handle empty carts and other domain errors with custom exceptions

### REST API

The Spring Boot API currently exposes product endpoints:

| Method | Endpoint | Purpose |
|--------|----------|---------|
| `GET` | `/` | Check that the application is running |
| `GET` | `/products` | Return all products |
| `POST` | `/products` | Add a product |
| `GET` | `/products/{name}` | Search for a product by name |
| `PUT` | `/products/{id}` | Update a product's stock |
| `DELETE` | `/products/{id}` | Remove a product |

Successful product creation returns HTTP `201 Created`; update and delete operations return `404 Not Found` when the product does not exist.

### Design and architecture

- Spring Boot application entry point
- MVC-style separation between controllers, services, models, and UI
- Interface-based service contracts
- Service layer for business logic
- Custom exceptions for domain validation
- In-memory `ArrayList` storage during the current development phase

## 🛠️ Tech stack

| Component | Technology |
|-----------|------------|
| **Language** | Java 25 |
| **Framework** | Spring Boot 3.5.6 |
| **Build tool** | Maven |
| **Web layer** | Spring Boot Web / REST controllers |
| **Persistence dependencies** | Spring Data JPA and MySQL Connector/J |
| **Current data store** | In-memory collections |
| **User interface** | Interactive CLI |

## 🚀 Getting started

### Prerequisites

- Java 25 or a compatible JDK
- Maven 3.9+
- MySQL, if you are working on the database integration

### Run with Maven

1. Clone the repository:

   ```bash
   git clone https://github.com/Dusthakarmonika/MiniCommerceBackend.git
   cd MiniCommerceBackend
   ```

2. Configure database credentials as environment variables when database integration is enabled:

   ```bash
   export DB_USERNAME=your_mysql_username
   export DB_PASSWORD=your_mysql_password
   ```

3. Build the project:

   ```bash
   mvn clean package
   ```

4. Start the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

The application starts on `http://localhost:8080` by default.

### Try the API

Check the application:

```bash
curl http://localhost:8080/
```

Add a product:

```bash
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{
    "productID": 1,
    "productName": "Laptop",
    "price": 50000,
    "stock": 10
  }'
```

List products:

```bash
curl http://localhost:8080/products
```

The repository also includes `test.http` with an example product request for IDE HTTP clients.

## 🖥️ CLI application

The original interactive CLI remains available through `UI.Main`. It supports:

1. Add, display, search, update, and remove products
2. Add, display, search, update, and delete customers
3. Add products to a customer's cart
4. Display, update, and remove cart items
5. Place orders and select a payment type
6. Exit the application

The CLI and REST API use the same service-layer concepts, but the current storage is in memory and is not shared across separate application processes.

## 📁 Project structure

```text
MiniCommerceBackend/
├── pom.xml
├── src/
│   ├── com/dusthakarmonika/minicommerce/
│   │   ├── controller/       # Spring REST controllers
│   │   ├── model/            # Product, customer, cart, order, and payment models
│   │   ├── services/         # Product, customer, cart, and order services
│   │   ├── Interfaces/       # Service contracts
│   │   ├── Exception/        # Custom domain exceptions
│   │   ├── UI/               # Interactive CLI
│   │   └── MiniCommerceApplication.java
│   └── main/resources/
│       └── application.properties
├── test.http                 # Example REST request
├── README.md
└── .gitignore
```

## 🔐 Configuration

Database properties are read from environment variables rather than being committed as plain-text credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/minicommerce
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Before using database-backed features, create the `minicommerce` database and provide valid credentials. Full JPA entity and repository support is part of the next persistence phase.

## 🎯 Roadmap

- [ ] Add JPA entities and repositories
- [ ] Persist products, customers, carts, and orders in MySQL
- [ ] Add REST endpoints for customers, carts, and orders
- [ ] Add request validation and consistent API error responses
- [ ] Add order status and cancellation workflows
- [ ] Add authentication and role-based authorization
- [ ] Add invoice, discount, category, and wishlist features
- [ ] Add JUnit and integration test coverage
- [ ] Add API documentation with Swagger/OpenAPI
- [ ] Add structured logging and monitoring

## 🤝 Contributing

1. Fork the repository.
2. Create a feature branch:

   ```bash
   git checkout -b feature/your-feature
   ```

3. Build and test your changes with Maven.
4. Commit using a meaningful message.
5. Push the branch and open a pull request.

Please follow Java naming conventions, keep business logic in the service layer, and update the documentation when behavior changes.

## 👤 Author

**Dusthakarmonika**

- GitHub: [@Dusthakarmonika](https://github.com/Dusthakarmonika)
- Project: [MiniCommerceBackend](https://github.com/Dusthakarmonika/MiniCommerceBackend)

## 📞 Support

For questions, bugs, or feature suggestions, [open an issue](https://github.com/Dusthakarmonika/MiniCommerceBackend/issues).
