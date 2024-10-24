
package Persistencia;

import Modelo.Conexion;
import Modelo.Reserva;
import Modelo.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservaData {
    private Connection con = Conexion.cargaConexion();
    private MesaData mesaData = new MesaData();

    public ReservaData() {}

    public void guardarReserva(Reserva r) throws SQLException {
        String sql = "INSERT INTO reserva(numero_mesa, dni_cliente, nombre, fecha, hora, vigencia, estado) VALUES(?,?,?,?,?,?,?)";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, r.getMesa().getNumeroMesa());
        s.setString(2, r.getDni_cliente());
        s.setString(3, r.getNombre());
        s.setObject(4, r.getFecha());
        s.setObject(5, r.getHora());
        s.setString(6, r.getVigencia());
        s.setBoolean(7, r.isEstado());
        
        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("Reserva registrada con éxito");
            JOptionPane.showMessageDialog(null, "Reserva registrada con éxito");
        } else {
            System.out.println("Error al registrar la reserva");
        }
    }

    public void eliminarReserva(int idReserva) throws SQLException {
        String sql = "DELETE FROM reserva WHERE idReserva = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, idReserva);
        
        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("La reserva " + idReserva + " fue eliminada con éxito");
            JOptionPane.showMessageDialog(null, "La reserva fue eliminada con éxito");
        } else {
            System.out.println("Error al eliminar la reserva");
        }
    }

    public Reserva buscarReserva(int idReserva) throws SQLException {
        Reserva reserva = null;
        String sql = "SELECT * FROM reserva WHERE idReserva = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idReserva);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            reserva = new Reserva(rs.getInt("idReserva"),
                                  mesaData.buscar(rs.getInt("numero_mesa")),
                                  rs.getString("dni_cliente"),
                                  rs.getString("nombre"),
                                  rs.getObject("fecha", LocalDate.class),
                                  rs.getObject("hora", LocalDateTime.class),
                                  rs.getString("vigencia"),
                                  rs.getBoolean("estado"));
        }
        
        return reserva;
    }

    public void actualizarReserva(Reserva r) throws SQLException {
        String sql = "UPDATE reserva SET numero_mesa = ?, dni_cliente = ?, nombre = ?, fecha = ?, hora = ?, vigencia = ?, estado = ? WHERE idReserva = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, r.getMesa().getNumeroMesa());
        s.setString(2, r.getDni_cliente());
        s.setString(3, r.getNombre());
        s.setObject(4, r.getFecha());
        s.setObject(5, r.getHora());
        s.setString(6, r.getVigencia());
        s.setBoolean(7, r.isEstado());
        s.setInt(8, r.getIdReserva());

        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("Reserva actualizada con éxito");
            JOptionPane.showMessageDialog(null, "Reserva actualizada con éxito");
        } else {
            System.out.println("Error al actualizar la reserva");
        }
    }

    public ArrayList<Reserva> listarReservas() throws SQLException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Reserva reserva = new Reserva(rs.getInt("idReserva"),
                                          mesaData.buscar(rs.getInt("numero_mesa")),
                                          rs.getString("dni_cliente"),
                                          rs.getString("nombre"),
                                          rs.getObject("fecha", LocalDate.class),
                                          rs.getObject("hora", LocalDateTime.class),
                                          rs.getString("vigencia"),
                                          rs.getBoolean("estado"));
            reservas.add(reserva);
        }
        return reservas;
    }

    public ArrayList<Reserva> listarReservasActivas() throws SQLException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE estado = 1";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Reserva reserva = new Reserva(rs.getInt("idReserva"),
                                          mesaData.buscar(rs.getInt("numero_mesa")),
                                          rs.getString("dni_cliente"),
                                          rs.getString("nombre"),
                                          rs.getObject("fecha", LocalDate.class),
                                          rs.getObject("hora", LocalDateTime.class),
                                          rs.getString("vigencia"),
                                          rs.getBoolean("estado"));
            reservas.add(reserva);
        }
        return reservas;
    }

    public ArrayList<Reserva> buscarReservasPorFecha(LocalDate fecha) throws SQLException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE fecha = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1, fecha);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Reserva reserva = new Reserva(rs.getInt("idReserva"),
                                          mesaData.buscar(rs.getInt("numero_mesa")),
                                          rs.getString("dni_cliente"),
                                          rs.getString("nombre"),
                                          rs.getObject("fecha", LocalDate.class),
                                          rs.getObject("hora", LocalDateTime.class),
                                          rs.getString("vigencia"),
                                          rs.getBoolean("estado"));
            reservas.add(reserva);
        }
        return reservas;
    }
}
