package expresat;

import java.util.ArrayList;
import javax.swing.JTextArea;

public class Visualizar_Denuncias extends javax.swing.JFrame 
{
    Conexion conexion;
    
    public Visualizar_Denuncias(String rol) 
    {
        conexion= new Conexion();
        initComponents();
        LlenarDenuncias(rol);
        this.setSize(800, 600);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jButton1.setText("Nombre");
        jButton1.setPreferredSize(new java.awt.Dimension(115, 23));
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 50, 115, 23);

        jLabel1.setText("Filtros");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(630, 20, 60, 14);

        jButton2.setText("Primer Apellido");
        jButton2.setPreferredSize(new java.awt.Dimension(115, 23));
        getContentPane().add(jButton2);
        jButton2.setBounds(520, 80, 115, 23);

        jButton3.setLabel("Segundo Apellido");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(670, 80, 115, 23);

        jButton4.setText("Cedula");
        jButton4.setPreferredSize(new java.awt.Dimension(115, 23));
        getContentPane().add(jButton4);
        jButton4.setBounds(670, 50, 115, 23);

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(683, 400, 100, 23);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 500, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void LlenarDenuncias(String rol) 
    {
        ArrayList<String> lista= new ArrayList();
        conexion.preparardb();
        lista= conexion.getDenuncias(rol);
        JTextArea reporte;
        
        for (int i = 0; i < lista.size(); i++) 
        {
            reporte = new JTextArea();
            reporte.setText(lista.get(i));
            reporte.setEditable(false);
            this.jPanel1.add(reporte);
        }
    }
}