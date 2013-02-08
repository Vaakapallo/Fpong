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

    private int x;
    private int y;
    private int deltax;
    private int deltay;
    private Random random = new Random();

    public Pallo(int x, int y, int deltax, int deltay) {
        this.x = x;
        this.y = y;
        this.deltax = deltax;
        this.deltay = deltay;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getdX() {
        return deltax;
    }

    public int getdY() {
        return deltay;
    }

    public void setdX(int dx) {
        deltax = dx;
    }

    public void setdY(int dy) {
        deltay += random.nextInt(25) - 25 / 2;

    }

    public void kaannaY() {
        deltay = deltay * -1;
    }

    public void kaannaX() {
        if (deltax > 0) {
            deltax += (random.nextInt(20));
        } else {
            deltax -= (random.nextInt(20));
        }
        deltax = deltax * -1;
    }

    public void liikuta() {
        if (Math.abs(deltax) < 25) {
            deltax *= 1.1;
            deltax += -1 * (random.nextInt(2));
        }
        if (Math.abs(deltay) > 100) {
            deltay *= 0.9;
        }
        if (Math.abs(deltax) > 80) {
            deltax *= 0.9;
        }

        x += deltax;
        y += deltay;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pallo other = (Pallo) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.deltax != other.deltax) {
            return false;
        }
        if (this.deltay != other.deltay) {
            return false;
        }
        return true;
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
