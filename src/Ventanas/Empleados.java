/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ricardo
 */
public class Empleados extends javax.swing.JFrame {

    /**
     * Creates new form Paciente
     */
    public Empleados() {
        initComponents();
        Conexion();
        CargarProfesion();
        CargarEspecialidad();
        TablaEmpleados();
    }
    
    Connection conexion;
    PreparedStatement preparedStatement;
    ResultSet resultset;
    
    public class Profesion{
        String idProfesion;
        String nombreProfesion;
        
        public Profesion(String id,String nombre){
            this.idProfesion=id;
            this.nombreProfesion=nombre;
        }
        
        public String toString(){
            
            return nombreProfesion;
        }
    }
    
    public void CargarProfesion(){
        try {
            preparedStatement = conexion.prepareStatement("select * from profesion");
            resultset = preparedStatement.executeQuery();
            profesionCombobox.removeAll();
            
            while(resultset.next()){
                profesionCombobox.addItem(new Profesion(resultset.getString(1),resultset.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cirugias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    public class Especialidad{
        String idEspecialidad;
        String nombreEspecialidad;
        
        public Especialidad(String id,String nombre){
            this.idEspecialidad=id;
            this.nombreEspecialidad=nombre;
        }
        
        public String toString(){
            
            return nombreEspecialidad;
        }
    }
    
    public void CargarEspecialidad(){
        try {
            preparedStatement = conexion.prepareStatement("select * from especialidad");
            resultset = preparedStatement.executeQuery();
            especialidadCombobox.removeAll();
            
            while(resultset.next()){
                especialidadCombobox.addItem(new Especialidad(resultset.getString(1),resultset.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cirugias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    public void Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectohospital?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT","root","");
            //conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/proyectohospital?autoReconnect=true&useSSL=false","root","");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void TablaEmpleados(){
        try {
            preparedStatement = conexion.prepareStatement("select * from empleados");
            resultset = preparedStatement.executeQuery();
            java.sql.ResultSetMetaData Rsm = resultset.getMetaData();
            int conteoColumna;
            conteoColumna = Rsm.getColumnCount();
            DefaultTableModel defaultTable = (DefaultTableModel)tablaEmpleados.getModel();
            defaultTable.setRowCount(0);
            
            while(resultset.next()){
                Vector vector = new Vector();
                
                for (int indiceColumna = 0; indiceColumna < conteoColumna; indiceColumna++) {
                    vector.add(resultset.getString("id_empleados"));
                    vector.add(resultset.getString("nombre"));
                    vector.add(resultset.getString("primer_apellido"));
                    vector.add(resultset.getString("segundo_apellido"));
                    vector.add(resultset.getString("grado_academico"));
                    vector.add(resultset.getString("profesion"));
                    vector.add(resultset.getString("especialidad"));
                    vector.add(resultset.getString("telefono"));
                    vector.add(resultset.getString("correo"));
                    vector.add(resultset.getString("estado_civil"));
                }
                defaultTable.addRow(vector);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        empleadoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cedulaEmpleadoText = new javax.swing.JTextField();
        nombreEmpleadoText = new javax.swing.JTextField();
        apellido1EmpleadoText = new javax.swing.JTextField();
        apellido2EmpleadoText = new javax.swing.JTextField();
        correoEmpleadoText = new javax.swing.JTextField();
        telefonoEmpleadoText = new javax.swing.JTextField();
        estadoCivilEmpleadoCombobox = new javax.swing.JComboBox<>();
        usuarioEmpleadoCombobox = new javax.swing.JComboBox<>();
        idPacienteLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gradoAcademicoText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        profesionCombobox = new javax.swing.JComboBox();
        especialidadCombobox = new javax.swing.JComboBox();
        agregarEmpleadoButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        empleadoPanel.setBackground(new java.awt.Color(153, 153, 255));
        empleadoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cedula");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Primer apellido");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Segundo apellido");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Estado civil");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Correo");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Usuario");

        apellido2EmpleadoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido2EmpleadoTextActionPerformed(evt);
            }
        });

        estadoCivilEmpleadoCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero(a)", "Casado(a)" }));

        usuarioEmpleadoCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioEmpleadoComboboxActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Grado academico");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Profesion");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Especialidad");

        profesionCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesionComboboxActionPerformed(evt);
            }
        });

        especialidadCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                especialidadComboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout empleadoPanelLayout = new javax.swing.GroupLayout(empleadoPanel);
        empleadoPanel.setLayout(empleadoPanelLayout);
        empleadoPanelLayout.setHorizontalGroup(
            empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empleadoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(empleadoPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(idPacienteLabel))
                    .addGroup(empleadoPanelLayout.createSequentialGroup()
                        .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, empleadoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gradoAcademicoText))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, empleadoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apellido1EmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apellido2EmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profesionCombobox, 0, 184, Short.MAX_VALUE)))
                    .addGroup(empleadoPanelLayout.createSequentialGroup()
                        .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, empleadoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(especialidadCombobox, 0, 188, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, empleadoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cedulaEmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(empleadoPanelLayout.createSequentialGroup()
                                .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuarioEmpleadoCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(correoEmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(estadoCivilEmpleadoCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telefonoEmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(empleadoPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(72, 72, 72)
                                    .addComponent(nombreEmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        empleadoPanelLayout.setVerticalGroup(
            empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empleadoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idPacienteLabel)
                .addGap(18, 18, 18)
                .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cedulaEmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(nombreEmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellido1EmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(apellido2EmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(gradoAcademicoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(profesionCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addComponent(telefonoEmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(especialidadCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correoEmpleadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(estadoCivilEmpleadoCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(empleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioEmpleadoCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(65, 65, 65))
        );

        agregarEmpleadoButton.setText("Agregar");
        agregarEmpleadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEmpleadoButtonActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificacion", "Nombre", "Primer apellido", "Segundo apellido", "Grado academico", "Profesion", "Especialidad", "Telefono", "Correo", "Estado Civil", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(agregarEmpleadoButton)
                        .addGap(291, 291, 291)
                        .addComponent(salirButton)
                        .addGap(0, 144, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addComponent(empleadoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(empleadoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarEmpleadoButton)
                    .addComponent(salirButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarEmpleadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEmpleadoButtonActionPerformed
        int cedulaEmpleado = Integer.parseInt(cedulaEmpleadoText.getText());
        String nombreEmpleado = nombreEmpleadoText.getText();
        String apellido1Empleado = apellido1EmpleadoText.getText();
        String apellido2Empleado = apellido2EmpleadoText.getText();
        String gradoAcademico = gradoAcademicoText.getText();
        String nombreProfesion = profesionCombobox.getSelectedItem().toString();
        String nombreEspecialidad = especialidadCombobox.getSelectedItem().toString();
        int telefonoEmpleado = Integer.parseInt(telefonoEmpleadoText.getText());
        String correoEmpleado = correoEmpleadoText.getText();
        String estadoCivilEmpleado = estadoCivilEmpleadoCombobox.getSelectedItem().toString();
        //String usuarioEmpleado = usuarioEmpleadoCombobox.getSelectedItem().toString();
        //String especialidadEmpleado = especialidadCombobox.getSelectedItem().toString();
        
        Conexion();
        try {
            preparedStatement = conexion.prepareStatement("insert into empleados(identificacion,nombre,primer_apellido,segundo_apellido,grado_academico,profesion,especialidad,telefono,correo,estado_civil)values(?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,cedulaEmpleado);
            preparedStatement.setString(2, nombreEmpleado);
            preparedStatement.setString(3, apellido1Empleado); 
            preparedStatement.setString(4,apellido2Empleado);
            preparedStatement.setString(5, gradoAcademico);
            preparedStatement.setString(6, nombreProfesion);
            preparedStatement.setString(7, nombreEspecialidad);
            preparedStatement.setInt(8, telefonoEmpleado);
            preparedStatement.setString(9, correoEmpleado);
            preparedStatement.setString(10, estadoCivilEmpleado);
            preparedStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Empleado ingresado");
            
            cedulaEmpleadoText.setText("");
            nombreEmpleadoText.setText("");
            apellido1EmpleadoText.setText("");
            apellido2EmpleadoText.setText("");
            profesionCombobox.setSelectedIndex(-1);
            especialidadCombobox.setSelectedIndex(-1);
            estadoCivilEmpleadoCombobox.setSelectedIndex(-1);
            telefonoEmpleadoText.setText("");
            usuarioEmpleadoCombobox.setSelectedIndex(-1);
            correoEmpleadoText.setText("");
            cedulaEmpleadoText.requestFocus();
            TablaEmpleados();
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_agregarEmpleadoButtonActionPerformed

    private void apellido2EmpleadoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellido2EmpleadoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellido2EmpleadoTextActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        DefaultTableModel defaultEmpleado = (DefaultTableModel)tablaEmpleados.getModel();
        int SelectIndex = tablaEmpleados.getSelectedRow();
        
        cedulaEmpleadoText.setText(defaultEmpleado.getValueAt(SelectIndex, 1).toString());
        nombreEmpleadoText.setText(defaultEmpleado.getValueAt(SelectIndex, 2).toString());
        apellido1EmpleadoText.setText(defaultEmpleado.getValueAt(SelectIndex, 3).toString());
        apellido2EmpleadoText.setText(defaultEmpleado.getValueAt(SelectIndex, 4).toString());
        gradoAcademicoText.setText(defaultEmpleado.getValueAt(SelectIndex, 5).toString());
        profesionCombobox.setSelectedItem(defaultEmpleado.getValueAt(SelectIndex, 6).toString());
        especialidadCombobox.setSelectedItem(defaultEmpleado.getValueAt(SelectIndex, 7).toString());
        telefonoEmpleadoText.setText(defaultEmpleado.getValueAt(SelectIndex, 8).toString());
        correoEmpleadoText.setText(defaultEmpleado.getValueAt(SelectIndex, 9).toString());
        estadoCivilEmpleadoCombobox.setSelectedItem(defaultEmpleado.getValueAt(SelectIndex, 10).toString());
        agregarEmpleadoButton.setEnabled(false);
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_salirButtonActionPerformed

    private void usuarioEmpleadoComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioEmpleadoComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioEmpleadoComboboxActionPerformed

    private void profesionComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesionComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profesionComboboxActionPerformed

    private void especialidadComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_especialidadComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_especialidadComboboxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarEmpleadoButton;
    private javax.swing.JTextField apellido1EmpleadoText;
    private javax.swing.JTextField apellido2EmpleadoText;
    private javax.swing.JTextField cedulaEmpleadoText;
    private javax.swing.JTextField correoEmpleadoText;
    private javax.swing.JPanel empleadoPanel;
    private javax.swing.JComboBox especialidadCombobox;
    private javax.swing.JComboBox<String> estadoCivilEmpleadoCombobox;
    private javax.swing.JTextField gradoAcademicoText;
    private javax.swing.JLabel idPacienteLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreEmpleadoText;
    private javax.swing.JComboBox profesionCombobox;
    private javax.swing.JButton salirButton;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField telefonoEmpleadoText;
    private javax.swing.JComboBox<String> usuarioEmpleadoCombobox;
    // End of variables declaration//GEN-END:variables
}
