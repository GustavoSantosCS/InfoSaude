package br.udesc.ceavi.pin.infosaude.principal;

import br.udesc.ceavi.pin.infosaude.view.frame.FramePrincipal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Classe Principal
 * 
 * @author Gustavo
 * @version 1.0
 * @since 23/10/2018
 */
public class Main implements Runnable{

    public static void main(String[] args) {
        Main main = new Main();
        Thread thread = new Thread(main);
        thread.start();
    }

    @Override
    public void run() {
        FramePrincipal framePrincipal;
        try {
            framePrincipal = new FramePrincipal();
            framePrincipal.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
