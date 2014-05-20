package expresat;

public class PaginaPrincipal extends javax.swing.JFrame 
{
    String usuario;
    String rol;
    
    public PaginaPrincipal(String user, String rol) 
    {
        initComponents();
        setUsuario(user);
        setRol(rol);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));
        jPanel1.setLayout(null);

        jButton1.setText("Registrar una denuncia");
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 30, 160, 23);

        jButton2.setText("Ver denuncias");
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 60, 160, 23);

        jButton7.setText("Calificar persona");
        jPanel1.add(jButton7);
        jButton7.setBounds(10, 90, 160, 23);

        jButton4.setText("Registro de categoria");
        jPanel1.add(jButton4);
        jButton4.setBounds(10, 120, 160, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 10, 280, 420);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrador"));
        jPanel2.setLayout(null);

        jButton3.setText("Registrar Persona");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(10, 30, 140, 23);

        jButton5.setText("Registro de entidades");
        jPanel2.add(jButton5);
        jButton5.setBounds(10, 60, 140, 23);

        jButton6.setText("Registro de usuarios");
        jPanel2.add(jButton6);
        jButton6.setBounds(10, 90, 140, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(310, 10, 240, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}