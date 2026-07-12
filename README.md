# 🎓 Student Management System

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  <img src="https://img.shields.io/badge/JDBC-Connectivity-success?style=for-the-badge" alt="JDBC">
  <img src="https://img.shields.io/badge/Swing-AWT-red?style=for-the-badge" alt="Swing">
</p>

<p align="center">
A Java desktop application for managing student records using <strong>Java</strong>, <strong>Swing</strong>, <strong>AWT</strong>, <strong>JDBC</strong>, and <strong>MySQL</strong>. The application provides a graphical interface for performing CRUD operations on student data.
</p>

---

# 📖 Overview

**Student Management System** is a desktop application developed in Java to simplify student record management. It demonstrates Java GUI development, event-driven programming, and MySQL database connectivity using JDBC.

The application allows users to securely manage student information through an easy-to-use graphical interface.

---

# ✨ Features

* 🔐 Login Interface
* ➕ Add Student Records
* 🔍 Search Student Records
* ✏️ Update Student Information
* ❌ Delete Student Records
* 📋 View Student Information
* 💾 MySQL Database Integration
* 🖥️ User-Friendly Java Swing Interface

---

# 🛠️ Technologies Used

| Technology | Purpose                         |
| ---------- | ------------------------------- |
| Java       | Core Programming Language       |
| Swing      | Graphical User Interface        |
| AWT        | Event Handling & GUI Components |
| JDBC       | Database Connectivity           |
| MySQL      | Database Management System      |

---

# 📂 Project Structure

```text
Student-Management-System/
│
├── README.md
├── src/
│   ├── login.java
│   ├── Home.java
│   ├── Insert_data.java
│   ├── Search_data.java
│   ├── Update_data.java
│   ├── Delete_data.java
│   └── retrive_data.java
│
└── lib/
    └── mysql-connector-j-8.1.0.jar
```

---

# ⚙️ Modules

### 🔐 Login

Provides access to the application through a simple login interface.

### ➕ Insert Student

Adds new student records to the database.

### 🔍 Search Student

Searches student information using the Roll Number.

### ✏️ Update Student

Updates existing student records.

### ❌ Delete Student

Deletes student records from the database.

### 📋 Retrieve Student Data

Displays student information stored in the database.

---

# 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/santosh23i/Student-Management-System.git
cd Student-Management-System
```

### Requirements

* Java JDK 8 or later
* MySQL Server
* MySQL Connector/J (`mysql-connector-j-8.1.0.jar`)

---

# ▶️ Running the Project

Compile the Java source files and ensure the MySQL Connector/J library is included in the classpath.

Run the application using:

```bash
java login
```

---

# 🗄️ Database Information

This application uses **MySQL** with **JDBC** for storing student information.

> **Important:** The original MySQL database schema (`.sql` file) used during development is no longer available. Therefore, the project cannot be executed immediately after cloning. To run the application, create a compatible MySQL database (`stud_db`) and update the JDBC connection details if required.

---

# 📚 What You'll Learn

This project demonstrates practical implementation of:

* Object-Oriented Programming (OOP)
* Java Swing GUI Development
* AWT Event Handling
* JDBC Database Connectivity
* MySQL Integration
* CRUD Operations
* Desktop Application Development

---

# 🚀 Future Improvements

* 🔒 Secure password authentication
* 📊 Dashboard with analytics
* 📄 PDF report generation
* 📤 Export student records
* 🔍 Advanced search and filtering
* 👥 Multi-user support
* 🎨 Modern JavaFX user interface

---

# 🤝 Contributing

Contributions, suggestions, and improvements are always welcome.

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push your branch.
5. Open a Pull Request.

---

# 👨‍💻 Author

**Santosh Ingle**

* GitHub: https://github.com/santosh23i

---

# 📄 License

This project is shared for educational and learning purposes.

---

<p align="center">
<b>Built with ❤️ using Java, Swing, AWT, JDBC & MySQL</b>
</p>

<p align="center">
⭐ If you found this project useful, don't forget to give it a star!
</p>
