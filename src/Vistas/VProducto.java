
package Vistas;

import java.sql.*;
import Modelo.Conexion;
import Modelo.Producto;
import Persistencia.ProductosData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VProducto extends javax.swing.JInternalFrame {
    
    private ArrayList<Producto> lista = new ArrayList<>();
    private ProductosData pdata = new ProductosData();
    private Connection con = Conexion.cargaConexion();
    private boolean cargando = false;
    
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return fila == modelo.getRowCount() - 1;
        }
    };
    
    public VProducto() {
        initComponents();
        try {
            lista = pdata.listar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        
        Botones(false);
        cargarCabecera();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jcCategoria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbCargar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por codigo/nombre:  ");

        jbBuscar.setText("Buscar");
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

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Categorias:");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio", "Stock", "Categoria", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jbCargar.setText("Cargar");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");

        jbEliminar.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfBuscar))
                .addGap(12, 12, 12)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEliminar)
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbBuscar)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar)
                    .addComponent(jbCargar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCategoriaActionPerformed
        
    }//GEN-LAST:event_jcCategoriaActionPerformed

    private void jcCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcCategoriaItemStateChanged
        String filtro;
        String nombre = jtfBuscar.getText();
        switch (jcCategoria.getSelectedItem().toString()) {
            case ("0-todas") : {filtro="todas";break;}
            case ("1-pizzas") : {filtro="pizzas";break;}
            case ("2-hamburguesas") : {filtro="hamburguesas";break;}
            case ("3-lomos") : {filtro="lomos";break;}
            case ("4-tacos") : {filtro="tacos";break;}
            case ("5-bebidas/a") : {filtro="bebidas sin alcohol";break;}
            case ("6-bebidasc/a") : {filtro="bebidas con alcohol";break;}
            case ("7-gaseosas") : {filtro="bebidas gaseosas";break;}
            default : {filtro="ninguna";break;}
        }
        
        try {
            if (nombre.trim().isEmpty()) {
                if ("todas".equals(filtro)) {
                    lista = pdata.listar();
                }else
                    lista = pdata.filtrarCategoria(filtro);
            }else{
                if ("todas".equals(filtro)) {
                    lista = pdata.listar();
                }else
                    lista = pdata.filtrarCategoriaYNombre(filtro,nombre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla con filtro: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        cargarTabla();
    }//GEN-LAST:event_jcCategoriaItemStateChanged

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String buscar = jtfBuscar.getText();
        
        try {
            int codigo = Integer.parseInt(buscar);
            
            lista.clear();
            try {
                lista.add(pdata.buscar(codigo));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al buscar por codigo: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException e) {
            try {
                lista = pdata.buscarPorNombre(buscar);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al buscar por nombre: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
        cargarTabla();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
        if (!cargando) {
            cargando = true;
            try {
                modelo.addRow(new Object[] {
                    Enumerar(),
                    "",
                    "",
                    "",
                    "",
                    ""
                });
                int row = modelo.getRowCount()-1;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al cargar el producto: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_jbCargarActionPerformed
    
    public void cargarCabecera() {
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Categoria");
        modelo.addColumn("Estado");
        jTable.setModel(modelo);
    }
    
    private void cargarTabla() {
        cargando = false;
        modelo.setRowCount(0);
        for (Producto p: lista) {
            agregarFila(p);
        }
    }
    
    private void agregarFila(Producto p) {
        modelo.addRow(new Object[] {
            p.getCodigo(),
            p.getNombre(),
            p.getPrecio(),
            p.getStock(),
            p.getCategoria(),
            p.isEstado()
        });
    }
    
    private void Botones(boolean b) {
        jbActualizar.setEnabled(b);
        jbEliminar.setEnabled(b);
    }
    
    private int Enumerar() throws SQLException {
        int size = pdata.listar().size();
        int numero=0;
        for (int i=1; i<size+10; i++) {
            if (pdata.buscar(i)==null) {
                numero = i;
                break;
            }
        }
        return numero;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JComboBox<String> jcCategoria;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
