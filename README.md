# Contact Management System

A Java console-based Contact Management System that allows users to add, view, search, edit, and delete contacts with file persistence.

This project demonstrates OOP principles, HashMap usage, and file handling in Java.

---

##  Features

- ➕ Add new contact (Name, Phone, Email)
- 🔍 Search contact by phone number (O(1) lookup)
- ✏ Edit existing contact
- 🗑 Delete contact
- 📋 View all contacts
- 💾 File persistence (data saved in contacts.txt)
- 🚫 Prevents duplicate phone numbers
- 🛡 Input validation for menu selection

---

## Technologies Used

- Java
- HashMap (Data Structure)
- File Handling (BufferedReader & BufferedWriter)
- VS Code
- Git & GitHub

---

## Concepts Used

- Object-Oriented Programming (OOP)
- HashMap for fast data retrieval
- File I/O operations
- Exception handling
- Menu-driven program design

---

## How It Works

1. On startup, contacts are loaded from `contacts.txt`.
2. Users interact with the system through a menu.
3. Contacts are stored in a `HashMap<String, Contact>` where:
   - Key = Phone number (unique)
   - Value = Contact object
4. After every add, edit, or delete operation:
   - Data is saved automatically to file.
5. On exit, all data remains stored for next run.

---

📈 Time Complexity

 Operation  Complexity 

 Add       | O(1) 
 Search    | O(1) 
 Edit      | O(1) 
 Delete    | O(1) 
 View All  | O(n) 

Space Complexity: O(n)

👨‍💻 Author

Keerthan Poojari
