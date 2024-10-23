
package Modelo;

public class Mesero {
    private int dniMesero;
    private String nombre;
    private String apellido;
    private String reemplazando;
    private boolean estado;

    
    public Mesero() {
    }

    public Mesero(int dniMesero, String nombre, String apellido, String reemplazando, boolean estado) {
        this.dniMesero = dniMesero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.reemplazando = reemplazando;
        this.estado = estado;
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

    public String getReemplazando() {
        return reemplazando;
    }

    public void setReemplazando(String reemplazando) {
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
        return "Mesero{" +
                "dniMesero=" + dniMesero +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
