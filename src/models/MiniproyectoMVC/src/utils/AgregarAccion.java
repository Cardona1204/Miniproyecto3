package utils;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import controller.Actions;
import controller.Controller;

public class AgregarAccion {
    @FunctionalInterface
    public interface Funcion {
        void ejecutar();
    }
    public static Action cambiarAccion(Actions actions, Controller controller){
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setAction(actions);
                controller.actionPerformed(e);
            }
        };
    }
    public static Action cambiarAccion(Funcion funcion){
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               funcion.ejecutar();
            }
        };
    }
}
