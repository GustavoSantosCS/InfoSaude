package br.udesc.ceavi.pin.infosaude.principal;

import br.udesc.ceavi.pin.infosaude.view.frame.FramePrincipal;


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
        FramePrincipal framePrincipal = new FramePrincipal();
        framePrincipal.setVisible(true);
    }

}
