package View;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView(Scanner scanner) {
        this.scanner = scanner; 
    }

    public void displayMenu() {
        System.out.println("======= Menu =====");
        System.out.println("1. Add a contact");
        System.out.println("2. Find contact");
        System.out.println("3. Delete contact");
        System.out.println("4. Print contact");
        System.out.println("5. Exit");
        System.out.print("Ingrese la opcion 🫡: ");
    }

    public String getinput(String prompt) {
        System.out.print(" * " + prompt);
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println("------" + message);
    }
}
