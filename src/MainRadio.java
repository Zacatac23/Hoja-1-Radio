import java.util.Scanner;

public class MainRadio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Radio radio = new Radio();

        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    radio.turnOn();
                    break;
                case 2:
                    radio.changeFrequency();
                    break;
                case 3:
                    radio.scanStations();
                    break;
                case 4:
                    System.out.println("Ingrese el número del botón para guardar: ");
                    int saveButton = scanner.nextInt();
                    radio.saveStation(saveButton);
                    break;
                case 5:
                    System.out.println("Ingrese el número del botón para seleccionar: ");
                    int selectButton = scanner.nextInt();
                    radio.selectStation(selectButton);
                    break;
                case 6:
                    radio.turnOff();
                    break;
                case 7:
                    System.out.println("La radio está actualmente en la banda: " + radio.getBand());
                    break;
                case 8:
                    System.out.println("Ingrese la nueva banda (AM o FM): ");
                    String newBand = scanner.next();
                    radio.setBand(Band.valueOf(newBand.toUpperCase()));
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                    break;
            }

        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println("Menú:");
        System.out.println("1. Encender");
        System.out.println("2. Cambiar Banda");
        System.out.println("4. Guardar Emisora en Botón");
        System.out.println("5. Seleccionar Emisora desde Botón");
        System.out.println("6. Apagar");
        System.out.println("8. Cambiar Banda Manualmente");
        System.out.println("0. Salir");
        System.out.println("Ingrese su elección: ");
    }
}