package expresat;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Registrar_Entidad extends javax.swing.JFrame {
    
    Conexion conexion;
    public Registrar_Entidad() {
        initComponents();
        conexion= new Conexion();
        this.jLabel10.setVisible(false);
        llenarComboBoxCat();       // método que accede a la base de datos para rellenar con las categorias de los entes existentes.
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 410, 90, 23);

        jTextField1.setMinimumSize(new java.awt.Dimension(6, 30));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(200, 10, 220, 30);

        jLabel1.setText("Nombre del ente o la institución*:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 190, 14);

        jButton2.setText("Atrás");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(430, 410, 90, 23);

        jLabel2.setText("Cédula jurídica:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 60, 100, 14);

        jTextField2.setMinimumSize(new java.awt.Dimension(6, 30));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(200, 50, 220, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dirección"));
        jPanel1.setLayout(null);

        jLabel3.setText("País*:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 20, 60, 14);

        jLabel4.setText("Provincia*:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 60, 80, 14);

        jLabel5.setText("Cantón*:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 100, 80, 14);

        jLabel6.setText("Distrito*:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 140, 80, 14);

        jLabel7.setText("Barrio:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 180, 50, 20);

        jLabel8.setText("* campos obligados");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 210, 170, 14);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(120, 10, 170, 30);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(120, 50, 170, 30);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(120, 90, 170, 30);
        jPanel1.add(jTextField6);
        jTextField6.setBounds(120, 130, 170, 30);
        jPanel1.add(jTextField7);
        jTextField7.setBounds(120, 170, 170, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 140, 300, 230);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(200, 100, 220, 20);

        jLabel9.setText("Categoría:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 100, 110, 14);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("ERROOOOR!!!!");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(70, 380, 530, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.jTextField1.getText().equals("") || this.jTextField4.getText().equals("") || this.jTextField5.getText().equals("") || this.jTextField6.getText().equals(""))
        {
            this.jLabel10.setText("ERROR: Faltan campos de texto que rellenar");
            this.jLabel10.setVisible(true);
        }
        else 
        {
            Conexion conexion = new Conexion(); // crea una nueva conexion con la base de datos
            conexion.preparardb(); // Funcion en la forma principal que prepara la base de datos para realizar trabajos desde la interfaz
             if (conexion.registrarEntidad(jTextField1.getText(),jTextField2.getText(),String.valueOf(jComboBox1.getSelectedItem()),jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),jTextField6.getText(),jTextField7.getText())) 
            {
                JOptionPane.showMessageDialog(null, "Entidad registrada correctamente");
                this.dispose();
            }
            
            conexion.destruir();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

private void llenarComboBoxCat()       // método que accede a la base de datos para rellenar con Entes registrados
    {
        this.jComboBox1.addItem(""); // Deja un espacio en blanco pues este espacio es opcional
        ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverListaCat();
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            this.jComboBox1.addItem(lista.get(i));
        }
        
        conexion.destruir();
    }

}
