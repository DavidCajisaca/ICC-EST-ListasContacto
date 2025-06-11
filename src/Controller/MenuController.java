package Controller;

import Model.Contact;
import View.ConsoleView;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController(ContactManager contactManager, ConsoleView consoleView) {
        this.contactManager = contactManager;
        this.consoleView = consoleView;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            consoleView.displayMenu();
            String option = consoleView.getinput("Enter option: ");
            switch (option) {
                case "1":
                    addContact();
                    break;
                case "2":
                    findContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    printList();
                    break;
                case "5":
                    exit = true;
                    consoleView.showMessage("Exiting...");
                    break;
                default:
                    consoleView.showMessage("Invalid Option");
                    break;
            }
        }
    }

    private void addContact() {
        String name = consoleView.getinput("Enter the name: ");
        String phone = consoleView.getinput("Enter the phone number: ");
        Contact<String, String> contact = new Contact<>(name, phone);
        contactManager.addContact(contact);
        consoleView.showMessage("Contact added");
    }

    private void findContact() {
        String name = consoleView.getinput("Enter the name to search for: ");
        Contact<String, String> contact = contactManager.findContactByName(name);
        if (contact != null) {
            consoleView.showMessage("Contact found: " + contact);
        } else {
            consoleView.showMessage("Contact not found");
        }
    }

    private void deleteContact() {
        String name = consoleView.getinput("Enter the name to delete: ");
        contactManager.deleteContactByName(name);
        consoleView.showMessage("Contact deleted");
    }

    private void printList() {
        contactManager.printList();
    }
}
