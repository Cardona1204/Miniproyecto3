package models;
import java.util.ArrayList;

public class Candidato extends Ciudadano {
    
    private Orientacion orientacion;
    private Partido partido;
    private ArrayList<Propuesta> promesas;  
    private int votos;
    
    public Candidato(String nombre, String cedula, Ciudades ciudad, Orientacion orientacion, Partido partido, ArrayList<Propuesta> promesas) {
        super(nombre, cedula, ciudad);
        this.orientacion = orientacion;
        this.partido = partido;
        this.promesas = promesas;
        this.votos =0;
    }

    public Candidato(String nombre, String cedula, Ciudades ciudad, Orientacion orientacion, Partido partido) {
        super(nombre, cedula, ciudad);
        this.orientacion = orientacion;
        this.partido = partido;
        this.promesas = new ArrayList<>();
        this.votos =0;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public ArrayList<Propuesta> getPromesas() {
        return promesas;
    }

    public void setPromesas(ArrayList<Propuesta> promesas) {
        this.promesas = promesas;
    }
    public boolean addPromesa(Propuesta promesa) {
      return  promesas.add(promesa);
    }

    public boolean eliminarPropuesta(Propuesta promesa) {
        return promesas.remove(promesa);
    }

    public boolean eliminarPropuesta(String titulo) {
        for (int i = 0; i < promesas.size(); i++) {
            if (promesas.get(i).getTitulo().equals(titulo)) {
                promesas.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarPromesa(Propuesta promesa, Propuesta nuevaPromesa) {
        for (int i = 0; i < promesas.size(); i++) {
            if (promesas.get(i).getTitulo().equals(promesa.getTitulo())) {
                promesas.set(i, nuevaPromesa);
                return true;
            }
        }
        return false;
    }


    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getVotos(){
        return votos;
    }


    @Override
    public String toString() {
      
        return "Nombre: " + super.getNombre() + " Cedula: " + super.getCedula() + " Ciudad: " + super.getCiudad() + " Orientacion: " + orientacion ;
    }

}
