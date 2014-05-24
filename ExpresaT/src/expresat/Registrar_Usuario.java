package expresat;

import java.util.ArrayList;

public class Registrar_Usuario extends javax.swing.JFrame 
{
    String nick, pass, rol, persona;
    Contrato contrato;
    Conexion conexion;
    
    public Registrar_Usuario(Contrato contrato) 
    {
        initComponents();
        this.jLabel9.setVisible(false);
        this.contrato=contrato;
        conexion = new Conexion();
        llenarComboBoxPersonas();
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
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

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
        jPanel1.add(jTextField4);
        jTextField4.setBounds(140, 90, 220, 30);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(140, 10, 220, 30);
        jPanel1.add(jTextField6);
        jTextField6.setBounds(140, 50, 220, 30);

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
        jLabel1.setBounds(10, 140, 130, 14);

        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(140, 140, 220, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 11, 380, 221);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!this.jTextField4.getText().equals("") && !this.jTextField5.getText().equals("") && !this.jTextField6.getText().equals("") && (this.jRadioButton1.isSelected() || this.jRadioButton2.isSelected()))
        {
            if(this.jTextField4.getText().equals(this.jTextField6.getText()))
            {
                nick=this.jTextField5.getText();
                pass=this.jTextField4.getText();
                persona= String.valueOf(this.jComboBox1.getSelectedItem());
                rol=this.jRadioButton1.isSelected()?"Administrador":"Usuario";
                contrato=new Contrato(nick, pass, rol,persona);
                contrato.setVisible(true);
                this.dispose();
            }
            else
            {
                this.jLabel9.setText("Las contraseñas no coinciden");
                this.jLabel9.setVisible(true);
                this.jTextField4.setText("");
                this.jTextField6.setText("");
            }
        }
        else 
        {
            this.jLabel9.setText("Falta llenar un campo de texto o no seleccionó el rol del nuevo usuario");
            this.jLabel9.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables

    private void llenarComboBoxPersonas() 
    {
        ArrayList<String> lista= new ArrayList();
        conexion.preparardb();
        lista= conexion.devolverListaPersonas();
        
        for (int i = 0; i < lista.size(); i++) 
        {
            this.jComboBox1.addItem(lista.get(i));
        }
        
        conexion.destruir();
    }
}
