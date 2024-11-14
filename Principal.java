import java.io.IOException;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversion conversion = new Conversion();

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            if (opcion == 9) {
                System.out.println("Saliendo del conversor. ¡Hasta pronto!");
                break;
            }

            System.out.print("Ingrese la cantidad que desea convertir: ");
            double cantidad = scanner.nextDouble();

            try {
                realizarConversion(opcion, cantidad, conversion);
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("********************************************");
        System.out.println("  Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println("********************************************");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Dólar => Lempira hondureño");
        System.out.println("8) Lempira hondureño => Dólar");
        System.out.println("9) Salir");
        System.out.print("Elija una opción válida: ");
    }

    private static void realizarConversion(int opcion, double cantidad, Conversion conversion) throws IOException, InterruptedException {
        double resultado = 0;
        switch (opcion) {
            case 1:
                resultado = conversion.convert("USD", "ARS", cantidad);
                System.out.println(cantidad + " Dólar = " + resultado + " Peso argentino");
                break;
            case 2:
                resultado = conversion.convert("ARS", "USD", cantidad);
                System.out.println(cantidad + " Peso argentino = " + resultado + " Dólar");
                break;
            case 3:
                resultado = conversion.convert("USD", "BRL", cantidad);
                System.out.println(cantidad + " Dólar = " + resultado + " Real brasileño");
                break;
            case 4:
                resultado = conversion.convert("BRL", "USD", cantidad);
                System.out.println(cantidad + " Real brasileño = " + resultado + " Dólar");
                break;
            case 5:
                resultado = conversion.convert("USD", "COP", cantidad);
                System.out.println(cantidad + " Dólar = " + resultado + " Peso colombiano");
                break;
            case 6:
                resultado = conversion.convert("COP", "USD", cantidad);
                System.out.println(cantidad + " Peso colombiano = " + resultado + " Dólar");
                break;
            case 7:
                resultado = conversion.convert("USD", "HNL", cantidad);
                System.out.println(cantidad + " Dólar = " + resultado + " Lempira hondureño");
                break;
            case 8:
                resultado = conversion.convert("HNL", "USD", cantidad);
                System.out.println(cantidad + " Lempira hondureño = " + resultado + " Dólar");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                break;
        }
    }
}
