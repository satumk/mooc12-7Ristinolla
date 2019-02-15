
package ristinolla;

public class Ristinolla {
    private int[][] ristinolla;
    
    public Ristinolla() {
        this.ristinolla = new int[3][3];
    }
    
    public void alusta() {
        int arvo = 10;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                this.ristinolla[x][y] = arvo;
                arvo++;
            }
        }
    }
    
    public boolean onkoPelattu(int x, int y) {
        if (this.ristinolla[x][y] == 1 || this.ristinolla[x][y] == 2) {
            return true;
        }
        return false;
    }
    
    public boolean asetaArvo(int x, int y, int arvo) {
        if (this.ristinolla[x][y] != 1 || this.ristinolla[x][y] != 2) {
            this.ristinolla[x][y] = arvo;
            return true;
        }
        return false;
    }
    
    public boolean onkoVoitto() {
        if (this.ristinolla[0][0] == this.ristinolla[0][1] && this.ristinolla[0][1] == this.ristinolla[0][2]) {
            return true; // vasen sarake
        }
        if (this.ristinolla[1][0] == this.ristinolla[1][1] && this.ristinolla[1][1] == this.ristinolla[1][2]) {
            return true; // keskisarake
        }
        if (this.ristinolla[2][0] == this.ristinolla[2][1] && this.ristinolla[2][1] == this.ristinolla[2][2]) {
            return true; // oikea sarake
        }
        if (this.ristinolla[0][0] == this.ristinolla[1][0] && this.ristinolla[1][0] == this.ristinolla[2][0]) {
            return true; // alin rivi vaakataso
        }
        if (this.ristinolla[0][1] == this.ristinolla[1][1] && this.ristinolla[1][1] == this.ristinolla[2][1]) {
            return true; // keskirivi vaakataso
        }
        if (this.ristinolla[0][2] == this.ristinolla[1][2] && this.ristinolla[1][2] == this.ristinolla[2][2]) {
            return true; // ylin rivi vaakataso
        }
        if (this.ristinolla[0][0] == this.ristinolla[1][1] && this.ristinolla[1][1] == this.ristinolla[2][2]) {
            return true; // ristiin vas ylhäältä oik alhaalle
        }
        if (this.ristinolla[2][0] == this.ristinolla[1][1] && this.ristinolla[1][1] == this.ristinolla[0][2]) {
            return true; // ja toisin päin
        }
        return false;
    }
}
