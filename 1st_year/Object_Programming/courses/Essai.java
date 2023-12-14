package Pack1 ;
import java.util.* ;
public class Essai {
    int chp0 ;
    private int chp1 ;
    protected int chp2 ;
    public int chp3 ;
    Essai e ;

    public Essai (int chp0,int chp1,int chp2,int chp3) {
        this.chp0 = chp0;
        this.chp1 = chp1;
        this.chp2 = chp2;
        this.chp3 = chp3 ;
    }
    public void maj() {
        this.e = new Essai(chp0+1, chp1+1, chp2+1, chp3+1) ;
    }
    private String toStringReduit() {
        // tous les champs de e sont accessibles ici puisque
        // e et this sont de la meme classe
        return " et ("+e.chp0+", "+e.chp1+", "+e.chp2+", "+e.chp3+")" ;
    }
    public String toString() {
        return "Essai contient "+chp0+", "+chp1+", "+chp2+", "+chp3+toStringReduit()+"." ;
    }
    public static void main(String[] args) {
        Essai ess1 = new Essai(5,10,20,30);
        ess1.maj() ;
        Essai ess2 = new Essai(55,100,200,300);
        ess2.maj() ;
        System.out.println(ess1.toString());
        System.out.println(ess2.toString());
        System.out.println("Le chp0 de Essai est = "+ess1.chp0);
        System.out.println("Le chp1 de Essai est = "+ess1.chp1);
        System.out.println("Le chp2 de Essai est = "+ess1.chp2);
        System.out.println("Le chp3 de Essai est = "+ess1.chp3);
    }
}