package appLoja;

import javax.swing.SwingUtilities;

import dao.Controller;
import view.CelularView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater( () -> {
        	CelularView view = new CelularView();
            Controller controller = new Controller(view);
            controller.iniciar();
        });
    }
}

