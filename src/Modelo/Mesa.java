package Modelo;

public class Mesa {
    private int numeroMesa;   
    private int capacidad;   
    private boolean estado;    
    private String ocupada; 

    public Mesa() {
    }

    public Mesa(int numeroMesa, int capacidad, boolean estado, String ocupada) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.ocupada = ocupada;
    }

    public Mesa(int capacidad, boolean estado, String ocupada) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.ocupada = ocupada;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getOcupada() {
        return ocupada;
    }

    public void setOcupada(String ocupada) {
        this.ocupada = ocupada;
    }
    
    
    
}
