package expresat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Visualizar_Denuncias extends javax.swing.JFrame 
{
    Conexion conexion;
    
    public Visualizar_Denuncias(String rol) 
    {
        conexion= new Conexion();
        initComponents();
        LlenarDenuncias(rol);
        this.setSize(1000, 600);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(800, 350, 100, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables

    private void LlenarDenuncias(String rol) 
    {
        ArrayList<String> lista= new ArrayList();           // lista de denuncias
        JPanel pan = new JPanel();                          // panel a introducir al jscroll
        int tamañopanel=0;                                  // dependiendo de la cantidad de denuncias introducidas, así será el tamaño del scroll
        pan.setLayout(null);
        conexion.preparardb();      
        lista= conexion.getDenuncias(rol);                  // obtiene denuncias de la base de datos
        JPanel reporte;                                     // panel de contenido de la nota
        JScrollPane texto;                                  // si el panel es muy grande el scroll permitirá verlo por completo
        
        for (int i = 0; i < lista.size(); i++)              //ciclo que introduce cada denuncia
        {
            reporte = new JPanel();
            reporte.setAutoscrolls(true);
            reporte.setBounds(10, i*100, 500, 400);         // da tamaño a la denuncia
            reporte.setPreferredSize(new Dimension(lista.get(i).length()*6+100,  200));
            reporte.add(new JTextArea(lista.get(i).split("_")[0]+"\n"+lista.get(i).split("_")[1]+"\n \n Editado por:"+lista.get(i).split("_")[2]));
            reporte.setBackground(Color.white);
            texto= new JScrollPane(reporte);
            pan.add(texto);
            texto.setBounds(10, i*201, 500, 200);
            tamañopanel=i+1;
        }
        
        pan.setPreferredSize(new Dimension(800,  tamañopanel*201));     // programacion del scroll
        JScrollPane panel1 = new JScrollPane();
        panel1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        panel1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel1.setViewportView(pan);
        panel1.setBounds(0, 0, 800, 600);                               // construccion en el jframe
        getContentPane().add(panel1);
        pack();
    }
}