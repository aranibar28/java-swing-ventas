package Consultas;
import Controlador.Conexion;
import Vista.RegistrosFactura;
import Vista.RegistroCliente;
import Vista.*;
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscarClientesF extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;
    
    Conexion cc= new Conexion();
    Connection cn = cc.getConexion();
    
    public BuscarClientesF() {
        initComponents();       
        mostrarclientes("");
        this.setLocation(100,100);
    }
   
    void mostrarclientes(String valor){
        String[]titulos={"Codigo","Nombres","Apellidos","Sexo","DNI","Telefono","RUC","Email","Direccion"} ;  
        String []Registros= new String[9];
        modelo=new DefaultTableModel(null,titulos);
        String Sql="SELECT * FROM cliente WHERE CONCAT(cod_cli,nom_cli,ape_cli,dni_cli) LIKE '%"+valor+"%'";
       
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(Sql);
             while(rs.next()){
                Registros[0]=rs.getString("cod_cli");  
                Registros[1]=rs.getString("nom_cli");  
                Registros[2]=rs.getString("ape_cli");  
                Registros[3]=rs.getString("sexo_cli");  
                Registros[4]=rs.getString("dni_cli");  
                Registros[5]=rs.getString("tel_cli");  
                Registros[6]=rs.getString("ruc_cli");  
                Registros[7]=rs.getString("email_cli");  
                Registros[8]=rs.getString("dir_cli");  
                modelo.addRow(Registros);
             } 
            tbclientes.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarClientesF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnenviar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnbus = new javax.swing.JButton();
        txtbus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        Btnregistrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        mnenviar.setText("Enviar Datos");
        mnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnenviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnenviar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CLIENTES");

        jLabel1.setText("Buscar Cliente:");

        btnbus.setText("Mostrar Todo");
        btnbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusActionPerformed(evt);
            }
        });

        txtbus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusKeyReleased(evt);
            }
        });

        tbclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbclientes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbclientes);

        Btnregistrar.setText("Registrar Clientes");
        Btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnregistrarActionPerformed(evt);
            }
        });

        jButton1.setText("Enviar Datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btnregistrar)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbus)
                    .addComponent(Btnregistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusActionPerformed
    mostrarclientes("");
}//GEN-LAST:event_btnbusActionPerformed

private void txtbusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyReleased
    mostrarclientes(txtbus.getText());
}//GEN-LAST:event_txtbusKeyReleased

private void mnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnenviarActionPerformed
    String cod="",nom="",ape="",dni="",dir="",ruc="";
    int fila = tbclientes.getSelectedRow();
    try {
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");          
        }
        else{
            cod = (String)tbclientes.getValueAt(fila, 0);
            nom = (String)tbclientes.getValueAt(fila, 1);
            ape = (String)tbclientes.getValueAt(fila, 2);
            dni = (String)tbclientes.getValueAt(fila, 4);
            ruc = (String)tbclientes.getValueAt(fila, 6);
            dir = (String)tbclientes.getValueAt(fila, 8);
            
        RegistrosFactura.txtcod.setDisabledTextColor(Color.blue);
        RegistrosFactura.txtcod.setText(cod);
        RegistrosFactura.txtnomape.setDisabledTextColor(Color.blue);
        RegistrosFactura.txtnomape.setText(nom+" "+ape);
        RegistrosFactura.txtdir.setDisabledTextColor(Color.blue);
        RegistrosFactura.txtdir.setText(dir);
        RegistrosFactura.txtdni.setDisabledTextColor(Color.blue);
        RegistrosFactura.txtdni.setText(dni);
        RegistrosFactura.txtruc.setDisabledTextColor(Color.blue);
        RegistrosFactura.txtruc.setText(ruc);
        
            this.dispose();
            }
        } catch (Exception e) {
    }
}//GEN-LAST:event_mnenviarActionPerformed

private void BtnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnregistrarActionPerformed
    try {
        RegistroCliente ingcli= new RegistroCliente();
        Principal.Escritorio.add(ingcli);
        ingcli.toFront();
        ingcli.setVisible(true);
        this.dispose();
        
        } catch (Exception e) {
    }  
}//GEN-LAST:event_BtnregistrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     String cod="",nom="",ape="",dni="",dir="",ruc="";
    int fila = tbclientes.getSelectedRow();
    try {
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");          
        }
        else{
            cod = (String)tbclientes.getValueAt(fila, 0);
            nom = (String)tbclientes.getValueAt(fila, 1);
            ape = (String)tbclientes.getValueAt(fila, 2);
            dni = (String)tbclientes.getValueAt(fila, 4);
            ruc = (String)tbclientes.getValueAt(fila, 6);
            dir = (String)tbclientes.getValueAt(fila, 8);
            
        RegistrosFactura.txtcod.setDisabledTextColor(Color.blue);
        RegistrosFactura.txtcod.setText(cod);
        RegistrosFactura.txtnomape.setDisabledTextColor(Color.blue);
        RegistrosFactura.txtnomape.setText(nom+" "+ape);
        RegistrosFactura.txtdir.setDisabledTextColor(Color.blue);
        RegistrosFactura.txtdir.setText(dir);
        RegistrosFactura.txtdni.setDisabledTextColor(Color.blue);
        RegistrosFactura.txtdni.setText(dni);
        RegistrosFactura.txtruc.setDisabledTextColor(Color.blue);
        RegistrosFactura.txtruc.setText(ruc);
        
            this.dispose();
            }
        } catch (Exception e) {
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnregistrar;
    private javax.swing.JButton btnbus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnenviar;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtbus;
    // End of variables declaration//GEN-END:variables

}
