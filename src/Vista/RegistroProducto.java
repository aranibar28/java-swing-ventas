package Vista;

import Controlador.Conexion;
import Modelo.Codigo;
import Modelo.Producto;
import Controlador.ProductoDAO;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroProducto extends javax.swing.JInternalFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.getConexion();
    DefaultTableModel model;

    ProductoDAO obj = new ProductoDAO();

    public RegistroProducto() {
        initComponents();

        this.setLocation(150, 20);
        bloquear();
        cargar("");
    }

    void bloquear() {
        txtcod.setEnabled(false);
        txtdes.setEnabled(false);
        txtpre.setEnabled(false);
        txtstock.setEnabled(false);
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(true);
        btncancelar.setEnabled(false);
        btnactualizar.setEnabled(false);
        cbotipo.setEnabled(false);
    }

    void limpiar() {
        txtcod.setText("");
        txtdes.setText("");
        txtpre.setText("");
        txtstock.setText("");
        txtbuscar.setText("");
        cbotipo.setSelectedIndex(0);
        cargar("");
    }

    void desbloquear() {
        txtcod.setEnabled(true);
        txtdes.setEnabled(true);
        txtpre.setEnabled(true);
        txtstock.setEnabled(true);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btncancelar.setEnabled(true);
        cbotipo.setEnabled(true);
    }

    void cargar(String valor) {

        String[] titulos = {"Código", "Descripción", "Precio", "Stock", "Tipo"};
        model = new DefaultTableModel(null, titulos);

        try {
            for (Producto p : obj.MostrarProducto(txtbuscar.getText())) {
                Object mostrar[] = {
                    p.getCodigo(),
                    p.getDescripcion(),
                    p.getPrecio(),
                    p.getStock(),
                    p.getTipo(),};
                model.addRow(mostrar);
            }
            tbproductos.setModel(model);
            tbproductos.getColumnModel().getColumn(0).setPreferredWidth(150);
            tbproductos.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbproductos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbproductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbproductos.getColumnModel().getColumn(4).setPreferredWidth(150);
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    void codigos() {
        int j;
        String c = "";
        String sql = "SELECT MAX(cod_pro) FROM producto";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                txtcod.setText("CP0001");
            } else {
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);
                char r3 = c.charAt(4);
                char r4 = c.charAt(5);
                String r = "";
                r = "" + r1 + r2 + r3 + r4;
                j = Integer.parseInt(r);
                Codigo gen = new Codigo();
                gen.Generar(j);
                txtcod.setText("CP" + gen.serie());
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnactualizar = new javax.swing.JMenuItem();
        mneliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbproductos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        mnactualizar.setText("Modificar");
        mnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnactualizarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnactualizar);

        mneliminar.setText("Eliminar");
        mneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneliminar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("REGISTRO DE PRODUCTOS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código:");

        txtcod.setEditable(false);
        txtcod.setBackground(new java.awt.Color(255, 255, 255));
        txtcod.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtcod.setForeground(new java.awt.Color(0, 204, 102));
        txtcod.setEnabled(false);
        txtcod.setFocusable(false);
        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripción:");

        txtdes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtdes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdesActionPerformed(evt);
            }
        });
        txtdes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdesKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio:");

        txtpre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtpre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpreActionPerformed(evt);
            }
        });
        txtpre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpreKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stock:");

        txtstock.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtstockKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo:");

        cbotipo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N
        cbotipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Abarrotes", "Bebidas", "Tragos", "Lacteos", "Limpieza" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel3))
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpre, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdes, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 320, 220));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);

        btnnuevo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnNuevo.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnGuardar.png"))); // NOI18N
        btnguardar.setText("Grabar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnactualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnActualizar.png"))); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnCancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnactualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, 220));

        tbproductos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tbproductos.setForeground(new java.awt.Color(0, 0, 102));
        tbproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbproductos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tbproductos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 490, 129));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        txtbuscar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 92, -1));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnBuscar.png"))); // NOI18N
        jButton1.setText("Mostrar Todo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnModificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnEliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 100, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Fondo2.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
    txtcod.transferFocus();
}//GEN-LAST:event_txtcodActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
    this.dispose();
}//GEN-LAST:event_btnsalirActionPerformed

private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
    desbloquear();
    limpiar();
    txtcod.requestFocus();
    codigos();
}//GEN-LAST:event_btnnuevoActionPerformed

private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
    bloquear();
    limpiar();
}//GEN-LAST:event_btncancelarActionPerformed

private void txtdesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdesActionPerformed
    txtdes.transferFocus();
}//GEN-LAST:event_txtdesActionPerformed

private void txtpreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpreActionPerformed
    txtpre.transferFocus();
}//GEN-LAST:event_txtpreActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    txtbuscar.setText("");
    cargar("");
}//GEN-LAST:event_jButton1ActionPerformed

private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
    cargar(txtbuscar.getText());
}//GEN-LAST:event_txtbuscarKeyReleased

private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
    int fila = tbproductos.getSelectedRow();
    if (fila >= 0) {
        String cliente = tbproductos.getValueAt(fila, 0).toString();

        try {
            ProductoDAO.getInstancia().Eliminar(cliente);
            JOptionPane.showMessageDialog(null, "Producto Eliminado");
            bloquear();
            limpiar();
            cargar("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    } else {
        JOptionPane.showMessageDialog(this, "No ha selecionado ninguna fila.");
    }
}//GEN-LAST:event_mneliminarActionPerformed

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
    String cod, des, tip;
    double pre;
    int stock;
    int n = cbotipo.getSelectedIndex();

    if (txtcod.getText().compareTo("") != 0
            && txtdes.getText().compareTo("") != 0
            && txtpre.getText().compareTo("") != 0
            && txtstock.getText().compareTo("") != 0
            && n != 0) {

        cod = txtcod.getText();
        des = txtdes.getText();
        pre = Double.parseDouble(txtpre.getText());
        stock = Integer.parseInt(txtstock.getText());
        tip = cbotipo.getSelectedItem().toString();

        Producto producto = new Producto(cod, des, pre, stock, tip);

        try {
            ProductoDAO.getInstancia().Registrar(producto);
            JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
            bloquear();
            limpiar();
            cargar("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    } else {
        JOptionPane.showMessageDialog(null, "Faltan Completar Datos");
    }

}//GEN-LAST:event_btnguardarActionPerformed

private void mnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnactualizarActionPerformed
    int fila = tbproductos.getSelectedRow();
    if (fila >= 0) {
        desbloquear();
        btnactualizar.setEnabled(true);
        btnguardar.setEnabled(false);
        txtcod.setText(tbproductos.getValueAt(fila, 0).toString());
        txtdes.setText(tbproductos.getValueAt(fila, 1).toString());
        txtpre.setText(tbproductos.getValueAt(fila, 2).toString());
        txtstock.setText(tbproductos.getValueAt(fila, 3).toString());
        cbotipo.setSelectedItem(tbproductos.getValueAt(fila, 4).toString());
    } else {
        JOptionPane.showMessageDialog(this, "No ha selecionado ninguna fila.");
        bloquear();
    }
}//GEN-LAST:event_mnactualizarActionPerformed

private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
    String cod, des, tip;
    double pre;
    int stock;

    cod = txtcod.getText();
    des = txtdes.getText();
    pre = Double.parseDouble(txtpre.getText());
    stock = Integer.parseInt(txtstock.getText());
    tip = cbotipo.getSelectedItem().toString();

    Producto producto = new Producto(cod, des, pre, stock, tip);

    try {
        ProductoDAO.getInstancia().Actualizar(producto);
        JOptionPane.showMessageDialog(null, "Registro Actualizado");
        bloquear();
        limpiar();
        cargar("");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
}//GEN-LAST:event_btnactualizarActionPerformed

    private void txtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyTyped
        char car = evt.getKeyChar();
        if (txtstock.getText().length() >= 4) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtstockKeyTyped

    private void txtdesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdesKeyTyped
        if (txtdes.getText().length() >= 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtdesKeyTyped

    private void txtpreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }

        if (evt.getKeyChar() == '.' && txtpre.getText().contains(".")) {
            evt.consume();
        }

    }//GEN-LAST:event_txtpreKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = tbproductos.getSelectedRow();
        if (fila >= 0) {
            desbloquear();
            btnactualizar.setEnabled(true);
            btnguardar.setEnabled(false);
            txtcod.setText(tbproductos.getValueAt(fila, 0).toString());
            txtdes.setText(tbproductos.getValueAt(fila, 1).toString());
            txtpre.setText(tbproductos.getValueAt(fila, 2).toString());
            txtstock.setText(tbproductos.getValueAt(fila, 3).toString());
            cbotipo.setSelectedItem(tbproductos.getValueAt(fila, 4).toString());
        } else {
            JOptionPane.showMessageDialog(this, "No ha selecionado ninguna fila.");
            bloquear();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tbproductos.getSelectedRow();
        if (fila >= 0) {
            String cliente = tbproductos.getValueAt(fila, 0).toString();

            try {
                ProductoDAO.getInstancia().Eliminar(cliente);
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                bloquear();
                limpiar();
                cargar("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "No ha selecionado ninguna fila.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbotipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mnactualizar;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JTable tbproductos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtdes;
    private javax.swing.JTextField txtpre;
    private javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables
}
