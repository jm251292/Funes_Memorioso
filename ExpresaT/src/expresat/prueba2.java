package expresat;

import java.util.ArrayList;

public class prueba2 
{
    String persona= "eee_rrrr_iii";
    
    public prueba2() 
    {
        String cedula= persona.split("_")[persona.split("_").length-1];
        System.out.println(cedula);
    }   
}