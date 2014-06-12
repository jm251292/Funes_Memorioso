package expresat;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BuscarEnte extends javax.swing.JFrame 
{
    Conexion conexion;  // variable de interacción con la base de datos

    public BuscarEnte() 
    {
        initComponents();
        conexion = new Conexion();  // limpia campos e inicializa los componentes
         this.jTextField2.setText("");
         this.jTextField3.setText("");
         this.jTextArea1.setText("");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(192, 192, 192));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 11, 375, 534);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(650, 531, 100, 23);

        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(450, 170, 120, 14);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(588, 167, 130, 20);

        jLabel2.setText("Cédula Jurídica:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(450, 208, 120, 14);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(588, 205, 130, 20);

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(510, 256, 100, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         this.jTextField2.setText("");// boton de regreso al menu principal
         this.jTextField3.setText("");
         this.jTextArea1.setText("");
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         if(this.jTextField2.getText()!=null && this.jTextField3.getText().equals(""))  // busca el ente
            {
                String Nom = this.jTextField2.getText();                    // si busca solo por el nombre filtra por el mismo
                llenarListaEntesNom(Nom);
            }
         else if(this.jTextField3.getText()!=null && this.jTextField2.getText().equals("")) // si busca solo por la cédula filtra por la misma
            {
                String Ced = this.jTextField3.getText();                    
                llenarListaEntes(Ced);
            }
         else                                                                                       // si no digito filtro
            {
                JOptionPane.showMessageDialog(null, "Error detectado, no digitó filtro");
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private void llenarListaEntes(String Ced) 
    {
         ArrayList<String> lista= new ArrayList();       // lista con las cédulas para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverEntesCed(Ced);
        String temp = "";
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            temp += lista.get(i)+"\n";
        }
        this.jTextArea1.setText(temp);
        conexion.destruir();
    }

    private void llenarListaEntesNom(String Nom) 
    {
         ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverEntesNom(Nom);
        String temp = "";
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agrega uno a uno a las personas
        {
            temp += lista.get(i)+"\n";
        }
        this.jTextArea1.setText(temp);
        conexion.destruir();
    }
    
}
