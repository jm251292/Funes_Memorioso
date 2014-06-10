package expresat;

import java.util.ArrayList;

public class prueba2 
{
    Conexion c;
    ArrayList<String> a;
    
    public prueba2() 
    {
        c= new Conexion();
        a= new ArrayList();
        a=c.getreportes("admin");
        System.out.println(a);
    }   
}