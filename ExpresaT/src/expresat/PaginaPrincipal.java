package expresat;

public class PaginaPrincipal extends javax.swing.JFrame 
{
    String usuario;     // variable que guarda el usuario que se logueó
    String rol;         // rol del usuario que se logueó
    Registrar_Usuario registrar_Usuario;        // instancias de las diferentes ventana para que no se abran mas de una vez
    Registro_Denuncia registro_Denuncia;
    Registrar_Categoria registrar_Categoria;
    Registrar_Entidad registrar_Entidad;
    Registrar_Persona registrar_Persona;
    Contrato contrato;
    
    public PaginaPrincipal(String user, String rol) 
    {
        initComponents();
        setUsuario(user);       // métodos getter y setter necesarios
        setRol(rol);
        
        activarControles();
    }

    public String getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }

    public void setRol(String rol) 
    {
        this.rol = rol;
    }

    public String getRol() 
    {
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
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));
        jPanel1.setLayout(null);

        jButton1.setText("Registrar una denuncia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 30, 220, 23);

        jButton2.setText("Ver denuncias");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 60, 220, 23);

        jButton7.setText("Calificar persona");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(10, 90, 220, 23);

        jButton4.setText("Registro de categoria de Personas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(10, 120, 220, 23);

        jButton8.setText("Cerrar Sesión");
        jButton8.setMaximumSize(new java.awt.Dimension(135, 23));
        jButton8.setMinimumSize(new java.awt.Dimension(135, 23));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(10, 390, 120, 23);

        jButton9.setText("Registro de Categoría de Entes");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(10, 150, 220, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 280, 420);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrador"));
        jPanel2.setLayout(null);

        jButton3.setText("Registrar Persona");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(10, 30, 220, 23);

        jButton5.setText("Registro de entidades");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(10, 60, 220, 23);

        jButton6.setText("Registro de usuarios");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(10, 90, 220, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(320, 20, 280, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(registrar_Persona == null)   // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            registrar_Persona=new Registrar_Persona();
            registrar_Persona.setVisible(true);
        }
        else
        {
            registrar_Persona.show();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(registro_Denuncia == null)  // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            registro_Denuncia=new Registro_Denuncia();
            registro_Denuncia.setVisible(true);
        }
        else
        {
            registro_Denuncia.show();
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         new Visualizar_Denuncias().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(registrar_Categoria == null) // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            registrar_Categoria=new Registrar_Categoria();
            registrar_Categoria.setVisible(true);
        }
        else
        {
            registrar_Categoria.show();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(registrar_Entidad == null)       // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            registrar_Entidad=new Registrar_Entidad();
            registrar_Entidad.setVisible(true);
        }
        else
        {
            registrar_Entidad.show();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(registrar_Usuario == null && contrato== null)        // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            registrar_Usuario=new Registrar_Usuario(contrato);
            registrar_Usuario.setVisible(true);
        }
        else
        {
            if (registrar_Usuario != null)
            {
                registrar_Usuario.show();
            }
            else
                contrato.show();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calificar_Persona().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    // Botón Cerrar Sesión 
        
        if(registrar_Usuario!=null)registrar_Usuario.dispose();        
        if(registro_Denuncia!=null)registro_Denuncia.dispose();
        if(registrar_Categoria!=null)registrar_Categoria.dispose();
        if(registrar_Entidad!=null)registrar_Entidad.dispose();
        if(registrar_Persona!=null)registrar_Persona.dispose();
        if(contrato!=null)contrato.dispose();
        
        Login login = new Login();
        login.show();      // muestra la ventana de Login
        this.dispose();     // libera esta ventana de memoria
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCategoriaEmpresa().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void activarControles() // si es un usuario no deberia tener acceso a los controles administrativos
    {
        if(rol.equals("Usuario"))
        {
            this.jPanel2.setVisible(false);
        }
    }
}