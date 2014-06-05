package expresat;

import javax.swing.JOptionPane;
// Clase que generara el contrato de uso de la aplicacion cada vez que se cree un nuevo usuario.
public class Contrato extends javax.swing.JFrame 
{
    String nick, pass, rol, persona;
    
    public Contrato(String nick, String pass, String rol, String persona) 
    {
        initComponents();
        this.nick=nick;
        this.pass=pass;
        this.rol=rol;
        this.persona= persona;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(620, 525));
        getContentPane().setLayout(null);

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(360, 460, 87, 23);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(510, 460, 86, 23);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("No, acepto los terminos indicados en el contrato.");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(10, 400, 662, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Acepto los terminos indicados en el contrato.");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(10, 370, 662, 23);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Mediante el presente contrato el usuario, que esta por crearse, acepta la total y completa\nresponsabilidad del uso que le de al servicio brindado por nuestra empresa y como tal\nnos vemos librados de cualquier implicacion legal de cualquier responsabilidad una vez \naceptado este documento.\n\nEl software desarrollado posee un reglamente de uso que se explicara a continuación:\n\n* No se podra usar el software para fines malignos.\n* No se debe reportar más de una vez seguida a la misma persona inmediatamente.\n* No revelar la identidad propia o de algún conocido que haga uso del software.\n* Abstenerse de usar lenguaje soez a la hora de realizar una denuncia.\n* Las calificaciones son 100% subjetivas, no se deben presentar problemas por el\nresultado que presenten.\n\nAhora una vez aceptado el contrato y habiendo leido las normas de uso la empresa \nse compromete a brindarle al usuario los siguientes servicios:\n\n* Denunciar un ente o persona presentando evidencias.\n* Calificar algún ente o persona basandose en alguna experiencia previa con el mismo.\n* Realizar consultas sobre algún ente o persona existentes en la base de datos.\n* Crear alguna categoría nueva para un ente o una persona.\n* Reportar algún usuario por infringir alguna de las normas explicadas anteriormente.\n");
        jTextArea1.setCaretPosition(1);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 10, 580, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(null, "A falta de la aceptación del contrato de uso, el usuario no se ha creado");
        this.dispose(); // Cierra la ventana de contrato y no crea el usuario si no aceptan el mismo
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(this.jRadioButton2.isSelected())
        {
            Conexion conexion = new Conexion(); // crea una nueva conexion con la base de datos
            conexion.preparardb(); // Funcion en la forma principal que prepara la base de datos para realizar trabajos desde la interfaz
            
            
            if (conexion.registrarUsuario(nick, pass, rol, persona))
            {
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente"); // Parece haber problemas aqui ID no puede ser null xq en la tabla cartesiana hay problemas
                this.dispose();
            }
            else if (this.jRadioButton1.isSelected())
            {
                 JOptionPane.showMessageDialog(null, "Por favor lea y acepte los terminos de uso");
                 this.dispose(); // Cierra la ventana de contrato y no crea el usuario si no aceptan el mismo
            }
            conexion.destruir();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
