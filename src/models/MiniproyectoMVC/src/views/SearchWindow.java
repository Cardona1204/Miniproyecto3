package views;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Actions;
import controller.Controller;
import models.Candidato;
import utils.AgregarAccion;



public class SearchWindow extends JFrame implements View{
   
    private JButton buscarB;
    private JButton volverB;
    private JTextField nameBox;
    private JLabel headText;
    private JScrollPane jScrollPane1;
    private JTextArea showText;
    private Controller controller;

    public SearchWindow(Controller controller) {
        this.controller = controller;
        this.controller.setView(this);
        initComponents();
    }
   
    private void initComponents() {

        headText = new JLabel();
        nameBox = new JTextField();
        jScrollPane1 = new JScrollPane();
        showText = new JTextArea();
        buscarB = new JButton();
        volverB = new JButton();

        headText.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        headText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headText.setText("Candidatos");

        showText.setColumns(20);
        showText.setRows(5);
        jScrollPane1.setViewportView(showText);

        buscarB.setAction(AgregarAccion.cambiarAccion(Actions.SEARCH, controller));
        buscarB.setText("Buscar");

        volverB.setAction(AgregarAccion.cambiarAccion(()-> dispose()));
        volverB.setText("Volver");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(nameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volverB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(headText, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(buscarB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(headText)
                .addGap(18, 18, 18)
                .addComponent(nameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(buscarB)
                .addGap(7, 7, 7)
                .addComponent(volverB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchWindow(controller).setVisible(true);
            }
        });*/
    }

    @Override
    public void init(Controller controller) {
        
    }


    @Override
    public Candidato getCandidato() {
       return null;
    }

 
    
    @Override
    public void verCandidato(String candidato) {
       showText.setText(candidato);
    }

    @Override
    public void listCandidato(Candidato[] strings) {
    }

    @Override
    public boolean confirmarAccion(String message) {
        return true;
    }

    @Override
    public void messageInfo(String message) {
     JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
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
        return "";
    }


}
