package utils;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class FocusVentana {

    @FunctionalInterface
    public interface AccionVentana {
        void ejecutar();
    }

    static public void focus(JFrame ventana, AccionVentana accion) {

    ventana.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
           accion.ejecutar();
        }
    });

    }


     static public void focus(JFrame ventana,JFrame origen){

    ventana.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
           origen.setVisible(true);
        }
    });

    }
}

