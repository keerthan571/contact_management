import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n📒 Contact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> editContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("Exiting... 👋");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    private static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("✅ Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n📋 Contact List:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    private static void editContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to edit: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter new Name: ");
            contacts.get(index).setName(sc.nextLine());

            System.out.print("Enter new Phone: ");
            contacts.get(index).setPhone(sc.nextLine());

            System.out.print("Enter new Email: ");
            contacts.get(index).setEmail(sc.nextLine());

            System.out.println("✏ Contact updated successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    private static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("🗑 Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }
}