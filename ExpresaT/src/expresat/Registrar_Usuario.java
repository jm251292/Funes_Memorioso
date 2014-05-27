package expresat;

import java.util.ArrayList;

public class Registrar_Usuario extends javax.swing.JFrame 
{
    String nick, pass, rol, persona;        // variables que guardan los nuevos datos del usuario recién creado
    Contrato contrato;                      // instancia de la siguiente ventana la cual incluye el contrato del usuario el cual tiene que aceptar para poder crear su cuenta
    Conexion conexion;                      // instancia para conetar con la base de datos
    
    public Registrar_Usuario(Contrato contrato) 
    {
        initComponents();
        this.jLabel9.setVisible(false);     // Label necesario para mostrar errores desactivado
        this.contrato=contrato;
        conexion = new Conexion();
        llenarComboBoxPersonas();           // llena el ComboBox con personas a las cuales no se les ha asignado una cuenta personal
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 350));
        getContentPane().setLayout(null);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 238, 96, 23);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(196, 238, 96, 23);

        jPanel1.setInheritsPopupMenu(true);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel5.setText("Repetir Contraseña:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 100, 124, 14);

        jLabel6.setText("Nick:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 20, 60, 14);

        jLabel7.setText("Contraseña:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 60, 124, 14);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(140, 10, 220, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("EL NICK SELECCIONADO YA SE ENCUENTRA EN USO");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 196, 282, 14);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Administrador");
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(10, 170, 91, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Usuario");
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(150, 170, 100, 23);

        jLabel1.setText("Relacionar con Persona:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 140, 150, 14);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(160, 140, 220, 20);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(140, 90, 220, 30);
        jPanel1.add(jPasswordField2);
        jPasswordField2.setBounds(140, 50, 220, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 11, 480, 221);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!this.jPasswordField1.getText().equals("") && !this.jTextField5.getText().equals("") && !this.jPasswordField2.getText().equals("") && (this.jRadioButton1.isSelected() || this.jRadioButton2.isSelected()))      // verifica que no falte ningún campo por rellenar
        {
            if(this.jPasswordField1.getText().equals(this.jPasswordField2.getText()))   // verifica que la contraseña esta repetida correctamente para términos de seguridad
            {
                nick=this.jTextField5.getText();        // obtiene el nick del nuevo usuario de los campos de texto
                pass=this.jPasswordField1.getText();    // obtiene la contraseña del nuevo usuario de los campos de texto
                persona= String.valueOf(this.jComboBox1.getSelectedItem()); // obtiene la persona con la cual se va a ligar el nuevo usuario de los campos de texto, si algo le pasa a esta persona el usuario responderá por ella
                rol=this.jRadioButton1.isSelected()?"Administrador":"Usuario"; // obtiene el rol del nuevo usuario de los campos de texto
                contrato=new Contrato(nick, pass, rol,persona);         // prepara la ventana con el contrato y le pasa los parámetros para crear la nueva cuenta
                contrato.setVisible(true);                  
                this.dispose();         // libera y destruye esta ventana
            }
            else
            {
                this.jLabel9.setText("Las contraseñas no coinciden");       // en caso de que las contraseñas no coincidan, manda el error correspondiente
                this.jLabel9.setVisible(true);
                this.jPasswordField1.setText("");       // borra los campos de contraseña para que vuelva a intentar
                this.jPasswordField2.setText("");
            }
        }
        else        // si falto campos de texto por rellenar aqui se pone el error
        {
            this.jLabel9.setText("Falta llenar un campo de texto o no seleccionó el rol del nuevo usuario");
            this.jLabel9.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();     // boton de cancelar
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    private void llenarComboBoxPersonas()       // método que accede a la base de datos para rellenar con personas registradas y que no han sido relacionadas a una cuenta
    {
        ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverListaPersonas();
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            this.jComboBox1.addItem(lista.get(i));
        }
        
        conexion.destruir();
    }
}
