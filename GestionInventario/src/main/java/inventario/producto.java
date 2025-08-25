
package inventario;

/**
 *
 * @author corne
 */

public class producto {
    private String codigo; // Código único del producto
    private String nombre; // Nombre del producto
    private int cantidad;  // Cantidad disponible
    private double precio; // Precio del producto

    // Constructor
    public producto(String codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Convierte el producto en una línea para guardar en el archivo
    public String toArchivo() {
        return codigo + "," + nombre + "," + cantidad + "," + precio;
    }

    // Crear un producto a partir de una línea del archivo
    public static producto desdeArchivo(String linea) {
        try {
            String[] partes = linea.split(",");
            String codigo = partes[0];
            String nombre = partes[1];
            int cantidad = Integer.parseInt(partes[2]);
            double precio = Double.parseDouble(partes[3]);
            return new producto(codigo, nombre, cantidad, precio);
        } catch (Exception e) {
            System.out.println("Linea invalida en el archivo: " + linea);
            return null;
        }
    }

    // Para mostrar información en consola
    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Cantidad: " + cantidad + ", Precio: $" + precio;
    }
}
