package proyecto1;
import java.util.Stack;

public class Servicios {

    public Products agregarProducto(Stack<Products> productos, int id, String nombre, String categoria, int cantidad,
            double precio) {
        Products p = buscarProducto(productos, id);
        if (p != null) {
            System.out.println("\nProducto ya existe");
            return null;
        } else {
            productos.push(new Products(id, nombre, categoria, cantidad, precio));
            System.out.println("\nProducto agregado");
            return productos.peek();
        }
    }

    public Products modificarCantidad(Stack<Products> productos, int id, int cantidad) {
        Products p = buscarProducto(productos, id);
        if (p != null) {
            p.actualizarCantidad(cantidad);
            System.out.println("\nCantidad actualizada");
            return p;
        } else {
            System.out.println("\nProducto no encontrado");
            return null;
        }
    }

    public Products modificarPrecio(Stack<Products> productos, int id, double precio) {
        Products p = buscarProducto(productos, id);
        if (p != null) {
            p.actualizarPrecio(precio);
            System.out.println("\nPrecio actualizado");
            return p;
        } else {
            System.out.println("\nProducto no encontrado");
            return null;
        }
    }

    public Products eliminarProducto(Stack<Products> productos, int id) {
        Products p = buscarProducto(productos, id);
        if (p != null) {
            p.setEstado(false);
            System.out.println("\nProducto eliminado");
            productos.remove(p);
            return p;
        } else {
            System.out.println("\nProducto no encontrado");
            return null;
        }
    }

    public Products buscarProducto(Stack<Products> productos, int id) {
        for (Products p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void mostrarProductos(Stack<Products> productos) {
        System.out.println("\nInventario");
        for (Products p : productos) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Id: " + p.getId());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Categoria: " + p.getCategoria());
            System.out.println("Cantidad: " + p.getCantidad());
            System.out.println("Precio: " + p.getPrecio());
            System.out.println("Estado: " + (p.getEstado() ? "Disponible" : "No Disponible"));
            System.out.println("------------------------------------------------------------------");
        }
    }

    public void mostrarHistorial() {
    }
}
