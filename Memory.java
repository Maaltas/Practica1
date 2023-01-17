import java.util.Scanner;
import java.util.Random;
public class Memory {
    public static void main(String[] args){
        Scanner obj=new Scanner (System.in);
        String continuar="n";
        String [] paraules ={"pinya     ", "Kiwi     ", "cirera     ", "maduixa     ", "melo     ", "llimona     ", "mandarina     ", "pepino     ", "platan     ", "chirimoia     ", "poma     ", "granada     ", "raim     ", "pera     ", "taronja     ", "papaya     ", "sindria     ", "fambruesa     "};
        do {
            System.out.println("Joc del Memory. Entra les dimensions del taulell");
            System.out.println("****************************************************");

            System.out.println("Indica el número de files del taulell");
            int fil=obj.nextInt(); //fil=Keyboard.readint();
            System.out.println("Indica el número de columnes del taulell");
            int col=obj.nextInt(); //col=Keyboard.readint();
            while (ValorCorrecte(fil,col) == false) {
                    System.out.println("Indica el número de files del taulell");
                    fil=obj.nextInt(); //fil=Keyboard.readint();
                    System.out.println("Indica el número de columnes del taulell");
                    col=obj.nextInt(); //col=Keyboard.readint();
            }
            String taulell[][]=new String[fil][col];
            Boolean encertats [][]=new Boolean[fil][col];
            taulell=randomizador(taulell,fil,col,paraules);
            imprimirTaulell(taulell);
            System.out.println("Vols continuar?");
            continuar=obj.next();
        } while (continuar!="s" || continuar!="S");
    }

    private static boolean comparcio(String[][] t, Boolean[][] e, int fil, int col){
        if (t[fil][col].equals(e[fil][col])){
            return true;
        } else return false;
    }
    private static String[][] randomizador(String[][] t,int fil, int col, String[] paraules){
        String s;
        Random var = new Random();
        for (int x=0; x<t.length; x++){
            for (int y=0; y<t.length+1; y++){
                do{
                    s=paraules[var.nextInt(18)];
                    t[x][y]=s;
                } while (comprovacio(t,s)==false);
            }
        }
        return t;
    }
    private static boolean ValorCorrecte(int fil, int col) {
        if (fil*col % 2 == 0 && fil >0 && col >0 && fil*col<=36) {
            return true;
        }else {
            System.out.println("Error, torna a indicar les mides");
            return false;
        }
    }
    private static void imprimirTaulell(String [][] taulell){
        for (int x=0; x<taulell.length; x++){
            for (int y=0; y<=taulell.length; y++){
                System.out.print(taulell[x][y]);
            }
            System.out.println(" ");
        }
    }
    private static boolean comprovacio(String [][] t, String b){
        for (int x=0; x<t.length; x++){
            for (int y=0; y<=t.length; y++){
                if (t[x][y].equals(b)){
                    return true;
                }
            }
        }
        return false;
    }
}
