
package Vistas;

import java.sql.*;
import Modelo.Conexion;
import Modelo.Producto;
import Persistencia.ProductosData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VReservas extends javax.swing.JInternalFrame {
    
    private ArrayList<Producto> lista = new ArrayList<>();
    private ProductosData pdata = new ProductosData();
    private Connection con = Conexion.cargaConexion();
    private int rowSelected = -1;
    private int srowSelected = -1;
    private int prowSelected = -1;
    private boolean cargando = false;
    private boolean cambiando = false;
    
    private String pcodigo = null;
    private String pnombre = null;
    private String pprecio = null;
    private String pstock = null;
    private String pcategoria = null;
    private String pestado = null;
    
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
            lista = pdata.listar();
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
        jButton1 = new javax.swing.JButton();
        jLfondo = new javax.swing.JLabel();
        jcbFecha = new javax.swing.JCheckBox();
        jcbHora = new javax.swing.JCheckBox();
        jrVigencia = new javax.swing.JRadioButton();
        jrNoVigencia = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();

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

        jCheckBox1.setBackground(new java.awt.Color(204, 187, 165));
        jCheckBox1.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jCheckBox1.setText("ID / Apellido:");

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcbFecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbHora)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jrVigencia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrNoVigencia))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(109, 109, 109)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrNoVigencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        String filtro=null;
        
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
                    filtro,
                    ""
                });
                jTable.setModel(modelo2);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al cargar el producto: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbCargarActionPerformed
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        int row = modelo2.getRowCount()-1;
        String mcodigo = modelo2.getValueAt(row, 0).toString();
        String mnombre = modelo2.getValueAt(row, 1).toString();
        String mprecio = modelo2.getValueAt(row, 2).toString();
        String mstock = modelo2.getValueAt(row, 3).toString();
        String mcategoria = modelo2.getValueAt(row, 4).toString();
        String mestado = modelo2.getValueAt(row, 5).toString();
        Producto p = new Producto();
        
        Set<String> categorias = new HashSet<>();
        categorias.add("1");
        categorias.add("2");
        categorias.add("3");
        categorias.add("4");
        categorias.add("5");
        categorias.add("6");
        categorias.add("7");
        categorias.add("pizzas");
        categorias.add("lomos");
        categorias.add("hamburguesas");
        categorias.add("tacos");
        categorias.add("bebidas con alcohol");
        categorias.add("bebidas sin alcohol");
        categorias.add("bebidas gaseosas");
        
        try {
            int codigo = Integer.parseInt(mcodigo);
            if (codigo<1) {
                JOptionPane.showMessageDialog(this, "Error el codigo no puede ser menor a uno", "Error de tipo codigo", JOptionPane.ERROR_MESSAGE);
                return;
            }else
            if (pdata.buscar(codigo)==null) {
                p.setCodigo(codigo);
            }else{
                JOptionPane.showMessageDialog(this, "Error el codigo ingresado ya existe en la base de datos", "Error codigo existente", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el codigo ingresado no es un numero entero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!mnombre.trim().equalsIgnoreCase("")) {
            p.setNombre(mnombre);
        }else{
            JOptionPane.showMessageDialog(this, "Error el nombre esta vacio", "Error nombre vacio", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            double precio = Double.parseDouble(mprecio);
            p.setPrecio(precio);
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error el precio ingresado no es un numero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int stock = Integer.parseInt(mstock);
            p.setStock(stock);
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error el stock ingresado no es un numero entero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (categorias.contains(mcategoria)) {
            switch (mcategoria.toLowerCase()) {
                case ("1") : case ("pizzas") : {
                    p.setCategoria("pizzas");break;
                }
                case ("2") : case ("lomos") : {
                    p.setCategoria("lomos");break;
                }
                case ("3") : case ("hamburguesas") : {
                    p.setCategoria("hamburguesas");break;
                }
                case ("4") : case ("tacos") : {
                    p.setCategoria("tacos");break;
                }
                case ("5") : case ("bebidas con alcohol") : {
                    p.setCategoria("bebidas con alcohol");break;
                }
                case ("6") : case ("bebidas sin alcohol") : {
                    p.setCategoria("bebidas sin alcohol");break;
                }
                case ("7") : case ("bebidas gaseosas") : {
                    p.setCategoria("bebidas gaseosas");break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error la categoria solo puede ser:(1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas)", "Error nombre vacio", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            p.setEstado(mestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Errorn el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            pdata.guardarProducto(p);
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jtfBuscar.setText("");
            jTable.setModel(modelo);
            lista = pdata.listar();
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al guardar el producto: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
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
        try {
            if (cargando) {
                cargarFiltro();
            }else{
                int codigo = Integer.parseInt(jTable.getValueAt(rowSelected, 0).toString());
                pdata.CambiarEstado(false, codigo);
                cargarFiltro();
            }
        } catch (NumberFormatException | SQLException ex) {
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
                    String mcodigo = modelo3.getValueAt(prowSelected, 0).toString();
                    String mnombre = modelo3.getValueAt(prowSelected, 1).toString();
                    String mprecio = modelo3.getValueAt(prowSelected, 2).toString();
                    String mstock = modelo3.getValueAt(prowSelected, 3).toString();
                    String mcategoria = modelo3.getValueAt(prowSelected, 4).toString();
                    String mestado = modelo3.getValueAt(prowSelected, 5).toString();
                    
                    if (mcodigo.equals(pcodigo)&mnombre.equals(pnombre)&
                        mprecio.equals(pprecio)&mstock.equals(pstock)&
                        mcategoria.equals(pcategoria)&mestado.equals(pestado)) {
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
                    modelo3.setValueAt(pcodigo, prowSelected, 0);
                    modelo3.setValueAt(pnombre, prowSelected, 1);
                    modelo3.setValueAt(pprecio, prowSelected, 2);
                    modelo3.setValueAt(pstock, prowSelected, 3);
                    modelo3.setValueAt(pcategoria, prowSelected, 4);
                    modelo3.setValueAt(pestado, prowSelected, 5);
                }
                prowSelected = srowSelected;
                pcodigo = modelo.getValueAt(prowSelected, 0).toString();
                pnombre = modelo.getValueAt(prowSelected, 1).toString();
                pprecio = modelo.getValueAt(prowSelected, 2).toString();
                pstock = modelo.getValueAt(prowSelected, 3).toString();
                pcategoria = modelo.getValueAt(prowSelected, 4).toString();
                pestado = modelo.getValueAt(prowSelected, 5).toString();
                if (srowSelected!=-1) {
                    cambiando = false;
                    jbActualizar.setEnabled(false);
                    //System.out.println("("+srowSelected+") cambiando: "+cambiando);
                }
            }
        }
    }//GEN-LAST:event_jTablePropertyChange

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        String mcodigo = modelo3.getValueAt(srowSelected, 0).toString();
        String mnombre = modelo3.getValueAt(srowSelected, 1).toString();
        String mprecio = modelo3.getValueAt(srowSelected, 2).toString();
        String mstock = modelo3.getValueAt(srowSelected, 3).toString();
        String mcategoria = modelo3.getValueAt(srowSelected, 4).toString();
        String mestado = modelo3.getValueAt(srowSelected, 5).toString();
        Producto p = new Producto();
        
        Set<String> categorias = new HashSet<>();
        categorias.add("1");
        categorias.add("2");
        categorias.add("3");
        categorias.add("4");
        categorias.add("5");
        categorias.add("6");
        categorias.add("7");
        categorias.add("pizzas");
        categorias.add("lomos");
        categorias.add("hamburguesas");
        categorias.add("tacos");
        categorias.add("bebidas con alcohol");
        categorias.add("bebidas sin alcohol");
        categorias.add("bebidas gaseosas");
        String cambios = "";
        
        try {
            int codigo = Integer.parseInt(mcodigo);
            if (codigo<1) {
                JOptionPane.showMessageDialog(this, "Error el codigo no puede ser menor a uno", "Error de tipo codigo", JOptionPane.ERROR_MESSAGE);
                return;
            }else
            if (pdata.buscar(codigo)==null) {
                p.setCodigo(codigo);
                cambios += "codigo";
            }else{
                if (mcodigo.equals(pcodigo)) {
                    p.setCodigo(codigo);
                }else{
                    JOptionPane.showMessageDialog(this, "Error el codigo ingresado ya existe en la base de datos", "Error codigo existente", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el codigo ingresado no es un numero entero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!mnombre.trim().equalsIgnoreCase("")) {
            p.setNombre(mnombre);
            cambios += ",nombre";
        }else{
            JOptionPane.showMessageDialog(this, "Error el nombre esta vacio", "Error nombre vacio", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            double precio = Double.parseDouble(mprecio);
            p.setPrecio(precio);
            cambios += ",precio";
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error el precio ingresado no es un numero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int stock = Integer.parseInt(mstock);
            p.setStock(stock);
            cambios += ",stock";
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error el stock ingresado no es un numero entero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (categorias.contains(mcategoria)) {
            switch (mcategoria.toLowerCase()) {
                case ("1") : case ("pizzas") : {
                    p.setCategoria("pizzas");break;
                }
                case ("2") : case ("lomos") : {
                    p.setCategoria("lomos");break;
                }
                case ("3") : case ("hamburguesas") : {
                    p.setCategoria("hamburguesas");break;
                }
                case ("4") : case ("tacos") : {
                    p.setCategoria("tacos");break;
                }
                case ("5") : case ("bebidas con alcohol") : {
                    p.setCategoria("bebidas con alcohol");break;
                }
                case ("6") : case ("bebidas sin alcohol") : {
                    p.setCategoria("bebidas sin alcohol");break;
                }
                case ("7") : case ("bebidas gaseosas") : {
                    p.setCategoria("bebidas gaseosas");break;
                }
            }
            cambios += ",categoria";
        }else{
            JOptionPane.showMessageDialog(this, "Error la categoria solo puede ser:(1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas)", "Error nombre vacio", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            p.setEstado(mestado.equalsIgnoreCase("true"));
            cambios += ",estado";
        }else{
            JOptionPane.showMessageDialog(this, "Errorn el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        pdata.actualizar(p,cambios,Integer.parseInt(pcodigo));
        cargando = false;
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        jTable.setModel(modelo);
        cargarFiltro();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jcbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFechaActionPerformed

    private void jrVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrVigenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrVigenciaActionPerformed

    private void jrNoVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoVigenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrNoVigenciaActionPerformed
    
    public void limpiarAcciones() {
        jTable.setModel(modelo);
        Botones(false);
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        cambiando = false;
        pcodigo = null;
        pnombre = null;
        pprecio = null;
        pstock = null;
        pcategoria = null;
        pestado = null;
        rowSelected = -1;
        srowSelected = -1;
        prowSelected = -1;
    }
    
    public void cargarCabecera() {
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Categoria");
        modelo.addColumn("Estado");
        jTable.setModel(modelo);
        modelo2.addColumn("Código");
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Precio");
        modelo2.addColumn("Stock");
        modelo2.addColumn("Categoria");
        modelo2.addColumn("Estado");
        modelo3.addColumn("Código");
        modelo3.addColumn("Nombre");
        modelo3.addColumn("Precio");
        modelo3.addColumn("Stock");
        modelo3.addColumn("Categoria");
        modelo3.addColumn("Estado");
    }
    
    private void cargarTabla() {
        limpiarAcciones();
        cargando = false;
        modelo.setRowCount(0);
        modelo2.setRowCount(0);
        modelo3.setRowCount(0);
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
        modelo2.addRow(new Object[] {
            p.getCodigo(),
            p.getNombre(),
            p.getPrecio(),
            p.getStock(),
            p.getCategoria(),
            p.isEstado()
        });
        modelo3.addRow(new Object[] {
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
    
    private void cargarFiltro() {
        String filtro=null;
        String nombre = jtfBuscar.getText();
        
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
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotVigencia;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLfondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JCheckBox jcbFecha;
    private javax.swing.JCheckBox jcbHora;
    private javax.swing.JRadioButton jrNoVigencia;
    private javax.swing.JRadioButton jrVigencia;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
