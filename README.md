# 🏥 Hospital Management System — Frontend Setup

This guide provides step-by-step instructions to set up and run the **Angular frontend** of the Hospital Management System project.

---

## ⚙️ Prerequisites

- Node.js (LTS version)
- npm (comes with Node.js)
- Angular CLI v17 or later

---

## 🚀 Setup Steps

### Step 1: Install Node.js

Download and install the **LTS version** of Node.js from:
👉 [https://nodejs.org/](https://nodejs.org/)
(This also installs npm automatically.)

---

### Step 2: Verify Node.js and npm installation

```bash
node -v
npm -v
```

---

### Step 3: Install Angular CLI globally

```bash
npm install -g @angular/cli@17
```

---

### Step 4: Clone the project repository

```bash
git clone https://github.com/SP2224/Hospital-Management-System.git
```

---

### Step 5: Navigate to the frontend project folder

```bash
cd Hospital-Management-System/Hospital-Management-System-main/project_frontend
```

---

### Step 6: Install project dependencies

```bash
npm install
```

---

### Step 7: Install Bootstrap

```bash
npm install bootstrap
```

> Optional: You can also add Bootstrap in `angular.json` under the `styles` array if needed.

---

### Step 8: Install Angular build tools (if missing)

```bash
npm install
```

---

### Step 9: Start the Angular development server

```bash
ng serve
```

---

### Step 10: Open the application in a browser

Once the server starts, open your browser and go to:
👉 [http://localhost:4200](http://localhost:4200)
