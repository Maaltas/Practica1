package Sessio2;
import java.util.Random;
public class Taulell {
    private Paraula [][] taulell;
    private int parelles;
    private static final String[] mots = {"pinya     ", "Kiwi     ", "cirera     ", "maduixa     ", "melo     ", "llimona     ", "mandarina     ", "pepino     ", "platan     ", "chirimoia     ", "poma     ", "granada     ", "raim     ", "pera     ", "taronja     ", "papaya     ", "sindria     ", "fambruesa     "};
    private static final String[] usedWords = new String[36];
    private int fil;
    private int col;
    public Taulell (int fil, int col){
        taulell = new Paraula[fil][col];
        this.fil=fil;
        this.col=col;
        parelles=0;
        emplena();
    }
    private void emplena(){
        Random var = new Random();
        String s;
        int cont=0;
        for (int x=0; x< fil;x++){
            for (int y=0; y<col;y++) {
                s=mots[var.nextInt((taulell.length)*(taulell[x].length)/2)];;
                taulell[x][y]=new Paraula(s);
                while (quants(s)){
                    s=mots[var.nextInt((taulell.length)*(taulell[x].length)/2)];
                    taulell[x][y]=new Paraula(s);
                }
                usedWords[cont]=s;
                cont++;
            }
        }
    }
    private boolean quants(String paraula){
        int quants=0;
        int x=0;
        while (x<usedWords.length) {
            if(usedWords[x]==null){
                return false;
            } else {
                if(usedWords[x].equals(paraula)){
                    quants++;
                }
                if (quants==2){
                    return true;
                }
                x++;
            }
        }
        return false;
    }

    public void mostrar(int fil1, int col1, int fil2, int col2){
        if(fanParella(fil1,col1,fil2,col2)){
            for(int x=0;x< fil;x++){
                for(int y=0; y< col;y++){
                    if(taulell[x][y].getParella()){
                        taulell[x][y].mostrarParaula();
                        System.out.print("        ");
                    } else {
                        System.out.print("TAPAT       ");
                    }
                }
                System.out.println("");
            }
        } else {
            for(int x=0;x< fil;x++) {
                for (int y = 0; y < col; y++) {
                    System.out.print("TAPAT       ");
                }
                System.out.println("");
            }
        }
    }
    public boolean fanParella(int fil1, int col1, int fil2, int col2){
        if(taulell[fil1][col1].iguals(taulell[fil2][col2])){
            if(taulell[fil1][col1].getParella() || taulell[fil2][col2].getParella()){
                return true;
            } else {
                taulell[fil1][col1].setParella();
                taulell[fil2][col2].setParella();
                parelles++;
                return true;
            }
        }
        return false;
    }
    public boolean aparellada(int fil, int col){
        return taulell[fil][col].getParella();
    }
    public boolean fiJoc(){
        if (parelles==fil*col){
            return true;
        }
        return false;
    }
}

