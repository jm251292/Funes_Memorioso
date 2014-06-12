package expresat;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class visualizarPersonas extends javax.swing.JFrame 
{
    Conexion conexion;
    JPanel info;
    int mayor=0;                             // para guardar la calificacion mas usada
    float promedio=0;                          // para guardar la calificacion promedio
    JProgressBar barra1, barra2, barra3, barra4, barra5, barra6, barra7, barra8, barra9, barra10;
    JLabel letrero1, letrero2, letrero3, letrero4, letrero5, letrero6, letrero7, letrero8, letrero9, letrero10, ratingGeneral;
    ArrayList<String> listaVotaciones;       //votos son cuanta cantidad de votos hay de n estrellas igual a la posicion en el array, mientras que lista de votaciones son los votos totales
    ArrayList<Integer> votos;
    
    public visualizarPersonas() 
    {
        initComponents();
        construcciones();                       // método que construye los objetos
        add(info);                              // añade panel artificial que se activa por mouse
        info.setVisible(false);                 // lo hace invisible porque no ha pasado el mouse por encima del label
        llenarComboBoxPersonas();                  // llena el combo box con los entes para escoger
        this.setSize(1000, 600);                // asigna tamaño a la ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Persona a consultar:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 20, 100, 14);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(170, 20, 210, 20);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información"));
        jPanel1.setLayout(null);

        jLabel3.setText("Lugar de trabajo:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(16, 27, 338, 14);

        jLabel4.setText("Roles sociales:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(16, 47, 338, 14);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 70, 370, 120);
        jPanel1.getAccessibleContext().setAccessibleName("Direccion");

        jLabel2.setText("Persona");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MuestraRating(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2DesapareceRating(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(420, 24, 210, 20);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(670, 20, 120, 23);

        jLabel8.setText("Votos:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(660, 60, 80, 14);

        jProgressBar1.setMaximum(10);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(420, 60, 220, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        getCalculoVotaciones();                         // calcula las votaciones
        jLabel2.setText(String.valueOf(jComboBox1.getSelectedItem()));
        String infopersona=String.valueOf(jComboBox1.getSelectedItem());
        String [] cedula;
        cedula = infopersona.split("_");
        conexion.preparardb();
        jLabel3.setText("Lugar de trabajo: "+conexion.devolverLugarTrabajo(cedula[2]));
        jLabel4.setText("Roles sociales: "+conexion.devolverRolesSociales(cedula[2]));
        conexion.destruir();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel2MuestraRating(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MuestraRating
        info.setBounds(420, 90, 500, 500);              // handler que se actuva cuando el mouse pasa por encima del nombre
        info.setVisible(true);                          // lo muestra
    }//GEN-LAST:event_jLabel2MuestraRating

    private void jLabel2DesapareceRating(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2DesapareceRating
        info.setVisible(false);                         // desaparece el panel artificial
    }//GEN-LAST:event_jLabel2DesapareceRating

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
    
    private void llenarComboBoxPersonas()       // método que accede a la base de datos para rellenar con personas registradas y que no han sido relacionadas a una cuenta
    {
        ArrayList<String> lista= new ArrayList();       // lista con los nombres para añadir al comboBox
        conexion.preparardb();
        lista= conexion.devolverListaPersonas();           // llena el combo box
        
        for (int i = 0; i < lista.size(); i++)          // ciclo que agraga uno a uno a las personas
        {
            this.jComboBox1.addItem(lista.get(i));
        }
        
        conexion.destruir();
    }

    private void construcciones() 
    {
        listaVotaciones= new ArrayList();       // vector para guardar las votaciones
        votos= new ArrayList();                 // vector que tiene las repeticiones de las calificaciones
        votos.add(0);                           // crea en él 10 campos que son las 10 únicas calificaciones posibles
        votos.add(0);
        votos.add(0);
        votos.add(0);
        votos.add(0);
        votos.add(0);
        votos.add(0);
        votos.add(0);
        votos.add(0);
        votos.add(0);
        conexion= new Conexion();               // variable de conexion a la base de datos
        info= new JPanel();                     // crea panel artificial (no los que crea el plugin de NetBeans)
        info.setLayout(null);                   // anula despliegue para que el método setBounds sea ejecutado
        barra1= new JProgressBar();             // crea barras de calificación
        barra2= new JProgressBar();
        barra3= new JProgressBar();
        barra4= new JProgressBar();
        barra5= new JProgressBar();
        barra6= new JProgressBar();
        barra7= new JProgressBar();
        barra8= new JProgressBar();
        barra9= new JProgressBar();
        barra10= new JProgressBar();
        ratingGeneral= new JLabel();            // etiqueta que muestra el primedio
        letrero1= new JLabel();                 // crea las etiquetas que anuncian las calificaciones
        letrero2= new JLabel();
        letrero3= new JLabel();
        letrero4= new JLabel();
        letrero5= new JLabel();
        letrero6= new JLabel();
        letrero7= new JLabel();
        letrero8= new JLabel();
        letrero9= new JLabel();
        letrero10= new JLabel();
        info.add(barra1);                       // añade las barras al panel artificial
        info.add(barra2);
        info.add(barra3);
        info.add(barra4);
        info.add(barra5);
        info.add(barra6);
        info.add(barra7);
        info.add(barra8);
        info.add(barra9);
        info.add(barra10);
        info.add(letrero1);                     // añade las etiquetas al panel
        info.add(letrero2);
        info.add(letrero3);
        info.add(letrero4);
        info.add(letrero5);
        info.add(letrero6);
        info.add(letrero7);
        info.add(letrero8);
        info.add(letrero9);
        info.add(letrero10);
        info.add(ratingGeneral); 
        ratingGeneral.setBounds(10, 10, 100, 100);      // posiciona los elementos en el panel artificial
        ratingGeneral.setFont(new Font("Tahoma",Font.PLAIN,30));
        barra1.setBounds(200, 10, 100, 20);
        barra2.setBounds(200, 30, 100, 20);
        barra3.setBounds(200, 50, 100, 20);
        barra4.setBounds(200, 70, 100, 20);
        barra5.setBounds(200, 90, 100, 20);
        barra6.setBounds(200, 110, 100, 20);
        barra7.setBounds(200, 130, 100, 20);
        barra8.setBounds(200, 150, 100, 20);
        barra9.setBounds(200, 170, 100, 20);
        barra10.setBounds(200, 190, 100, 20);
        barra10.setBounds(200, 190, 100, 20);
        letrero1.setBounds(100, 10, 100, 20);
        letrero2.setBounds(100, 30, 100, 20);
        letrero3.setBounds(100, 50, 100, 20);
        letrero4.setBounds(100, 70, 100, 20);
        letrero5.setBounds(100, 90, 100, 20);
        letrero6.setBounds(100, 110, 100, 20);
        letrero7.setBounds(100, 130, 100, 20);
        letrero8.setBounds(100, 150, 100, 20);
        letrero9.setBounds(100, 170, 100, 20);
        letrero10.setBounds(100, 190, 100, 20);
    }

    private void getCalculoVotaciones() 
    {
        promedio=0;                                 // reinicia los valores para no hacer informacion errónea
        conexion.preparardb();
        String infopersona=String.valueOf(jComboBox1.getSelectedItem());
        String [] cedula;
        cedula = infopersona.split("_");
        listaVotaciones= conexion.calificacionesPersona(cedula[2]); // obtiene calificaciones según lo seleccionado en el combobox
        conexion.destruir(); 
        votos.set(0, 0);                            // reinicia los valores para no hacer informacion errónea
        votos.set(1, 0);
        votos.set(2, 0);
        votos.set(3, 0);
        votos.set(4, 0);
        votos.set(5, 0);
        votos.set(6, 0);
        votos.set(7, 0);
        votos.set(8, 0);
        votos.set(9, 0);
        
        for (int i = 0; i < listaVotaciones.size(); i++)    // ciclo que suma las repeticiones de votos de i estrellas sobre votos, el array de 10 posiciones
        {
            votos.set(Integer.parseInt(listaVotaciones.get(i))-1, votos.get(Integer.parseInt(listaVotaciones.get(i))-1)+1);
            promedio+=Integer.parseInt(listaVotaciones.get(i));
        }
        
        promedio/=listaVotaciones.size();                   // termina de calcular el promedio
        
        for (int i = 0; i < listaVotaciones.size(); i++) 
        {
        }
        
        for (int i = 0; i < votos.size(); i++)              // ciclo que captura la calificacion mas usada
        {
            if (votos.get(i)>mayor) 
            {
                mayor=votos.get(i);
            }
        }
        
        barra1.setMaximum(mayor);                           // asigna a todos que su maximo valor posible
        barra2.setMaximum(mayor);
        barra3.setMaximum(mayor);
        barra4.setMaximum(mayor);
        barra5.setMaximum(mayor);
        barra6.setMaximum(mayor);
        barra7.setMaximum(mayor);
        barra8.setMaximum(mayor);
        barra9.setMaximum(mayor);
        barra10.setMaximum(mayor);
        
        barra1.setValue(votos.get(0));                           // asigna el valor de la barra sagun la repeticion de la calificacion
        barra2.setValue(votos.get(1));
        barra3.setValue(votos.get(2));
        barra4.setValue(votos.get(3));
        barra5.setValue(votos.get(4));
        barra6.setValue(votos.get(5));
        barra7.setValue(votos.get(6));
        barra8.setValue(votos.get(7));
        barra9.setValue(votos.get(8));
        barra10.setValue(votos.get(9));
        
        letrero1.setText("1 estrella ("+votos.get(0)+")");      // asigna el texto a las etiquetas que titulan las barras con su respectivo numero de repeticiones de la calificacion
        letrero2.setText("2 estrellas ("+votos.get(1)+")");
        letrero3.setText("3 estrellas ("+votos.get(2)+")");
        letrero4.setText("4 estrellas ("+votos.get(3)+")");
        letrero5.setText("5 estrellas ("+votos.get(4)+")");
        letrero6.setText("6 estrellas ("+votos.get(5)+")");
        letrero7.setText("7 estrellas ("+votos.get(6)+")");
        letrero8.setText("8 estrellas ("+votos.get(7)+")");
        letrero9.setText("9 estrellas ("+votos.get(8)+")");
        letrero10.setText("10 estrellas ("+votos.get(9)+")");
        ratingGeneral.setText(""+promedio);                     // refresca label de promedio general
        jLabel8.setText("Votos: "+listaVotaciones.size());      // refresca el numero de calificaciones que tiene
        jProgressBar1.setValue(Math.round(promedio));           // actualiza la barra de promedio general
    }
}
