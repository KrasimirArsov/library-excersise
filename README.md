# library-excersise

# Technical Documentation for CRUD Service

This document provides information on how to access and interact with the CRUD service for managing `Books`, `Students`, and `BorrowRecords`. It also outlines the constraints for acceptable values in the service.

---

## Base URL
The CRUD service is accessible at:

```
http://ygolocalleaderboard.tplinkdns.com:8080/api
```


---

## Endpoints

### **Books**

#### **1. Get All Books**
- **Endpoint**: `GET /books`
- **Description**: Retrieve a list of all books.
- **Response**:
    - `200 OK` with a list of books in JSON format.

#### **2. Get a Book by ID**
- **Endpoint**: `GET /books/{id}`
- **Description**: Retrieve details of a book by its ID.
- **Response**:
    - `200 OK` if the book exists.
    - `404 Not Found` if the book does not exist.

#### **3. Create a New Book**
- **Endpoint**: `POST /books`
- **Description**: Add a new book to the system.
- **Request Body**:
  ```json
  {
      "title": "<string>",
      "author": "<string>",
      "availableCopies": <integer>
  }
  ```
- **Response**:
    - `201 Created` if the book is added successfully.
    - `400 Bad Request` if validation fails.

#### **4. Update a Book**
- **Endpoint**: `PUT /books/{id}`
- **Description**: Update the details of an existing book.
- **Request Body**:
  ```json
  {
      "title": "<string>",
      "author": "<string>",
      "availableCopies": <integer>
  }
  ```
- **Response**:
    - `200 OK` if the update is successful.
    - `404 Not Found` if the book does not exist.
    - `400 Bad Request` if validation fails.

#### **5. Delete a Book**
- **Endpoint**: `DELETE /books/{id}`
- **Description**: Delete a book by its ID.
- **Response**:
    - `204 No Content` if the deletion is successful.
    - `404 Not Found` if the book does not exist.

---

### **Students**

#### **1. Get All Students**
- **Endpoint**: `GET /students`
- **Description**: Retrieve a list of all students.

#### **2. Get a Student by ID**
- **Endpoint**: `GET /students/{id}`
- **Description**: Retrieve details of a student by their ID.

#### **3. Create a New Student**
- **Endpoint**: `POST /students`
- **Description**: Add a new student to the system.
- **Request Body**:
  ```json
  {
      "name": "<string>",
      "email": "<string>"
  }
  ```

#### **4. Update a Student**
- **Endpoint**: `PUT /students/{id}`

#### **5. Delete a Student**
- **Endpoint**: `DELETE /students/{id}`

---

### **BorrowRecords**

#### **1. Get All Borrow Records**
- **Endpoint**: `GET /borrowRecords`

#### **2. Get a Borrow Record by ID**
- **Endpoint**: `GET /borrowRecords/{id}`

#### **3. Create a New Borrow Record**
- **Endpoint**: `POST /borrowRecords`
- **Request Body**:
  ```json
  {
      "book": { "id": <integer> },
      "student": { "id": <integer> },
      "borrowDate": "<YYYY-MM-DD>",
      "returnDate": "<YYYY-MM-DD or null>"
  }
  ```

#### **4. Update a Borrow Record**
- **Endpoint**: `PUT /borrowRecords/{id}`
- **Request Body**:
  ```json
  {
      "book": { "id": <integer> },
      "student": { "id": <integer> },
      "borrowDate": "<YYYY-MM-DD>",
      "returnDate": "<YYYY-MM-DD or null>"
  }
  ```

#### **5. Delete a Borrow Record**
- **Endpoint**: `DELETE /borrowRecords/{id}`

---

## Constraints for Values

### **Books**
- `title`: Must be a non-empty string.
- `author`: Must be a non-empty string.
- `availableCopies`: Must be an integer greater than or equal to 0.

### **Students**
- `name`: Must be a non-empty string.
- `email`: Must be a valid email address format.

### **BorrowRecords**
- `book`: Must reference a valid `book_id` from the `Books` table.
- `student`: Must reference a valid `student_id` from the `Students` table.
- `borrowDate`: Must be in `YYYY-MM-DD` format and cannot be in the future.
- `returnDate`: Must be in `YYYY-MM-DD` format or `null`. If present, it cannot be earlier than `borrowDate`.

---

## Error Codes

### Common Errors
- `400 Bad Request`: Invalid input or constraints violated.
- `404 Not Found`: Resource does not exist.
- `500 Internal Server Error`: Unexpected server error.

---

## Examples

### Create a New Borrow Record
```bash
curl -X POST -H "Content-Type: application/json" -d '{
    "book": { "id": 1 },
    "student": { "id": 2 },
    "borrowDate": "2024-12-15",
    "returnDate": null
}' http://localhost:8080/borrowRecords
```

### Get All Borrow Records
```bash
curl -X GET http://localhost:8080/borrowRecords
```

### Update a Borrow Record
```bash
curl -X PUT -H "Content-Type: application/json" -d '{
    "book": { "id": 1 },
    "student": { "id": 2 },
    "borrowDate": "2024-12-15",
    "returnDate": "2024-12-20"
}' http://localhost:8080/borrowRecords/1
```

