package com.example.guyotro_larabia_project.operate;

public class Multiplication {

    private int operande1;
    private int operande2;
    private int resultat;

    public Multiplication(int op1, int op2){
        this.operande1 = op1;
        this.operande2 = op2;
        this.resultat = op1*op2;
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
