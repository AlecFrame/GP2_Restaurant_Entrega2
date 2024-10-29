
package Vistas;

import java.sql.*;
import Modelo.Conexion;
import Modelo.Mesa;
import Persistencia.MesaData;
import Persistencia.MeseroData;
import Persistencia.ProductosData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VMesa extends javax.swing.JInternalFrame {
    
    private ArrayList<Mesa> lista = new ArrayList<>();
    private ProductosData pdata = new ProductosData();
    private MesaData mdata = new MesaData();
    private MeseroData msdata = new MeseroData();
    private Connection con = Conexion.cargaConexion();
    private int rowSelected = -1;
    private int srowSelected = -1;
    private int prowSelected = -1;
    private boolean cargando = false;
    private boolean cambiando = false;
    
    private String pnumero = null;
    private String pcapacidad = null;
    private String pcondicion = null;
    private String pestado = null;
    private String pmesero = null;
    
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
    
    public VMesa() {
        initComponents();
        try {
            lista = mdata.listarMesas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        
        jbGuardar.setEnabled(false);
        Botones(false);
        cargarCabecera();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        GrupoBotMesa = new javax.swing.ButtonGroup();
        jbBuscar = new javax.swing.JButton();
        jcCategoria = new javax.swing.JComboBox<>();
        jbCondicion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbCargar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLfondo = new javax.swing.JLabel();
        jBotonMesa = new javax.swing.JRadioButton();
        jBotonCapacidad = new javax.swing.JRadioButton();
        jbBuscaPor = new javax.swing.JLabel();

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

        setBackground(new java.awt.Color(204, 187, 161));
        setBorder(null);
        setForeground(new java.awt.Color(255, 255, 204));
        setTitle("Mesa");
        setFont(new java.awt.Font("Calibri", 1, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo5.png"))); // NOI18N

        jbBuscar.setBackground(new java.awt.Color(153, 102, 0));
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

        jcCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0-todas", "1-pizzas", "2-hamburguesas", "3-lomos", "4-tacos", "5-bebidas/a", "6-bebidasc/a", "7-gaseosas" }));
        jcCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcCategoriaItemStateChanged(evt);
            }
        });
        jcCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCategoriaActionPerformed(evt);
            }
        });

        jbCondicion.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jbCondicion.setText("Condición:");

        jTable.setBackground(new java.awt.Color(255, 255, 204));
        jTable.setBorder(new javax.swing.border.MatteBorder(null));
        jTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable.setForeground(new java.awt.Color(153, 102, 0));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null}
            },
            new String [] {
                "Nro de mesa", "Capacidad", "Condicion", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setHeaderValue("Nro de mesa");
            jTable.getColumnModel().getColumn(1).setHeaderValue("Capacidad");
            jTable.getColumnModel().getColumn(2).setHeaderValue("Condicion");
            jTable.getColumnModel().getColumn(3).setHeaderValue("Estado");
        }

        jbCargar.setBackground(new java.awt.Color(153, 102, 0));
        jbCargar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbCargar.setForeground(new java.awt.Color(255, 255, 204));
        jbCargar.setText("Cargar");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        jbActualizar.setBackground(new java.awt.Color(153, 102, 0));
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

        jbGuardar.setBackground(new java.awt.Color(153, 102, 0));
        jbGuardar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(255, 255, 204));
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 204));
        jButton1.setText("Cerrar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLfondo.setBackground(new java.awt.Color(255, 204, 153));
        jLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/mesa1.jpg"))); // NOI18N

        jBotonMesa.setBackground(new java.awt.Color(204, 187, 161));
        GrupoBotMesa.add(jBotonMesa);
        jBotonMesa.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jBotonMesa.setText("Número de mesa");
        jBotonMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonMesaActionPerformed(evt);
            }
        });

        jBotonCapacidad.setBackground(new java.awt.Color(204, 187, 161));
        GrupoBotMesa.add(jBotonCapacidad);
        jBotonCapacidad.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jBotonCapacidad.setText("Capacidad");

        jbBuscaPor.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jbBuscaPor.setText("Busca por:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jbCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jbBuscaPor)
                                .addComponent(jbCondicion))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBotonCapacidad)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jBotonMesa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jcCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBotonMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaPor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBotonCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCondicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbCargar)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCategoriaActionPerformed
        
    }//GEN-LAST:event_jcCategoriaActionPerformed

    private void jcCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcCategoriaItemStateChanged
        
    }//GEN-LAST:event_jcCategoriaItemStateChanged

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        
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
                    "",
                });
                jTable.setModel(modelo2);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al cargar el producto: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbCargarActionPerformed
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTablePropertyChange
        
    }//GEN-LAST:event_jTablePropertyChange

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jBotonMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBotonMesaActionPerformed
    
    public void limpiarAcciones() {
        jTable.setModel(modelo);
        Botones(false);
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        cambiando = false;
        pnumero = null;
        pcapacidad = null;
        pcondicion = null;
        pestado = null;
        pmesero = null;
        rowSelected = -1;
        srowSelected = -1;
        prowSelected = -1;
    }
    
    public void cargarModelo(DefaultTableModel modelos) {
        modelos.addColumn("N° de Mesa");
        modelos.addColumn("Capacidad");
        modelos.addColumn("Condicion");
        modelos.addColumn("Estado");
        modelos.addColumn("Mesero Asignado");
    }
    
    public void cargarCabecera() {
        cargarModelo(modelo);
        cargarModelo(modelo2);
        cargarModelo(modelo3);
        jTable.setModel(modelo);
    }
    
    private void cargarTabla() {
        limpiarAcciones();
        cargando = false;
        modelo.setRowCount(0);
        modelo2.setRowCount(0);
        modelo3.setRowCount(0);
        for (Mesa m: lista) {
            agregarFila(m);
        }
    }
    
    private void agregarFila(Mesa m) {
        modelo.addRow(new Object[] {
            m.getNumeroMesa(),
            m.getCapacidad(),
            m.getOcupada(),
            m.isEstado(),
            m.getMesero().getDniMesero(),
        });
    }
    
    private void Botones(boolean b) {
        jbActualizar.setEnabled(b);
        jbEliminar.setEnabled(b);
    }
    
    private int Enumerar() throws SQLException {
        int size = mdata.listarMesas().size();
        int numero=0;
        for (int i=1; i<size+10; i++) {
            if (mdata.buscar(i)==null) {
                numero = i;
                break;
            }
        }
        return numero;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotMesa;
    private javax.swing.JRadioButton jBotonCapacidad;
    private javax.swing.JRadioButton jBotonMesa;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLfondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JLabel jbBuscaPor;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JLabel jbCondicion;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JComboBox<String> jcCategoria;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
