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
public class Cita_postoperatoria extends javax.swing.JFrame {

    /**
     * Creates new form Cirugias
     */
    public Cita_postoperatoria() {
        initComponents();
        Conexion();
        CargarPaciente();
        CargarHospital();
        TablaPostoperatoria();
    }

    Connection conexion;
    PreparedStatement preparedStatement;
    ResultSet resultset;
    
    
    
    
    
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
            Logger.getLogger(Cita_postoperatoria.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Cita_postoperatoria.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    public void TablaPostoperatoria(){
        try {
            preparedStatement = conexion.prepareStatement("select * from cita_postoperatoria");
            resultset = preparedStatement.executeQuery();
            java.sql.ResultSetMetaData Rsm = resultset.getMetaData();
            int conteoColumna;
            conteoColumna = Rsm.getColumnCount();
            DefaultTableModel defaultTable = (DefaultTableModel)tablaPostoperatoria.getModel();
            defaultTable.setRowCount(0);
            
            while(resultset.next()){
                Vector vector = new Vector();
                
                for (int indiceColumna = 0; indiceColumna < conteoColumna; indiceColumna++) {
                    vector.add(resultset.getString("id_postoperatoria"));
                    vector.add(resultset.getString("hospital"));
                    vector.add(resultset.getString("paciente"));
                    vector.add(resultset.getString("fecha"));
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
        pacienteCombobox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        hospitalCombobox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        fechaPostoperatoriaText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPostoperatoria = new javax.swing.JTable();
        crearInternamientoButton = new javax.swing.JButton();
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cita postoperatoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Fecha cita postoperatoria:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Hospital: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Paciente:");

        fechaPostoperatoriaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaPostoperatoriaTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(50, 50, 50)
                        .addComponent(fechaPostoperatoriaText, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(167, 167, 167)
                        .addComponent(pacienteCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(165, 165, 165)
                        .addComponent(hospitalCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hospitalCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pacienteCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fechaPostoperatoriaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        tablaPostoperatoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Internamiento", "Hospital", "Paciente", "Fecha Cita Postoperatoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaPostoperatoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPostoperatoriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPostoperatoria);

        crearInternamientoButton.setText("Crear cita postoperatoria");
        crearInternamientoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearInternamientoButtonActionPerformed(evt);
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
                .addComponent(crearInternamientoButton)
                .addGap(182, 182, 182)
                .addComponent(salirButton)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearInternamientoButton)
                    .addComponent(salirButton))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void crearInternamientoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearInternamientoButtonActionPerformed
        
        
        String hospital = hospitalCombobox.getSelectedItem().toString();
        String paciente = pacienteCombobox.getSelectedItem().toString();
        String fechapostoperatoria = fechaPostoperatoriaText.getText();
        
        Conexion();
        try {
            preparedStatement = conexion.prepareStatement("insert into cita_postoperatoria(hospital,paciente,fecha)values(?,?,?)");
            preparedStatement.setString(1,hospital);
            preparedStatement.setString(2,paciente);
            preparedStatement.setString(3,fechapostoperatoria);
            preparedStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Cita postoperatoria ingresada");
            
            hospitalCombobox.setSelectedIndex(-1);
            pacienteCombobox.setSelectedIndex(-1);
            fechaPostoperatoriaText.setText("");
            fechaPostoperatoriaText.requestFocus();
            TablaPostoperatoria();
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_crearInternamientoButtonActionPerformed

    private void tablaPostoperatoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPostoperatoriaMouseClicked
        DefaultTableModel defaultPostoperatoria = (DefaultTableModel)tablaPostoperatoria.getModel();
        int SelectIndex = tablaPostoperatoria.getSelectedRow();
        
        hospitalCombobox.setSelectedItem(defaultPostoperatoria.getValueAt(SelectIndex, 1).toString());
        pacienteCombobox.setSelectedItem(defaultPostoperatoria.getValueAt(SelectIndex, 2).toString());
        fechaPostoperatoriaText.setText(defaultPostoperatoria.getValueAt(SelectIndex, 3).toString());
        
        
    }//GEN-LAST:event_tablaPostoperatoriaMouseClicked

    private void fechaPostoperatoriaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaPostoperatoriaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaPostoperatoriaTextActionPerformed

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
            java.util.logging.Logger.getLogger(Cita_postoperatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cita_postoperatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cita_postoperatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cita_postoperatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cita_postoperatoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearInternamientoButton;
    private javax.swing.JTextField fechaPostoperatoriaText;
    private javax.swing.JComboBox hospitalCombobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox pacienteCombobox;
    private javax.swing.JButton salirButton;
    private javax.swing.JTable tablaPostoperatoria;
    // End of variables declaration//GEN-END:variables
}
