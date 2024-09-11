package proyecto1;

import org.aspectj.lang.annotation.Aspect;

import java.util.*;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
public class Aspects {
    String historial = "";
    Date fechaHoraActual = new Date();

    @AfterReturning(pointcut = "execution(* proyecto1.Servicios.agregarProducto(..)) || execution(* proyecto1.Servicios.modificarCantidad(..)) || execution(* proyecto1.Servicios.modificarPrecio(..)) || execution(* proyecto1.Servicios.eliminarProducto(..))", returning = "result")
    public void manageHistorial(Object result) {
        Products p = (Products) result;
        try {
            historial += "------------------------------------------------------------------\n" +
                    "Id: " + p.getId() + "\n" +
                    "Nombre: " + p.getNombre() + "\n" +
                    "Categoria: " + p.getCategoria() + "\n" +
                    "Cantidad: " + p.getCantidad() + "\n" +
                    "Precio: " + p.getPrecio() + "\n" +
                    "Estado: " + (p.getEstado() ? "Disponible" : "No Disponible") + "\n" +
                    "Fecha y hora: " + fechaHoraActual + "\n" +
                    "------------------------------------------------------------------\n";
            System.out.println("\nRegistro guardado en historial\n");

            System.out.println("Id: " + p.getId());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Categoria: " + p.getCategoria());
            System.out.println("Cantidad: " + p.getCantidad());
            System.out.println("Precio: " + p.getPrecio());
            System.out.println("Estado: " + (p.getEstado() ? "Disponible" : "No Disponible"));

            if (p.getCantidad() < 3) {
                System.out.println("\nProducto con pocas existencias");
            }

        } catch (Exception e) {
            System.out.println("\nError al guardar en historial");
        }
    }

    @After("execution(* proyecto1.Servicios.mostrarHistorial(..))")
    public void mostrarHistorial() {
        System.out.println("\nHistorial de modificaciones");
        System.out.println(historial);
    }
}