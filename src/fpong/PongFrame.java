/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fpong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Lassi
 */
class PongFrame extends JFrame implements KeyListener {

    private PongPanel paneeli = new PongPanel();
    private boolean maila1ylos = false;
    private boolean maila1alas = false;
    private boolean maila2ylos = false;
    private boolean maila2alas = false;

    public PongFrame(PongPanel paneeli) {
        this.paneeli = paneeli;
        add(paneeli);
        addKeyListener(this);

    }

    public void paivitaPaneeli() {
        repaint();
    }

    public void liikkukaa() throws InterruptedException {
        paneeli.liikuta(maila1ylos, maila1alas, maila2ylos, maila2alas);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 's') {
            maila1alas = true;
        } else if (e.getKeyChar() == 'w') {
            maila1ylos = true;
        }

        if (e.getKeyChar() == '2') {
            maila2alas = true;
        } else if (e.getKeyChar() == '5') {
            maila2ylos = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 's') {
            maila1alas = false;
        } else if (e.getKeyChar() == 'w') {
            maila1ylos = false;
        }

        if (e.getKeyChar() == '2') {
            maila2alas = false;
        } else if (e.getKeyChar() == '5') {
            maila2ylos = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
