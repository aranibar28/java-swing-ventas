package Vista;

import Controlador.Conexion;
import Modelo.Cliente;
import Modelo.Codigo;
import Controlador.ClienteDAO;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroCliente extends javax.swing.JInternalFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.getConexion();
    DefaultTableModel model;

    ClienteDAO obj = new ClienteDAO();

    public RegistroCliente() {
        initComponents();
        this.setLocation(50, 20);
        bloquear();
        cargar("");
    }

    void bloquear() {
        txtcod.setEnabled(false);
        txtnom.setEnabled(false);
        txtape.setEnabled(false);
        txtdir.setEnabled(false);
        txtemail.setEnabled(false);
        txttel.setEnabled(false);
        txtruc.setEnabled(false);
        txtdni.setEnabled(false);
        cbosexo.setEnabled(false);
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(true);
        btncancelar.setEnabled(false);
        btnactualizar.setEnabled(false);
    }

    void limpiar() {
        txtcod.setText("");
        txtnom.setText("");
        txtdir.setText("");
        txtdni.setText("");
        txtemail.setText("");
        txtruc.setText("");
        txttel.setText("");
        txtape.setText("");
        txtbuscar.setText("");
        cargar("");
    }

    void desbloquear() {
        txtcod.setEnabled(true);
        txtnom.setEnabled(true);
        txtape.setEnabled(true);
        txtdir.setEnabled(true);
        txtemail.setEnabled(true);
        txttel.setEnabled(true);
        txtruc.setEnabled(true);
        txtdni.setEnabled(true);
        cbosexo.setEnabled(true);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btncancelar.setEnabled(true);
        btnactualizar.setEnabled(false);
    }

    void cargar(String valor) {

        String[] titulos = {"Código", "Nombres", "Apellidos", "Sexo", "DNI", "Teléfono", "RUC", "Email", "Dirección"};
        model = new DefaultTableModel(null, titulos);

        try {
            for (Cliente p : obj.MostrarClientes(txtbuscar.getText())) {
                Object mostrar[] = {
                    p.getCodigo(),
                    p.getNombre(),
                    p.getApellido(),
                    p.getSexo(),
                    p.getDni(),
                    p.getTelefono(),
                    p.getRuc(),
                    p.getEmail(),
                    p.getDireccion()};
                model.addRow(mostrar);
            }
            tbclientes.setModel(model);
            tbclientes.getColumnModel().getColumn(0).setPreferredWidth(45);
            tbclientes.getColumnModel().getColumn(3).setPreferredWidth(30);
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    void codigosclientes() {
        int j;
        String c = "";
        String sql = "SELECT MAX(cod_cli) FROM cliente";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                txtcod.setText("CC0001");
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
                txtcod.setText("CC" + gen.serie());
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnmodificar = new javax.swing.JMenuItem();
        mneliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtape = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbosexo = new javax.swing.JComboBox();
        txttel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtruc = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        mnmodificar.setText("Modificar");
        mnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnmodificar);

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
        setTitle("REGISTRO DE CLIENTES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código:");

        txtcod.setEditable(false);
        txtcod.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtcod.setForeground(new java.awt.Color(0, 204, 102));
        txtcod.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres:");

        txtnom.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos:");

        txtape.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapeKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DNI:");

        txtdni.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sexo:");

        cbosexo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        cbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        txttel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txttel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Teléfono:");

        txtemail.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtemailKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email:");

        txtdir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtdir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdirKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dirección:");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("RUC:");

        txtruc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrucKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnom, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttel)
                            .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 67, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 530, 260));

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
        btnguardar.setText("Guardar");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnactualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 18, -1, 230));

        tbclientes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tbclientes.setForeground(new java.awt.Color(0, 0, 102));
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
        jScrollPane2.setViewportView(tbclientes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 690, 130));

        txtbuscar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 13)); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 100, -1));

        btnbuscar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnBuscar.png"))); // NOI18N
        btnbuscar.setText("Mostrar Todos");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Buscar:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 70, -1));

        btnModificar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnModificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnEliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Fondo2.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed

    String cod = txtcod.getText();
    String nom = txtnom.getText();
    String ape = txtape.getText();
    String sex = cbosexo.getSelectedItem().toString();
    String dni = txtdni.getText();
    String tel = txttel.getText();
    String ruc = txtruc.getText();
    String email = txtemail.getText();
    String dir = txtdir.getText();

    Cliente cliente = new Cliente(cod, nom, ape, sex, dni, tel, ruc, email, dir);

    try {
        ClienteDAO.getInstancia().Actualizar(cliente);
        JOptionPane.showMessageDialog(null, "Dato modificado");
        bloquear();
        limpiar();
        cargar("");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }

}//GEN-LAST:event_btnactualizarActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
    this.dispose();
}//GEN-LAST:event_btnsalirActionPerformed

private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
    desbloquear();
    limpiar();
    codigosclientes();
    txtcod.requestFocus();
}//GEN-LAST:event_btnnuevoActionPerformed

private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
    bloquear();
    limpiar();
}//GEN-LAST:event_btncancelarActionPerformed

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
    String cod, nom, ape, sex, dni, tel, ruc, email, dir;
    if (txtcod.getText().compareTo("") != 0
            && txtnom.getText().compareTo("") != 0
            && txtape.getText().compareTo("") != 0
            && txtdni.getText().compareTo("") != 0
            && txttel.getText().compareTo("") != 0
            && txtruc.getText().compareTo("") != 0
            && txtemail.getText().compareTo("") != 0
            && txtdir.getText().compareTo("") != 0) {

        cod = txtcod.getText();
        nom = txtnom.getText();
        ape = txtape.getText();
        sex = cbosexo.getSelectedItem().toString();
        dni = txtdni.getText();
        tel = txttel.getText();
        ruc = txtruc.getText();
        email = txtemail.getText();
        dir = txtdir.getText();

        Cliente cliente = new Cliente(cod, nom, ape, sex, dni, tel, ruc, email, dir);

        try {
            ClienteDAO.getInstancia().Registrar(cliente);
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

private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
    cargar(txtbuscar.getText());
}//GEN-LAST:event_txtbuscarKeyReleased
private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
    char car = evt.getKeyChar();
    if (txtdni.getText().length() >= 8) {
        evt.consume();
    }
    if ((car < '0' || car > '9')) {
        evt.consume();
    }
}//GEN-LAST:event_txtdniKeyTyped

private void txttelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelKeyTyped
    char car = evt.getKeyChar();
    if (txttel.getText().length() >= 9) {
        evt.consume();
    }
    if ((car < '0' || car > '9')) {
        evt.consume();
    }
}//GEN-LAST:event_txttelKeyTyped

private void txtrucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrucKeyTyped
    char car = evt.getKeyChar();
    if (txtruc.getText().length() >= 11) {
        evt.consume();
    }
    if ((car < '0' || car > '9')) {
        evt.consume();
    }
}//GEN-LAST:event_txtrucKeyTyped

private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped
    String texto = txtnom.getText();
    if (texto.length() > 0) {
        char primeraletra = texto.charAt(0);
        texto = Character.toUpperCase(primeraletra) + texto.substring(1, texto.length());
        txtnom.setText(texto);
    }
}//GEN-LAST:event_txtnomKeyTyped

private void txtapeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapeKeyTyped
    if (txtape.getText().length() >= 30) {
        evt.consume();
        Toolkit.getDefaultToolkit().beep();
    }
}//GEN-LAST:event_txtapeKeyTyped

private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
    int fila = tbclientes.getSelectedRow();
    if (fila >= 0) {
        String cliente = tbclientes.getValueAt(fila, 0).toString();

        try {
            ClienteDAO.getInstancia().Eliminar(cliente);
            JOptionPane.showMessageDialog(null, "Cliente Eliminado");
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

private void mnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnmodificarActionPerformed
    int fila = tbclientes.getSelectedRow();
    if (fila >= 0) {
        desbloquear();
        btnactualizar.setEnabled(true);
        btnguardar.setEnabled(false);
        txtcod.setText(tbclientes.getValueAt(fila, 0).toString());
        txtnom.setText(tbclientes.getValueAt(fila, 1).toString());
        txtape.setText(tbclientes.getValueAt(fila, 2).toString());
        cbosexo.setSelectedItem(tbclientes.getValueAt(fila, 3).toString());
        txtdni.setText(tbclientes.getValueAt(fila, 4).toString());
        txttel.setText(tbclientes.getValueAt(fila, 5).toString());
        txtruc.setText(tbclientes.getValueAt(fila, 6).toString());
        txtemail.setText(tbclientes.getValueAt(fila, 7).toString());
        txtdir.setText(tbclientes.getValueAt(fila, 8).toString());
    } else {
        JOptionPane.showMessageDialog(this, "No ha selecionado ninguna fila.");
        bloquear();
    }
}//GEN-LAST:event_mnmodificarActionPerformed

    private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
        if (txtape.getText().length() >= 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtemailKeyTyped

    private void txtdirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdirKeyTyped
        if (txtape.getText().length() >= 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtdirKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = tbclientes.getSelectedRow();
        if (fila >= 0) {
            desbloquear();
            btnactualizar.setEnabled(true);
            btnguardar.setEnabled(false);
            txtcod.setText(tbclientes.getValueAt(fila, 0).toString());
            txtnom.setText(tbclientes.getValueAt(fila, 1).toString());
            txtape.setText(tbclientes.getValueAt(fila, 2).toString());
            cbosexo.setSelectedItem(tbclientes.getValueAt(fila, 3).toString());
            txtdni.setText(tbclientes.getValueAt(fila, 4).toString());
            txttel.setText(tbclientes.getValueAt(fila, 5).toString());
            txtruc.setText(tbclientes.getValueAt(fila, 6).toString());
            txtemail.setText(tbclientes.getValueAt(fila, 7).toString());
            txtdir.setText(tbclientes.getValueAt(fila, 8).toString());
        } else {
            JOptionPane.showMessageDialog(this, "No ha selecionado ninguna fila.");
            bloquear();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tbclientes.getSelectedRow();
        if (fila >= 0) {
            String cliente = tbclientes.getValueAt(fila, 0).toString();

            try {
                ClienteDAO.getInstancia().Eliminar(cliente);
                JOptionPane.showMessageDialog(null, "Cliente Eliminado");
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

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        txtbuscar.setText("");
        cargar("");
    }//GEN-LAST:event_btnbuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbosexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnmodificar;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtruc;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
