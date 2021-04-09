package com.example.guyotro_larabia_project.operate;

import java.util.ArrayList;

public class TableOperation {

    //liste d'objets Multiplications
    private ArrayList<Operation> table = new ArrayList<>();

    public TableOperation(boolean[] operandes, char operator){

        for (int i=1; i<=10; i++ ){
            table.add(new Operation(operandes, operator));
        }

    }

    public ArrayList<Operation> getAdditions(){
        return table;
    }

}
