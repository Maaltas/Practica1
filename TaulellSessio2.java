package Sessio2;
import java.util.Random;
public class Taulell {
    private Paraula [][] taulell;
    private int parelles;
    private static final String[] mots = {"pinya     ", "Kiwi     ", "cirera     ", "maduixa     ", "melo     ", "llimona     ", "mandarina     ", "pepino     ", "platan     ", "chirimoia     ", "poma     ", "granada     ", "raim     ", "pera     ", "taronja     ", "papaya     ", "sindria     ", "fambruesa     "};

    public Taulell (int fil, int col){
        Paraula taulell[][]= new Paraula [fil][col];
    }
    public void emplena(){
        Random var = new Random();
        String s;
        int fil= taulell.length;
        for (int x=0; x< taulell.length;x++){
            for (int y=0; y<taulell[x].length;y++) {
                s=mots[var.nextInt((fil)*(taulell[x].length)/2)];
                char[] c = s.toCharArray();

            }
        }

    }
    /*
    for (int x=0;x<taulell.length;x++){
            for (int y=0;y<taulell[x].length;y++){
                s=paraules[var.nextInt((fil*col)/2)];
                t[x][y]=s;
                while (quants(s,t)>0){
                    s=paraules[var.nextInt((fil*col)/2)];
                }
                t[x][y]=s;
            }
        }
     */
    /*
    int quantes=0;
        boolean trobat=false;
        for (int x=0; x<taulell.length && !trobat;x++){
            for(int y=0; y<taulell[x].length;y++){
                if (parula.equals(taulell[x][y])){
                    quantes++;
                }
                if (quantes == 2) {
                    return quantes;
                }
            }
        }
     */
}



