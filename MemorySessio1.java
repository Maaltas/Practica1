import java.util.Scanner;
import java.util.Random;
public class Memory {
    public static void main(String[] args){
        Scanner obj=new Scanner (System.in);
        char continuar='n';
        Boolean fin=false;
        String [] paraules ={"pinya     ", "Kiwi     ", "cirera     ", "maduixa     ", "melo     ", "llimona     ", "mandarina     ", "pepino     ", "platan     ", "chirimoia     ", "poma     ", "granada     ", "raim     ", "pera     ", "taronja     ", "papaya     ", "sindria     ", "fambruesa     "};
        while (!fin) {
            System.out.println("Joc del Memory. Entra les dimensions del taulell");
            System.out.println("****************************************************");
            System.out.println("Indica el número de files del taulell");
            int fil=obj.nextInt(); //fil=Keyboard.readint();
            System.out.println("Indica el número de columnes del taulell");
            int col=obj.nextInt(); //col=Keyboard.readint();
            while (!ValorCorrecte(fil, col)) {
                System.out.println("Indica el número de files del taulell");
                fil=obj.nextInt(); //fil=Keyboard.readint();
                System.out.println("Indica el número de columnes del taulell");
                col=obj.nextInt(); //col=Keyboard.readint();
            }
            String[][] taulell =new String[fil][col];
            Boolean encertats [][]=new Boolean[fil][col];
            encertats=inicialitzarBoolean(encertats);
            taulell=randomizador(taulell,fil,col,paraules);
            System.out.println("*********************************");
            imprimirTaulell(taulell,encertats);
            System.out.println("*********************************");
            int parelles=0;
            while(parelles!=(fil*col)/2){
                System.out.println("Quina fila vols destapar?");
                int fil1=obj.nextInt();
                System.out.println("Quina columna vols destapar?");
                int col1=obj.nextInt();
                System.out.println("Quina segona fila vols destapar?");
                int fil2=obj.nextInt();
                System.out.println("Quina segona columna vols destapar?");
                int col2=obj.nextInt();
                while (fil1==fil2 && col1==col2 || fil1>fil && fil2>fil && col1>col && col2>col){
                    System.out.println("Valors entrats incorrectes!");
                    System.out.println("Quina fila vols destapar?");
                    fil1=obj.nextInt();
                    System.out.println("Quina columna vols destapar?");
                    col1=obj.nextInt();
                    System.out.println("Quina segona fila vols destapar?");
                    fil2=obj.nextInt();
                    System.out.println("Quina segona columna vols destapar?");
                    col2=obj.nextInt();
                }
                fil1--;
                col1--;
                fil2--;
                col2--;
                while (encertats[fil1][col1] || encertats[fil2][col2]){
                    System.out.println("Aquestes dades ja han sigut introduïdes, introdueix noves dades");
                    System.out.println("Quina fila vols destapar?");
                    fil1=obj.nextInt();
                    System.out.println("Quina columna vols destapar?");
                    col1=obj.nextInt();
                    System.out.println("Quina segona fila vols destapar?");
                    fil2=obj.nextInt();
                    System.out.println("Quina segona columna vols destapar?");
                    col2=obj.nextInt();
                }
                System.out.println("Comprovem els resultats:");
                encertats[fil1][col1]=true;
                encertats[fil2][col2]=true;
                encertats=comprovacioUnica(taulell,encertats,fil1,fil2,col1,col2);
                imprimirTaulell(taulell,encertats);
                if(encertats[fil1][col1] && encertats[fil2][col2]){
                    parelles++;
                }
                System.out.println("Portes: " + parelles + " et falten: " + (((fil*col)/2)-parelles));
            }
            System.out.println("Felicitats!! Has trobat totes les parelles");
            System.out.println("Vols fer unaltre partida");
            continuar=obj.next().charAt(0);
            if(continuar!='s' || continuar!='S'){
                fin=true;
            }
        }
        System.out.println("El joc ha acabat moltes gràcies per jugar!");
    }
    // metode que imprimeix el taulell llegint si al array de boolean hi ha un true o un faslse, en el cas que hi hagi un true imprimirà la posició del taulell
    private static void imprimirTaulell (String [][] t, Boolean [][] b){
        for (int i=0; i<t.length;i++){
            for (int j=0; j<t[i].length;j++){
                if (b[i][j]){
                    System.out.print(t[i][j]);
                } else {
                    System.out.print("TAPAT         ");
                }
            }
            System.out.println("");
        }
    }
    // metode que coloca un false a totes les posicions del array de boolean
    private static Boolean [][] inicialitzarBoolean(Boolean[][] b){
        for(int i=0; i<b.length;i++){
            for (int j=0; j<b[i].length;j++){
                b[i][j]=false;
            }
        }
        return b;
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
                while (quants(s,t)>0){
                    s=paraules[var.nextInt((fil*col)/2)];
                }
                t[x][y]=s;
            }
        }
        return t;
    }
    private static Boolean[][] comprovacioUnica(String [][] t, Boolean [][] b, int fil1, int fil2, int col1, int col2){
        imprimirTaulell(t,b);
        if(t[fil1][col1].equals(t[fil2][col2])){
            System.out.println("Felicitats!! Son iguals");
        } else {
            System.out.println("Torna a intentar!");
            b[fil1][col1]=false;
            b[fil2][col2]=false;
        }
        return b;
    }
    private static boolean ValorCorrecte(int fil, int col) {
        if (fil*col % 2 == 0 && fil>0 && col>0 && fil*col<=36) {
            return true;
        }else {
            System.out.println("Error, torna a indicar les mides");
            return false;
        }
    }
    private static void imprimirTaulellPle(String [][] taulell,int fil, int col){
        for (int x=0; x<fil; x++){
            for (int y=0; y<col; y++){
                System.out.print(taulell[x][y]);
            }
            System.out.println(" ");
        }
    }
    private static int quants(String parula, String[][] taulell){
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
        return -1;
    }
}
