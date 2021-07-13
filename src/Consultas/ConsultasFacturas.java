package Consultas;
import Controlador.Conexion;
import Vista.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.*;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class ConsultasFacturas extends javax.swing.JInternalFrame {

    public ConsultasFacturas() {
        initComponents();
        cargartodasfacturas();
        this.setLocation(25,15 );
        jDateChooser1.setEnabled(false);   
    }
    void cargartodasfacturas(){
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"NUMERO","COD. CLIENTE","RUC CLIENTE","SUBTOTAL","IGV","TOTAL","FECHA"};
        tabla.setColumnIdentifiers(titulos);
        this.tbfacturas.setModel(tabla);
        String consulta= "SELECT * FROM factura";
        String []Datos= new String [7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next()){
                Datos[0]=rs.getString("num_fac");
                Datos[1]=rs.getString("cod_cli");
                Datos[2]=rs.getString("ruc_cli");
                Datos[3]=rs.getString("subtotal");
                Datos[4]=rs.getString("igv");
                Datos[5]=rs.getString("total");
                Datos[6]=rs.getString("fec_fac");
                
                tabla.addRow(Datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnver = new javax.swing.JMenuItem();
        mneliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        rdbnnumero = new javax.swing.JRadioButton();
        rdbbnfecha = new javax.swing.JRadioButton();
        rdbntodos = new javax.swing.JRadioButton();
        txtnumero = new javax.swing.JTextField();
        btnbuscador = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbfacturas = new javax.swing.JTable();
        btnDetalles = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        mnver.setText("Ver Detalle");
        mnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnverActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnver);

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
        setTitle("CONSULTA DE FACTURAS");

        buttonGroup1.add(rdbnnumero);
        rdbnnumero.setSelected(true);
        rdbnnumero.setText("Mostrar  por Nº:");
        rdbnnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbnnumeroActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbbnfecha);
        rdbbnfecha.setText("Mostrar por Fecha");
        rdbbnfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbbnfechaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbntodos);
        rdbntodos.setText("Mostrar todas:");
        rdbntodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbntodosActionPerformed(evt);
            }
        });

        btnbuscador.setText("BUSCAR");
        btnbuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdbnnumero)
                                .addGap(27, 27, 27)
                                .addComponent(txtnumero))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdbbnfecha)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdbntodos))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbnnumero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdbbnfecha)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbntodos))
                    .addComponent(btnbuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tbfacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbfacturas.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbfacturas);

        btnDetalles.setText("Ver Detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(btnDetalles)
                .addGap(33, 33, 33)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setBounds(0, 0, 674, 348);
    }// </editor-fold>//GEN-END:initComponents

private void btnbuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscadorActionPerformed
  
    String num=txtnumero.getText();
    
    String consulta="";
    if(rdbnnumero.isSelected()==true){
        consulta= "SELECT * FROM factura WHERE num_fac='"+num+"'";
    }
    if(rdbbnfecha.isSelected()==true){
           Date fecha=jDateChooser1.getDate();
   SimpleDateFormat formatofecha= new SimpleDateFormat("dd/MM/YYYY");
String fec=""+formatofecha.format(fecha);
        consulta= "SELECT * FROM factura WHERE fec_fac='"+fec+"'";
    }
    if(rdbntodos.isSelected()==true){
        consulta= "SELECT * FROM factura ";
    }
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"NUMERO","COD. CLIENTE","RUC CLIENTE","SUBTOTAL","IGV","TOTAL","FECHA"};
        tabla.setColumnIdentifiers(titulos);
        this.tbfacturas.setModel(tabla);
        
        String []Datos= new String [7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("num_fac");
                Datos[1]=rs.getString("cod_cli");
                Datos[2]=rs.getString("ruc_cli");
                Datos[3]=rs.getString("subtotal");
                Datos[4]=rs.getString("igv");
                Datos[5]=rs.getString("total");
                Datos[6]=rs.getString("fec_fac");
                
                tabla.addRow(Datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_btnbuscadorActionPerformed

private void rdbnnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbnnumeroActionPerformed
    if(rdbnnumero.isSelected()==true){
        txtnumero.setEnabled(true);
        txtnumero.requestFocus();
        jDateChooser1.setDate(null);
        jDateChooser1.setEnabled(false);   
    }
}//GEN-LAST:event_rdbnnumeroActionPerformed

private void rdbbnfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbbnfechaActionPerformed
    if(rdbbnfecha.isSelected()==true){
        jDateChooser1.setEnabled(true);
        txtnumero.setEnabled(false);
        txtnumero.setText(""); 
    }
}//GEN-LAST:event_rdbbnfechaActionPerformed

private void rdbntodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbntodosActionPerformed
    if(rdbntodos.isSelected()==true){
        jDateChooser1.setEnabled(false);
        jDateChooser1.setDate(null);
        txtnumero.setText("");
        txtnumero.setEnabled(false);
        cargartodasfacturas();
    } 
}//GEN-LAST:event_rdbntodosActionPerformed

private void mnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnverActionPerformed
    int filasele= tbfacturas.getSelectedRow();
    if(filasele==-1){
        JOptionPane.showMessageDialog(null, "No Seleciono ninguna fila");
    }
    else{
           DetalleFactura detalle = new DetalleFactura();
    Principal.Escritorio.add(detalle);
    detalle.toFront();
    detalle.setVisible(true);
        String numfac=tbfacturas.getValueAt(filasele, 0).toString();
        String cod=tbfacturas.getValueAt(filasele, 1).toString();
        String ruc=tbfacturas.getValueAt(filasele, 2).toString();
        String subtotal=tbfacturas.getValueAt(filasele, 3).toString();
        String igv=tbfacturas.getValueAt(filasele, 4).toString();
        String total=tbfacturas.getValueAt(filasele, 5).toString();
        String fecha=tbfacturas.getValueAt(filasele, 6).toString();
        DetalleFactura.txtfac.setText(numfac);
        DetalleFactura.txtcod.setText(cod);
        DetalleFactura.txtruc.setText(ruc);
        DetalleFactura.txtsub.setText(subtotal);
        DetalleFactura.txtigv.setText(igv);
        DetalleFactura.txttot.setText(total);
        DetalleFactura.txtfecha.setText(fecha);
        DefaultTableModel model = (DefaultTableModel) DetalleFactura.tbdetalle.getModel();
        String ver="SELECT * FROM detallefactura WHERE num_fac='"+numfac+"'";
        String []datos= new String[5]   ;
        try {
                Statement st = cn.createStatement();
                ResultSet rs= st.executeQuery(ver);
                while(rs.next())
                {
                    datos[0]=rs.getString("cod_pro");
                    datos[1]=rs.getString("des_pro");
                    datos[2]=rs.getString("cant_pro");
                    datos[3]=rs.getString("pre_unit");
                    datos[4]=rs.getString("pre_tot");
                    model.addRow(datos);
                    
                }
                DetalleFactura.tbdetalle.setModel(model);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasFacturas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}//GEN-LAST:event_mnverActionPerformed

private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
    int fila=tbfacturas.getSelectedRow();
    if(fila>=0)
    {
        String cod=tbfacturas.getValueAt(fila, 0).toString();
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM factura WHERE num_fac='"+cod+"'");
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasBoletas.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargartodasfacturas();  
    }
    else{
        JOptionPane.showMessageDialog(this, "Seleccione alguna fila");
    }
}//GEN-LAST:event_mneliminarActionPerformed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
    int filasele= tbfacturas.getSelectedRow();
    if(filasele==-1){
        JOptionPane.showMessageDialog(null, "No Seleciono ninguna fila");
    }
    else{
           DetalleFactura detalle = new DetalleFactura();
    Principal.Escritorio.add(detalle);
    detalle.toFront();
    detalle.setVisible(true);
        String numfac=tbfacturas.getValueAt(filasele, 0).toString();
        String cod=tbfacturas.getValueAt(filasele, 1).toString();
        String ruc=tbfacturas.getValueAt(filasele, 2).toString();
        String subtotal=tbfacturas.getValueAt(filasele, 3).toString();
        String igv=tbfacturas.getValueAt(filasele, 4).toString();
        String total=tbfacturas.getValueAt(filasele, 5).toString();
        String fecha=tbfacturas.getValueAt(filasele, 6).toString();
        DetalleFactura.txtfac.setText(numfac);
        DetalleFactura.txtcod.setText(cod);
        DetalleFactura.txtruc.setText(ruc);
        DetalleFactura.txtsub.setText(subtotal);
        DetalleFactura.txtigv.setText(igv);
        DetalleFactura.txttot.setText(total);
        DetalleFactura.txtfecha.setText(fecha);
        DefaultTableModel model = (DefaultTableModel) DetalleFactura.tbdetalle.getModel();
        String ver="SELECT * FROM detallefactura WHERE num_fac='"+numfac+"'";
        String []datos= new String[5]   ;
        try {
                Statement st = cn.createStatement();
                ResultSet rs= st.executeQuery(ver);
                while(rs.next())
                {
                    datos[0]=rs.getString("cod_pro");
                    datos[1]=rs.getString("des_pro");
                    datos[2]=rs.getString("cant_pro");
                    datos[3]=rs.getString("pre_unit");
                    datos[4]=rs.getString("pre_tot");
                    model.addRow(datos);
                    
                }
                DetalleFactura.tbdetalle.setModel(model);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasFacturas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    int fila=tbfacturas.getSelectedRow();
    if(fila>=0)
    {
        String cod=tbfacturas.getValueAt(fila, 0).toString();
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM factura WHERE num_fac='"+cod+"'");
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasBoletas.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargartodasfacturas();  
    }
    else{
        JOptionPane.showMessageDialog(this, "Seleccione alguna fila");
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnbuscador;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnver;
    private javax.swing.JRadioButton rdbbnfecha;
    private javax.swing.JRadioButton rdbnnumero;
    private javax.swing.JRadioButton rdbntodos;
    public static javax.swing.JTable tbfacturas;
    private javax.swing.JTextField txtnumero;
    // End of variables declaration//GEN-END:variables
Conexion cc= new Conexion();
Connection cn= cc.getConexion();
}
