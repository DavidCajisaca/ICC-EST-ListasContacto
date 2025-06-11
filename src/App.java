import Controller.ContactManager;
import Controller.MenuController;
import View.ConsoleView;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        ConsoleView consoleView = new ConsoleView(scanner);
        MenuController menuController = new MenuController(contactManager, consoleView);

        menuController.showMenu();

        scanner.close(); 
    }
}
 