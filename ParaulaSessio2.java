package Sessio2;

public class Paraula {
    private char[] mot;
    private int llarg;
    private boolean parella;

    public Paraula(String mot){
        this.mot=mot.toCharArray();
        llarg=mot.length();
    }
    public boolean iguals (Paraula altra){
        return altra.equals(this);
    }
    public void mostrarParaula(){
        for (int x=0; x<llarg;x++){
            System.out.print(mot[x]);
        }
    }
    public boolean getParella(){
        return parella;
    }
    public boolean setParella(){
        return parella= !parella;
    }
}
