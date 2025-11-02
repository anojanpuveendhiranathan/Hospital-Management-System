# 🏥 Hospital Management System

The **Hospital Management System (HMS)** is designed to digitalize hospital operations such as doctor management, patient registration, appointment scheduling, and staff coordination.
It provides a centralized platform for administrators, doctors, and patients — improving **efficiency, transparency, and communication** within the hospital.

---

## ⚙️ Current Features

### 1. Add Doctor

* Allows admins to register new doctors with details like name, specialization, contact, and experience.
* Data is stored in the database for future retrieval or search.

**Possible Improvements**

* Add edit/delete options for doctor records
* Validate inputs (avoid duplicate emails/phones)
* Include profile photo and specialization field

**Benefits**

* Keeps doctor records organized
* Simplifies onboarding of new doctors

---

### 2. View / Search Doctors

* Displays all registered doctors
* Allows search by name or specialization

**Possible Improvements**

* Add filters (experience, category, operations)
* Sorting and pagination for large data sets

**Benefits**

* Easy access to doctor details
* Faster decision-making for admins/patients

---

### 3. Add Patient

* Enables staff to register new patients with basic details like name, age, gender, and contact.

**Possible Improvements**

* Add fields for disease, assigned doctor, and admission date
* Prevent duplicate entries
* Allow uploading reports or prescriptions

**Benefits**

* Keeps patient data digital and accessible
* Reduces paperwork and manual errors

---

### 4. View / Search Patients

* Displays all patient records with search and filter options.

**Possible Improvements**

* Add filters (admission date, disease, doctor)
* Pagination for long lists
* Export reports (PDF/Excel)

**Benefits**

* Quick access to patient data
* Speeds up hospital workflow

---

## 🚀 Proposed Features

1. **Edit / Delete Doctor** — Update or remove doctor records to keep data accurate.
2. **Manage Special Categories** — Add and manage categories like Physiotherapists, Dentists, Dermatologists, etc.
3. **Manage Patients** — Edit, delete, and view patient history for better tracking.
4. **Search / Filter Doctors** — Add advanced filters by experience, operations performed, or department.
5. **Employee Management** — Manage doctors, nurses, cleaners, and other staff with details like designation and salary.
6. **Shift Management** — Assign and manage work shifts for all employees.
7. **Doctor Appointment View** — Allow doctors to view appointments for specific dates.
8. **Patient Appointment Booking & Email Notification** — Patients can book appointments online and receive confirmation emails.
9. **Emergency Case Information** — Provide first-aid guidance and basic health tips.

---

## 🔮 Future Scope

Planned future enhancements include:

* Billing and payment modules
* Report generation
* Role-based access control
* Live chat with hospital staff

---

## 🌟 Advantages

1. **Centralized Data Management** — All information in one place.
2. **Improved Efficiency** — Automates repetitive tasks.
3. **Easy Access to Information** — Accessible by doctors and staff anytime.
4. **Better Patient Experience** — Online booking & notifications.
5. **Enhanced Administration** — Employee and shift management.
6. **Accurate Records** — Keeps information up-to-date.
7. **Scalable Design** — Future modules can be added easily.

---

## ⚠️ Disadvantages

1. Initial setup cost and time
2. Training requirements for hospital staff
3. Data security concerns (sensitive health data)
4. Dependence on internet and system uptime
5. Need for regular maintenance and updates
6. Possible human error during data entry

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot (Java)
* **Frontend:** JavaFX / HTML / CSS (as applicable)
* **Database:** MySQL / MariaDB
* **Version Control:** Git & GitHub

---

## 📘 How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/anojanpuveendhiranathan/Hospital-Management-System.git
   ```

2. Open the project in your IDE (IntelliJ IDEA, Eclipse, or VS Code).

3. Configure **application.properties** with your MySQL database credentials.

4. Run the Spring Boot application:

   ```bash
   mvnw spring-boot:run
   ```

5. Access the system through the configured URL (e.g., `http://localhost:8080`).

---

## 👥 Contributors

* [Anojan Puveendhiranathan](https://github.com/anojanpuveendhiranathan)
* [Bansari Mukeshbhai Sorathiya](https://github.com/bansari-sorathiya)
* [Vidhyadhari Kummari](https://github.com/kummarividhyadhari-beep)
* [Prudhvi Nadh Goud Sammeta](https://github.com/prudhvinadhgoud)
---

## 📄 License

This project is open-source and available for educational and development use.
