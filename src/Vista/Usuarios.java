package Vista;
import Vista.Principal;
import Controlador.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class Usuarios extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;

    public Usuarios() {
        initComponents();       
        this.setLocation(80,80);   
        mostrarusuarios();
        Generarnumeracion();   
    }
    
    Conexion cc = new Conexion();
    Connection cn = cc.getConexion();
    String idfila="";
    
    void Generarnumeracion(){
     String SQL="select max(idusuario) from usuario";
          int c=0;
          int b=0;
          
        try {
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(SQL);
            while(rs.next()){              
                 c=rs.getInt(1);
            }
            if(c==0){
                txtid.setText("1");
            }else{
                txtid.setText(""+(c+1));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
   void mostrarusuarios(){
   String [] titulos= {"ID","Usuario","Tipo Usuario"};
   modelo=new  DefaultTableModel(null,titulos);   
   String datos []= new String[5];
   String sql="SELECT * FROM  usuario"; 
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString("idusuario");
                datos[1]=rs.getString("nick");
                datos[2]= rs.getString("tipousuario");
                modelo.addRow(datos);
            }
            tbusuario.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnick = new javax.swing.JTextField();
        cbotipo = new javax.swing.JComboBox();
        txtpass = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbusuario = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        btnaceptar = new javax.swing.JButton();
        txtcontra = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id:");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo Usuario:");

        txtid.setEditable(false);
        txtid.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N
        txtid.setFocusable(false);

        txtnick.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N

        cbotipo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N
        cbotipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Invitado" }));

        txtpass.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnick, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 270, 190));

        tbusuario.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tbusuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbusuario.setOpaque(false);
        jScrollPane1.setViewportView(tbusuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 330, 200));

        btneliminar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/newEliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        btnregistrar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/newConfirmar.png"))); // NOI18N
        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        btnaceptar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btnaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/newRegistro.png"))); // NOI18N
        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));
        getContentPane().add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 90, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Fondo1.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
    if((txtnick.getText().equals("")) || (txtpass.getText().equals(""))){
        JOptionPane.showMessageDialog(this, "Faltan rellenar campos obligatorios.");
    }else{
            
    String ins="INSERT INTO usuario (nick, password,tipousuario) VALUES(?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(ins);
            pst.setString(1, txtnick.getText());
            pst.setString(2,new String(txtpass.getPassword()));
            pst.setString(3, cbotipo.getSelectedItem().toString());
            int n= pst.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(this, "Se guardaron los datos");
                mostrarusuarios();
                txtnick.setText(null);
                txtpass.setText(null);
                cbotipo.setSelectedIndex(0);
                Generarnumeracion();
            }else{
                 JOptionPane.showMessageDialog(this, "Error");
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}//GEN-LAST:event_btnregistrarActionPerformed

private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
    int fila= tbusuario.getSelectedRow();
    if(fila<0){
        JOptionPane.showMessageDialog(this, "Seleccione alguna fila");
    }else{
         idfila= tbusuario.getValueAt(fila, 0).toString();
         JOptionPane.showMessageDialog(this, "Ingrese la contraseña del Administrador actual para eliminar al Usuario.");
         txtcontra.requestFocus();
    }
}//GEN-LAST:event_btneliminarActionPerformed

private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
    String compara="";
    String contra="";
    contra= new String(txtcontra.getPassword());
    
    String cap= Principal.lblusu.getText();
    System.out.print(cap);
    String sql="SELECT * FROM usuario WHERE nick='"+cap+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            compara=rs.getString("password");
            }
          System.out.println(compara);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
          if(compara.equals(contra)){    
                String eli="DELETE FROM usuario WHERE idusuario = '"+idfila+"'";
                PreparedStatement pst;
            try {
                pst = cn.prepareStatement(eli);
                  int m=pst.executeUpdate();
                if(m>0){
                    JOptionPane.showMessageDialog(this, "Registro Eliminado");
                     mostrarusuarios();
                     txtcontra.setText(null);    
                }
                else{
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar");
                    mostrarusuarios();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        }   
}//GEN-LAST:event_btnaceptarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox cbotipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbusuario;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnick;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
