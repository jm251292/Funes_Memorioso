package expresat;

import javax.swing.JOptionPane;

public class PaginaPrincipal extends javax.swing.JFrame 
{
    String usuario;     // variable que guarda el usuario que se logueó
    String rol;         // rol del usuario que se logueó
    Registrar_Usuario registrar_Usuario;        // instancias de las diferentes ventana para que no se abran mas de una vez
    Registro_Denuncia_Persona registro_Denuncia_Persona;
    Registro_Denuncia_Ente registro_Denuncia_Ente;
    reportar_Usuario reportar_Usuario;
    VisualizarEntes visualizarEntes;
    Registrar_Categoria registrar_Categoria;
    Borrar_Denuncia borrar_Denuncia;
    Visualizar_Denuncias visualizar_Denuncias;
    Registrar_Entidad registrar_Entidad;
    RegistrarCategoriaEmpresa registrarCategoriaEmpresa;
    Home perfil;
    visualizarPersonas visualizarPersonas; 
    Registrar_Persona registrar_Persona;
    Contrato contrato;
    Conexion conexion;
    
    public PaginaPrincipal(String user, String rol) 
    {
        initComponents();
        setUsuario(user);       // métodos getter y setter necesarios
        setRol(rol);
        
        activarControles();
        conexion= new Conexion();
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
        jButton9 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));
        jPanel1.setLayout(null);

        jButton1.setText("Denunciar una persona");
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

        jButton7.setText("Denunciar un ente");
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

        jButton9.setText("Registro de Categoría de Entes");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(10, 150, 220, 23);

        jButton13.setText("Modificar Perfil");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13);
        jButton13.setBounds(10, 179, 220, 23);

        jButton10.setText("Borrar o editar denuncia ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(10, 210, 220, 23);

        jButton11.setText("Reportar usuario");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(10, 240, 220, 23);

        jButton15.setText("Ver ente");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15);
        jButton15.setBounds(10, 270, 220, 23);

        jButton17.setText("Ver todas las Personas");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17);
        jButton17.setBounds(10, 300, 220, 23);

        jButton18.setText("Ver Persona");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18);
        jButton18.setBounds(10, 330, 220, 23);

        jButton19.setText("Ver todos los entes");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton19);
        jButton19.setBounds(10, 360, 220, 23);

        jButton16.setText("Introducir lugar laboral");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16);
        jButton16.setBounds(10, 390, 220, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 280, 480);

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

        jButton12.setText("Cantidad de Reportes para bloquear");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12);
        jButton12.setBounds(10, 120, 220, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(320, 20, 280, 420);

        jButton8.setText("Cerrar Sesión");
        jButton8.setMaximumSize(new java.awt.Dimension(135, 23));
        jButton8.setMinimumSize(new java.awt.Dimension(135, 23));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(620, 510, 120, 23);

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
        if(registro_Denuncia_Persona == null)  // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            registro_Denuncia_Persona=new Registro_Denuncia_Persona(usuario);
            registro_Denuncia_Persona.setVisible(true);
        }
        else
        {
            registro_Denuncia_Persona.show();
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(visualizar_Denuncias == null)  // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            visualizar_Denuncias=new Visualizar_Denuncias(usuario);
            visualizar_Denuncias.setVisible(true);
        }
        else
        {
            visualizar_Denuncias.show();
        }        
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
        if(registro_Denuncia_Ente == null)  // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            registro_Denuncia_Ente=new Registro_Denuncia_Ente(usuario);
            registro_Denuncia_Ente.setVisible(true);
        }
        else
        {
            registro_Denuncia_Ente.show();
        } 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    // Botón Cerrar Sesión 
        
        if(registrar_Usuario!=null)registrar_Usuario.dispose();        
        if(registro_Denuncia_Persona!=null)registro_Denuncia_Persona.dispose();
        if(registro_Denuncia_Ente!=null)registro_Denuncia_Ente.dispose();
        if(registrar_Categoria!=null)registrar_Categoria.dispose();
        if(borrar_Denuncia!=null)borrar_Denuncia.dispose();
        if(visualizar_Denuncias!=null)visualizar_Denuncias.dispose();
        if(registrarCategoriaEmpresa!=null)registrarCategoriaEmpresa.dispose();
        if(registrar_Entidad!=null)registrar_Entidad.dispose();
        if(registrar_Persona!=null)registrar_Persona.dispose();
        if(contrato!=null)contrato.dispose();
        if(reportar_Usuario!=null)reportar_Usuario.dispose();
        if(visualizarEntes!=null)visualizarEntes.dispose();
        if(visualizarPersonas!=null)visualizarPersonas.dispose();
        if(perfil!=null)perfil.dispose();
        
        
        Login login = new Login();
        login.show();      // muestra la ventana de Login
        this.dispose();     // libera esta ventana de memoria
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(registrarCategoriaEmpresa == null)  // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            registrarCategoriaEmpresa=new RegistrarCategoriaEmpresa();
            registrarCategoriaEmpresa.setVisible(true);
        }
        else
        {
            registrarCategoriaEmpresa.show();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(borrar_Denuncia == null)  // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            borrar_Denuncia=new Borrar_Denuncia(this.usuario);
            borrar_Denuncia.setVisible(true);
        }
        else
        {
            borrar_Denuncia.show();
        } 
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try
        {
            int cantidad= Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de reportes que debe cumplir un usuario para ser bloqueado"));
            conexion.preparardb();
            conexion.setCantidadDenunciasBloqueo(cantidad);
            conexion.destruir();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "El parametro introducido no es correcto");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if(perfil == null)       // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            perfil=new Home(this.usuario);
            perfil.setVisible(true);
        }
        else
        {
            perfil.show();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(reportar_Usuario == null)       // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            reportar_Usuario=new reportar_Usuario(this.usuario);
            reportar_Usuario.setVisible(true);
        }
        else
        {
            reportar_Usuario.show();
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if(visualizarEntes == null)       // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            visualizarEntes=new VisualizarEntes();
            visualizarEntes.setVisible(true);
        }
        else
        {
            visualizarEntes.show();
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try
        {
            String lugar= JOptionPane.showInputDialog("Digite el nuevo lugar de trabajo");
            conexion.preparardb();
            conexion.introducirLugarTrabajo(lugar);
            conexion.destruir();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "El parametro introducido no es correcto");
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPersona().setVisible(true);
            }
        });        
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarEnte().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if(visualizarPersonas == null)       // si no se ha creado una ventana, entonces la crea si no muestra la que ya se instanció
        {
            visualizarPersonas=new visualizarPersonas();
            visualizarPersonas.setVisible(true);
        }
        else
        {
            visualizarPersonas.show();
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
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