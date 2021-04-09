package com.example.guyotro_larabia_project.operate;

import java.util.ArrayList;

public class TableDAddition {

    //liste d'objets Multiplications
    private ArrayList<Addition> table = new ArrayList<>();

    public TableDAddition(boolean[] operandes, char operator){

        for (int i=1; i<=10; i++ ){
            table.add(new Addition(operandes, operator));
        }

    }

    public ArrayList<Addition> getAdditions(){
        return table;
    }

}
