
package Modelo;

public class Mesero {
    private int dniMesero;
    private String nombre;
    private String apellido;
    private String reemplazando;
    private boolean estado;
    private int numeroMesa;

    
    

    public Mesero(int dniMesero, String nombre, String apellido, String reemplazando, boolean estado, int numeroMesa) {
        this.dniMesero = dniMesero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.reemplazando = reemplazando;
        this.estado = estado;
        this.numeroMesa = numeroMesa;
    }

    public Mesero(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Mesero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        this.estado = estado;}
    
    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    
    }
    
    @Override
    public String toString() {
        return "Mesero{" +
                "dniMesero=" + dniMesero +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroMesa=" + numeroMesa +
                '}';
    }
}
