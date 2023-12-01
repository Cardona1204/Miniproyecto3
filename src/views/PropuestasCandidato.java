package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Candidato;
import models.Propuesta;
import utils.Validacion;

public class PropuestasCandidato extends JFrame implements ActionListener {
    private Candidato candidato;
    private JList<Propuesta> propuestasList;
    private JTextField tituloField;
    private JTextArea descripcionArea;
    private JButton ingresarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JButton atrasButton;

    public PropuestasCandidato( Candidato candidato) {
        this.candidato = candidato;
        initComponents();
    }

    private void initComponents() {

        propuestasList = new JList<>(candidato.getPromesas().toArray(new Propuesta[0]));
        propuestasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        propuestasList.addListSelectionListener(e -> mostrarDetallePropuesta());

        tituloField = new JTextField();
        descripcionArea = new JTextArea();
        descripcionArea.setLineWrap(true);  // Hacer que el texto se ajuste automáticamente al tamaño del área
        descripcionArea.setWrapStyleWord(true);

        ingresarButton = new JButton("Ingresar Propuesta");
        actualizarButton = new JButton("Actualizar Propuesta");
        eliminarButton = new JButton("Eliminar Propuesta");
        atrasButton = new JButton("Atrás");

        ingresarButton.addActionListener(this);
        actualizarButton.addActionListener(this);
        eliminarButton.addActionListener(this);
        atrasButton.addActionListener(this);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(new JScrollPane(propuestasList), BorderLayout.WEST);
        panelSuperior.add(createDetallePanel(), BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout());
        panelInferior.add(ingresarButton);
        panelInferior.add(actualizarButton);
        panelInferior.add(eliminarButton);
        panelInferior.add(atrasButton);

        setLayout(new BorderLayout());
        add(panelSuperior, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 500);  // Ajusté el tamaño para dar espacio a la descripción
        setVisible(true);
    }

    private JPanel createDetallePanel() {
        JPanel detallePanel = new JPanel(new BorderLayout());

        JPanel camposPanel = new JPanel(new GridLayout(2, 1));
        camposPanel.add(new JLabel("Título de la Propuesta:"));
        camposPanel.add(tituloField);

        detallePanel.add(camposPanel, BorderLayout.NORTH);
        detallePanel.add(new JScrollPane(descripcionArea), BorderLayout.CENTER);

        return detallePanel;
    }

    private void mostrarDetallePropuesta() {
        Propuesta selectedPropuesta = propuestasList.getSelectedValue();
        if (selectedPropuesta != null) {
            tituloField.setText(selectedPropuesta.getTitulo());
            descripcionArea.setText(selectedPropuesta.getDescripcion());
        } else {
            tituloField.setText("");
            descripcionArea.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ingresarButton) {
            ingresarPropuesta();
        } else if (e.getSource() == actualizarButton) {
            actualizarPropuesta();
        } else if (e.getSource() == eliminarButton) {
            eliminarPropuesta();
        } else if (e.getSource() == atrasButton) {
            dispose();
        }
        actualizarCombo();
    }
    private void actualizarCombo(){
        propuestasList.removeAll();
        propuestasList.setListData(candidato.getPromesas().toArray(new Propuesta[0]));
    }

    private void ingresarPropuesta() {
       String tituloPropuesta = tituloField.getText();
       String descripcionPropuesta = descripcionArea.getText();
       if(!Validacion.validarDatos(tituloPropuesta, descripcionPropuesta)){
        JOptionPane.showMessageDialog(this, "Todos los datos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
       }
       Propuesta propuesta = new Propuesta(tituloPropuesta, descripcionPropuesta);
       candidato.addPromesa(propuesta);

    }

    private void actualizarPropuesta() {
       String tituloPropuesta = tituloField.getText();
       String descripcionPropuesta = descripcionArea.getText();
       if(!Validacion.validarDatos(tituloPropuesta, descripcionPropuesta)){
        JOptionPane.showMessageDialog(this, "Todos los datos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
       }
       Propuesta propuesta = new Propuesta(tituloPropuesta, descripcionPropuesta);
       
       String mensaje = candidato.actualizarPromesa(propuestasList.getSelectedValue(), propuesta)? "Propuesta actualizada" : "No se pudo actualizar la propuesta";
       JOptionPane.showMessageDialog(this, mensaje);
    }

    private void eliminarPropuesta() {
        if(JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar la propuesta?", "Confirmación", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
            return;
        }
        String mensaje = candidato.eliminarPropuesta(propuestasList.getSelectedValue()) ? "Propuesta eliminada" : "No se pudo eliminar la propuesta";
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
