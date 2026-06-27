# Mini E-Commerce Backend

A lightweight Java-based e-commerce system for managing product inventory. **This project is under active development.**

## 📊 Project Status

**Phase**: Early Development (Alpha v0.1)

### Implementation Status
| Feature | Status | Notes |
|---------|--------|-------|
| Product Management | ✅ Done | CRUD operations working |
| Customer Module | 🟡 In Progress | Model created, not integrated |
| Orders | 🔴 Not Started | Planned for Phase 2 |
| Database | 🔴 Not Started | Currently uses in-memory ArrayList |
| REST API | 🔴 Not Started | Planned for Phase 4 |

---

## Features

### ✅ Currently Working
- ✓ Add products with ID, name, price, and stock
- ✓ View all products in inventory
- ✓ Search products by name
- ✓ Update product stock levels
- ✓ Remove products from inventory
- ✓ Customer data model with getters/setters

### 🟡 In Development
- [ ] Integrate Customer with product orders
- [ ] Search improvements (by category, price range)
- [ ] Unit tests

### 🔴 Not Yet Started
- [ ] Database persistence (MySQL/PostgreSQL)
- [ ] User authentication
- [ ] Order history tracking
- [ ] REST API endpoints
- [ ] Payment processing

---

## Project Structure

```
src/
  ├── UI/
  │   └── Main.java              # CLI menu & user interaction
  ├── model/
  │   ├── Customer.java          # Customer entity (done)
  │   └── product.java           # Product entity (done)
  └── services/
      └── ProductServices.java   # Business logic (mostly done)
```

---

## Getting Started

### Prerequisites
- Java 8 or higher
- IntelliJ IDEA or command line

### Installation

```bash
git clone https://github.com/Dusthakarmonika/MiniCommerceBackend.git
cd MiniCommerceBackend
```

### Running

**From IntelliJ:**
1. Open project
2. Right-click `src/UI/Main.java`
3. Click "Run"

**From Command Line:**
```bash
javac -d bin src/**/*.java
java -cp bin UI.Main
```

### ⚠️ Current Limitations
- **In-memory storage only** - All data is lost when you close the app
- **No database** - Integration planned for Phase 3
- **Limited error handling** - Basic validation only
- **CLI only** - No web interface yet

---

## Usage

Run the application and follow the menu:

```
------ WELCOME TO MINI E-COMMERCE ------
OPTION 1 : Add a Product
OPTION 2 : Display the Products
OPTION 3 : Search the Product
OPTION 4 : Update the Stock
OPTION 5 : Remove the Product
OPTION 6 : Exit
```

### Quick Example

```
Add a laptop:
1. Choose Option 1
2. Product ID: 101
3. Name: Laptop
4. Price: 50000
5. Stock: 10
```

---

## 🗺️ Roadmap

### Phase 1: Core Product Management ✅ 60% Done
- [x] Product CRUD
- [x] Basic CLI
- [ ] Input validation
- [ ] Error handling improvements
- [ ] Unit tests

### Phase 2: Customer & Orders 🟡 Planned (July 2026)
- [ ] Order model
- [ ] Link customers to orders
- [ ] Order history
- [ ] Invoice generation

### Phase 3: Database Layer 🔴 Planned (Aug 2026)
- [ ] MySQL setup
- [ ] Hibernate integration
- [ ] Data persistence layer
- [ ] Migration from ArrayList to DB

### Phase 4: REST API 🔴 Future (Sep 2026)
- [ ] Spring Boot framework
- [ ] API endpoints
- [ ] Authentication
- [ ] Swagger documentation

---

## Known Issues & TODO

### Bugs to Fix
- [ ] Stock update logic searches by stock value instead of product ID
- [ ] Better error messages needed
- [ ] Duplicate imports in Main.java

### Improvements Needed
- [ ] Add input validation
- [ ] Handle edge cases (negative prices, zero stock)
- [ ] Improve search algorithm
- [ ] Add logging

---

## Technologies

- **Language**: Java
- **Data Structure**: ArrayList (temporary, will migrate to DB)
- **Architecture**: MVC (Model-View-Controller)

---

## Contributing

Contributions welcome! Since this is early-stage:

1. Fork the repository
2. Create a branch: `git checkout -b feature/your-feature`
3. Make changes
4. Test your code
5. Commit: `git commit -m "Add feature description"`
6. Push: `git push origin feature/your-feature`
7. Create Pull Request

### Areas We Need Help With
- Unit tests (JUnit)
- Database schema design
- Performance optimization
- Bug fixes (see Known Issues)

---

## Author

**Dusthakarmonika**
- GitHub: [@Dusthakarmonika](https://github.com/Dusthakarmonika)
- Open to feedback and suggestions!

---

## License

MIT License - Free to use and modify
