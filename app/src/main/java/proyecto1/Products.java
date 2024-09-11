package proyecto1;

public class Products {
    String nombre, categoria;
    int cantidad, id;
    double precio;
    boolean estado;

    public Products(int id,String nombre, String categoria, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = true;
    }

    public int getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public void actualizarCantidad(int nuevaCantidad) {
        setCantidad(nuevaCantidad);
    }

    public void actualizarPrecio(double nuevoPrecio) {
        setPrecio(nuevoPrecio);
    }

    
}
