package expresat;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Conexion 
{
    private Connection conexion;
    static String bd="ExpresaT";
    static String user="root";
    static String password="root";
    Statement stmt = null;
    ResultSet rs = null;
    DefaultTableModel m;
    String url = "jdbc:mysql://localhost:3306/test"; 
    String usuario = "user"; 
    Connection con = null; 
    
    public void preparardb()
    { //llamamos a la funcion para preparar nuestra Conexion
        try
        {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            if ( con != null )
            System.out.println("Se ha establecido una conexión a la base de datos : " + url );
            stmt = (Statement) con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Error en preparardb");
        }
    }

    public Connection getConexion()
    {
        return conexion;
    }
    
    public boolean autenticar(String usuario, String pass, String rol)
    {
        try
        {
            ResultSet r=stmt.executeQuery("call login('"+usuario+"','"+pass+"','"+rol+"');");
            r.next();
            
            if (!(r.getString("count(*)").equals("0")))
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    public void prueba()
    {
        try
        {
            ResultSet r=stmt.executeQuery("call proyeccion;");
            String fila[]=new String[4];
            while(r.next())
            {
                fila[0]=r.getString("nick");
                fila[1]=r.getString("contraseña");
                fila[2]=r.getString("rol");
                fila[3]=r.getString("bloqueado");
                System.out.println(fila[0]+" "+fila[1]+" "+fila[2]+" "+fila[3]+"\n");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    

    public void cerrar(ResultSet rs)
    {
        if(rs !=null)
        {
            try
            {
                rs.close();
            }
            catch(Exception e)
            {
                System.out.print("No es posible cerrar la Conexion");
            }
        }
    }

    public void cerrar(java.sql.Statement stmt)
    {
        if(stmt !=null)
        {
            try
            {
                stmt.close();
            }
            catch(Exception e){}
        }
    }

    public void destruir()
    {
        if(conexion !=null){

        try{
        conexion.close();
        }
        catch(Exception e){}
        }
    }

public boolean registrarUsuario(String nick, String pass, String rol, String persona) 
    {
        String cedula= persona.split("_")[persona.split("_").length-1]; // obtenemos la cedula de la persona ya que viene en el siguiente formato "apellido1_nombre_cedula"
        
        try
        {
            ResultSet r=stmt.executeQuery("call registrarUsuarios('"+nick+"','"+pass+"','"+rol+"','"+cedula+"');");
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return false;
    }

public boolean registrarPersona(String nom, String ape1, String ape2, String Ced, String Gen, String fecha,String nombretipopersona)
    {
        try
        {
            ResultSet r=stmt.executeQuery("call ins_Persona('"+nom+"','"+ape1+"','"+ape2+"','"+Ced+"','"+Gen+"','"+fecha+"','"+nombretipopersona+"');");
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    public ArrayList<String> devolverListaPersonas()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarPersonasSinCuenta();");
            while(r.next())
            {
                lista.add(r.getString("apellido1")+"_"+r.getString("nombre")+"_"+r.getString("cedula"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }
    
    public ArrayList<String> devolverListaEntes()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarEntidad();");
            while(r.next())
            {
                if(r.getString("cedula") != null) // Condicional que verifica la existencia de una cedula juridica.
                {
                lista.add(r.getString("Nombre")+"_"+r.getString("cedula"));
                }
                else {lista.add(r.getString("Nombre"));}
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }
    
    public ArrayList<String> devolverListaTiposPersona()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarTipoPersona();");
            while(r.next())
            {
                lista.add(r.getString("Nombre"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }

}