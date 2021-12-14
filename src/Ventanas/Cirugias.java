/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ricardo
 */
public class Cirugias extends javax.swing.JFrame {

    /**
     * Creates new form Cirugias
     */
    public Cirugias() {
        initComponents();
        Conexion();
        CargarDoctor();
        CargarPaciente();
        CargarHospital();
        TablaCitas();
    }

    Connection conexion;
    PreparedStatement preparedStatement;
    ResultSet resultset;
    
    
    public class Empleados{
        String idDoctor;
        String nombreDoctor;
        
        public Empleados(String id,String nombre){
            this.idDoctor=id;
            this.nombreDoctor=nombre;
        }
        
        public String toString(){
            
            return nombreDoctor;
        }
    }
    
    public void CargarDoctor(){
        try {
            preparedStatement = conexion.prepareStatement("select * from empleados");
            resultset = preparedStatement.executeQuery();
            doctorCombobox.removeAll();
            
            while(resultset.next()){
                doctorCombobox.addItem(new Empleados(resultset.getString(1),resultset.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cirugias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public class Paciente{
        String idPaciente;
        String nombrePaciente;
        
        public Paciente(String id,String nombre){
            this.idPaciente=id;
            this.nombrePaciente=nombre;
        }
        
        public String toString(){
            
            return nombrePaciente;
        }
    }
    
    public void CargarPaciente(){
        try {
            preparedStatement = conexion.prepareStatement("select * from pacientes");
            resultset = preparedStatement.executeQuery();
            pacienteCombobox.removeAll();
            
            while(resultset.next()){
                pacienteCombobox.addItem(new Paciente(resultset.getString(1),resultset.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cirugias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public class Hospital{
        String idHospital;
        String nombreHospital;
        
        public Hospital(String id,String nombre){
            this.idHospital=id;
            this.nombreHospital=nombre;
        }
        
        public String toString(){
            
            return nombreHospital;
        }
    }
    
    public void CargarHospital(){
        try {
            preparedStatement = conexion.prepareStatement("select * from hospitales");
            resultset = preparedStatement.executeQuery();
            pacienteCombobox.removeAll();
            
            while(resultset.next()){
                hospitalCombobox.addItem(new Hospital(resultset.getString(1),resultset.getString(2)));
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
    
    
    public void TablaCitas(){
        try {
            preparedStatement = conexion.prepareStatement("select * from citas");
            resultset = preparedStatement.executeQuery();
            java.sql.ResultSetMetaData Rsm = resultset.getMetaData();
            int conteoColumna;
            conteoColumna = Rsm.getColumnCount();
            DefaultTableModel defaultTable = (DefaultTableModel)tablaCirugias.getModel();
            defaultTable.setRowCount(0);
            
            while(resultset.next()){
                Vector vector = new Vector();
                
                for (int indiceColumna = 0; indiceColumna < conteoColumna; indiceColumna++) {
                    vector.add(resultset.getString("id_cita"));
                    vector.add(resultset.getString("doctor"));
                    vector.add(resultset.getString("paciente"));
                    vector.add(resultset.getString("hospital"));
                    vector.add(resultset.getString("tipo_operacion"));
                }
                defaultTable.addRow(vector);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventanas.Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        doctorCombobox = new javax.swing.JComboBox();
        pacienteCombobox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        hospitalCombobox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        operacionText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCirugias = new javax.swing.JTable();
        crearCitaButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cirugias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Doctor: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Paciente: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Hospital: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tipo operacion:");

        operacionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacionTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(operacionText))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hospitalCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doctorCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pacienteCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(doctorCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pacienteCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hospitalCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(operacionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        tablaCirugias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cita", "Doctor", "Paciente", "Hospital", "Tipo de Operacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaCirugias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCirugiasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCirugias);

        crearCitaButton.setText("Crear Cita");
        crearCitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCitaButtonActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(crearCitaButton)
                .addGap(182, 182, 182)
                .addComponent(salirButton)
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearCitaButton)
                    .addComponent(salirButton))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void crearCitaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCitaButtonActionPerformed
        
        String nombreDoctor = doctorCombobox.getSelectedItem().toString();
        String nombrePaciente = pacienteCombobox.getSelectedItem().toString();
        String nombreHospital = hospitalCombobox.getSelectedItem().toString();
        String tipo_operacion = operacionText.getText();
        
        Conexion();
        try {
            preparedStatement = conexion.prepareStatement("insert into citas(doctor,paciente,hospital,tipo_operacion)values(?,?,?,?)");
            preparedStatement.setString(1,nombreDoctor);
            preparedStatement.setString(2, nombrePaciente);
            preparedStatement.setString(3,nombreHospital);
            preparedStatement.setString(4,tipo_operacion);
            preparedStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Cirugia ingresada");
            
            
            doctorCombobox.setSelectedIndex(-1);
            pacienteCombobox.setSelectedIndex(-1);
            hospitalCombobox.setSelectedIndex(-1);
            operacionText.setText("");
            doctorCombobox.requestFocus();
            TablaCitas();
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_crearCitaButtonActionPerformed

    private void tablaCirugiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCirugiasMouseClicked
        DefaultTableModel defaultCirugias = (DefaultTableModel)tablaCirugias.getModel();
        int SelectIndex = tablaCirugias.getSelectedRow();
        
        doctorCombobox.setSelectedItem(defaultCirugias.getValueAt(SelectIndex, 1).toString());
        pacienteCombobox.setSelectedItem(defaultCirugias.getValueAt(SelectIndex, 2).toString());
        hospitalCombobox.setSelectedItem(defaultCirugias.getValueAt(SelectIndex, 3).toString());
        operacionText.setText(defaultCirugias.getValueAt(SelectIndex, 4).toString());
    }//GEN-LAST:event_tablaCirugiasMouseClicked

    private void operacionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_operacionTextActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_salirButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Cirugias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cirugias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cirugias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cirugias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cirugias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearCitaButton;
    private javax.swing.JComboBox doctorCombobox;
    private javax.swing.JComboBox hospitalCombobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField operacionText;
    private javax.swing.JComboBox pacienteCombobox;
    private javax.swing.JButton salirButton;
    private javax.swing.JTable tablaCirugias;
    // End of variables declaration//GEN-END:variables
}
