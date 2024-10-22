
package Modelo;

public class Mesero {
    private int dniMesero;
    private String nombre;
    private String apellido;

    
    public Mesero() {
    }

    
    public Mesero(int dniMesero, String nombre, String apellido) {
        this.dniMesero = dniMesero;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    
    public int getDni() {
        return dniMesero;
    }

    public void setDni(int dniMesero) {
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

    
    @Override
    public String toString() {
        return "Mesero{" +
                "dniMesero=" + dniMesero +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
