package views;

import java.util.Scanner;
import controller.Actions;
import controller.Controller;
import models.Candidato;
import models.Ciudades;
import models.Orientacion;
import models.Partido;
import models.Propuesta;

public class ViewConsola implements View {
    private Controller controller;
    private Candidato candidato;
    private Candidato updateCandidato;
    private boolean elegirCandidato;

    Scanner scanner;

    public ViewConsola() {
        scanner = new Scanner(System.in);
        elegirCandidato = false;
    }
   
    void menu() {
        int opcion = 0;
        while (true) {
            try {
                    System.out.println("----------Menu-----------\n");
                    System.out.println("Candidato elegido: " + (candidato == null ? "Ninguno" : candidato) + "\n");
                    System.out.println("0. Elegir candidato");
                    System.out.println("1. Insertar candidato");
                    System.out.println("2. Actualizar cadidato");
                    System.out.println("3. Eliminar candidato");
                    System.out.println("4. Buscar candidato");
                    System.out.println("5. Listar candidatos");
                    System.out.println("6. Candidato ganador");
                    System.out.println("7. Partido con más candidatos");
                    System.out.println("8. Ciudad con menos candidatos");
                    System.out.println("9. Propuestas ganador");
                    System.out.println("10. Acerca de");
                    System.out.println("11. Ayuda");
                    System.out.println("12. Salir");
                    System.out.println("Eliga una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 0:
                    elegirCandidato = true;
                    controller.setAction(Actions.LIST);
                    break;
                case 1:
                    insertarCandidato(false);
                    break;
                case 2:
                    updateCandidato = candidato;
                    insertarCandidato(true);
                    break;
                case 3:
                    controller.setAction(Actions.DELETE);
                    break;
                case 4:
                    controller.setAction(Actions.SEARCH);
                    break;
                case 5:
                    controller.setAction(Actions.LIST);
                    break;
                case 6:
                    controller.setAction(Actions.WINNER);
                    break;
                case 7:
                    controller.setAction(Actions.PARTY_WITH_CANDIDATES);
                    break;
                case 8:
                    controller.setAction(Actions.CITY_WITH_LESS_CANDIDATES);
                    break;
                case 9:
                    controller.setAction(Actions.WINNER_PROPOSALS);
                    break;
                case 10:
                    controller.setAction(Actions.ABOUT);
                    break;
                case 11:
                    controller.setAction(Actions.HELP);
                    break;
                case 12:
                    controller.setAction(Actions.EXIT);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            controller.actionPerformed(null);
            } catch (Exception e) {
                System.out.println(e);
            }
         
        }
       
    }
    @Override
    public void listCandidato(Candidato[] candidatos){
        System.out.println("----------Candidatos-----------\n");
        if(!elegirCandidato){
            for(Candidato candidato : candidatos){
                System.out.println(candidato);
            }
            return;
        }
        int opcion = 0;
        while(opcion != candidatos.length){
            for(int i = 0; i < candidatos.length; i++){
                System.out.println((i+1) + ". " + candidatos[i]);
            }
            System.out.println("Eliga una opción: ");
            opcion = scanner.nextInt();
            candidato = candidatos[opcion-1];
            elegirCandidato = false;
            return;
        }
       
    }

    public void agregarPropuestas(Candidato candidato){
        String[] opciones = {
            "Agregar Propuesta",
            "Eliminar Propuesta",
            "Listar Propuestas",
            "Volver"
        };
        String titulo = "";
        String descripcion = "";
        int opcion = 0;
        while(opcion != 4){
            for(int i = 0; i < opciones.length; i++){
                System.out.println((i+1) + ". " + opciones[i]);
            }
            System.out.println("Eliga una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    titulo = inputDialogo("Titulo: ");
                    descripcion = inputDialogo("Descripcion: ");
                    candidato.addPromesa(new Propuesta(titulo, descripcion));
                    break;
                case 2:
                    titulo = inputDialogo("Titulo: ");
                    String mensaje = candidato.eliminarPropuesta(titulo) ? "Propuesta eliminada" : "Propuesta no encontrada";
                    messageInfo(mensaje);
                    break;
                case 3:
                    for(Propuesta propuesta : candidato.getPromesas()){
                        System.out.println(propuesta);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public void insertarCandidato(boolean isUpdate) {
        Candidato candidato;
        String[] opciones = {
            "Nombre",
            "Cedula",
            "Partido",
            "Ciudad",
            "Orientación",
            "Propuesta",
            "Votos",
            !isUpdate ? "Guardar" : "Actualizar",
            "Volver"
        };
        int opcion = 0;
        if(!isUpdate){
            candidato = this.candidato != null ? this.candidato :new Candidato("", "", null, null, null);

        }else candidato = updateCandidato;
        while(opcion != 9){
            for(int i = 0; i < opciones.length; i++){
                System.out.println((i+1) + ". " + opciones[i]);
            }
            System.out.println("Eliga una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Nombre: ");
                    candidato.setNombre(scanner.next());
                    break;
                case 2:
                    System.out.println("Cedula: ");
                    candidato.setCedula(scanner.next());
                    break;
                    
                case 3:
                    System.out.println("Partido: ");
                    candidato.setPartido((Partido)elegirOpcion(Partido.values()));
                    break;
                case 4:
                    System.out.println("Ciudad: ");
                    candidato.setCiudad((Ciudades)elegirOpcion(Ciudades.values()));
                    break;
                case 5:
                    System.out.println("Orientación: ");
                    candidato.setOrientacion((Orientacion)elegirOpcion(Orientacion.values()));
                    break;
                case 6:
                    System.out.println("Propuesta: ");
                    agregarPropuestas(candidato);
                    break;
                case 7:
                    controller.setAction(Actions.ADD_VOTES);
                    break;
                case 8:
                    if(candidato != null){
                        controller.setAction(Actions.UPDATE);
                    }else{
                        controller.setAction(Actions.INSERT);
                    }
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            controller.actionPerformed(null);
        }
        candidato = null;
    }
  
    public Object elegirOpcion(Object[] opciones){
        int opcion = 0;
        while(opcion != opciones.length){
            for(int i = 0; i < opciones.length; i++){
                System.out.println((i+1) + ". " + opciones[i]);
            }
            System.out.println("Eliga una opción: ");
            opcion = scanner.nextInt();
            if(opcion == opciones.length){
                return "";
            }
            return opciones[opcion-1];
        }
        return "";
    }


    @Override
    public void init(Controller controller) {
        this.controller = controller;
        menu();
    }

    @Override
    public void verCandidato(String candidato) {

       System.out.println(candidato);
    }

    
    @Override
    public Candidato getCandidato() {
        return candidato;
    }

    @Override
    public void messageInfo(String message) {
        System.out.println("\u001B[34m"+"------------------------\n" +message+"\n------------------------"+"\u001B[0m");
    }

    @Override
    public boolean confirmarAccion(String message) {
        System.out.println(message);
        System.out.println("1. Si");
        System.out.println("2. No");
        int opcion = scanner.nextInt();
        return opcion == 1;
    }

    @Override
    public Candidato getCandidatoUpdate() {
      return updateCandidato;
    }

    @Override
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public String inputDialogo(String message) {
        scanner.nextLine();
        System.out.println(message);
        String respuesta = scanner.nextLine();
        return respuesta;
    }
    
}