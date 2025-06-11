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
            String option = consoleView.getinput("Ingrese la opcion: ");
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
                    consoleView.showMessage("Saliendo");
                    break;
                default:
                    consoleView.showMessage("opcion no valida");
                    break;
            }
        }
    }

    private void addContact() {
        String name = consoleView.getinput("Ingrese el nombre: ");
        String phone = consoleView.getinput("Ingrese el número de teléfono: ");
        Contact<String, String> contact = new Contact<>(name, phone);
        contactManager.addContact(contact);
        consoleView.showMessage("Contacto agregado:");
    }

    private void findContact() {
        String name = consoleView.getinput("Ingrese el nombre: ");
        Contact<String, String> contact = contactManager.findContactByName(name);
        if (contact != null) {
            consoleView.showMessage("Contact encontrado: " + contact);
        } else {
            consoleView.showMessage("Contacto no encontrado");
        } 
    }

    private void deleteContact() {
        String name = consoleView.getinput("Ingrese el nombre para eliminar: ");
        contactManager.deleteContactByName(name);
        consoleView.showMessage("Contacto eliminado");
    }

    private void printList() {
        contactManager.printList();
    }
}
