package expresat;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

// Clase conexion - Se encargara de realizar la conexion con la base de datos de mySQL
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
    { //llamamos a la funcion para preparar nuestra Conexion de esta manera todo se ve mas ordenado
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

    public Connection getConexion() // Funcion que retorna la conexion
    {
        return conexion;
    }
    
    // Funcion booleana que retorna si un usuario ingreso correctamente: Contraseña y Rol a la hora
    // de loguearse al sistema
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
    
    // funcion de testeo de que realiza pruebas sobre el login
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
    
// Funcion que finaliza la conexion existente.
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

    // Funcion que cierra el querry de sql que se utilizo
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
    
    // Funcion booleana que registra un nuevo usuario tras tomar la contraseña, rol, nickname y nombre de la persona
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

     // Funcion booleana que registra una nueva persona 
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

     // Funcion booleana que registra una nueva entidad
    public boolean registrarEntidad(String nom, String Ced, String categoria, String Country, String prov,String can, String dis, String bar, String direccion)
    {
        try
        {   
            if(verificarEntidad(nom))
            {
                ResultSet r=stmt.executeQuery("call ins_Ente('"+nom+"','"+Ced+"','"+categoria+"','"+Country+"','"+prov+"','"+can+"','"+dis+"','"+bar+"','"+direccion+"');");
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;
    }
    

     // Funcion booleana que registra una nueva categoria para las personas
    public boolean registrarCategoriaPer(String nom)
        {   
            try
            {   
                if(verificaCategoriaPersona(nom))
                {
                    ResultSet r;
                    r = stmt.executeQuery("call ins_tipoPersona('"+nom+"');");
                    return true;
                }

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

            return false;
        }
    
         // Funcion booleana que registra una nueva categoria para los entes.
        public boolean registrarCategoriaEmpresa(String nom)
        {   
            try
            {   
                if(verificaCategoriaEmpresa(nom))
                {
                    ResultSet r;
                    r = stmt.executeQuery("call ins_categoria('"+nom+"');");
                    return true;
                }

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

            return false;
        }

   // Funcion booleana que verifica si existe ya una categoria que un usuario intenta crear.
    public boolean verificaCategoriaPersona(String nom)
        {
             try
            {   
                ResultSet r;
                r = stmt.executeQuery("call getTipoPersonas('"+nom+"');");
                
                r.next();
                if(r.getString("nombre")==null || r.getString("nombre").equals(""))
                {
                    return true;
                }
                else
                    return false;    
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

            return true;
        }

    // Funcion booleana que verifica la existencia de alguna categoria perteneciente a entes.
    public boolean verificaCategoriaEmpresa(String nom)
        {
             try
            {   
                ResultSet r;
                r = stmt.executeQuery("call retornarCategoria('"+nom+"');");

                r.next();

                if(r.getString("nombre")==null || r.getString("nombre").equals(""))
                {
                    return true;
                }
                else
                    return false;    
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

            return true;
        }

    // Funcion booleana que verifica la existencia de un usuario en la base de datos usando el nickname
    public boolean VerificarUsuario(String nick) 
    {
         try
        {   
            ResultSet r;
            r = stmt.executeQuery("call retornarUsuario('"+nick+"');");

            r.next();

            if(r.getString("Nick")==null || r.getString("Nick").equals(""))
            {
                return true;
            }
            else
                return false;    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return true;
    }
    
    // Funcion booleana que verifica la existencia de una nueva entidad en la base de datos usando el nombre.
    public boolean verificarEntidad(String nom)
    {
        try
        {   
            ResultSet r;
            r = stmt.executeQuery("call retornarEntidad('"+nom+"');");
            r.next();
                // Verificacion de una unica empresa con los datos obligatorios
            if((r.getString("Nombre")==null ))
            {
                return true;
            }    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return true;
        }

        return false;
    }
    
    // Arreglo que devuelve las personas sin cuenta que existen en la base de datos para presentarlas en un combobox
    public ArrayList<String> devolverListaPersonasSinCuenta()
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
    
    // Arreglo que devuelve las denuncias existentes hacia algun ente o persona
    public ArrayList<String> devolverListaDenuncias(String nom)
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarDenunciasUsuario('"+nom+"');");
            while(r.next())
            {
                lista.add(r.getString("nombrdenuncia")+"_"+r.getString("denuncia"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }
    
    // Arreglo que devuelve las personas registradas que existen en la base de datos
    public ArrayList<String> devolverListaPersonas()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarPersonasGEN();");
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
    
    // Arreglo que devuelve las entidades registradas que existen en la base de datos
    public ArrayList<String> devolverListaEntes()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarEntidadGEN();");
            while(r.next())
            {
                if(r.getString("cedulajur") != null && !r.getString("cedulajur").equals("")) // Condicional que verifica la existencia de una cedula juridica.
                {
                    lista.add(r.getString("Nombre")+"_"+r.getString("cedulajur"));
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
    
    public ArrayList<String> devolverListaEntesSinCedulaJuridica()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarEntidadGEN();");
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
    
    // Arreglo que devuelve las categorias para personas que existen en la base de datos
    public ArrayList<String> devolverListaTiposPersona()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call get_TipoPersonaGEN();");
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
    
    // Arreglo que devuelve las categorias para entidades que existen en la base de datos
    public ArrayList<String> devolverListaCat()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call getCategoriaGEN();");
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
    
    public String devolverDireccion(String ente)
    {    
        String direccion="";
        
        try
        {
            ResultSet r=stmt.executeQuery("call getDireccionGeneral('"+ente+"');");
            while(r.next())
            {
                direccion=r.getString("direcciongeneral");
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return "";
        }
               
        return direccion;
    }

    // Funcion que inserta una denuncia, en la base de datos, hacia alguna persona existente.
    void insertarDenunciaPersona(String nombre, String descripcion, String listaArchivos, String persona, String privacidad, int nota, String usuario) 
    {
        String cedula= persona.split("_")[persona.split("_").length-1];
        String lista[]=listaArchivos.split("\n");
        
        try
        {
            ResultSet r=stmt.executeQuery("call InsertarDenunciaPersona('"+descripcion+"','"+privacidad+"','"+nombre+"','"+cedula+"',"+nota+",'"+usuario+"');");
            
            for (int i = 0; i < lista.length; i++)
            {
                r=stmt.executeQuery("call agregararchivoDenuncia('"+lista[i]+"','"+nombre+"');");
            }
            JOptionPane.showMessageDialog(null, "Denuncia Realizada Con Exito");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al iinsertar denuncia");
        }
    }
    
    // Funcion que "borra" (esconde) una denuncia de la vista de los usuarios y elimina la calificacion del promedio.
    void desactivardenuncia(String nombre)
    {
        try
        {
            ResultSet r=stmt.executeQuery("call desactivardenuncia('"+nombre+"');");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar denuncia");
        }
    }
    
    // Funcion que permite modificar el texto de una denuncia existente
    void actualizarDenuncia(String nombre, String texto)
    {
        try
        {
            ResultSet r=stmt.executeQuery("call actualizardenuncia('"+nombre+"','"+texto+"');");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar denuncia");
        }
    }
    
    // Funcion que inserta una denuncia, en la base de datos, hacia alguna entidad existente.
    void insertarDenunciaEnte(String nombre, String descripcion, String listaArchivos, String ente, String privacidad, int nota, String usuario) 
    {
        String nombreEnte= ente.split("_")[0];
        String lista[]=listaArchivos.split("\n");
        
        try
        {
            ResultSet r=stmt.executeQuery("call InsertarDenunciaEnte('"+descripcion+"','"+privacidad+"','"+nombre+"','"+nombreEnte+"',"+nota+",'"+usuario+"');");
            
            for (int i = 0; i < lista.length; i++)
            {
                r=stmt.executeQuery("call agregararchivoDenuncia('"+lista[i]+"','"+nombre+"');");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al iinsertar denuncia");
        }
    }

    // Funcion que Verifica la existencia de una persona en la base de datos.
    boolean verificarPersona(String datosPersona) 
    {
        try
        {   
            ResultSet r;
            r = stmt.executeQuery("call retornarPersona('"+datosPersona.split("_")[datosPersona.split("_").length-1]+"');");
            r.next();
                // Verificacion de una unica persona con su numero de cedula
            if((r.getString("Nombre")==null ))
            {
                return false;
            }
            else
                return true;    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;
    }
    
    //Funcion que permite actualizar la informacion de usuario (nick & pass)
    boolean actualizarUsuario(String nuevoNick, String pass, String viejoNick) 
    {
        try
        {
            ResultSet r=stmt.executeQuery("call actualizarUsuario('"+nuevoNick+"','"+pass+"','"+viejoNick+"');");
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;
    }

    //Funcion que permite reportar algun usuario (el usuario se bloqueara al alcanzar una cantidad parametrizable de reportes
    void insertarReporteUsuario(String texto, String usuarioAcusado) 
    {        
        try
        {
            ResultSet r=stmt.executeQuery("call InsertarReporte('"+texto+"','"+usuarioAcusado+"');");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar reporte");
        }
    }
      
// Arreglo que retorna la lista de usuarios existentes.
    ArrayList<String> devolverListaUsuarios() 
    {
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call getusers('"+usuario+"');");
            while(r.next())
            {
                lista.add(r.getString("nick"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }

    // Arreglo que retorna todos los reportes realizados hacia un usuario
    ArrayList<String> getreportes(String nick) 
    {
        ArrayList<String> lista= new ArrayList();
        System.out.println(nick);
        
        try
        {
            ResultSet s=stmt.executeQuery("call get_reporte('"+nick+"');");
            
            while(s.next())
            {
                lista.add(s.getString("razon"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getSuppressed());
        }
        
        return lista;
    }
    
// Arreglo que contiene todas las denuncias realizadas
    ArrayList<String> getDenuncias(String rol) 
    {
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call getallDenuncias('"+rol+"');");
            while(r.next())
            {
                lista.add(r.getString("nombrdenuncia")+"_"+r.getString("denuncia"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }
    
    // arreglo con todas las calificaciones de una persona, obtenidas por medio de la cedula.
    ArrayList<String> calificacionesPersona(String ced) 
    {
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call getcalificacionPersonas('"+ced+"');");
            while(r.next())
            {
                lista.add(r.getString("calificacion"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }
  
    // arreglo con todas las calificaciones de una Entidad, obtenidas por medio de su nombre.
    ArrayList<String> calificacionesEnte(String nom) 
    {
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call getcalificacionEntes('"+nom+"');");
            while(r.next())
            {
                lista.add(r.getString("calificacion"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }

    String devolverPais(String ente) 
    {
        String pais="";
        
        try
        {
            ResultSet r=stmt.executeQuery("call getPais('"+ente+"');");
            while(r.next())
            {
                pais=r.getString("nombre");
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return "";
        }
               
        return pais;
    }

    String devolverProvincia(String ente) 
    {
        String provincia="";
        
        try
        {
            ResultSet r=stmt.executeQuery("call getProvincia('"+ente+"');");
            while(r.next())
            {
                provincia=r.getString("nombre");
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return "";
        }
               
        return provincia;
    }

    String devolverCanton(String ente) 
    {
        String canton="";
        
        try
        {
            ResultSet r=stmt.executeQuery("call getcanton('"+ente+"');");
            while(r.next())
            {
                canton=r.getString("nombre");
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return "";
        }
               
        return canton;
    }

    String devolverDistrito(String ente) 
    {
        String distrito="";
        
        try
        {
            ResultSet r=stmt.executeQuery("call getdistrito('"+ente+"');");
            while(r.next())
            {
                distrito=r.getString("nombre");
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return "";
        }
               
        return distrito;
    }

    String devolverBarrio(String ente) 
    {
        String barrio="";
        
        try
        {
            ResultSet r=stmt.executeQuery("call getbarrio('"+ente+"');");
            while(r.next())
            {
                barrio=r.getString("nombre");
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return "";
        }
               
        return barrio;
    }

    void setCantidadDenunciasBloqueo(int cantidad) 
    {
        try
        {
            ResultSet r=stmt.executeQuery("call InsertarLimiteReporte('"+cantidad+"');");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    void introducirLugarTrabajo(String lugar) {
        try
        {
            ResultSet r=stmt.executeQuery("call InsertarLimiteReporte('"+lugar+"');"); // WTF??
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    // arreglo con todas las calificaciones de una Entidad, obtenidas por medio de su nombre.
    ArrayList<String> devolverPersonasCed() 
    {
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call get_personaCed();");
            while(r.next())
            {
                lista.add(r.getString("Apellido1")+" "+r.getString("Apellido2")+" "+r.getString("Nombre")+" "+r.getString("Cedula"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }

    ArrayList<String> devolverPersonasNom() {
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call get_personaNom();");
            while(r.next())
            {
                lista.add(r.getString("Apellido1")+" "+r.getString("Apellido2")+" "+r.getString("Nombre")+" "+r.getString("Cedula"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }

    ArrayList<String> devolverPersonasApe() {
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call get_personaApe();");
            while(r.next())
            {
                lista.add(r.getString("Apellido1")+" "+r.getString("Apellido2")+" "+r.getString("Nombre")+" "+r.getString("Cedula"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }

    ArrayList<String> devolverEntesCed() {
         ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call get_enteCed();");
            while(r.next())
            {
                if(r.getString("CedulaJur")!=null)
                {
                    lista.add(r.getString("Nombre")+" "+r.getString("CedulaJur"));
                }
                else
                {
                    lista.add(r.getString("Nombre"));
                }
                
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }

    ArrayList<String> devolverEntesNom() {
         ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call get_EnteNom();");
            while(r.next())
            {
                if(r.getString("CedulaJur")!=null)
                {
                    lista.add(r.getString("Nombre")+" "+r.getString("CedulaJur"));
                }
                else
                {
                    lista.add(r.getString("Nombre"));
                }
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