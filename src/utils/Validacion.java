package utils;

public class Validacion {
    
    public static boolean validarDatos(String... datos){

        for (String dato : datos) {
            if(dato.isEmpty()){
                return false;
            }
        }
        return true;
    }
}