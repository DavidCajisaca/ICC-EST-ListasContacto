package View;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView(Scanner scanner) {
        this.scanner = scanner; 
    }

    public void displayMenu() {
        System.out.println("======= Menu =====");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Imprimir contacto");
        System.out.println("5. Salir");
        System.out.print("Ingrese la opcion : ");
    }

    public String getinput(String mensaje) {
        System.out.print("  " + mensaje);
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println("------" + message);
    }
}
