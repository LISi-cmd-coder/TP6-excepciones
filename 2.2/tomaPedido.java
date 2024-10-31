import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Clase que gestiona la toma de pedidos.
 * 
 * @author Lisandro Valenzuela   
 * @version 11032002
 */
public class TomaPedido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear laboratorio
        Laboratorio lab = new Laboratorio("Drogueria S.A", "P. Sherman Calle Wallaby 42, Sidney", "3794547259");
        Cliente client = new Cliente(23, "Valenzuela", "lisi", 23.4);
        Calendar fechaPedido = Calendar.getInstance();
        
        try {
            // Intentar crear el pedido con una lista vacía
            Pedido pedido = new Pedido(fechaPedido, client, new ArrayList<>());
            System.out.print("Ingrese el número de productos que desea agregar al pedido: ");
            int numProductos = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            for (int i = 0; i < numProductos; i++) {
                System.out.println("Ingrese código: ");
                int codigo = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.println("Ingrese rubro: ");
                String rubro = scanner.nextLine();
                System.out.println("Ingrese descripción:");
                String descrip = scanner.nextLine();
                System.out.println("Ingrese costo:");
                double costo = scanner.nextDouble();
                System.out.println("Ingrese el stock:");
                int stock = scanner.nextInt();
                System.out.print("Porcentaje de Punto de Reposición: ");
                double porcPtoRepo = scanner.nextDouble();
                System.out.print("Existencia Mínima: ");
                int existMinima = scanner.nextInt();
                // Crear producto
                Producto producto = new Producto(codigo, rubro, descrip, costo, stock, porcPtoRepo, existMinima, lab);
                pedido.agregarProducto(producto);
            }

            // Mostrar el pedido
            pedido.mostrarPedido();

        } catch (PedidoInvalidoException e) {
            System.out.println("El pedido no se ha creado.");
            System.out.println("PedidoInvalidoException: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
