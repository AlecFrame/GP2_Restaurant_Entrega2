
package Persistencia;

import Modelo.Conexion;
import Modelo.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaData {
    private Connection con = Conexion.cargaConexion();
    private MesaData mesaData = new MesaData();

    public ReservaData() {}

    public void guardarReserva(Reserva r) throws SQLException {
        if (r.getIdReserva()==0) {
            String sql = "INSERT INTO reserva(numero_mesa, dni_cliente, apellido, fecha, hora, vigencia, estado) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, r.getMesa().getNumeroMesa());
            s.setString(2, r.getDni_cliente());
            s.setString(3, r.getNombre());
            s.setDate(4, java.sql.Date.valueOf(r.getFecha()));
            s.setTime(5, java.sql.Time.valueOf(r.getHora()));
            s.setString(6, r.getVigencia());
            s.setBoolean(7, r.isEstado());

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Reserva registrada con éxito");
                JOptionPane.showMessageDialog(null, "Reserva registrada con éxito");
            } else {
                System.out.println("Error al registrar la reserva");
            }
        }else{
            String sql = "INSERT INTO reserva(idReserva, numero_mesa, dni_cliente, apellido, fecha, hora, vigencia, estado) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, r.getIdReserva());
            s.setInt(2, r.getMesa().getNumeroMesa());
            s.setString(3, r.getDni_cliente());
            s.setString(4, r.getNombre());
            s.setDate(5, java.sql.Date.valueOf(r.getFecha()));
            s.setTime(6, java.sql.Time.valueOf(r.getHora()));
            s.setString(7, r.getVigencia());
            s.setBoolean(8, r.isEstado());

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Reserva registrada con éxito");
                JOptionPane.showMessageDialog(null, "Reserva registrada con éxito");
            } else {
                System.out.println("Error al registrar la reserva");
            }
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
                                  rs.getString("apellido"),
                                  rs.getDate("fecha").toLocalDate(),
                                  rs.getTime("hora").toLocalTime(),
                                  rs.getString("vigencia"),
                                  rs.getBoolean("estado"));
        }
        
        return reserva;
    }

    public void actualizarReserva(Reserva r, int id) throws SQLException {
        if (r.getIdReserva()==0){
            String sql = "UPDATE reserva SET numero_mesa = ?, dni_cliente = ?, apellido = ?, fecha = ?, hora = ?, vigencia = ?, estado = ? WHERE idReserva = ?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, r.getMesa().getNumeroMesa());
            s.setString(2, r.getDni_cliente());
            s.setString(3, r.getNombre());
            s.setDate(4, java.sql.Date.valueOf(r.getFecha()));
            s.setTime(5, java.sql.Time.valueOf(r.getHora()));
            s.setString(6, r.getVigencia());
            s.setBoolean(7, r.isEstado());
            s.setInt(8, id);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Reserva actualizada con éxito");
                JOptionPane.showMessageDialog(null, "Reserva actualizada con éxito");
            } else {
                System.out.println("Error al actualizar la reserva");
            }
        }else{
            String sql = "UPDATE reserva SET idReserva = ?, numero_mesa = ?, dni_cliente = ?, apellido = ?, fecha = ?, hora = ?, vigencia = ?, estado = ? WHERE idReserva = ?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, r.getIdReserva());
            s.setInt(2, r.getMesa().getNumeroMesa());
            s.setString(3, r.getDni_cliente());
            s.setString(4, r.getNombre());
            s.setDate(5, java.sql.Date.valueOf(r.getFecha()));
            s.setTime(6, java.sql.Time.valueOf(r.getHora()));
            s.setString(7, r.getVigencia());
            s.setBoolean(8, r.isEstado());
            s.setInt(9, id);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Reserva actualizada con éxito");
                JOptionPane.showMessageDialog(null, "Reserva actualizada con éxito");
            } else {
                System.out.println("Error al actualizar la reserva");
            }
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
                                          rs.getString("apellido"),
                                           rs.getDate("fecha").toLocalDate(),
                                            rs.getTime("hora").toLocalTime(),
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
                                          rs.getString("apellido"),
                                            rs.getDate("fecha").toLocalDate(),
                                            rs.getTime("hora").toLocalTime(),
                                          rs.getString("vigencia"),
                                          rs.getBoolean("estado"));
            reservas.add(reserva);
        }
        return reservas;
    }

    public ArrayList<Reserva> buscarReservasPorFechayHora(LocalDate fecha, LocalTime hora) throws SQLException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        if (fecha!=null & hora!=null) {
            String sql = "SELECT * FROM reserva WHERE fecha = ? AND hora = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, fecha);
            ps.setObject(2, hora);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva(rs.getInt("idReserva"),
                                              mesaData.buscar(rs.getInt("numero_mesa")),
                                              rs.getString("dni_cliente"),
                                              rs.getString("apellido"),
                                              rs.getDate("fecha").toLocalDate(),
                                              rs.getTime("hora").toLocalTime(),
                                              rs.getString("vigencia"),
                                              rs.getBoolean("estado"));
                reservas.add(reserva);
            }
        }else
        if (hora!=null) {
            String sql = "SELECT * FROM reserva WHERE hora = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, hora);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva(rs.getInt("idReserva"),
                                              mesaData.buscar(rs.getInt("numero_mesa")),
                                              rs.getString("dni_cliente"),
                                              rs.getString("apellido"),
                                              rs.getDate("fecha").toLocalDate(),
                                              rs.getTime("hora").toLocalTime(),
                                              rs.getString("vigencia"),
                                              rs.getBoolean("estado"));
                reservas.add(reserva);
            }
        }else
        if (fecha!=null) {
            String sql = "SELECT * FROM reserva WHERE fecha = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, fecha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva(rs.getInt("idReserva"),
                                              mesaData.buscar(rs.getInt("numero_mesa")),
                                              rs.getString("dni_cliente"),
                                              rs.getString("apellido"),
                                               rs.getDate("fecha").toLocalDate(),
                                                rs.getTime("hora").toLocalTime(),
                                              rs.getString("vigencia"),
                                              rs.getBoolean("estado"));
                reservas.add(reserva);
            }
        }
        return reservas;
    }
}
