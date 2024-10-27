package Persistencia;
import Modelo.Conexion;
import Modelo.Mesero;
import Modelo.Pedido;
import java.sql.*;
import java.util.ArrayList;

public class MeseroData {
    private Connection con = Conexion.cargaConexion();
    private MesaData mdata = new MesaData();
    
    public MeseroData() {}

    public void guardar(Mesero mesero) throws SQLException {
        if (mesero.getDniMesero()==0) {
            String sql = "INSERT INTO mesero(apellido, nombre, numero_mesa, remplazando, estado) VALUES(?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mesero.getApellido());
            ps.setString(2, mesero.getNombre());
            ps.setInt(3, (int) mesero.getMesa().getNumeroMesa());
            if (mesero.getReemplazando()==null) {
                ps.setNull(4, java.sql.Types.VARCHAR);
            }else
                ps.setString(4, String.valueOf(mesero.getReemplazando().getDniMesero()));
            ps.setBoolean(5, mesero.isEstado());


            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Mesero registrado con éxito.");
            }
        }else{
            String sql = "INSERT INTO mesero(dni_mesero, apellido, nombre, numero_mesa, remplazando, estado) VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(mesero.getDniMesero()));
            ps.setString(2, mesero.getApellido());
            ps.setString(3, mesero.getNombre());
            ps.setInt(4, (int) mesero.getMesa().getNumeroMesa());
            if (mesero.getReemplazando()==null) {
                ps.setNull(5, java.sql.Types.VARCHAR);
            }else
                ps.setString(5, String.valueOf(mesero.getReemplazando().getDniMesero()));
            ps.setBoolean(6, mesero.isEstado());


            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Mesero registrado con éxito.");
            }
        }
    }

    public void eliminar(String dni) throws SQLException {
        String sql = "DELETE FROM mesero WHERE dni_mesero = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        
        int filas = ps.executeUpdate();
        if (filas > 0) {
            System.out.println("Mesero con DNI " + dni + " fue eliminado.");
        }
    }

    public Mesero buscar(String dni) throws SQLException {
        Mesero mesero = null;
        String sql = "SELECT * FROM mesero WHERE dni_mesero = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            mesero = new Mesero(
                rs.getInt("dni_mesero"), 
                rs.getString("apellido"), 
                rs.getString("nombre"), 
                mdata.buscar(rs.getInt("numero_mesa")), 
                buscar(rs.getString("remplazando")),
                rs.getBoolean("estado"));
        }
        
        return mesero;
    }

    public void actualizar(Mesero mesero, int dni) throws SQLException {
        if (mesero.getDniMesero()==0) {
            String sql = "UPDATE mesero SET apellido=?, nombre=?, numero_mesa=?, remplazando=?, estado=? WHERE dni_mesero=?";
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mesero.getApellido());
            ps.setString(2, mesero.getNombre());
            ps.setInt(3, mesero.getMesa().getNumeroMesa());
            if (mesero.getReemplazando()==null) {
                ps.setNull(4, java.sql.Types.VARCHAR);
            }else
                ps.setString(4, String.valueOf(mesero.getReemplazando().getDniMesero()));
            ps.setBoolean(5, mesero.isEstado());
            ps.setInt(6, dni);
            
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Mesero actualizado con éxito.");
            }
        }else {
            String sql = "UPDATE mesero SET dni_mesero=?, apellido=?, nombre=?, numero_mesa=?, remplazando=?, estado=? WHERE dni_mesero=?";
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(mesero.getDniMesero()));
            ps.setString(2, mesero.getApellido());
            ps.setString(3, mesero.getNombre());
            ps.setInt(4, mesero.getMesa().getNumeroMesa());
            ps.setString(5, String.valueOf(mesero.getReemplazando().getDniMesero()));
            ps.setBoolean(6, mesero.isEstado());
            ps.setInt(7, dni);
            
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Mesero actualizado con éxito.");
            }
        }
    }

    public ArrayList<Mesero> listar() throws SQLException {
        ArrayList<Mesero> lista = new ArrayList<>();
        String sql = "SELECT * FROM mesero";
        
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(sql);
        
      while (rs.next()) {
            String dniReemplazando = rs.getString("remplazando");
            Mesero reemplazando = null;
            if (dniReemplazando != null && !rs.wasNull()) {
                reemplazando = buscar(dniReemplazando);
            }
            lista.add(new Mesero(
                rs.getInt("dni_mesero"), 
                rs.getString("apellido"), 
                rs.getString("nombre"), 
                mdata.buscar(rs.getInt("numero_mesa")), 
                reemplazando,
                rs.getBoolean("estado")));
        }
        
        return lista;
    }

    public ArrayList<Pedido> listarPedidosPorMesero(int dniMesero, Date fecha) throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
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
        String sql = "UPDATE pedido SET estado = false WHERE idPedido = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPedido);
        
        int filas = ps.executeUpdate();
        if (filas > 0) {
            System.out.println("Pedido con ID " + idPedido + " fue anulado.");
        }
    }
}
