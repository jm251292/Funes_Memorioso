package expresat;
import javax.swing.JOptionPane;

public class home extends javax.swing.JFrame 
{
    Conexion conexion;
    String viejoNick;
    
    public home(String nick)
    {
        initComponents();
        viejoNick= nick;
        conexion= new Conexion();
        jLabel4.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Nombre usuario:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 44, 90, 20);

        jLabel2.setText("Contraseña nueva:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 70, 100, 20);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(190, 40, 150, 20);

        jLabel3.setText("Repetir contraseña nueva:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 100, 140, 14);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(190, 70, 150, 20);
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(190, 100, 150, 20);

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 40, 90, 23);

        jButton2.setText("Cancelar");
        getContentPane().add(jButton2);
        jButton2.setBounds(370, 80, 90, 23);

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 160, 260, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String pass, nuevoNick;
        
        if(!this.jPasswordField1.getText().equals("") && !this.jTextField1.getText().equals("") && !this.jPasswordField2.getText().equals(""))      // verifica que no falte ningún campo por rellenar
        {
            if(this.jPasswordField1.getText().equals(this.jPasswordField2.getText()))   // verifica que la contraseña esta repetida correctamente para términos de seguridad
            {
                conexion.preparardb();
                if(conexion.VerificarUsuario(jTextField1.getText()))
                {
                    conexion.destruir();
                    nuevoNick=this.jTextField1.getText();        // obtiene el nick del nuevo usuario de los campos de texto
                    pass=this.jPasswordField1.getText();    // obtiene la contraseña del nuevo usuario de los campos de texto
                    
                    if (conexion.actualizarUsuario(nuevoNick, pass, viejoNick))
                    {
                        JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente"); // Parece haber problemas aqui ID no puede ser null xq en la tabla cartesiana hay problemas
                        this.dispose();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El nick deseado ya existe por favor modifiquelo");
                    conexion.destruir();
                    jTextField1.setText("");
                }
            }
            else
            {
                this.jLabel4.setText("Las contraseñas no coinciden");       // en caso de que las contraseñas no coincidan, manda el error correspondiente
                this.jLabel4.setVisible(true);
                this.jPasswordField1.setText("");       // borra los campos de contraseña para que vuelva a intentar
                this.jPasswordField2.setText("");
            }
        }
        else        // si falto campos de texto por rellenar aqui se pone el error
        {
            this.jLabel4.setText("Falta llenar un campo de texto");
            this.jLabel4.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
