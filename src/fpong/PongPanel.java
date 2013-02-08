/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fpong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Lassi
 */
class PongPanel extends JPanel {

    private ArrayList<Pallo> pallot = new ArrayList();
    private int maila1y = 2000;
    private int maila1x = 160;
    private int maila2y = 2000;
    private int maila2x = 6000;
    private int maila1d = 50;
    private int maila2d = 50;
    private int mailanKorkeus = 800;
    private int score1 = 0;
    private int score2 = 0;
    private int mailanSyvyys = 80;
    private int palloja;
    private Random random = new Random();

    public PongPanel() {
        pallot.add(new Pallo(3200, 2400, (int) (25 * Math.pow(-1.0, random.nextInt(2))), (int) (25 * Math.pow(-1.0, random.nextInt(2)))));

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 640, 480);
        g.setColor(Color.white);
        piirraMailat(g);
        piirraPallo(g);
        g.drawString(score1 + ":" + score2, 320, 20);
        palloja = pallot.size();
        g.drawString("palloja: " + palloja, 320, 40);
        g.setColor(Color.black);
        g.drawString("palloja: " + palloja, 321, 41);
    }

    private void piirraMailat(Graphics g) {
        g.fillRect(maila1x / 10, maila1y / 10, 8, mailanKorkeus / 10);
        g.fillRect(maila2x / 10, maila2y / 10, 8, mailanKorkeus / 10);

    }

    private void piirraPallo(Graphics g) {
        if (pallot.isEmpty()) {
            pallot.add(new Pallo(3200, 2400, (int) (35 * Math.pow(-1.0, random.nextInt(2))), (int) (random.nextInt(40) - 20)));
        }
        try {
            for (Pallo pallo : pallot) {
                g.fillRect(pallo.getX() / 10, pallo.getY() / 10, 8, 8);
            }
        } catch (ConcurrentModificationException e) {
            return;
        }


    }

    public void liikuta(boolean maila1ylos, boolean maila1alas, boolean maila2ylos, boolean maila2alas) throws InterruptedException {
        Thread.currentThread().sleep(16);
        liikutaPalloja();
        liikutaMailoja(maila1ylos, maila1alas, maila2ylos, maila2alas);
    }

    public void liikutaPalloja() {
        ArrayList<Pallo> poistettavat = new ArrayList<>();
        ArrayList<Pallo> lisattavat = new ArrayList<>();

        for (Pallo pallo : pallot) {
            if (pallo.getY() < 0 || pallo.getY() > 4800 - 80) {
                pallo.kaannaY();
            }
            if (pallo.getX() < maila1x + 80 && pallo.getX() > maila1x - mailanSyvyys) {
                if (pallo.getY() > maila1y && pallo.getY() < maila1y + mailanKorkeus) {
                    pallo.setdX(Math.abs(pallo.getdX()) + random.nextInt(10));
                    pallo.setdY(maila1d);
                    lisattavat.add(new Pallo(maila1x + 80, pallo.getY(), pallo.getdX(), (int) (pallo.getdY() - Math.random() * pallo.getdY())));
                }
            } else if (pallo.getX() > maila2x - 80 && pallo.getX() < maila2x + mailanSyvyys) {
                if (pallo.getY() > maila2y && pallo.getY() < maila2y + mailanKorkeus) {
                    pallo.setdX(Math.abs(pallo.getdX() + random.nextInt(10)) * -1);
                    pallo.setdY(maila2d);
                    lisattavat.add(new Pallo(maila2x - 80, pallo.getY(), pallo.getdX(), (int) (pallo.getdY() - Math.random() * pallo.getdY())));
                }
            }
            if (pallo.getX() > 6400) {
                score1++;
                poistettavat.add(pallo);
            } else if (pallo.getX() < -80) {
                score2++;
                poistettavat.add(pallo);
            }
            pallo.liikuta();
        }
        if (!lisattavat.isEmpty()) {
            for (Pallo pallo : lisattavat) {
                pallot.add(pallo);
            }
            lisattavat.clear();
        }
        if (!poistettavat.isEmpty()) {
            for (Pallo pallo : poistettavat) {
                pallot.remove(pallo);
            }
            poistettavat.clear();
        }


    }

    void liikutaMailoja(boolean maila1ylos, boolean maila1alas, boolean maila2ylos, boolean maila2alas) {
        if (maila1ylos && maila1y > 0) {
            maila1y -= maila1d;
        } else if (maila1alas && maila1y < 4800 - mailanKorkeus) {
            maila1y += maila1d;
        }
        if (maila2ylos && maila2y > 0) {
            maila2y -= maila1d;
        } else if (maila2alas && maila2y < 4800 - mailanKorkeus) {
            maila2y += maila2d;
        }
    }
}
