package Vista;

import Consultas.BuscarClientesB;
import Consultas.BuscarProductosB;
import Controlador.Conexion;
import Modelo.Numero;
import Modelo.Boleta;
import Controlador.BoletaDAO;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RegistrosBoleta extends javax.swing.JInternalFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.getConexion();

    public RegistrosBoleta() {
        initComponents();
        this.setLocation(40, 30);
        txtfecha.setDisabledTextColor(Color.blue);
        txtfecha.setText(fechaact());
        txtnumbol.setDisabledTextColor(Color.red);
        txtcod.setDisabledTextColor(Color.blue);
        txtdire.setDisabledTextColor(Color.blue);
        txtdni.setDisabledTextColor(Color.blue);
        txtnomape.setDisabledTextColor(Color.blue);
        numeros();
    }

    void descontarstock(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM producto WHERE  cod_pro='" + codi + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(4);
            }
        } catch (SQLException e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE producto SET Stock='" + desfinal + "' WHERE cod_pro = '" + codi + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    private void numeros() {
        String c = "";
        String sql = "select max(num_bol) from boleta";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                txtnumbol.setText("00000001");
            } else {
                int j = Integer.parseInt(c);
                Numero gen = new Numero();
                gen.Generar(j);
                txtnumbol.setText(gen.serie());
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    void calcular() {
        String pre, can;
        int cantidad;
        double precio;
        double subtotal = 0;
        double importe;

        for (int i = 0; i < tbdetbol.getRowCount(); i++) {

            pre = tbdetbol.getValueAt(i, 2).toString();
            can = tbdetbol.getValueAt(i, 3).toString();
            precio = Double.parseDouble(pre);
            cantidad = Integer.parseInt(can);
            importe = precio * cantidad;
            subtotal = subtotal + importe;
            tbdetbol.setValueAt(Math.rint(importe * 100) / 100, i, 4);
        }
        txttotal.setText("" + Math.rint(subtotal * 100) / 100);
    }

    void boleta() {
        String numbol, codcli, total, fecha;
        numbol = txtnumbol.getText();
        codcli = txtcod.getText();
        total = txttotal.getText();
        fecha = txtfecha.getText();

        Boleta boleta = new Boleta(numbol, codcli, total, fecha);
        try {
            BoletaDAO.getInstancia().Registrar(boleta);
            JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente.");

        } catch (SQLException ex) {
            System.out.println("Error RegistroBoleta: " + ex.getMessage());
        }
    }

    void detalleboleta() {
        for (int i = 0; i < tbdetbol.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO detalleboleta(num_bol,cod_pro,des_pro,cant_pro,pre_unit,pre_venta) VALUES (?,?,?,?,?,?)";
            String numbol = txtnumbol.getText();
            String codpro = tbdetbol.getValueAt(i, 0).toString();
            String despro = tbdetbol.getValueAt(i, 1).toString();
            String cantpro = tbdetbol.getValueAt(i, 3).toString();
            String preunit = tbdetbol.getValueAt(i, 2).toString();
            String importe = tbdetbol.getValueAt(i, 4).toString();

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, numbol);
                pst.setString(2, codpro);
                pst.setString(3, despro);
                pst.setString(4, cantpro);
                pst.setString(5, preunit);
                pst.setString(6, importe);
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(RegistrosFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnumbol = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtnomape = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtdire = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnclientes = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnproductos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdetbol = new javax.swing.JTable();
        btncalcular = new javax.swing.JButton();
        btnven = new javax.swing.JButton();
        btneli = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("BOLETA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RUC 20600736711");

        jLabel6.setBackground(new java.awt.Color(51, 51, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("       Boleta de Venta");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nº");

        txtnumbol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnumbol.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtnumbol, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtnumbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        jPanel3.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Señor(es):");

        txtnomape.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtnomape.setEnabled(false);

        txtdni.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtdni.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DNI:");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cod.Cliente:");

        txtcod.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtcod.setEnabled(false);

        txtfecha.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtfecha.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha:");

        txtdire.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtdire.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Direccion:");

        btnclientes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btnclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/BuscarCli.png"))); // NOI18N
        btnclientes.setText("...");
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Productos:");

        btnproductos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btnproductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Buscar.png"))); // NOI18N
        btnproductos.setText("Buscar");
        btnproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtnomape, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfecha))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnclientes)
                                .addGap(0, 74, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtdire, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(2, 2, 2)
                        .addComponent(btnproductos)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtnomape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtdire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(btnproductos))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 118, 500, -1));

        tbdetbol.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tbdetbol.setForeground(new java.awt.Color(0, 0, 204));
        tbdetbol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio", "Cantidad", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbdetbol);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 228, 508, 121));

        btncalcular.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btncalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Calculo.png"))); // NOI18N
        btncalcular.setText(" Realizar Cálculo");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });
        getContentPane().add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 150, -1));

        btnven.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btnven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btnven.setText(" Realizar Venta");
        btnven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenActionPerformed(evt);
            }
        });
        getContentPane().add(btnven, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 150, -1));

        btneli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btneli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar.png"))); // NOI18N
        btneli.setText(" Eliminar");
        btneli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliActionPerformed(evt);
            }
        });
        getContentPane().add(btneli, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 150, -1));

        btnsalir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar.png"))); // NOI18N
        btnsalir.setText(" Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 150, -1));

        txttotal.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txttotal.setForeground(new java.awt.Color(0, 153, 51));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 68, -1));

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Total:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Gustosa S.A.C");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("De: Roxana Caceres  ");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Av. los Angeles Mza. e Lote. 5");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telf: 5291591");

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Lima - Perú");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(16, 16, 16)))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 730, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
    if (tbdetbol.getRowCount() < 1) {
        JOptionPane.showMessageDialog(this, "Porfavor, seleccione un producto.");
    } else {
        calcular();
    }
}//GEN-LAST:event_btncalcularActionPerformed

private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed
    BuscarClientesB cli = new BuscarClientesB();
    Principal.Escritorio.add(cli);
    cli.toFront();
    cli.setVisible(true);
}//GEN-LAST:event_btnclientesActionPerformed

private void btnproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductosActionPerformed
    try {
        BuscarProductosB pro = new BuscarProductosB();
        Principal.Escritorio.add(pro);
        pro.toFront();
        pro.setVisible(true);
    } catch (Exception e) {
    }
}//GEN-LAST:event_btnproductosActionPerformed

private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed
    if ((txtcod.getText().equals("")) || (txttotal.getText().equals(""))) {
        JOptionPane.showMessageDialog(this, "No ingreso cliente/productos o falta realizar operación.");
    } else {
        String capcod = "", capcan = "";
        for (int i = 0; i < RegistrosBoleta.tbdetbol.getRowCount(); i++) {
            capcod = RegistrosBoleta.tbdetbol.getValueAt(i, 0).toString();
            capcan = RegistrosBoleta.tbdetbol.getValueAt(i, 3).toString();
            descontarstock(capcod, capcan);
        }
        boleta();
        detalleboleta();
        txtcod.setText("");
        txtnomape.setText("");
        txtdni.setText("");
        txtdire.setText("");
        txttotal.setText("");

        DefaultTableModel modelo = (DefaultTableModel) tbdetbol.getModel();
        int a = tbdetbol.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
        numeros();
    }

}//GEN-LAST:event_btnvenActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
    this.dispose();
}//GEN-LAST:event_btnsalirActionPerformed

private void btneliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliActionPerformed
    DefaultTableModel model = (DefaultTableModel) tbdetbol.getModel();
    int fila = tbdetbol.getSelectedRow();
    if (fila >= 0) {
        model.removeRow(fila);
        txttotal.setText("");
    } else {
        JOptionPane.showMessageDialog(null, "Tabla vacía o no seleccionó ninguna fila.");
    }

}//GEN-LAST:event_btneliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnclientes;
    private javax.swing.JButton btneli;
    private javax.swing.JButton btnproductos;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnven;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable tbdetbol;
    public static javax.swing.JTextField txtcod;
    public static javax.swing.JTextField txtdire;
    public static javax.swing.JTextField txtdni;
    public static javax.swing.JTextField txtfecha;
    public static javax.swing.JTextField txtnomape;
    private javax.swing.JTextField txtnumbol;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
