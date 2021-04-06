package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guyotro_larabia_project.operate.Addition;
import com.example.guyotro_larabia_project.operate.TableDAddition;

import java.util.ArrayList;
import java.util.Iterator;

public class AdditionActivity extends AppCompatActivity {

    Addition add;
    TableDAddition table = new TableDAddition();
    ArrayList<String> listeRep = new ArrayList<>();
    int compteur = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        add = table.getAdditions().get(compteur-1);
        TextView enonce = findViewById(R.id.addition_operation);
        enonce.setText(add.getOperande1()+" + "+add.getOperande2()+" = ");

//        TextView compteurText = findViewById(R.id.addition_compteur);
//        compteur.setText(compteur+"/10");

    }

    public void nextAdd(View view){
        EditText reponse = findViewById(R.id.addition_resultat);
        if (listeRep.size() < compteur){
            listeRep.add(reponse.getText().toString());
        }
        else{
            listeRep.set(compteur-1, reponse.getText().toString());
        }

        if (compteur < 10){
            compteur++;
            TextView compteurText = findViewById(R.id.addition_compteur);
            compteurText.setText(compteur+"/10");

            add = table.getAdditions().get(compteur-1);
            TextView enonce = findViewById(R.id.addition_operation);
            enonce.setText(add.getOperande1()+" + "+add.getOperande2()+" = ");

            //Restaurer les résultats entrés
            if (listeRep.size() < compteur){
                reponse.setText("");
            }
            else{
                reponse.setText(listeRep.get(compteur-1));
            }
        }
        else{
            finAdd(view);
        }
    }

    public void prevAdd(View view){
        EditText reponse = findViewById(R.id.addition_resultat);

        listeRep.set(compteur-1, reponse.getText().toString());

        if (compteur > 1){
            compteur--;
            TextView compteurText = findViewById(R.id.addition_compteur);
            compteurText.setText(compteur+"/10");

            add = table.getAdditions().get(compteur-1);
            TextView enonce = findViewById(R.id.addition_operation);
            enonce.setText(add.getOperande1()+" + "+add.getOperande2()+" = ");

            //Restaurer les résultats entrés
            reponse.setText(listeRep.get(compteur-1));
        }
    }

    public void finAdd(View view){
        Iterator aIterator = table.getAdditions().iterator();
        Iterator bIterator = listeRep.iterator();

        int nbErr = 0;
        //On itère à travers table et editList en comparant les résultats
        while (aIterator.hasNext() && bIterator.hasNext()){

            Addition aItem = (Addition) aIterator.next();
            String bItem = (String) bIterator.next();

            // Test du résultat. Si aucune réponse n'est entrée, on attrape l'erreur et on augment nbErr
            try {
                if (Integer.valueOf(bItem) != aItem.getResultat()){
                    nbErr ++;
                }
            }
            catch (Exception e){
                nbErr ++;
            }
        }

        if (nbErr == 0){
            Intent intent = new Intent(this, FelicitationOpActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, ErreurOpActivity.class);
            intent.putExtra("nbErrors", nbErr);
            startActivity(intent);
        }
    }

}