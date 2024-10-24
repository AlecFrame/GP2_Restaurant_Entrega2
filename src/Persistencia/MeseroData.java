package Persistencia;

import Modelo.Conexion;
import Modelo.Mesero;
import Modelo.Pedido;
import java.sql.*;
import java.util.ArrayList;

public class MeseroData {
    private Connection con = Conexion.cargaConexion();
    
    public MeseroData() {}

    
    public void guardarMesero(Mesero mesero) throws SQLException {
        String sql = "INSERT INTO mesero(dni, nombre, apellido) VALUES(?, ?, ?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, mesero.getDniMesero());
        ps.setString(2, mesero.getNombre());
        ps.setString(3, mesero.getApellido());
        
        int filas = ps.executeUpdate();
        if (filas > 0) {
            System.out.println("Mesero registrado con éxito.");
        }
    }

    
    public void eliminarMesero(int dni) throws SQLException {
        String sql = "DELETE FROM mesero WHERE dni = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, dni);
        
        int filas = ps.executeUpdate();
        if (filas > 0) {
            System.out.println("Mesero con DNI " + dni + " fue eliminado.");
        }
    }

   
    public Mesero buscarMesero(int dni) throws SQLException {
        Mesero mesero = null;
        String sql = "SELECT * FROM mesero WHERE dni = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, dni);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            mesero = new Mesero(rs.getInt("dni"), rs.getString("nombre"), rs.getString("apellido"));
        }
        
        return mesero;
    }

  
    public void actualizarMesero(Mesero mesero) throws SQLException {
        String sql = "UPDATE mesero SET nombre = ?, apellido = ? WHERE dni = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, mesero.getNombre());
        ps.setString(2, mesero.getApellido());
        ps.setInt(3, mesero.getDniMesero());
        
        int filas = ps.executeUpdate();
        if (filas > 0) {
            System.out.println("Mesero actualizado con éxito.");
        }
    }

   
    public ArrayList<Mesero> listarMeseros() throws SQLException {
        ArrayList<Mesero> lista = new ArrayList<>();
        String sql = "SELECT * FROM mesero";
        
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(sql);
        
        while (rs.next()) {
            lista.add(new Mesero(rs.getInt("dni"), rs.getString("nombre"), rs.getString("apellido")));
        }
        
        return lista;
    }

   
    public ArrayList<Pedido> listarPedidosPorMesero(int dniMesero, Date fecha) throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        MesaData mdata = new MesaData();
        String sql = "SELECT * FROM pedido WHERE dni_mesero = ? AND DATE(fecha_hora) = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, dniMesero);
        ps.setDate(2, fecha);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            pedidos.add(new Pedido(
                rs.getInt("id_pedido"),
                rs.getString("dni_mesero"),
                mdata.buscar((int)rs.getInt("numero_mesa")),
                rs.getDouble("total"),
                rs.getBoolean("cobrado"),
                rs.getBoolean("estado")
            ));
        }
        
        return pedidos;
    }

    
    public double listarIngresosPorFecha(Date fecha) throws SQLException {
        double totalIngresos = 0;
        String sql = "SELECT SUM(monto_total) AS ingresos FROM pedido WHERE DATE(fecha_hora) = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, fecha);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            totalIngresos = rs.getDouble("ingresos");
        }
        
        return totalIngresos;
    }

    
    public void anularPedido(int idPedido) throws SQLException {
        String sql = "UPDATE pedido SET estado = 'anulado' WHERE id_pedido = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPedido);
        
        int filas = ps.executeUpdate();
        if (filas > 0) {
            System.out.println("Pedido con ID " + idPedido + " fue anulado.");
        }
    }
}
