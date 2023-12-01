package views;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Actions;
import controller.Controller;
import models.Candidato;
import utils.AgregarAccion;
import utils.FocusVentana;

public class CrudWindow extends JFrame implements  View {

    
    private JButton[] buttons;
    private Controller controller;
    
    private void createUI() {
        setTitle("Sistema de Gestión de Candidatos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 500);
        // Panel para el título
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Por favor ingrese la opción de su preferencia");
        titleLabel.setFont(new Font("Ebrima", Font.BOLD, 14));
        titlePanel.add(titleLabel);

        // Panel para los botones en una cuadrícula 3x3
        JPanel gridPanel = new JPanel(new GridLayout(4, 3, 10, 10));
        buttons = new JButton[12];

        for (int i = 0; i < 12; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Ebrima", Font.PLAIN, 12));
            buttons[i].setHorizontalAlignment(SwingConstants.CENTER);
            buttons[i].setVerticalAlignment(SwingConstants.CENTER);
            gridPanel.add(buttons[i]);
        }
        buttons[0].setAction(AgregarAccion.cambiarAccion(()-> handleButtonClick(0)));
        buttons[1].setAction(AgregarAccion.cambiarAccion(()-> handleButtonClick(1)));
        buttons[2].setAction(AgregarAccion.cambiarAccion(()-> handleButtonClick(2)));
        buttons[3].setAction(AgregarAccion.cambiarAccion(Actions.SEARCH, controller));
        buttons[4].setAction(AgregarAccion.cambiarAccion(Actions.LIST, controller));
        buttons[5].setAction(AgregarAccion.cambiarAccion(Actions.WINNER, controller));
        buttons[6].setAction(AgregarAccion.cambiarAccion(Actions.PARTY_WITH_CANDIDATES, controller));
        buttons[7].setAction(AgregarAccion.cambiarAccion(Actions.CITY_WITH_LESS_CANDIDATES, controller));
        buttons[8].setAction(AgregarAccion.cambiarAccion(Actions.WINNER_PROPOSALS, controller));
        buttons[9].setAction(AgregarAccion.cambiarAccion(Actions.ABOUT, controller));
        buttons[10].setAction(AgregarAccion.cambiarAccion(Actions.HELP, controller));
        buttons[11].setAction(AgregarAccion.cambiarAccion(Actions.EXIT, controller));

        // Asignar texto a los botones
        buttons[0].setText("Insertar Candidato");
        buttons[1].setText("Actualizar Candidato");
        buttons[2].setText("Eliminar Candidato");
        buttons[3].setText("Buscar Candidato por nombre");
        buttons[4].setText("Listar Candidatos");
        buttons[5].setText("Candidato Ganador"); 
        buttons[6].setText("Partido con más candidatos");
        buttons[7].setText("Ciudad con menos candidatos");
        buttons[8].setText("Propuestas ganador");    
        buttons[9].setText("Acerca De");       
        buttons[10].setText("Ayuda");
        buttons[11].setText("Salir");

        // Agregar paneles al frame
        add(titlePanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        setVisible(true);
    }
private void handleButtonClick(int option) {
        try {
            switch (option) {
                case 0:
                    InsertWindow insert = new InsertWindow(controller, Actions.INSERT);
                    setVisible(false);
                    FocusVentana.focus(insert, () -> {
                        controller.setView(this);
                        setVisible(true);
                       
                    });
                    break;
                case 1:
                    UpdateWindow update = new UpdateWindow(controller);
                    setVisible(false);
                    FocusVentana.focus(update,() -> {
                        controller.setView(this);
                        setVisible(true);
                       
                    });
                    break;
                case 2:
                    DeleteWindow delete = new DeleteWindow(controller);
                   setVisible(false);
                    FocusVentana.focus(delete, () -> {
                        controller.setView(this);
                        setVisible(true);
                       
                    });
                    break;
                case 3:
                    SearchWindow search = new SearchWindow(controller);
                    setVisible(false);
                    FocusVentana.focus(search, () -> {
                        controller.setView(this);
                        setVisible(true);
                      
                    });
                    break;
            }
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error");
        }
    }

    

    void volverFocus(){
        controller.setView(this);
        setVisible(true);
    }


    @Override
    public Candidato getCandidato() {
       return null;
    }



    @Override
    public void init(Controller controller) {   
       this.controller = controller;
       createUI();
    }
   
    @Override
    public void verCandidato(String candidato) {
       
    }
    @Override
    public void listCandidato(Candidato[] candidatos) {
      Lista lista = new Lista(candidatos);
        setVisible(false);
        FocusVentana.focus(lista, this);
    }
    @Override
    public boolean confirmarAccion(String message) {
        return true;
    }
    @Override
    public void messageInfo(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    @Override
    public Candidato getCandidatoUpdate() {
        return null;
    }
    @Override
    public void setCandidato(Candidato candidato) {
       
    }
    @Override
    public String inputDialogo(String message) {
      return JOptionPane.showInputDialog(this, message);
    }
   

}
