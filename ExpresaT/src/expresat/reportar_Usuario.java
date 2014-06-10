package expresat;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class reportar_Usuario extends javax.swing.JFrame 
{
    Conexion conexion;
    String user;
    
    public reportar_Usuario(String usuario) 
    {
        user=usuario;
        conexion= new Conexion();
        initComponents();
        llenarComboBoxPersonas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 600, 160));
        setMinimumSize(new java.awt.Dimension(600, 160));
        setPreferredSize(new java.awt.Dimension(600, 160));
        getContentPane().setLayout(null);

        jButton1.setText("Reportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 110, 250, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 270, 90);

        jLabel1.setText("Descripcion del reporte:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 180, 14);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(310, 40, 250, 20);

        jLabel2.setText("Involucrar usuario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 20, 170, 20);

        jButton4.setText("Atras");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(310, 80, 250, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextArea1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Faltan datos por rellenar");
        }
        else
        {
            conexion.preparardb();
            conexion.insertarReporteUsuario(jTextArea1.getText(), String.valueOf(jComboBox1.getSelectedItem()));
            JOptionPane.showMessageDialog(rootPane, "Usuario reportado correctamente");
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void llenarComboBoxPersonas()       // método que accede a la base de datos para rellenar con personas registradas y que no han sido relacionadas a una cuenta
    {
        ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverListaUsuarios();
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            this.jComboBox1.addItem(lista.get(i));
        }
        
        conexion.destruir();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
