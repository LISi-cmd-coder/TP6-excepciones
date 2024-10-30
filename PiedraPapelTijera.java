import java.io.BufferedReader; // Importa BufferedReader para leer entradas del usuario
import java.io.IOException; // Importa IOException para manejar errores de entrada/salida
import java.io.InputStreamReader; // Importa InputStreamReader para convertir bytes en caracteres

public class PiedraPapelTijera {

    public static void main(String[] args) {
        // Crea un BufferedReader para leer la entrada del usuario
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int intentos = 3; // Inicializa el número de intentos permitidos

        System.out.println("Bienvenido al juego de Piedra, Papel o Tijera.");

        // Bucle que permite al usuario intentar ingresar su elección hasta agotar los intentos
        while (intentos > 0) {
            System.out.print("Ingrese su elección (1 - Piedra, 2 - Papel, 3 - Tijera): ");

            try {
                // Intenta leer y convertir la entrada a un entero
                int eleccion = Integer.parseInt(br.readLine());

                // Verifica si la elección está dentro de los valores válidos
                if (eleccion >= 1 && eleccion <= 3) {
                    jugarPiedraPapelTijera(eleccion); // Llama al método para jugar
                    System.out.println("Fin del Juego.");
                    break; // Sale del bucle si se realiza una jugada válida
                } else {
                    // Mensaje para elecciones fuera del rango permitido
                    System.out.println("Elija una opción válida (1, 2 o 3).");
                }
            } catch (NumberFormatException e) {
                // Captura errores de formato numérico en caso de entradas no válidas
                System.out.println("Error: Entrada no válida. Por favor ingrese un número (1, 2 o 3).");
                System.out.println("Detalles del error: " + e.getMessage()); // Muestra el mensaje del error
            } catch (IOException e) {
                // Captura errores de entrada/salida
                System.out.println("Error: Ocurrió un problema de entrada/salida.");
                System.out.println("Detalles del error: " + e.getMessage()); // Muestra el mensaje del error
            } finally {
                // Bloque finally que se ejecuta siempre
                System.out.println("Fin del bloque – finally");
            }

            // Decrementa el contador de intentos restantes
            intentos--;
            if (intentos > 0) {
                // Informa al usuario cuántos intentos le quedan
                System.out.println("Te quedan " + intentos + " intentos.");
            } else {
                // Mensaje final si se superan los intentos
                System.out.println("Ha superado el número máximo de intentos. Salida del juego.");
            }
        }
    }

    public static void jugarPiedraPapelTijera(int eleccion) {
        // Genera una elección aleatoria para la máquina
        int eleccionMaquina = (int) (Math.random() * 3) + 1;
        System.out.println("Elección de la máquina: " + eleccionMaquina);

        // Determina el resultado del juego
        if (eleccion == eleccionMaquina) {
            System.out.println("Empate");
        } else if ((eleccion == 1 && eleccionMaquina == 3) || (eleccion == 2 && eleccionMaquina == 1)
                || (eleccion == 3 && eleccionMaquina == 2)) {
            System.out.println("¡Ganaste! :) ");
        } else {
            System.out.println("La máquina gana :( ");
        }
    }
}
