import java.util.Scanner;

public class ControlarTanque {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese la capacidad del tanque: ");
        int capacidad = entrada.nextInt();
        System.out.println("Ingrese la cantidad de litros que tiene el tanque: ");
        int litros = entrada.nextInt();

        Tanque tanqueNafta = new Tanque(capacidad, litros);

        System.out.println("Ingrese una opción: 1 - Agregar Litros 2 - Quitar Litros");
        int opcion = entrada.nextInt();

        try {
            switch (opcion) {
                case 1:
                    System.out.println("¿Cuántos litros desea agregar?");
                    int litrosNuevos = entrada.nextInt();
                    tanqueNafta.agregarCarga(litrosNuevos);
                    System.out.println("Carga actual: " + tanqueNafta.getCarga());
                    break;
                case 2:
                    System.out.println("¿Cuántos litros desea quitar?");
                    int litrosAQuitar = entrada.nextInt();
                    tanqueNafta.quitarCarga(litrosAQuitar);
                    System.out.println("Carga actual: " + tanqueNafta.getCarga());
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } catch (TanqueLlenoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (TanqueVacioException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            entrada.close();
        }
    }
}