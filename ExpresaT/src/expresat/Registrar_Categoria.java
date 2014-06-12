package expresat;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Registrar_Categoria extends javax.swing.JFrame 
{
    Conexion conexion;
    
    public Registrar_Categoria() {
        initComponents();
        conexion = new Conexion();
        this.jTextField1.setText(null);
        this.jTextArea1.setText("");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 800, 345));
        setMinimumSize(new java.awt.Dimension(800, 345));
        getContentPane().setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(190, 40, 200, 30);

        jLabel1.setText("Nombre de la nueva categoría:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 50, 190, 14);

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(133, 123, 90, 23);

        jButton2.setText("Atrás");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(332, 209, 90, 23);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(192, 192, 192));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(490, 11, 300, 300);

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(168, 209, 90, 23);

        jLabel2.setText("Consultar Categotrías:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(19, 213, 122, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jTextField1.setText(null);
        this.jTextArea1.setText("");
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Crear Categoria
            Conexion conexion = new Conexion(); // crea una nueva conexion con la base de datos
            conexion.preparardb(); // Funcion en la forma principal que prepara la base de datos para realizar trabajos desde la interfaz
             if (conexion.registrarCategoriaPer(jTextField1.getText())) 
            {
                JOptionPane.showMessageDialog(null, "Categoria registrada correctamente");
                this.jTextField1.setText(null);
                this.dispose();
            }
            else
             {
                JOptionPane.showMessageDialog(null, "La Categoría Registrada YA existe");
                this.jTextField1.setText(null);
             }
            conexion.destruir();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        llenarListaCat();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

        private void llenarListaCat() {
         ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverCatPersona();
        String temp = "";
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            temp += lista.get(i)+"\n";
        }
        this.jTextArea1.setText(temp);
        conexion.destruir();
    }
    
}
