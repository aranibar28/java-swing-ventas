package Vista;
import Consultas.*;

public class Principal extends javax.swing.JFrame {
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        txtUser = new javax.swing.JLabel();
        lblusu = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mCerrar = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mClientes = new javax.swing.JMenuItem();
        mProductos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mFactura = new javax.swing.JMenuItem();
        mBoleta = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mConsultaFacturas = new javax.swing.JMenuItem();
        mConsultaBoletas = new javax.swing.JMenuItem();
        mConsultaClientes = new javax.swing.JMenuItem();
        mConsultaProductos = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mNuevoUsuario = new javax.swing.JMenuItem();
        mAyuda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mFinalizar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Ventas");
        setIconImages(null);

        Escritorio.setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1490, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        Escritorio.add(jPanel1);
        jPanel1.setBounds(0, 0, 1490, 800);

        txtUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtUser.setForeground(new java.awt.Color(0, 204, 102));
        txtUser.setText("Usuario Conectado:");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Inicio.png"))); // NOI18N
        jMenu1.setText("Archivo");

        mCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/CerrarSesion.png"))); // NOI18N
        mCerrar.setText("Cerrar Sesión");
        mCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCerrarActionPerformed(evt);
            }
        });
        jMenu1.add(mCerrar);

        mSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Salir.png"))); // NOI18N
        mSalir.setText("Salir");
        mSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Mantenimiento.png"))); // NOI18N
        jMenu2.setText("Mantenimiento");

        mClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Clientes.png"))); // NOI18N
        mClientes.setText("Clientes");
        mClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mClientesActionPerformed(evt);
            }
        });
        jMenu2.add(mClientes);

        mProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Productos.png"))); // NOI18N
        mProductos.setText("Productos");
        mProductos.setToolTipText("");
        mProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mProductosActionPerformed(evt);
            }
        });
        jMenu2.add(mProductos);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Movimiento.png"))); // NOI18N
        jMenu3.setText("Movimiento");

        mFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Factura.png"))); // NOI18N
        mFactura.setText("Factura");
        mFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFacturaActionPerformed(evt);
            }
        });
        jMenu3.add(mFactura);

        mBoleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Boleta.png"))); // NOI18N
        mBoleta.setText("Boleta");
        mBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mBoletaActionPerformed(evt);
            }
        });
        jMenu3.add(mBoleta);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Consultas.png"))); // NOI18N
        jMenu4.setText("Consultas");

        mConsultaFacturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Factura.png"))); // NOI18N
        mConsultaFacturas.setText("Facturas");
        mConsultaFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConsultaFacturasActionPerformed(evt);
            }
        });
        jMenu4.add(mConsultaFacturas);

        mConsultaBoletas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Boleta.png"))); // NOI18N
        mConsultaBoletas.setText("Boletas");
        mConsultaBoletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConsultaBoletasActionPerformed(evt);
            }
        });
        jMenu4.add(mConsultaBoletas);

        mConsultaClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/SearchClient.png"))); // NOI18N
        mConsultaClientes.setText("Clientes");
        mConsultaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConsultaClientesActionPerformed(evt);
            }
        });
        jMenu4.add(mConsultaClientes);

        mConsultaProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Productos.png"))); // NOI18N
        mConsultaProductos.setText("Productos");
        mConsultaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConsultaProductosActionPerformed(evt);
            }
        });
        jMenu4.add(mConsultaProductos);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reportes.png"))); // NOI18N
        jMenu5.setText("Reportes");

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Factura.png"))); // NOI18N
        jMenuItem13.setText("Facturas");
        jMenu5.add(jMenuItem13);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Boleta.png"))); // NOI18N
        jMenuItem14.setText("Boletas");
        jMenu5.add(jMenuItem14);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ReportClient.png"))); // NOI18N
        jMenuItem6.setText("Clientes");
        jMenu5.add(jMenuItem6);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Productos.png"))); // NOI18N
        jMenuItem12.setText("Productos");
        jMenu5.add(jMenuItem12);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Administrador.png"))); // NOI18N
        jMenu6.setText("Administrador");

        mNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Nuevo.png"))); // NOI18N
        mNuevoUsuario.setText("Nuevo Usuario");
        mNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNuevoUsuarioActionPerformed(evt);
            }
        });
        jMenu6.add(mNuevoUsuario);

        jMenuBar1.add(jMenu6);

        mAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Help.png"))); // NOI18N
        mAyuda.setText("Ayuda");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Acerca.png"))); // NOI18N
        jMenuItem1.setText(" Acerca de Nosotros");
        mAyuda.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Ayuda.png"))); // NOI18N
        jMenuItem2.setText(" Ayuda");
        mAyuda.add(jMenuItem2);

        jMenuBar1.add(mAyuda);

        mFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Closed.png"))); // NOI18N
        mFinalizar.setText("Salir");
        mFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mFinalizarMouseClicked(evt);
            }
        });
        jMenuBar1.add(mFinalizar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblusu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(577, Short.MAX_VALUE))
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser)
                    .addComponent(lblusu))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
private void mCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCerrarActionPerformed
    Inicio principal= new Inicio();
    principal.setVisible(true);
    principal.pack();
    this.setVisible(false);
}//GEN-LAST:event_mCerrarActionPerformed

private void mClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mClientesActionPerformed
    RegistroCliente cli= new RegistroCliente();
    Escritorio.add(cli);
    cli.show();
}//GEN-LAST:event_mClientesActionPerformed

private void mFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFacturaActionPerformed
    RegistrosFactura fac = new RegistrosFactura();
    Escritorio.add(fac);
    fac.show();
}//GEN-LAST:event_mFacturaActionPerformed

private void mConsultaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConsultaClientesActionPerformed
   ConsultasClientes clientes = new ConsultasClientes();
    Escritorio.add(clientes);
    clientes.show();
}//GEN-LAST:event_mConsultaClientesActionPerformed

private void mConsultaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConsultaProductosActionPerformed
    ConsultasProductos productos = new ConsultasProductos();
    Escritorio.add(productos);
    productos.show();
}//GEN-LAST:event_mConsultaProductosActionPerformed

private void mConsultaFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConsultaFacturasActionPerformed
    ConsultasFacturas Facturas = new  ConsultasFacturas();
    Escritorio.add(Facturas);
    Facturas.show();
}//GEN-LAST:event_mConsultaFacturasActionPerformed

private void mBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBoletaActionPerformed
    RegistrosBoleta bol = new RegistrosBoleta();
    Escritorio.add(bol);
    bol.show();
}//GEN-LAST:event_mBoletaActionPerformed

private void mConsultaBoletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConsultaBoletasActionPerformed
    ConsultasBoletas Boletas = new  ConsultasBoletas();
    Escritorio.add(Boletas);
    Boletas.show();
}//GEN-LAST:event_mConsultaBoletasActionPerformed

private void mNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNuevoUsuarioActionPerformed
    Usuarios usu = new Usuarios();
    Escritorio.add(usu);
    usu.show();
}//GEN-LAST:event_mNuevoUsuarioActionPerformed

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
    dispose();
    }//GEN-LAST:event_mSalirActionPerformed

    private void mFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mFinalizarMouseClicked
    dispose();
    }//GEN-LAST:event_mFinalizarMouseClicked

    private void mProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProductosActionPerformed
        RegistroProducto ip = new RegistroProducto();
        Escritorio.add(ip);
        ip.show();
    }//GEN-LAST:event_mProductosActionPerformed
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblusu;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenuItem mBoleta;
    private javax.swing.JMenuItem mCerrar;
    private javax.swing.JMenuItem mClientes;
    private javax.swing.JMenuItem mConsultaBoletas;
    private javax.swing.JMenuItem mConsultaClientes;
    private javax.swing.JMenuItem mConsultaFacturas;
    private javax.swing.JMenuItem mConsultaProductos;
    private javax.swing.JMenuItem mFactura;
    private javax.swing.JMenu mFinalizar;
    private javax.swing.JMenuItem mNuevoUsuario;
    private javax.swing.JMenuItem mProductos;
    private javax.swing.JMenuItem mSalir;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
