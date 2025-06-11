package Controller;

import Model.Contact;
import Model.LinkedList;
import Model.Node;

public class ContactManager {
    private LinkedList<Contact<String, String>> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contact<String, String> contact) {
        contacts.appendToTail(contact);
    }

    public Contact<String, String> findContactByName(String name) {
        Node<Contact<String, String>> current = contacts.getHead();
        while (current != null) {
            if (current.getValue().getName().equalsIgnoreCase(name)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteContactByName(String name) {
        Node<Contact<String, String>> current = contacts.getHead();
        if (current == null)
            return;
        if (current.getValue().getName().equalsIgnoreCase(name)) {
            contacts.setHead(current.getNext());
            contacts.setSize(contacts.getSize() - 1);
            return;
        }
        while (current.getNext() != null) {
            if (current.getNext().getValue().getName().equalsIgnoreCase(name)) {
                current.setNext(current.getNext().getNext());
                contacts.setSize(contacts.getSize() - 1);
                return;
            }
            current = current.getNext();
        }
    }

    public void printList() {
        contacts.print();
    }
}
