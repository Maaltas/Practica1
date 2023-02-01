package Sessio2;

import java.util.Scanner;

public class Memory {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Joc del Memory. Entra les dimensions del taulell");
        System.out.println("****************************************************");
        System.out.println("Indica el número de files del taulell");
        int fil = obj.nextInt(); //fil=Keyboard.readint();
        System.out.println("Indica el número de columnes del taulell");
        int col = obj.nextInt(); //col=Keyboard.readint();
        while (!ValorCorrecte(fil, col)) {
            System.out.println("Indica el número de files del taulell");
            fil = obj.nextInt(); //fil=Keyboard.readint();
            System.out.println("Indica el número de columnes del taulell");
            col = obj.nextInt(); //col=Keyboard.readint();
        }
        Taulell t = new Taulell(fil, col);
        int parelles = 0;
        while (t.fiJoc()) {
            System.out.println("Quina fila vols destapar?");
            int fil1 = obj.nextInt();
            System.out.println("Quina columna vols destapar?");
            int col1 = obj.nextInt();
            System.out.println("Quina segona fila vols destapar?");
            int fil2 = obj.nextInt();
            System.out.println("Quina segona columna vols destapar?");
            int col2 = obj.nextInt();
            while (fil1 == fil2 && col1 == col2 || fil1 > fil || fil2 > fil || col1 > col || col2 > col) {
                System.out.println("Valors entrats incorrectes!");
                System.out.println("Quina fila vols destapar?");
                fil1 = obj.nextInt();
                System.out.println("Quina columna vols destapar?");
                col1 = obj.nextInt();
                System.out.println("Quina segona fila vols destapar?");
                fil2 = obj.nextInt();
                System.out.println("Quina segona columna vols destapar?");
                col2 = obj.nextInt();
            }
            fil1--;
            col1--;
            fil2--;
            col2--;
            while (t.aparellada(fil1, col1) || t.aparellada(fil2, col2)) {
                System.out.println("Aquestes dades ja han sigut introduïdes, introdueix noves dades");
                System.out.println("Quina fila vols destapar?");
                fil1 = obj.nextInt();
                System.out.println("Quina columna vols destapar?");
                col1 = obj.nextInt();
                System.out.println("Quina segona fila vols destapar?");
                fil2 = obj.nextInt();
                System.out.println("Quina segona columna vols destapar?");
                col2 = obj.nextInt();
            }
            System.out.println("Comprovem els resultats:");
            t.mostrar(fil1, col1, fil2, col2);
            if (t.fanParella(fil1, col1, fil2, col2)) {
                System.out.println("Felicitats!! Has trobat una parella");
            } else {
                System.out.println("Vaja! Torna a intentar-ho");
            }
        }
        System.out.println("El joc ha acabat moltes gràcies per jugar!");
    }

    private static boolean ValorCorrecte(int fil, int col) {
        if (fil * col % 2 == 0 && fil > 0 && col > 0 && fil * col <= 36) {
            return true;
        } else {
            System.out.println("Error, torna a indicar les mides");
            return false;
        }
    }
}
