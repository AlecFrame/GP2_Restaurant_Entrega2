
package Modelo;

public class Pedido {
    private int idPedido;
    private String dni_mesero;
    private Mesa mesa;
    private double importe;
    private boolean cobrado;
    private boolean estado;

    public Pedido(int idPedido, String dni_mesero, Mesa mesa, double importe, boolean cobrado, boolean estado) {
        this.idPedido = idPedido;
        this.dni_mesero = dni_mesero;
        this.mesa = mesa;
        this.importe = importe;
        this.cobrado = cobrado;
        this.estado = estado;
    }

    public Pedido(String dni_mesero, Mesa mesa, double importe, boolean cobrado, boolean estado) {
        this.dni_mesero = dni_mesero;
        this.mesa = mesa;
        this.importe = importe;
        this.cobrado = cobrado;
        this.estado = estado;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDni_mesero() {
        return dni_mesero;
    }

    public void setDni_mesero(String dni_mesero) {
        this.dni_mesero = dni_mesero;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
