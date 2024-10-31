import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Write a description of class Pedido here.
 * 
 * @author Lisandro Valenzuela
 * @version 11032002
 */
public class Pedido
{
   private Calendar fecha;
   private Cliente cliente; 
   private  ArrayList <Producto> productos;
   private Producto producto;
  
  public Pedido(Calendar p_fecha, Cliente p_client, Producto p_producto)
   {
        this.setFecha(p_fecha);
        this.setCliente(p_client);
        this.setProducto(p_producto);
        

   }
  public Pedido (Calendar p_fecha,Cliente p_client,ArrayList <Producto> p_productos )
  {
       this.setFecha(p_fecha);
       this.setCliente(p_client);
       this.setArrayProductos(p_productos);

  }

   //setters
   private void setFecha(Calendar p_fecha)
   {
        this.fecha=p_fecha;
   }
   private void setCliente(Cliente p_Cliente)
   {
        this.cliente=p_Cliente;

   }
   private void setProducto(Producto p_producto)
   {
        this.producto=p_producto;
   }
   private void setArrayProductos(ArrayList <Producto> p_products)
   {
            if(p_products==null ||  p_products.isEmpty())
            {
                throw new PedidoInvalidoException("La lista esta vacia");

            }else{
                  this.productos=p_products;
            }
    }
   //getters 
   public Calendar getFecha()
   {
    return this.fecha;
   }
   public Cliente getCliente()
   {
    return this.cliente;
   }
   public Producto getProducto()
   {
        return this.producto;
   }

   public double totalAlContado()
    {
        double total=0.0;
        for (Producto p: productos ) {
            total+=p.precioContado();
        }
        return total;
    }
    public double totalFinanciado()
    {
        double total=0.0;
        for(Producto p: productos)
        {
            total+=p.precioLista();
        }
        return total;
    }

     /**
     * Agrega un producto a la lista de productos del pedido.
     * @param p_producto El producto a agregar.
     * @return true si el producto se agregó correctamente, false si no se pudo agregar.
     */
    public boolean agregarProducto(Producto p_Producto) {
        if (p_Producto != null) {
            if (this.productos == null) {
                this.productos = new ArrayList<>(); // Inicializar la lista si es null
            }
            return this.productos.add(p_Producto); // Añadir el producto y retornar el resultado
        }
        return false; // Retornar false si el producto es null
    }

        /**
     * Elimina un producto de la lista de productos del pedido.
     * @param p_producto El producto a eliminar.
     * @return true si el producto se eliminó correctamente, false si el producto no estaba en la lista.
     */
    public boolean quitarProducto(Producto p_Producto)
    {
            if(p_Producto!=null && this.productos!=null)
            {
                return this.productos.remove(p_Producto);// Devuelve true si el producto estaba en la lista y se eliminó
            }
            return false; // Retorna false si el producto es null o la lista es null
    }

    public void mostrarPedido()
    {   
        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        String fechaFormateada = sdf.format(fecha.getTime());
        System.out.println("***Detalles del pedido***");
        System.out.println("Fecha: " + fechaFormateada );
        System.out.println("Producto \t Precio Lista\t Precio Contado");
        System.out.println("-------------------------------------------------");

        if(this.productos !=null)
        {
            for(Producto p : productos)
            {
                String descripcion = p.getDescripcion();
                double precioLista=   p.precioLista();
                double precioContando= p.precioContado();
 
                String precioListaString=String.format("%.2f", precioLista);
                String precioContadoString=String.format("%.2f", precioContando);

                System.out.println(descripcion +"\t"+precioListaString + "\t" +precioContadoString);
            }
        }
                double totalLista= totalFinanciado();
                double totalAlContado=totalAlContado();
                String cadenaPrecioCont = String.format("%.2f", totalAlContado);
                String cadenaLista= String.format("%.2f", totalLista);
                System.out.println("***Total-----"+cadenaLista+" " + cadenaPrecioCont);
    }



}
