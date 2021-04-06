package com.example.guyotro_larabia_project.operate;

public class Addition {

    private int operande1;
    private int operande2;
    private int resultat;

    public Addition(){
        this.operande1 = (int)(Math.random()*(9-0+1)) + 0; //range = max - min + 1;
        this.operande2 = (int)(Math.random()*(9-0+1)) + 0; //(int)(Math.random() * range) + min;
        this.resultat = operande1+operande2;
    }

    public int getOperande1() {
        return operande1;
    }

    public int getOperande2() {
        return operande2;
    }

    public int getResultat() {
        return resultat;
    }

}
