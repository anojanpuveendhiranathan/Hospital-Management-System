# 🏥 Hospital Management System — Backend Setup

This guide provides step-by-step instructions to set up and run the **Spring Boot backend** of the Hospital Management System.

---

## ⚙️ Prerequisites

Before running the project, make sure you have:

- **Java JDK 17 or higher**  
- **MySQL Server** (running on port `3306`)  

> 💡 You don’t need to install Maven — the project includes the **Maven Wrapper (`mvnw`)**.

---

## 🧩 Setup JAVA_HOME (if not already set)

### On Windows

1. Find your JDK installation path, for example:
```

C:\Program Files\Java\jdk-25

````

2. Open **Command Prompt (CMD)** and run:
```cmd
setx JAVA_HOME "C:\Program Files\Java\jdk-25"
setx PATH "%JAVA_HOME%\bin;%PATH%"
````

3. Close and reopen CMD, then verify:

```cmd
java -version
```

### On Linux / macOS

Edit your terminal profile file (`~/.bashrc`, `~/.zshrc`, etc.) and add:

```bash
export JAVA_HOME=/usr/lib/jvm/jdk-25
export PATH=$JAVA_HOME/bin:$PATH
```

Then run:

```bash
source ~/.bashrc
java -version
```

---

## 🗄️ Database Setup (MySQL)

1. Open **MySQL Command Line** or **MySQL Workbench**.
2. Create a new database:

```sql
CREATE DATABASE hospital_management;
```

---

## ⚙️ `application.properties`

Open `src/main/resources/application.properties` and add the following:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_management?useSSL=false
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

> 💡 Update the username and password according to your MySQL setup.

---

## ▶️ Run the Application

### On Windows:

```bash
mvnw spring-boot:run
```

### On Linux / macOS:

```bash
./mvnw spring-boot:run
```

Once started, open your browser and visit:

```
http://localhost:8080
```

---

## ✅ Notes

* Ensure **MySQL** is running before starting the Spring Boot app.
* Tables will be created automatically on startup.
* To stop the application, press **Ctrl + C** in the terminal.

