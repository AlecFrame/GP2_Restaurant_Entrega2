
package Vistas;

import java.sql.*;
import Modelo.Conexion;
import Modelo.Reserva;
import Persistencia.MesaData;
import Persistencia.ProductosData;
import Persistencia.ReservaData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VReservas extends javax.swing.JInternalFrame {
    
    private ArrayList<Reserva> lista = new ArrayList<>();
    private ProductosData pdata = new ProductosData();
    private ReservaData rdata = new ReservaData();
    private MesaData mdata = new MesaData();
    private Connection con = Conexion.cargaConexion();
    private int rowSelected = -1;
    private int srowSelected = -1;
    private int prowSelected = -1;
    private boolean cargando = false;
    private boolean cambiando = false;
    private LocalTime hora = null;
    private LocalDate fecha = null;
    private String vigencia = "null";
    
    private String pid = null;
    private String pmesa = null;
    private String pdni = null;
    private String papellido = null;
    private String pfecha = null;
    private String phora = null;
    private String pvigencia = null;
    
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return false;
        }
    };
    
    private DefaultTableModel modelo2 = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return fila == modelo2.getRowCount() - 1;
        }
    };
    
    private DefaultTableModel modelo3 = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return true;
        }
    };
    
    public VReservas() {
        initComponents();
        try {
            lista = rdata.listarReservas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        
        jbBuscar.setEnabled(false);
        jtfBuscar.setEnabled(false);
        jtfHora.setEnabled(false);
        jFecha.setEnabled(false);
        jbGuardar.setEnabled(false);
        Botones(false);
        cargarCabecera();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        GrupoBotVigencia = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbCargar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLfondo = new javax.swing.JLabel();
        jcbFecha = new javax.swing.JCheckBox();
        jcbHora = new javax.swing.JCheckBox();
        jrVigencia = new javax.swing.JRadioButton();
        jrNoVigencia = new javax.swing.JRadioButton();
        jcbBuscar = new javax.swing.JCheckBox();
        jFecha = new com.toedter.calendar.JDateChooser();
        jtfHora = new javax.swing.JTextField();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(204, 187, 165));
        setBorder(null);
        setClosable(true);
        setForeground(new java.awt.Color(255, 255, 204));
        setTitle("Reservas");
        setFont(new java.awt.Font("Calibri", 1, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo5.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jLabel1.setText("Busca por:");
        jLabel1.setAlignmentY(0.0F);

        jbBuscar.setBackground(new java.awt.Color(162, 108, 72));
        jbBuscar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 204));
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(null);
        jbBuscar.setBorderPainted(false);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jTable.setBackground(new java.awt.Color(255, 255, 204));
        jTable.setBorder(new javax.swing.border.MatteBorder(null));
        jTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable.setForeground(new java.awt.Color(153, 90, 48));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null, null, null}
            },
            new String [] {
                "ID", "N° de Mesa", "DNI Cliente", "Apellido", "Fecha Reser.", "Hora Reser.", "Vigencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.setGridColor(new java.awt.Color(92, 47, 7));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jbCargar.setBackground(new java.awt.Color(162, 108, 72));
        jbCargar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbCargar.setForeground(new java.awt.Color(255, 255, 204));
        jbCargar.setText("Cargar");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        jbActualizar.setBackground(new java.awt.Color(162, 108, 72));
        jbActualizar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbActualizar.setForeground(new java.awt.Color(255, 255, 204));
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(204, 0, 0));
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setBackground(new java.awt.Color(162, 108, 72));
        jbGuardar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(255, 255, 204));
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(204, 0, 0));
        jbSalir.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 204));
        jbSalir.setText("Cerrar");
        jbSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jLfondo.setBackground(new java.awt.Color(255, 204, 153));
        jLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/reserva2.png"))); // NOI18N

        jcbFecha.setBackground(new java.awt.Color(204, 187, 165));
        jcbFecha.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jcbFecha.setText("Fecha Reservada");
        jcbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFechaActionPerformed(evt);
            }
        });

        jcbHora.setBackground(new java.awt.Color(204, 187, 165));
        jcbHora.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jcbHora.setText("Hora Reservada");
        jcbHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbHoraActionPerformed(evt);
            }
        });

        jrVigencia.setBackground(new java.awt.Color(204, 187, 165));
        GrupoBotVigencia.add(jrVigencia);
        jrVigencia.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jrVigencia.setText("Vigencia");
        jrVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrVigenciaActionPerformed(evt);
            }
        });

        jrNoVigencia.setBackground(new java.awt.Color(204, 187, 165));
        GrupoBotVigencia.add(jrNoVigencia);
        jrNoVigencia.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jrNoVigencia.setText("No Vigencia");
        jrNoVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNoVigenciaActionPerformed(evt);
            }
        });

        jcbBuscar.setBackground(new java.awt.Color(204, 187, 165));
        jcbBuscar.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jcbBuscar.setText("ID / Apellido:");
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        jFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFechaPropertyChange(evt);
            }
        });

        jtfHora.setText("00:00");
        jtfHora.setToolTipText("");
        jtfHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfHoraKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jbSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbCargar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jbGuardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbActualizar)
                            .addGap(18, 18, 18)
                            .addComponent(jbEliminar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jcbBuscar))
                                    .addComponent(jcbFecha, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addComponent(jtfHora))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jrNoVigencia)
                                    .addComponent(jrVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbBuscar)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrNoVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbCargar)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String texto = jtfBuscar.getText();
        try {
            if (!"".equals(texto)) {
                try {
                    int id = Integer.parseInt(texto);
                    if (rdata.buscarInt(id)!=null) {
                        lista.clear();
                        lista.add(rdata.buscarInt(id));
                    }else {
                        JOptionPane.showMessageDialog(this, "La ID ingresada no existe","ID inexistente",JOptionPane.WARNING_MESSAGE);
                        lista = rdata.listarReservas();
                        cargarTabla();
                    }
                } catch(NumberFormatException e) {
                    lista = rdata.buscarString(texto);
                }
                cargarTabla();
            }else{
                lista = rdata.listarReservas();
                cargarTabla();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Error SQL: "+e,"Error SQL",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
        if (!cargando) {
            cargando = true;
            jbCargar.setEnabled(false);
            jbGuardar.setEnabled(true);
            try {
                modelo2.addRow(new Object[] {
                    Enumerar(),
                    "",
                    "",
                    "",
                    fecha,
                    hora,
                    (!"null".equals(vigencia))? vigencia:"",
                });
                jTable.setModel(modelo2);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al cargar el producto: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbCargarActionPerformed
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        int row = modelo2.getRowCount()-1;
        System.out.println(row);
        String mid = modelo2.getValueAt(row, 0).toString();
        String mmesa = modelo2.getValueAt(row, 1).toString();
        String mdni = modelo2.getValueAt(row, 2).toString();
        String mapellido = modelo2.getValueAt(row, 3).toString();
        String mfecha = "";
        if (modelo2.getValueAt(row, 4)!=null) {
            mfecha = modelo2.getValueAt(row, 4).toString();
        }
        String mhora = "";
        if (modelo2.getValueAt(row, 5)!=null) {
            mhora = modelo2.getValueAt(row, 5).toString();
        }
        String mvigencia = modelo2.getValueAt(row, 6).toString();
        Reserva r = new Reserva();
        
        try {
            int id = Integer.parseInt(mid);
            if (id<1) {
                JOptionPane.showMessageDialog(this, "Error el ID no puede ser menor a uno", "Error de tipo ID", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (rdata.buscarInt(id)==null) {
                r.setIdReserva(id);
            }else{
                JOptionPane.showMessageDialog(this, "Error el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el ID ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int mesa = Integer.parseInt(mmesa);
            if (mesa<1) {
                JOptionPane.showMessageDialog(this, "Error el Numero de mesa no puede ser menor a uno", "Error de numero de mesa", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (mdata.buscar(mesa)!=null) {
                r.setMesa(mdata.buscar(mesa));
            }else{
                JOptionPane.showMessageDialog(this, "Error el numero de mesa ingresado no existe", "Error mesa inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el numero de mesa ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mdni.trim().equalsIgnoreCase("")) {
            try {
                int dni = Integer.parseInt(mdni);

                if (mdni.length()>8) {
                    JOptionPane.showMessageDialog(this, "Error el DNI ha superado el maximo de 8 caracteres", "Error DNI supero 8 caracteres", JOptionPane.WARNING_MESSAGE);
                    return;
                }else
                    r.setDni_cliente(mdni);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error el DNI ingresado no es un número entero: "+e, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error el DNI del cliente esta vacío", "Error DNI vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mapellido.trim().equalsIgnoreCase("")) {
            r.setNombre(mapellido);
        }else{
            JOptionPane.showMessageDialog(this, "Error el Apellido del cliente esta vacío", "Error Apellido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            LocalDate fech = LocalDate.parse(mfecha);
            r.setFecha(fech);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error formato de fecha incorrecto, el formato es el siguiente (yyyy-MM-dd)", "Error Fecha incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        try {
            r.setHora(LocalTime.parse(mhora, formato));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error formato de la hora incorrecto, el formato es el siguiente (HH:mm)", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        switch (mvigencia) {
            case ("vigente") : {
                r.setVigencia(mvigencia);
                r.setEstado(true);
                break;
            }
            case ("no_vigente") : {
                r.setVigencia(mvigencia);
                r.setEstado(false);
                break;
            }
            default : {
                JOptionPane.showMessageDialog(this, "Error vigencia invalida, debe ser (vigente o no_vigente)", "Error vigencia incorrecta", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        try {
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jtfBuscar.setText("");
            quitarFiltros();
            jTable.setModel(modelo);
            lista = rdata.listarReservas();
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al guardar la reserva: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        rowSelected = jTable.getSelectedRow();
        if (jTable.getModel()==modelo3) {
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            srowSelected = jTable.getSelectedRow();
            //System.out.println("srow:"+srowSelected);
        }
        if (!cambiando) {
            jbEliminar.setEnabled(true);
            if (cargando==false) {
                jTable.setModel(modelo3);
            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            if (cargando) {
                cargarFiltro();
            }else{
                int codigo = Integer.parseInt(jTable.getValueAt(rowSelected, 0).toString());
                rdata.cambiarVigencia("no_vigente", codigo);
                cargarFiltro();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error de numeracion: "+ex, "Error entero", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cambiar el estado: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTablePropertyChange
        boolean cambiovalido = true;
        
        if (jTable.isEditing()) {
            jTable.getCellEditor().stopCellEditing();
        }
        
        if (jTable.getModel() == modelo3) {
            
            srowSelected = rowSelected;
            
            if (srowSelected == prowSelected) {
                if (prowSelected!=-1) {
                    String mid = modelo3.getValueAt(prowSelected, 0).toString();
                    String mmesa = modelo3.getValueAt(prowSelected, 1).toString();
                    String mdni = modelo3.getValueAt(prowSelected, 2).toString();
                    String mapellido = modelo3.getValueAt(prowSelected, 3).toString();
                    String mfecha = modelo3.getValueAt(prowSelected, 4).toString();
                    String mhora = modelo3.getValueAt(prowSelected, 5).toString();
                    String mvigencia = modelo3.getValueAt(prowSelected, 6).toString();
                    
                    if (mid.equals(pid)&mmesa.equals(pmesa)&
                        mdni.equals(pdni)&mapellido.equals(papellido)&
                        mfecha.equals(pfecha)&mhora.equals(phora)&
                        mvigencia.equals(pvigencia)) {
                        cambiovalido = false;
                    }
                }
                if (srowSelected!=-1&cambiovalido) {
                    cambiando = true;
                    jbActualizar.setEnabled(true);
                    //System.out.println("("+srowSelected+") cambiando: "+cambiando);
                }
            } else {
                if (prowSelected!=-1) {
                    modelo3.setValueAt(pid, prowSelected, 0);
                    modelo3.setValueAt(pmesa, prowSelected, 1);
                    modelo3.setValueAt(pdni, prowSelected, 2);
                    modelo3.setValueAt(papellido, prowSelected, 3);
                    modelo3.setValueAt(pfecha, prowSelected, 4);
                    modelo3.setValueAt(phora, prowSelected, 5);
                    modelo3.setValueAt(pvigencia, prowSelected, 6);
                }
                prowSelected = srowSelected;
                pid = modelo.getValueAt(prowSelected, 0).toString();
                pmesa = modelo.getValueAt(prowSelected, 1).toString();
                pdni = modelo.getValueAt(prowSelected, 2).toString();
                papellido = modelo.getValueAt(prowSelected, 3).toString();
                pfecha = modelo.getValueAt(prowSelected, 4).toString();
                phora = modelo.getValueAt(prowSelected, 5).toString();
                pvigencia = modelo.getValueAt(prowSelected, 6).toString();
                if (srowSelected!=-1) {
                    cambiando = false;
                    jbActualizar.setEnabled(false);
                    //System.out.println("("+srowSelected+") cambiando: "+cambiando);
                }
            }
        }
    }//GEN-LAST:event_jTablePropertyChange

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        String mid = modelo3.getValueAt(srowSelected, 0).toString();
        String mmesa = modelo3.getValueAt(srowSelected, 1).toString();
        String mdni = modelo3.getValueAt(srowSelected, 2).toString();
        String mapellido = modelo3.getValueAt(srowSelected, 3).toString();
        String mfecha = "";
        if (modelo3.getValueAt(srowSelected, 4)!=null) {
            mfecha = modelo3.getValueAt(srowSelected, 4).toString();
        }
        String mhora = "";
        if (modelo3.getValueAt(srowSelected, 5)!=null) {
            mhora = modelo3.getValueAt(srowSelected, 5).toString();
        }
        String mvigencia = modelo3.getValueAt(srowSelected, 6).toString();
        Reserva r = new Reserva();
        
        try {
            int id = Integer.parseInt(mid);
            if (id<1) {
                JOptionPane.showMessageDialog(this, "Error el ID no puede ser menor a uno", "Error de tipo ID", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (rdata.buscarInt(id)==null) {
                r.setIdReserva(id);
            }else{
                if (mid.equals(pid)) {
                    r.setIdReserva(id);
                }else {
                    JOptionPane.showMessageDialog(this, "Error el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el ID ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int mesa = Integer.parseInt(mmesa);
            if (mesa<1) {
                JOptionPane.showMessageDialog(this, "Error el Numero de mesa no puede ser menor a uno", "Error de numero de mesa", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (mdata.buscar(mesa)!=null) {
                r.setMesa(mdata.buscar(mesa));
            }else{
                JOptionPane.showMessageDialog(this, "Error el numero de mesa ingresado no existe", "Error mesa inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el numero de mesa ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mdni.trim().equalsIgnoreCase("")) {
            if (mdni.length()>8) {
                JOptionPane.showMessageDialog(this, "Error el DNI ha superado el maximo de 8 caracteres", "Error DNI supero 8 caracteres", JOptionPane.WARNING_MESSAGE);
                return;
            }else
                r.setDni_cliente(mdni);
        }else{
            JOptionPane.showMessageDialog(this, "Error el DNI del cliente esta vacío", "Error DNI vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mapellido.trim().equalsIgnoreCase("")) {
            r.setNombre(mapellido);
        }else{
            JOptionPane.showMessageDialog(this, "Error el Apellido del cliente esta vacío", "Error Apellido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            LocalDate fech = LocalDate.parse(mfecha);
            r.setFecha(fech);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error formato de fecha incorrecto, el formato es el siguiente (yyyy-MM-dd)", "Error Fecha incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        try {
            r.setHora(LocalTime.parse(mhora, formato));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error formato de la hora incorrecto, el formato es el siguiente (HH:mm)", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        switch (mvigencia) {
            case ("vigente") : {
                r.setVigencia(mvigencia);
                r.setEstado(true);
                break;
            }
            case ("no_vigente") : {
                r.setVigencia(mvigencia);
                r.setEstado(false);
                break;
            }
            default : {
                JOptionPane.showMessageDialog(this, "Error vigencia invalida, debe ser (vigente o no_vigente)", "Error vigencia incorrecta", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        try {
            rdata.actualizarReserva(r,Integer.parseInt(pid));
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jTable.setModel(modelo);
            cargarFiltro();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cambiar el estado: "+e, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jcbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFechaActionPerformed
        jFecha.setEnabled(jcbFecha.isSelected());
        if (!jcbFecha.isSelected()) {
            jFecha.setDate(null);
            fecha = null;
            cargarFiltro();
        }
    }//GEN-LAST:event_jcbFechaActionPerformed

    private void jrVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrVigenciaActionPerformed
        if (jrVigencia.isSelected()) {
            vigencia = "vigente";
            cargarFiltro();
        }
    }//GEN-LAST:event_jrVigenciaActionPerformed

    private void jrNoVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoVigenciaActionPerformed
        if (jrNoVigencia.isSelected()) {
            vigencia = "no_vigente";
            cargarFiltro();
        }
    }//GEN-LAST:event_jrNoVigenciaActionPerformed

    private void jcbHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbHoraActionPerformed
        jtfHora.setEnabled(jcbHora.isSelected());
        if (!jcbHora.isSelected()) {
            jtfHora.setText("00:00");
            hora = null;
            cargarFiltro();
        }
    }//GEN-LAST:event_jcbHoraActionPerformed

    private void jtfHoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfHoraKeyReleased
        String texto = jtfHora.getText();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        try {
            hora = LocalTime.parse(texto, formato);
            cargarFiltro();
        } catch (DateTimeParseException e) {
            hora = null;
            cargarFiltro();
        }
    }//GEN-LAST:event_jtfHoraKeyReleased

    private void jFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFechaPropertyChange
        if (jFecha.getDate()!=null) {
            fecha = LocalDate.of((jFecha.getDate().getYear()+1900), jFecha.getDate().getMonth()+1, jFecha.getDate().getDate());
            cargarFiltro();
        }else {
            fecha = null;
            cargarFiltro();
        }
    }//GEN-LAST:event_jFechaPropertyChange

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        jtfBuscar.setEnabled(jcbBuscar.isSelected());
        jbBuscar.setEnabled(jcbBuscar.isSelected());
        if (jcbBuscar.isSelected()==false) {
            jtfBuscar.setText("");
            cargarFiltro();
        }
    }//GEN-LAST:event_jcbBuscarActionPerformed
    
    public void quitarFiltros() {
        jcbHora.setSelected(false);
        jtfHora.setEnabled(false);
        jtfHora.setText("00:00");
        hora = null;
        jcbFecha.setSelected(false);
        jFecha.setDate(null);
        fecha = null;
        jrVigencia.setSelected(false);
        jrNoVigencia.setSelected(false);
        vigencia = "null";
    }
    
    public void limpiarAcciones() {
        jTable.setModel(modelo);
        Botones(false);
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        cambiando = false;
        pid = null;
        pmesa = null;
        pdni = null;
        papellido = null;
        pfecha = null;
        phora = null;
        pvigencia = null;
        rowSelected = -1;
        srowSelected = -1;
        prowSelected = -1;
    }
    
    public void agregarCabeceras(DefaultTableModel modelos) {
        modelos.addColumn("ID");
        modelos.addColumn("N° de Mesa");
        modelos.addColumn("DNI Cliente");
        modelos.addColumn("Apellido");
        modelos.addColumn("Fecha Reserva");
        modelos.addColumn("Hora Reserva");
        modelos.addColumn("Vigencia");
    }
    
    public void cargarCabecera() {
        agregarCabeceras(modelo);
        agregarCabeceras(modelo2);
        agregarCabeceras(modelo3);
        jTable.setModel(modelo);
    }
    
    private void cargarTabla() {
        limpiarAcciones();
        cargando = false;
        modelo.setRowCount(0);
        modelo2.setRowCount(0);
        modelo3.setRowCount(0);
        for (Reserva r: lista) {
            agregarFila(r);
        }
    }
    
    private void agregarFila(Reserva r) {
        modelo.addRow(new Object[] {
            r.getIdReserva(),
            r.getMesa().getNumeroMesa(),
            r.getDni_cliente(),
            r.getNombre(),
            r.getFecha(),
            r.getHora(),
            r.getVigencia()
        });
        modelo2.addRow(new Object[] {
            r.getIdReserva(),
            r.getMesa().getNumeroMesa(),
            r.getDni_cliente(),
            r.getNombre(),
            r.getFecha(),
            r.getHora(),
            r.getVigencia()
        });
        modelo3.addRow(new Object[] {
            r.getIdReserva(),
            r.getMesa().getNumeroMesa(),
            r.getDni_cliente(),
            r.getNombre(),
            r.getFecha(),
            r.getHora(),
            r.getVigencia()
        });
    }
    
    private void Botones(boolean b) {
        jbActualizar.setEnabled(b);
        jbEliminar.setEnabled(b);
    }
    
    private int Enumerar() throws SQLException {
        int size = rdata.listarReservas().size();
        int numero=0;
        for (int i=1; i<size+10; i++) {
            if (rdata.buscarInt(i)==null) {
                numero = i;
                break;
            }
        }
        return numero;
    }
    
    private void cargarFiltro() {
        try {
            if (hora!=null|fecha!=null|!"null".equals(vigencia)) {
                lista = rdata.buscarReservasPorFechayHorayVigencia(fecha, hora, vigencia);
            }else {
                lista = rdata.listarReservas();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL: "+e,"SQL Error",JOptionPane.ERROR_MESSAGE);
        }
        cargarTabla();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotVigencia;
    private javax.swing.JDesktopPane jDesktopPane1;
    private com.toedter.calendar.JDateChooser jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLfondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbBuscar;
    private javax.swing.JCheckBox jcbFecha;
    private javax.swing.JCheckBox jcbHora;
    private javax.swing.JRadioButton jrNoVigencia;
    private javax.swing.JRadioButton jrVigencia;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfHora;
    // End of variables declaration//GEN-END:variables
}
