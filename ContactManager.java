import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class ContactManager {
    private static final String FILE_NAME = "contacts.txt";
    private static HashMap<String, Contact> contacts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        loadFromFile();
        int choice = 0;
        do {
            printMenu();
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number (1-6).");
                sc.next();
                continue;
            }
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> searchContact();
                case 4 -> editContact();
                case 5 -> deleteContact();
                case 6 -> System.out.println("Exiting... ");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
        sc.close();
    }
    private static void printMenu() {
        System.out.println("\nContact Management System");
        System.out.println("1. Add Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Search Contact");
        System.out.println("4. Edit Contact");
        System.out.println("5. Delete Contact");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }
    private static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone (unique): ");
        String phone = sc.nextLine();
        if (contacts.containsKey(phone)) {
            System.out.println("Contact with this phone already exists!");
            return;
        }
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        contacts.put(phone, new Contact(name, phone, email));
        saveToFile();
        System.out.println("Contact added successfully.");
    }
    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        System.out.println("\nContact List:");
        for (Contact c : contacts.values())
            System.out.println(c);
    }
    private static void searchContact() {
        System.out.print("Enter phone to search: ");
        String phone = sc.nextLine();
        Contact c = contacts.get(phone);
        if (c != null)
            System.out.println("Found: " + c);
        else
            System.out.println("Contact not found.");
    }
    private static void editContact() {
        System.out.print("Enter phone to edit: ");
        String phone = sc.nextLine();
        Contact c = contacts.get(phone);
        if (c == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.print("Enter new Name: ");
        c.setName(sc.nextLine());
        System.out.print("Enter new Email: ");
        c.setEmail(sc.nextLine());
        saveToFile();
        System.out.println("Contact updated successfully.");
    }
    private static void deleteContact() {
        System.out.print("Enter phone to delete: ");
        String phone = sc.nextLine();
        if (contacts.remove(phone) != null) {
            saveToFile();
            System.out.println("Contact deleted successfully.");
        } else
            System.out.println("Contact not found.");
    }
    private static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Contact c : contacts.values()) {
                writer.write(c.getName() + "," + c.getPhone() + "," + c.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts.");
        }
    }
    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3)
                    contacts.put(data[1], new Contact(data[0], data[1], data[2]));
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts.");
        }
    }
}