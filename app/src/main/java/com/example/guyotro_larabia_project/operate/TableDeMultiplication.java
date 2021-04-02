package com.example.guyotro_larabia_project.operate;

import java.util.ArrayList;

public class TableDeMultiplication {

    //liste d'objets Multiplications
    private ArrayList<Multiplication> table = new ArrayList<>();

    public TableDeMultiplication(int fact){

        for (int i=1; i<10; i++ ){
            table.add(new Multiplication(fact, i));
        }

    }

    public ArrayList<Multiplication> getMultiplications(){
        return table;
    }

}
