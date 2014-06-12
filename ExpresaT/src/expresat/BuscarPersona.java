package expresat;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BuscarPersona extends javax.swing.JFrame 
{
   Conexion conexion;       // conexion a la base de datos
    
    public BuscarPersona() 
    {
        initComponents();
         conexion = new Conexion();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jButton5.setText("Regresar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(735, 530, 100, 23);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(192, 192, 192));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 11, 376, 546);

        jLabel1.setText("Buscar por Cédula:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 90, 135, 14);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(573, 87, 140, 20);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(573, 239, 90, 23);

        jLabel2.setText("Buscar por Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(420, 128, 135, 14);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(573, 125, 140, 20);

        jLabel3.setText("Buscar por Apellido:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(420, 166, 135, 14);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(573, 163, 140, 20);

        jLabel4.setText("Buscar por Categoría:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 204, 135, 14);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(573, 201, 140, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         this.jTextArea1.setText("");
         this.jTextField1.setText("");      // boton de cancelar
         this.jTextField2.setText("");
         this.jTextField3.setText("");
         this.jTextField4.setText("");
         this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            if(this.jTextField1.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField3.getText().equals("") && this.jTextField4.getText().equals(""))  // si no digita nada en los filtros
            {
                llenarListaPersonasTodas();
            }
            if(this.jTextField2.getText().equals("") && this.jTextField3.getText().equals("") && this.jTextField4.getText().equals(""))  // si filtra por cédula
            {
                String Ced = this.jTextField1.getText();
                llenarListaPersonas(Ced);
            }
            else if(this.jTextField1.getText().equals("") && this.jTextField3.getText().equals("") && this.jTextField4.getText().equals(""))// si filtra por nombre
            {
                String Nom = this.jTextField2.getText();
                llenarListaPersonasNom(Nom);
            }
            else if(!this.jTextField3.getText().equals("") && this.jTextField1.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField4.getText().equals("")) // si filtra por el primer apellido
            {
                String Ape = this.jTextField3.getText();
                llenarListaPersonasApe(Ape);
            }
            else if (this.jTextField4.getText()!=null && this.jTextField1.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField3.getText().equals("")) // si filtra por el segundo apellido
            {
                String Cat = this.jTextField4.getText();
                llenarListaPersonasCat(Cat);
            }
            else        // si no digitó filtro
            {
                JOptionPane.showMessageDialog(null, "Error detectado");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    // llena el listado de personas, ordenadas por cedula (default)
    private void llenarListaPersonas(String Ced) {
        ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverPersonasCed(Ced);
        String temp = "";
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            temp += lista.get(i)+"\n";
        }
        this.jTextArea1.setText(temp);
        conexion.destruir();
    }
    
        // llena el listado de personas, ordenadas por nombre
    private void llenarListaPersonasNom(String Nom) {
        ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverPersonasNom(Nom);
        String temp = "";
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            temp += lista.get(i)+"\n";
        }
        this.jTextArea1.setText(temp);
        conexion.destruir();
    }
    
            // llena el listado de personas, ordenadas por nombre
    private void llenarListaPersonasApe(String Ape) {
        ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverPersonasApe(Ape);
        String temp = "";
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            temp += lista.get(i)+"\n";
        }
        this.jTextArea1.setText(temp);
        conexion.destruir();
    }
        
    // llena el listado de personas, ordenadas por nombre
    private void llenarListaPersonasCat(String Cat) {
        ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverPersonasCat(Cat);
        String temp = "";
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            temp += lista.get(i)+"\n";
        }
        this.jTextArea1.setText(temp);
        conexion.destruir();
    }

    private void llenarListaPersonasTodas() 
    {
        
        ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverPersonas();
        String temp = "";
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            temp +=  lista.get(i)+"\n";
            
        }
        System.out.println(temp);
        this.jTextArea1.setText(temp);
        conexion.destruir();
    }
}
