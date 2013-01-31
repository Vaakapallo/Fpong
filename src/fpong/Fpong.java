/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fpong;

import javax.swing.JFrame;

/**
 *
 * @author Lassi
 */
public class Fpong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        PongPanel paneeli = new PongPanel();
        PongFrame ikkuna = new PongFrame(paneeli);
        ikkuna.setTitle("Pong");
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ikkuna.setSize(656, 518);
        ikkuna.setVisible(true);
        while (true) {
            ikkuna.paivitaPaneeli();
            ikkuna.liikkukaa();
        }
    }
}
