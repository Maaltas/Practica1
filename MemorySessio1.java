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
            System.out.println("*********************************");
            comprovacio(taulell,fil,col,paraules,0);
            System.out.println("*********************************");
            imprimirTaulell(taulell,fil,col);
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
        Boolean a;
        int cont=0;
        Random var = new Random();
        for (int x=0; x<fil; x++){
            for (int y=0; y<col; y++){
                s=paraules[var.nextInt((fil*col)/2)];
                t[x][y]=s;
                System.out.println(x + "·" + y + " --> " + t[x][y]);
            }
        }
        return t;
    }
    private static boolean ValorCorrecte(int fil, int col) {
        if (fil*col % 2 == 0 && fil>0 && col>0 && fil*col<=36) {
            return true;
        }else {
            System.out.println("Error, torna a indicar les mides");
            return false;
        }
    }
    private static void imprimirTaulell(String [][] taulell,int fil, int col){
        for (int x=0; x<fil; x++){
            for (int y=0; y<col; y++){
                System.out.print(taulell[x][y]);
            }
            System.out.println(" ");
        }
    }
    private static void comprovacio(String [][] t,int fil, int col, String [] paraules,int cont){
        // agafem uns valors inicials, amb aquest valors hem de comparar tota la matriu fins trobar una igual o un null
        Random var = new Random();
        int a=0;
        while ((fil*col)/2>a){
            for (int x=0; x<fil; x++){
                for (int y=0; y<col; y++){
                    System.out.println("Paraula analitzant: "  + paraules[a]);
                    if(t[x][y].equals(paraules[a])){
                        cont++;
                        System.out.println("Analitizant la posisicó: " + x +"·" + y + " valor del contador: " + cont);
                        if(cont==2){
                            System.out.println("S'ha fet un canvi a la posició -->  " + x + "·" + y);
                            System.out.print("L'antiga paraula era: " + t[x][y]);
                            t[x][y]=paraules[var.nextInt((fil*col)/2)];
                            System.out.println(", la nova paraula serà: " + t[x][y]);
                            cont=0;
                            //comprovacio(t,fil,col,paraules,cont);
                        }
                    }
                }
            }
            System.out.println("Ha acabat el for");
            cont=0;
            a++;
        }

    }
}
