package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Candidato;
import models.Ciudades;
import models.Partido;
import models.Propuesta;
import service.CandidatoService;
import utils.Validacion;
import views.View;

public class Controller implements ActionListener{
  
  
    private View view;
    private Actions action;
    private CandidatoService candidatoService;
    private Candidato candidato;
 
    public Controller(View view) {
        candidatoService = new CandidatoService();
        this.view = view;
        this.view.init(this);
    }

    public void setView(View view) {
        this.view = view;
     
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(action == null) return;
        switch (action) {
            case INSERT:
                candidato = view.getCandidato();
                if (candidato == null) {
                    view.messageInfo("Los campos no pueden estar vacíos");
                    break;
                }
                 if(!Validacion.validarDatos(candidato.getNombre(), candidato.getCedula())){
                    view.messageInfo("Los campos no pueden estar vacíos");
                    break;
                }
                if(!view.confirmarAccion("¿Está seguro de agregar el candidato?\n"+candidato)) break;
                boolean info = candidatoService.addCandidato(candidato);
                view.messageInfo(info ? "Candidato agregado" : "Error al agregar candidato");
                break;
            case ADD_VOTES:
                candidato = view.getCandidato();
                if(!Validacion.validarDatos(candidato.getNombre(), candidato.getCedula())){
                    view.messageInfo("Los campos no pueden estar vacíos");
                    break;
                }
                String votos = view.inputDialogo("Votos actuales "+candidato.getVotos() +"\nIngrese la cantidad de votos: " );
                if(votos == null || !Validacion.validarDatos(votos)){
                    view.messageInfo("El campo no puede estar vacío");
                    break;
                }
                try {
                    int voto = Integer.parseInt(votos);
                    if(voto < 0){
                        view.messageInfo("El número de votos no puede ser negativo");
                        break;
                    }
                    candidato.setVotos(voto);
                    view.setCandidato(candidato);
                    view.messageInfo("Votos agregados");
                } catch (Exception er) {
                    view.messageInfo("El número de votos no es válido");
                }
                break;
            case UPDATE:
                candidato = view.getCandidato();
                Candidato candidatoUpdate = view.getCandidatoUpdate();
                if (candidato == null || candidatoUpdate == null) {
                    view.messageInfo("Eliga un candidato");
                    break;
                }
                boolean status = candidatoService.updateCandidato(candidato, candidatoUpdate);
                view.messageInfo(status ? "Candidato actualizado" : "Error al actualizar candidato");
                break;
            case DELETE:
               candidato = view.getCandidato();
                if(candidato == null){
                    view.messageInfo("Eliga un candidato");
                    break;
                }
                if(!view.confirmarAccion("¿Está seguro de eliminar el candidato?\n"+candidato)) break;
                
                view.messageInfo(candidatoService.removeCandidato(candidato) ? "Candidato eliminado": "Error al eliminar candidato");
                view.listCandidato(candidatoService.getListaCandidato().toArray(new Candidato[0]));
                break;
            case SEARCH:
                String name = view.inputDialogo("Ingrese el nombre del candidato: ");
                if(name == null || !Validacion.validarDatos(name)){
                    view.messageInfo("El campo no puede estar vacío");
                    break;
                }
                candidato = candidatoService.getCandidato(name);
                if(candidato == null){
                    view.messageInfo("Candidato no encontrado");
                    break;
                }
                view.messageInfo(candidatoService.infoCandidato(candidato, false));
                break;
            case LIST:
                Candidato [] candidatos = candidatoService.getListaCandidato().toArray(new Candidato[0]);
                if(candidatos.length == 0){
                    view.messageInfo("No hay candidatos registrados");
                    break;
                }
                view.listCandidato(candidatos);
                break;
            case WINNER:
                candidato = candidatoService.getCandidatoGanador();
                if(candidato == null){
                    view.messageInfo("No hay votos registrados");
                    break;
                }
                view.messageInfo("Ganador\n" + candidatoService.infoCandidato(candidato, false));
                break;
            case CITY_WITH_LESS_CANDIDATES:
                Ciudades[] ciudades = candidatoService.getCiudadesMenosCandidatos().toArray(new Ciudades[0]);
                if(ciudades.length == 0){
                    view.messageInfo("No hay candidatos registrados");
                    break;
                }
                //mostrar solo 3
                String infoCiudades = "";
                for (int i = 0; i < (ciudades.length < 3 ? ciudades.length : 3); i++) {
                    infoCiudades += (i + 1) + ". " + ciudades[i] + "\n";
                }
                view.messageInfo("Ciudades con menos candidatos\n" + infoCiudades);
                break;
            case PARTY_WITH_CANDIDATES:
                Partido partido = candidatoService.getPartidoMasCandidatos();
                if(partido == null){
                    view.messageInfo("No hay candidatos registrados");
                    break;
                }
                view.messageInfo("Partido con más candidatos\n" + partido);
                break;
            case WINNER_PROPOSALS:
                candidato = candidatoService.getCandidatoGanador();
                if(candidato == null){
                    view.messageInfo("No hay votos registrados");
                    break;
                }
                String propuestas = "";
                for (Propuesta propuesta : candidato.getPromesas()) {
                    propuestas += propuesta.getTitulo() + ": " + propuesta.getDescripcion() + "\n";
                }
                view.messageInfo("Propuestas del ganador\n" + propuestas);
                break;
            case ABOUT:
                view.messageInfo("Desarrollado por:\n" 
                + "- LUIS MANUEL CARDONA TROCHEZ - 2059942\n"
                + "- JUAN DAVID GUTIERREZ FLORES - 2060104\n"
                + "- CESAR PENARANDA - 2266265\n"
                );
                break;
            case HELP:
                view.messageInfo("Ayuda:\n"
                + "1. Insertar Candidato: Permite agregar un candidato\n"
                + "2. Actualizar Candidato: Permite actualizar un candidato\n"
                + "3. Eliminar Candidato: Permite eliminar un candidato\n"
                + "4. Buscar Candidato: Permite buscar un candidato\n"
                + "5. Listar Candidatos: Permite listar los candidatos\n"
                + "6. Candidato Ganador: Permite ver el candidato ganador\n"
                + "7. Partido con más candidatos: Permite ver el partido con más candidatos\n"
                + "8. Ciudades con menos candidatos: Permite ver las ciudades con menos candidatos\n"
                + "9. Propuestas del ganador: Permite ver las propuestas del ganador\n"
                + "10. Acerca de: Permite ver información de los desarrolladores\n"
                );
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                view.messageInfo("Opción no válida");
        }
        action = null;
        candidato = null;
        
    }

}
