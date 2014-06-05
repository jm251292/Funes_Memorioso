package expresat;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Borrar_Denuncia extends javax.swing.JFrame 
{
    Conexion conexion;
    String usuario;
    ArrayList<String> lista;
    
    public Borrar_Denuncia(String usuario) 
    {
        initComponents();
        conexion= new Conexion();
        this.usuario=usuario;
        llenarCombobox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(220, 40, 230, 20);

        jLabel1.setText("Seleccione la denuncia a borrar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 40, 170, 14);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 200, 110, 23);

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 200, 120, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 80, 410, 96);

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(300, 200, 150, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String texto;
        
        for (int i = 0; i < lista.size(); i++) 
        {
            if(lista.get(i).split("_")[0].equals(String.valueOf(jComboBox1.getSelectedItem())))
            {
                jTextArea1.setText(lista.get(i).split("_")[1]);
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!String.valueOf(jComboBox1.getSelectedItem()).equals(""))
        {
            conexion.preparardb();
            conexion.desactivardenuncia(String.valueOf(jComboBox1.getSelectedItem()));
            jComboBox1.removeAllItems();
            llenarCombobox();
            JOptionPane.showMessageDialog(rootPane, "Eliminado correctamente");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!String.valueOf(jComboBox1.getSelectedItem()).equals(""))
        {
            conexion.preparardb();
            conexion.actualizarDenuncia(String.valueOf(jComboBox1.getSelectedItem()), jTextArea1.getText());
            llenarCombobox();
            JOptionPane.showMessageDialog(rootPane, "Actualizado correctamente");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void llenarCombobox() 
    {
        lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverListaDenuncias(usuario);
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            this.jComboBox1.addItem(lista.get(i).split("_")[0]);
        }
        
        conexion.destruir();
    }
}
