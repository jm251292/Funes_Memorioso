package expresat;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Home extends javax.swing.JFrame 
{
    Conexion conexion;
    String viejoNick;

    public Home(String nick) 
    {
        initComponents();
        viejoNick= nick;
        conexion= new Conexion();
        jLabel4.setVisible(false);
        getReportes(nick);
        this.setSize(800, 600);
        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.jTextField3.setText("");
        this.jTextField4.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Actualizar perfil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(390, 30, 140, 23);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(140, 20, 210, 30);

        jLabel1.setText("Nuevo nick");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 80, 14);

        jLabel2.setText("Nueva contraseña");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 130, 14);

        jLabel3.setText("Repetir contraseña");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 90, 110, 14);

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(360, 90, 200, 30);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(140, 50, 210, 30);
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(140, 80, 210, 30);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(390, 60, 140, 23);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(620, 40, 150, 30);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(620, 70, 150, 30);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(620, 100, 150, 30);

        jLabel5.setText("Nombre:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(560, 50, 50, 14);

        jLabel6.setText("Apellido 1");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(560, 80, 60, 14);

        jLabel7.setText("Apellido 2");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(560, 110, 60, 14);

        jLabel8.setText("Género:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(560, 140, 60, 14);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(620, 140, 150, 20);

        jButton3.setText("Actualizar informacion personal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(560, 370, 210, 23);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No añadir" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(560, 190, 210, 20);

        jLabel9.setText("Añadir funcion social:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(560, 170, 210, 14);

        jLabel10.setText("Eliminar rol social ya adquirido:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(560, 220, 200, 20);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No eliminar" }));
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(560, 240, 210, 20);

        jLabel11.setText("Añadir lugar de trabajo:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(560, 270, 200, 14);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No añadir" }));
        getContentPane().add(jComboBox4);
        jComboBox4.setBounds(560, 290, 210, 20);

        jLabel12.setText("Eliminar lugar de trabajo:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(560, 320, 150, 14);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No eliminar" }));
        getContentPane().add(jComboBox5);
        jComboBox5.setBounds(560, 340, 210, 20);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(40, 150, 460, 190);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.jTextField3.setText("");
        this.jTextField4.setText("");
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nuevoNombre, nuevoApellido1, nuevoApellido2, nuevoGenero, nuevoRol, rolEliminado,nuevoTrabajo, trabajoEliminado;
        
        if(!this.jTextField2.getText().equals("") && !this.jTextField3.getText().equals("") && !this.jTextField4.getText().equals(""))      // verifica que no falte ningún campo por rellenar
        {
                conexion.preparardb();
                
                conexion.destruir();
                nuevoNombre=this.jTextField2.getText();        // obtiene el nombre para actualizar
                nuevoApellido1=this.jTextField3.getText();    // obtiene el primer apellido para actualizar
                nuevoApellido2=this.jTextField3.getText();    // obtiene el segundo apellido para actualizar
                nuevoGenero=String.valueOf(jComboBox1.getSelectedItem());    // obtiene el genero para actualizar
                nuevoRol=String.valueOf(jComboBox2.getSelectedItem());    // obtiene el genero para actualizar
                nuevoTrabajo=String.valueOf(jComboBox3.getSelectedItem());    // obtiene el genero para actualizar
                rolEliminado=String.valueOf(jComboBox4.getSelectedItem());    // obtiene el genero para actualizar
                trabajoEliminado=String.valueOf(jComboBox5.getSelectedItem());    // obtiene el genero para actualizar
                
                if (conexion.actualizarPersona(nuevoNombre, nuevoApellido1, nuevoApellido2, nuevoGenero, nuevoRol,nuevoTrabajo,rolEliminado,trabajoEliminado, viejoNick ))
                {
                    JOptionPane.showMessageDialog(null, "Información personal actualizada correctamente"); // Parece haber problemas aqui ID no puede ser null xq en la tabla cartesiana hay problemas
                    this.dispose();
                }
        }
        else        // si falto campos de texto por rellenar aqui se pone el error
        {
            this.jLabel4.setText("Falta llenar un campo de texto");
            this.jLabel4.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private void getReportes(String nick) 
    {
        ArrayList<String> lista= new ArrayList();
        conexion.preparardb();
        lista= conexion.getreportes(nick);
        
        for (int i = 0; i < lista.size(); i++) 
        {
            jTextArea1.setText(jTextArea1.getText()+"Reporte #"+(i+1)+":  "+lista.get(i));
            System.out.println(lista.get(i));
        }
    }
}
