package views;
import controller.Actions;
import controller.Controller;
import models.Candidato;
import utils.AgregarAccion;
import utils.FocusVentana;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UpdateWindow extends JFrame implements View{
    Controller controller;

    private JButton jButton1;
    private JButton jButton2;
    private JComboBox<Candidato> jComboBox1;
    private JLabel jLabel1;
    private JButton listarButton;


    //DefaultComboBoxModel<Candidato> candidatos = new DefaultComboBoxModel<>();

    public UpdateWindow (Controller controller){
        this.controller = controller;
        this.controller.setView(this);
        controller.setAction(Actions.LIST);
        initComponents();
        listarButton.doClick();

    }

    private void initComponents() {

       
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        jComboBox1 = new JComboBox<>();
        listarButton = new JButton();
        listarButton.setAction(AgregarAccion.cambiarAccion(Actions.LIST, controller));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setAction(AgregarAccion.cambiarAccion(()->{
            InsertWindow insertWindow = new InsertWindow(controller, getCandidato(), Actions.UPDATE);
            FocusVentana.focus(insertWindow, () ->{
                controller.setView(this);
                listarButton.doClick();});
        }));
        jButton2.setAction(AgregarAccion.cambiarAccion(()-> dispose()));
        jButton1.setText("Seleccionar");
        jButton2.setText("Volver");


        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Candidato");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateWindow().setVisible(true);
            }
        }); */
    }

    @Override
    public void init(Controller controller) {
      
    }

    @Override
    public void verCandidato(String candidato) {
     
    }

    @Override
    public void listCandidato(Candidato[] strings) {
        jComboBox1.removeAllItems();
        for(Candidato candidato : strings){
            jComboBox1.addItem(candidato);
        }
    }

    @Override
    public Candidato getCandidato() {
        return (Candidato)jComboBox1.getSelectedItem();
    }



    @Override
    public boolean confirmarAccion(String message) {
       return JOptionPane.showConfirmDialog(this, message) == 0;
    }

    @Override
    public void setCandidato(Candidato candidato) {
        
    }

    @Override
    public Candidato getCandidatoUpdate() {
       return null;
    }

    @Override
    public void messageInfo(String message) {
         JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String inputDialogo(String message) {
       return JOptionPane.showInputDialog(this, message);
    }


}
