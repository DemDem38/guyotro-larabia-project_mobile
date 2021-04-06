package com.example.guyotro_larabia_project.operate;

import java.util.ArrayList;

public class TableDAddition {

    //liste d'objets Multiplications
    private ArrayList<Addition> table = new ArrayList<>();

    public TableDAddition(){

        for (int i=1; i<=10; i++ ){
            table.add(new Addition());
        }

    }

    public ArrayList<Addition> getAdditions(){
        return table;
    }

}
