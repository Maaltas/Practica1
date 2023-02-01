package Sessio2;

public class Paraula {
    private char[] mot;
    private int llarg;
    private boolean parella;

    public Paraula(String mot){
        this.mot=mot.toCharArray();
        llarg=mot.length();
        parella=false;
    }
    public boolean iguals (Paraula altra){
        if(altra.llarg!=this.llarg){
            return false;
        }
        for(int x=0; x<this.mot.length;x++){
            if(this.mot[x]!=altra.mot[x]){
                    return false;
            }
        }
        return true;
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
        return parella=!parella;
    }
}
