package expresat;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Registrar_Persona extends javax.swing.JFrame 
{
    Conexion conexion;
    public Registrar_Persona() 
    {
        initComponents();
        conexion= new Conexion();
        this.jLabel6.setVisible(false);
        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.jTextField3.setText("");
        this.jTextField4.setText("");
        this.jTextField5.setText("");
        
        for (int i = 0; i < 31; i++)                    // inicializa los días de enero
        {
            jComboBox4.addItem(String.valueOf(i+1));
        }
        
        llenarComboBoxEntes();   // método que accede a la base de datos para rellenar con Entes registrados
        llenarComboBoxTipos();       // método que accede a la base de datos para rellenar con las categorias de personas existentes.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jLabel9.setText("Institucion Donde Labora:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 290, 185, 14);

        jLabel10.setText("Cargo que Desempeña en la sociedad:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 337, 240, 14);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(580, 290, 90, 23);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(580, 320, 90, 23);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(260, 290, 210, 20);

        jPanel1.setMinimumSize(new java.awt.Dimension(660, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(660, 300));
        jPanel1.setLayout(null);

        jLabel1.setText("Nombre *:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 125, 14);

        jLabel2.setText("Primer Apellido *:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 50, 125, 14);

        jLabel3.setText("Segundo Apellido:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 80, 125, 14);

        jLabel4.setText("Cédula*:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 110, 125, 14);

        jLabel5.setText("Fecha de Nacimiento*:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 150, 150, 14);

        jLabel7.setText("Genero*:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 190, 125, 14);

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Hombre");
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(110, 190, 80, 23);

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Mujer");
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(190, 190, 80, 23);

        jTextField1.setToolTipText("");
        jPanel1.add(jTextField1);
        jTextField1.setBounds(140, 10, 250, 30);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(140, 40, 250, 30);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(140, 70, 250, 30);

        jTextField4.setToolTipText("");
        jPanel1.add(jTextField4);
        jTextField4.setBounds(140, 100, 250, 30);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(230, 140, 80, 30);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(390, 150, 90, 20);

        jPanel1.add(jComboBox4);
        jComboBox4.setBounds(560, 150, 80, 20);

        jLabel8.setText("Año:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(180, 150, 40, 14);

        jLabel11.setText("Mes:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(330, 150, 40, 14);

        jLabel12.setText("Dia:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(500, 150, 40, 14);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 660, 240);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("EROOREWS!!!!!!!!!!!!!!");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 260, 350, 22);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(260, 330, 210, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // verifica primero si hay errores
        
        if (this.jTextField1.getText().equals("") || this.jTextField2.getText().equals("") || this.jTextField4.getText().equals("") || this.jTextField5.getText().equals(""))
        {
            this.jLabel6.setText("ERROR: Faltan campos de texto que rellenar");
            jLabel6.setVisible(true);
        }
        else if(!(jRadioButton1.isSelected()) && !(jRadioButton2.isSelected()))
        {
            this.jLabel6.setText("ERROR: No ha escogido género");
            jLabel6.setVisible(true);
        }
        else
        {
          Conexion conexion = new Conexion(); // crea una nueva conexion con la base de datos
            conexion.preparardb(); // Funcion en la forma principal que prepara la base de datos para realizar trabajos desde la interfaz
            
            
            if (conexion.registrarPersona(jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText(),(jRadioButton1.isSelected())?"Masculino":"Femenino",getFechaConFormato(),String.valueOf(jComboBox2.getSelectedItem()))) 
            {
                JOptionPane.showMessageDialog(null, "Persona registrada correctamente");
                this.dispose();
            }
            
            conexion.destruir();  
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        jComboBox4.removeAllItems();
        String mes =String.valueOf(jComboBox3.getSelectedItem());
     
        if(!jTextField5.getText().equals(""))
        {
            if (mes.equals("Abril") || mes.equals("Junio") || mes.equals("Setiembre") || mes.equals("Noviembre"))
            {                
                for (int i = 0; i < 30; i++) 
                {
                    jComboBox4.addItem(String.valueOf(i+1));
                }
            }
            else if (mes.equals("Febrero"))
            {
                for (int i = 0; i < ((((Integer.parseInt(jTextField5.getText()))%4)==0)?29:28); i++) 
                {
                    jComboBox4.addItem(String.valueOf(i+1));
                }
            }
            else
            {
                for (int i = 0; i < 31; i++) 
                {
                    jComboBox4.addItem(String.valueOf(i+1));
                }
            }
        }
        else
        {
            jLabel6.setText("ERROR: primero digite el año");
            jLabel6.setVisible(true);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jLabel6.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // Combobox con entidades disponibles en la base de datos
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // Combobox con los cargos dispoibles en la base de datos
        
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
    
    private void llenarComboBoxEntes()       // método que accede a la base de datos para rellenar con Entes registrados
    {
        
        ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverListaEntes();
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            this.jComboBox1.addItem(lista.get(i));
        }
        
        conexion.destruir();
    }
    
    private String getFechaConFormato()       // método 
    {
        String fecha= ""+jTextField5.getText()+"-";
        
        switch (String.valueOf(jComboBox3.getSelectedItem()))
        {
            case "Enero":
            {
                fecha=fecha+"01-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Febrero":
            {
                fecha=fecha+"02-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Marzo":
            {
                fecha=fecha+"03-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Abril":
            {
                fecha=fecha+"04-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Mayo":
            {
                fecha=fecha+"05-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Junio":
            {
                fecha=fecha+"06-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Julio":
            {
                fecha=fecha+"07-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Agosto":
            {
                fecha=fecha+"08-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Setiembre":
            {
                fecha=fecha+"09-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Octubre":
            {
                fecha=fecha+"10-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Noviembre":
            {
                fecha=fecha+"11-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
            case "Diciembre":
            {
                fecha=fecha+"12-"+String.valueOf(jComboBox4.getSelectedItem());
                break;
            }
        }
        
        return fecha;
    }

    private void llenarComboBoxTipos()       // método que accede a la base de datos para rellenar con personas registradas y que no han sido relacionadas a una cuenta
    {
        ArrayList<String> lista= new ArrayList();       // método que accede a la base de datos para rellenar con las categorias de personas existentes.
        conexion.preparardb();
        lista= conexion.devolverListaTiposPersona();

        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            this.jComboBox2.addItem(lista.get(i));
        }

        conexion.destruir();
    }
}
