package expresat;

import javax.swing.JOptionPane;


public class RegistrarCategoriaEmpresa extends javax.swing.JFrame {


    public RegistrarCategoriaEmpresa() {
        initComponents();
        this.jLabel2.setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 450, 210));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(450, 210));
        setPreferredSize(new java.awt.Dimension(450, 210));
        getContentPane().setLayout(null);

        jLabel1.setText("Nombre de la Nueva Categoría:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 57, 180, 14);

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(131, 140, 73, 23);

        jButton2.setText("Atrás");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(240, 140, 73, 23);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(194, 44, 230, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("La categoría ya existe!!");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 100, 330, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                // Atras
        this.jTextField1.setText(null);
        this.jLabel2.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                // Crear Categoria
            Conexion conexion = new Conexion(); // crea una nueva conexion con la base de datos
            conexion.preparardb(); // Funcion en la forma principal que prepara la base de datos para realizar trabajos desde la interfaz
             if (conexion.registrarCategoriaEmpresa(jTextField1.getText())) 
            {
                JOptionPane.showMessageDialog(null, "Categoria Para Instituciones/Entes registrada correctamente");
                this.jTextField1.setText(null);
                this.dispose();
            }
            
            conexion.destruir();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
