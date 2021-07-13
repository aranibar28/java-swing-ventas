package Vista;

import Consultas.BuscarProductosF;
import Consultas.BuscarClientesF;
import Controlador.Conexion;
import Modelo.Factura;
import Controlador.FacturaDAO;
import Modelo.Numero;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RegistrosFactura extends javax.swing.JInternalFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.getConexion();

    public RegistrosFactura() {
        initComponents();
        this.setLocation(50, 20);
        txtfac.setEnabled(false);
        txtfec.setEnabled(false);
        txtfac.setDisabledTextColor(Color.red);
        txtfec.setDisabledTextColor(Color.blue);
        txtfec.setText(fechaactual());
        numeros();
    }

    public void DescontarStock(String codi, String can) {
        int descontar = Integer.parseInt(can);
        String stock = "";
        int DescuentoFinal;
        String consul = "SELECT * FROM producto WHERE  cod_pro='" + codi + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                stock = rs.getString(4);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        DescuentoFinal = Integer.parseInt(stock) - descontar;
        String modificar = "UPDATE producto SET Stock='" + DescuentoFinal + "' WHERE cod_pro = '" + codi + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modificar);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    private void numeros() {
        int j;
        String c = "";
        String SQL = "select max(num_fac) from factura";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                txtfac.setText("00000001");
            } else {
                j = Integer.parseInt(c);
                Numero gen = new Numero();
                gen.Generar(j);
                txtfac.setText(gen.serie());
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrosFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void Calcular() {
        String pre, can;
        int cantidad;
        double precio;
        double importe;
        double subtotal = 0;
        double igv = 0;
        double total = 0;

        for (int i = 0; i < tbdet.getRowCount(); i++) {
            pre = tbdet.getValueAt(i, 2).toString();
            can = tbdet.getValueAt(i, 3).toString();
            precio = Double.parseDouble(pre);
            cantidad = Integer.parseInt(can);

            importe = precio * cantidad;
            subtotal = subtotal + importe;
            igv = subtotal * 0.18;
            total = subtotal + igv;

            tbdet.setValueAt(Math.rint(importe * 100) / 100, i, 4);
        }
        txtsubtotal.setText(Double.toString(subtotal));
        txtigv.setText("" + Math.rint(igv * 100) / 100);
        txttotal.setText("" + Math.rint(total * 100) / 100);

    }

    void Registrar() {

        String numfac, codcli, ruccli, fecha;
        double subtotal, igv, total;
        numfac = txtfac.getText();
        codcli = txtcod.getText();
        ruccli = txtruc.getText();
        subtotal = Double.parseDouble(txtsubtotal.getText());
        igv = Double.parseDouble(txtigv.getText());
        total = Double.parseDouble(txttotal.getText());
        fecha = txtfec.getText();

        Factura factura = new Factura(numfac, codcli, ruccli, subtotal, igv, total, fecha);
        try {
            FacturaDAO.getInstancia().Registrar(factura);
            JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente.");

        } catch (SQLException ex) {
            System.out.println("Error RegistroFactura: " + ex.getMessage());
        }
    }

    void detallefactura() {
        for (int i = 0; i < tbdet.getRowCount(); i++) {
            String sql = "INSERT INTO detallefactura(num_fac,cod_pro,des_pro,cant_pro,pre_unit,pre_tot) VALUES (?,?,?,?,?,?)";
            String numfac = txtfac.getText();
            String codpro = tbdet.getValueAt(i, 0).toString();
            String despro = tbdet.getValueAt(i, 1).toString();
            String cantpro = tbdet.getValueAt(i, 3).toString();
            String preunit = tbdet.getValueAt(i, 2).toString();
            String importe = tbdet.getValueAt(i, 4).toString();

            try {
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, numfac);
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtnomape = new javax.swing.JTextField();
        btnclientes = new javax.swing.JButton();
        txtruc = new javax.swing.JTextField();
        btnproductos = new javax.swing.JButton();
        txtcod = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        txtdir = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtfec = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtfac = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtigv = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        tbdetalle = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdet = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
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
        setTitle("FACTURA");
        setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, -1, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 11, 470, -1));

        jPanel2.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Señor(a):");

        txtnomape.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtnomape.setForeground(new java.awt.Color(102, 0, 102));
        txtnomape.setEnabled(false);

        btnclientes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btnclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/BuscarCli.png"))); // NOI18N
        btnclientes.setText("...");
        btnclientes.setToolTipText("");
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });

        txtruc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtruc.setForeground(new java.awt.Color(102, 0, 102));
        txtruc.setEnabled(false);

        btnproductos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btnproductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Buscar.png"))); // NOI18N
        btnproductos.setText("Buscar");
        btnproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductosActionPerformed(evt);
            }
        });

        txtcod.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtcod.setForeground(new java.awt.Color(102, 0, 102));
        txtcod.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cod. Cliente:");

        txtdni.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtdni.setForeground(new java.awt.Color(102, 0, 102));
        txtdni.setEnabled(false);

        txtdir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtdir.setForeground(new java.awt.Color(102, 0, 102));
        txtdir.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Direccion:");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DNI:");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("RUC:");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha:");

        txtfec.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtfec.setForeground(new java.awt.Color(102, 0, 102));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Articulo:");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("FACTURA DE VENTA");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RUC 20600736711");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nº");

        txtfac.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfac))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel15))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtfac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnproductos))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtnomape, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnclientes))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(2, 2, 2)
                                .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtruc, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(txtfec))))
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtnomape)
                            .addComponent(btnclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(btnproductos)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 118, 673, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("SubTotal:");

        txtsubtotal.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtsubtotal.setForeground(new java.awt.Color(0, 153, 51));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("IGV:");

        txtigv.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtigv.setForeground(new java.awt.Color(0, 153, 51));

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Total:");

        txttotal.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txttotal.setForeground(new java.awt.Color(0, 153, 51));

        tbdetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));

        tbdet.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tbdet.setForeground(new java.awt.Color(0, 51, 204));
        tbdet.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbdet);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 18, Short.MAX_VALUE)
                    .addComponent(tbdetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 18, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 90, Short.MAX_VALUE)
                    .addComponent(tbdetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 89, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 240, 490, -1));

        jPanel5.setOpaque(false);

        btnguardar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btnguardar.setText(" Realizar Venta");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar.png"))); // NOI18N
        btnsalir.setText(" Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btncalcular.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btncalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Calculo.png"))); // NOI18N
        btncalcular.setText(" Realizar Cálculo");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar.png"))); // NOI18N
        btneliminar.setText(" Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btncalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 720, 440));

        setBounds(0, 0, 725, 466);
    }// </editor-fold>//GEN-END:initComponents
public static String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed
    BuscarClientesF cli = new BuscarClientesF();
    Principal.Escritorio.add(cli);
    cli.toFront();
    cli.setVisible(true);
}//GEN-LAST:event_btnclientesActionPerformed

private void btnproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductosActionPerformed
    try {
        BuscarProductosF pro = new BuscarProductosF();
        Principal.Escritorio.add(pro);
        pro.toFront();
        pro.setVisible(true);
    } catch (Exception e) {
    }
}//GEN-LAST:event_btnproductosActionPerformed

private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
    if (tbdet.getRowCount() < 1) {
        JOptionPane.showMessageDialog(this, "Porfavor, seleccione un producto.");
    } else {
        Calcular();
    }
}//GEN-LAST:event_btncalcularActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
    this.dispose();
}//GEN-LAST:event_btnsalirActionPerformed

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
    if ((txtcod.getText().equals("")) || (txtsubtotal.getText().equals(""))) {
        JOptionPane.showMessageDialog(this, "No ingreso cliente/productos o falta realizar operación.");
    } else {
        String capcod = "", capcan = "";
        for (int i = 0; i < RegistrosFactura.tbdet.getRowCount(); i++) {
            capcod = RegistrosFactura.tbdet.getValueAt(i, 0).toString();
            capcan = RegistrosFactura.tbdet.getValueAt(i, 3).toString();
            DescontarStock(capcod, capcan);
        }
        Registrar();
        detallefactura();

        txtcod.setText("");
        txtnomape.setText("");
        txtdir.setText("");
        txtdni.setText("");
        txtigv.setText("");
        txtsubtotal.setText("");
        txtruc.setText("");
        txttotal.setText("");

        DefaultTableModel modelo = (DefaultTableModel) tbdet.getModel();
        int a = tbdet.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
        numeros();
    }
}//GEN-LAST:event_btnguardarActionPerformed

private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
    DefaultTableModel modelo = (DefaultTableModel) tbdet.getModel();
    int fila = tbdet.getSelectedRow();
    if (fila >= 0) {
        modelo.removeRow(fila);
        txtigv.setText("");
        txtsubtotal.setText("");
        txttotal.setText("");
    } else {
        JOptionPane.showMessageDialog(null, "Tabla vacía o no seleccionó ninguna fila.");
    }
}//GEN-LAST:event_btneliminarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnclientes;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnproductos;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable tbdet;
    private javax.swing.JTable tbdetalle;
    public static javax.swing.JTextField txtcod;
    public static javax.swing.JTextField txtdir;
    public static javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtfac;
    private javax.swing.JTextField txtfec;
    private javax.swing.JTextField txtigv;
    public static javax.swing.JTextField txtnomape;
    public static javax.swing.JTextField txtruc;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
