
package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private int idReserva;
    private Mesa mesa;
    private String dni_cliente;
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String vigencia;
    private boolean estado;

    public Reserva() {
    }

    public Reserva(Mesa mesa, String dni_cliente, String nombre, LocalDate fecha, LocalTime hora, String vigencia, boolean estado) {
        this.mesa = mesa;
        this.dni_cliente = dni_cliente;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.vigencia = vigencia;
        this.estado = estado;
    }

    public Reserva(int idReserva, Mesa mesa, String dni_cliente, String nombre, LocalDate fecha, LocalTime hora, String vigencia, boolean estado) {
        this.idReserva = idReserva;
        this.mesa = mesa;
        this.dni_cliente = dni_cliente;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.vigencia = vigencia;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public String getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(String dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
