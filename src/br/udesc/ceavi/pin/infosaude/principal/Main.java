package br.udesc.ceavi.pin.infosaude.principal;

import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import br.udesc.ceavi.pin.infosaude.modelo.Profissional;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario_Logado;
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
    public static Usuario_Logado privilegio = new Profissional();
    
    

    @Override
    public void run() {
        FramePrincipal framePrincipal;
        try {
            framePrincipal = new FramePrincipal(true);
            framePrincipal.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
