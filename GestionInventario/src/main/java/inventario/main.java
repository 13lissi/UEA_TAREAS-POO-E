
package inventario;

/**
 *
 * @author corne
 */
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inventario inventario = new inventario("inventario.txt"); // Nombre del archivo

        while (true) {
            System.out.println("\n--- Menu de Inventario ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Codigo: "); 
                    String codigo = sc.nextLine();
                    System.out.print("Nombre: "); 
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad: "); 
                    int cantidad = Integer.parseInt(sc.nextLine());
                    System.out.print("Precio: "); 
                    double precio = Double.parseDouble(sc.nextLine());
                    inventario.agregarProducto(new producto(codigo, nombre, cantidad, precio));
                    break;

                case "2":
                    System.out.print("Código del producto a actualizar: "); 
                    codigo = sc.nextLine();
                    System.out.print("Nuevo nombre (Enter para no cambiar): "); 
                    nombre = sc.nextLine();
                    System.out.print("Nueva cantidad (Enter para no cambiar): "); 
                    String cantidadStr = sc.nextLine();
                    System.out.print("Nuevo precio (Enter para no cambiar): "); 
                    String precioStr = sc.nextLine();

                    Integer cant = cantidadStr.isEmpty() ? null : Integer.parseInt(cantidadStr);
                    Double prec = precioStr.isEmpty() ? null : Double.parseDouble(precioStr);
                    nombre = nombre.isEmpty() ? null : nombre;
                    inventario.actualizarProducto(codigo, nombre, cant, prec);
                    break;

                case "3":
                    System.out.print("Codigo del producto a eliminar: "); 
                    codigo = sc.nextLine();
                    inventario.eliminarProducto(codigo);
                    break;

                case "4":
                    inventario.mostrarInventario();
                    break;

                case "5":
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción invalida.");
            }
        }
    }
}

