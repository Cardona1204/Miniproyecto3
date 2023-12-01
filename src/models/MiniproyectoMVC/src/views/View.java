package views;

import controller.Controller;
import models.Candidato;

public interface View {

    void init(Controller controller);
    void verCandidato(String candidato);
    void listCandidato(Candidato[] candidatos);
    
 
    Candidato getCandidato();
    void setCandidato(Candidato candidato);
    Candidato getCandidatoUpdate();


    void messageInfo(String message);
    boolean confirmarAccion(String message);
    String inputDialogo(String message);
    
}
