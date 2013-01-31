/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fpong;

import java.util.Random;

/**
 *
 * @author Lassi
 */
public class Pallo implements Comparable<Pallo> {
    
    private int pallo[] = new int[4];
    private Random random = new Random();
    
    public Pallo(int x, int y, int deltax, int deltay) {
        pallo[0] = x;
        pallo[1] = y;
        pallo[2] = deltax;
        pallo[3] = deltay;
    }
    
    public int getX() {
        return pallo[0];
    }
    
    public int getY() {
        return pallo[1];
    }
    
    public int getdX() {
        return pallo[2];
    }
    
    public int getdY() {
        return pallo[3];
    }
    
    public void setdX(int dx) {
        pallo[2] = dx;
    }
    
    public void setdY(int dy) {
        pallo[3] += random.nextInt(25) - 25 / 2;
        
    }
    
    public void kaannaY() {
        pallo[3] *= -1;
    }
    
    public void kaannaX() {
        if (pallo[2] > 0) {
            pallo[2] += (random.nextInt(20));
        } else {
            pallo[2] -= (random.nextInt(20));
        }
        pallo[2] = pallo[2] * -1;
    }
    
    public void liikuta() {
        if (Math.abs(pallo[2]) < 25) {
            pallo[2] *= 1.1;
            pallo[2] += -1 * (random.nextInt(2));
        }
        if (Math.abs(pallo[3]) > 100) {
            pallo[3] *= 0.9;
        }
        if (Math.abs(pallo[2]) > 80) {
            pallo[2] *= 0.9;
        }
        
        pallo[0] += pallo[2];
        pallo[1] += pallo[3];
    }
    
    @Override
    public int compareTo(Pallo o) {
        if (this == o) {
            return 0;
        } else if (this.getX() > o.getX()) {
            return 1;
        } else {
            return -1;
        }
    }
}
