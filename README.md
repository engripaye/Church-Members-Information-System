# 📘 Church Members Information System

<img width="1536" height="1024" alt="ChatGPT Image Nov 17, 2025, 07_34_00 PM" src="https://github.com/user-attachments/assets/f805ee50-6d46-4257-803d-83ab86e63c89" />

A streamlined system for collecting church member details, managing prayer requests, and syncing all records to both a **PostgreSQL database** and **Google Sheets** for easy administrative access.

---

## 🎯 **Project Purpose**

Many churches collect member information through manual methods, making data retrieval slow and often disorganized.
This project solves that by offering:

* A **simple digital form** for members to submit personal details and prayer requests.
* **Secure storage** in a PostgreSQL database.
* **Automatic syncing** to Google Sheets for quick access by church workers.
* Optional nightly automated syncing for reliability.

---

## 🚀 **Tech Stack**

### **Backend**

* **Java 21**
* **Spring Boot 3.5**
* Spring Web
* Spring Data JPA
* PostgreSQL
* Google Sheets API
* Spring Scheduler (optional)

### **Deployment**

* Render (free tier)
* Google Cloud Service Account

---

## 🧱 **System Architecture**

```
Mobile/Web Form  --->  Spring Boot REST API  --->  PostgreSQL Database
                                   |
                                   +--> Sync to Google Sheets
```

A member submits a form → API stores data in PostgreSQL → Google Sheets is updated instantly.

---

## 📌 **Features**

### ✅ 1. Member Registration API — *Create a New Member Record*

**POST /api/members**

**Request Body:**

```json
{
  "name": "John Doe",
  "sex": "Male",
  "contact": "08012345678",
  "age": 24,
  "address": "Ikeja, Lagos",
  "occupation": "Software Engineer",
  "suggestion": "More youth programs",
  "prayerPoint": "Financial breakthrough"
}
```

---

### ✅ 2. Fetch All Members — *Admin View*

**GET /api/members**

Returns a list of all registered members with their details.

---

### ✅ 3. Sync to Google Sheets

Whenever a member submits the form:

1. Save data to the PostgreSQL database
2. Append a new row to a specified Google Sheet
3. Return success response

---

### ✅ 4. Automatic Sync Scheduler *(Optional)*

A nightly task (e.g., 12:00 AM) checks for unsynced records and pushes them to Google Sheets.

---

## 🗂️ **Project Structure**

```
church-members-info/
 ├── src/main/java/com/church/members
 │    ├── controller/
 │    │      MemberController.java
 │    ├── service/
 │    │      MemberService.java
 │    │      GoogleSheetService.java
 │    ├── model/
 │    │      Member.java
 │    ├── repository/
 │    │      MemberRepository.java
 │    └── dto/
 │           MemberRequest.java
 ├── src/main/resources/
 │    └── application.yml
 └── pom.xml
```

---

## ⚙️ **How to Run Locally**

### **1. Clone the repository**

```bash
git clone https://github.com/your-username/church-members-info.git
cd church-members-info
```

### **2. Configure Environment Variables**

Update `application.yml` with:

* PostgreSQL credentials
* Google Service Account JSON file path
* Google Sheets ID

### **3. Run the application**

```bash
./mvnw spring-boot:run
```

The API will run on:

```
http://localhost:8080
```

---

## 🗄️ Database Setup (PostgreSQL)

Create a database:

```sql
CREATE DATABASE church_members_db;
```

Ensure your Spring Boot config points to it.

---

## 🔗 Google Sheets API Setup

1. Go to Google Cloud Console
2. Create a Service Account
3. Enable Google Sheets API
4. Generate a JSON key and save it in your project
5. Share your Google Sheet with the service account email

---

## 🚀 Deployment on Render

* Connect your GitHub repo
* Select **Java** environment
* Add PostgreSQL from Render Marketplace
* Set required environment variables
* Deploy 🚀

Works perfectly on Render free tier.

---

## 🧪 Sample Test using cURL

### Add a Member

```bash
curl -X POST http://localhost:8080/api/members \
-H "Content-Type: application/json" \
-d '{ 
  "name": "Jane Doe", 
  "sex": "Female",
  "contact": "08123456789",
  "age": 30,
  "address": "Yaba, Lagos",
  "occupation": "Teacher",
  "suggestion": "More worship sessions",
  "prayerPoint": "Career progress"
}'
```

### Fetch All Members

```bash
curl http://localhost:8080/api/members
```

---

## 📈 Future Enhancements

* Admin dashboard UI
* Authentication & Role-based Access
* SMS/Email notification integration
* Support for multiple Sheets (e.g., prayer requests only)

---

## 🤝 Contributing

Contributions are welcome!
Fork the repo → Create a branch → Add your feature → Submit a PR.

---

## 🛡️ License

This project is licensed under the **MIT License**.

---

## ⭐ Support

If you find this project useful, give it a **star** ⭐ on GitHub!

---


