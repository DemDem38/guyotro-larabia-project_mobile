package com.example.guyotro_larabia_project.operate;

public class Addition {

    private int operande1;
    private int operande2;
    private int resultat;
    private int max = 9;
    private int min = 0;
    private int range = max - min + 1;


    public Addition(boolean[] operandes, char operator){
        //operandes a une taille de 6
        if (operandes[0]){
            this.operande1 += ((int)(Math.random()*(range)) + min)*100;
        }
        if (operandes[1]){
            this.operande1 += ((int)(Math.random()*(range)) + min)*10;
        }
        if (operandes[2]){
            this.operande1 += ((int)(Math.random()*(range)) + min);
        }
        if (operandes[3]){
            this.operande2 += ((int)(Math.random()*(range)) + min)*100;
        }
        if (operandes[4]){
            this.operande2 += ((int)(Math.random()*(range)) + min)*10;
        }
        if (operandes[5]){
            this.operande2 += ((int)(Math.random()*(range)) + min);
        }

//        this.operande1 = (int)(Math.random()*(9-0+1)) + 0; //range = max - min + 1;
//        this.operande2 = (int)(Math.random()*(9-0+1)) + 0; //(int)(Math.random() * range) + min;
        switch(operator){
            case '+':
                this.resultat = this.operande1 + this.operande2;
                break;
            case '-':
                this.resultat = this.operande1 - this.operande2;
                break;
            case 'x':
                this.resultat = this.operande1 * this.operande2;
                break;
            case '/':
                this.resultat = this.operande1 / this.operande2;
                break;
            default:
                this.operande1 = 404;
                this.operande2 = 404;
                this.resultat = 404;
        }

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
