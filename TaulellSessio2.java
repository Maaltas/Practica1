package Sessio2;
import java.util.Random;
public class Taulell {
    private Paraula [][] taulell;
    private int parelles;
    private static final String[] mots = {"pinya     ", "Kiwi     ", "cirera     ", "maduixa     ", "melo     ", "llimona     ", "mandarina     ", "pepino     ", "platan     ", "chirimoia     ", "poma     ", "granada     ", "raim     ", "pera     ", "taronja     ", "papaya     ", "sindria     ", "fambruesa     "};
    private static final String[] usedWords = new String [36];

    public Taulell (int fil, int col){
        Paraula taulell[][]= new Paraula [fil][col];
    }
    private void emplena(){
        Random var = new Random();
        String s;
        for (int x=0; x< taulell.length;x++){
            for (int y=0; y<taulell[x].length;y++) {
                s=mots[var.nextInt((taulell.length)*(taulell[x].length)/2)];;
                taulell[x][y]=new Paraula(s);
                while (quants(s)){
                    s=mots[var.nextInt((taulell.length)*(taulell[x].length)/2)];
                    taulell[x][y]=new Paraula(s);
                }
            }
        }
    }
    private boolean quants(String paraula){
        int quants=0;
        for (int x=0; x<taulell.length;x++) {
            for (int y = 0; y < taulell[x].length; y++) {
                if(usedWords[x].equals(paraula)){
                    quants++;
                }  
                if (quants==2){
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrar(int fil1, int col1, int fil2, int col2){
        for(int x=0;x< taulell.length;x++){
            for(int y=0; y< taulell[x].length;y++){
                if(taulell[x][y].getParella() && taulell[fil1][col1].getParella()){
                    System.out.print(taulell[x][y]);
                } else if (taulell[x][y].getParella() && taulell[fil2][col2].getParella()){
                    System.out.print(taulell[x][y]);
                } else {
                    System.out.print("TAPAT       ");
                }
            }
            System.out.println("");
        }
    }
    public boolean fanParella(int fil1, int col1, int fil2, int col2){
        if(taulell[fil1][col1].equals(taulell[fil2][col2])){
            taulell[fil1][col1].setParella();
            taulell[fil2][col2].setParella();
            return true;
        }
        return false;
    }
    public boolean aparellada(int fil, int col){
        return taulell[fil][col].getParella();
    }
    public boolean fiJoc(){
        if (parelles==((taulell.length*taulell[0].length)/2)){
            return true;
        }
        return false;
    }
}
