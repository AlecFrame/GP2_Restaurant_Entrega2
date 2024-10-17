
package Persistencia;

import Modelo.Conexion;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PedidoData {
    private Connection con = Conexion.cargaConexion();
    private MesaData mesa = new MesaData();

    public PedidoData() {}

    
    public void guardarPedido(Pedido p) throws SQLException {
        String sql = "INSERT INTO pedido(dni_mesero, numero_mesa, importe, cobrado, estado) VALUES(?,?,?,?,?)";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setString(1, p.getDni_mesero());
        s.setInt(2, p.getMesa().getNumeroMesa());
        s.setDouble(3, p.getImporte());
        s.setBoolean(4, p.isCobrado());
        s.setBoolean(5, p.isEstado());
        
        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("Pedido registrado con éxito");
            JOptionPane.showMessageDialog(null, "Pedido registrado con éxito");
        } else {
            System.out.println("Error al registrar el pedido");
        }
    }

    
    public void eliminarPedido(int idPedido) throws SQLException {
        String sql = "DELETE FROM pedido WHERE idPedido = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, idPedido);
        
        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("El pedido " + idPedido + " fue eliminado con éxito");
            JOptionPane.showMessageDialog(null, "El pedido fue eliminado con éxito");
        } else {
            System.out.println("Error al eliminar el pedido");
        }
    }

   
    public Pedido buscarPedido(int idPedido) throws SQLException {
        Pedido pedido = null;
        String sql = "SELECT * FROM pedido WHERE idPedido = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPedido);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pedido = new Pedido(rs.getInt("idPedido"),
                                rs.getString("dni_mesero"),
                                mesa.buscar(rs.getInt("numeroMesa")),
                                rs.getDouble("importe"),
                                rs.getBoolean("cobrado"),
                                rs.getBoolean("estado"));
        }
        
        return pedido;
    }

   
    public void actualizarPedido(Pedido p) throws SQLException {
        String sql = "UPDATE pedido SET dni_mesero = ?, numero_mesa = ?, importe = ?, cobrado = ?, estado = ? WHERE idPedido = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setString(1, p.getDni_mesero());
        s.setInt(2, p.getMesa().getNumeroMesa());
        s.setDouble(3, p.getImporte());
        s.setBoolean(4, p.isCobrado());
        s.setBoolean(5, p.isEstado());
        s.setInt(6, p.getIdPedido());

        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("Pedido actualizado con éxito");
            JOptionPane.showMessageDialog(null, "Pedido actualizado con éxito");
        } else {
            System.out.println("Error al actualizar el pedido");
        }
    }

    
    public ArrayList<Pedido> listarPedidos() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Pedido pedido = new Pedido(rs.getInt("idPedido"),
                                       rs.getString("dni_mesero"),
                                       mesa.buscar(rs.getInt("numeroMesa")),
                                       rs.getDouble("importe"),
                                       rs.getBoolean("cobrado"),
                                       rs.getBoolean("estado"));
            pedidos.add(pedido);
        }
        return pedidos;
    }

   
    public ArrayList<Pedido> listarPedidosCobrados() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE cobrado = 1";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Pedido pedido = new Pedido(rs.getInt("idPedido"),
                                       rs.getString("dni_mesero"),
                                       mesa.buscar(rs.getInt("numeroMesa")),
                                       rs.getDouble("importe"),
                                       rs.getBoolean("cobrado"),
                                       rs.getBoolean("estado"));
            pedidos.add(pedido);
        }
        return pedidos;
    }
}
