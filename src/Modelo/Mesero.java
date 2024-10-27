
package Modelo;

public class Mesero {
    private int dniMesero;
    private String nombre;
    private String apellido;
    private Mesa mesa;
    private Mesero reemplazando;
    private boolean estado;

    public Mesero(int dniMesero, String nombre, String apellido, Mesa mesa, Mesero reemplazando, boolean estado) {
        this.dniMesero = dniMesero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mesa = mesa;
        this.reemplazando = reemplazando;
        this.estado = estado;
    }

    public Mesero(String nombre, String apellido, Mesa mesa, Mesero reemplazando, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mesa = mesa;
        this.reemplazando = reemplazando;
        this.estado = estado;
    }

    public Mesero() {
    }

    public int getDniMesero() {
        return dniMesero;
    }

    public void setDniMesero(int dniMesero) {
        this.dniMesero = dniMesero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesero getReemplazando() {
        return reemplazando;
    }

    public void setReemplazando(Mesero reemplazando) {
        this.reemplazando = reemplazando;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mesero{" + "dniMesero=" + dniMesero + ", nombre=" + nombre + ", apellido=" + apellido + ", mesa=" + mesa.getNumeroMesa() + ", reemplazando=" + ((reemplazando==null)? "null":reemplazando.getDniMesero()) + ", estado=" + estado + '}';
    }
}