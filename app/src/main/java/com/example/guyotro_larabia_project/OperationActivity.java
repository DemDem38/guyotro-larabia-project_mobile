package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guyotro_larabia_project.operate.Operation;
import com.example.guyotro_larabia_project.operate.TableOperation;

import java.util.ArrayList;
import java.util.Iterator;

public class OperationActivity extends AppCompatActivity {
    //Clé de l'intent
    public static String CHECKLIST_KEY = "check_key";
    public static String OPERATOR_KEY = "operator";

    Operation add;
    TableOperation table;
    ArrayList<String> listeRep = new ArrayList<>(); //Liste des réponses entrées
    ArrayList<Boolean> correctList = new ArrayList<>(); //liste des réponses justes et fausses
    boolean[] checkList;
    char operator;
    int compteur = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        checkList = getIntent().getBooleanArrayExtra(CHECKLIST_KEY);
        operator = getIntent().getCharExtra(OPERATOR_KEY,'e');

        table = new TableOperation(checkList, operator);

        add = table.getAdditions().get(compteur-1);
        TextView enonce = findViewById(R.id.addition_operation);
        enonce.setText(add.getOperande1()+" "+operator+" "+add.getOperande2()+" = ");

//        TextView compteurText = findViewById(R.id.addition_compteur);
//        compteur.setText(compteur+"/10");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        compteur = 1;
        majAffiche();
    }


    public void nextAdd(View view){
        //Question suivante
        EditText reponse = findViewById(R.id.addition_resultat);
        saveRep(view);

        if (compteur < 10){
            compteur++;
            majAffiche();
        }
        else{
            finAdd(view);
        }
    }

    public void prevAdd(View view){
        //Question précédente
        EditText reponse = findViewById(R.id.addition_resultat);

        saveRep(view);

        if (compteur > 1){
            compteur--;
            majAffiche();
        }
    }

    public void finAdd(View view){
        //Compte le nombre d'erreurs et redirige vers les activités Erreur et Félicitation

        Iterator aIterator = table.getAdditions().iterator();
        Iterator bIterator = listeRep.iterator();

        int nbErr = 0;
        //On itère à travers table et listeRep en comparant les résultats

        if (correctList.size() > 0){ //on réinitialise la liste si ce n'est pas la première correction
            correctList = new ArrayList<>();
        }

        while (aIterator.hasNext() && bIterator.hasNext()){

            Operation aItem = (Operation) aIterator.next();
            String bItem = (String) bIterator.next();

            // Test du résultat. Si aucune réponse n'est entrée, on attrape l'erreur et on augment nbErr

            try {
                if (Integer.valueOf(bItem) != aItem.getResultat()){
                    nbErr ++;
                    correctList.add(false);
                }
                else{
                    correctList.add(true);
                }
            }
            catch (Exception e){
                nbErr ++;
                correctList.add(false);
            }
        }

        if (nbErr == 0){
            Intent intent = new Intent(this, FelicitationOpActivity.class);
            intent.putExtra(FelicitationOpActivity.OPERATOR_KEY, operator);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, ErreurOpActivity.class);
            intent.putExtra("nbErrors", nbErr);
            startActivity(intent);
        }
    }

    public void majAffiche(){
        //met à jour l'affichage du compteur ainsi que l'énoncé
        EditText reponse = findViewById(R.id.addition_resultat);
        TextView compteurText = findViewById(R.id.addition_compteur);
        compteurText.setText(compteur+"/10");

        add = table.getAdditions().get(compteur-1);
        TextView enonce = findViewById(R.id.addition_operation);
        enonce.setText(add.getOperande1()+" "+operator+" "+add.getOperande2()+" = ");

        //Restaurer les résultats entrés
        if (listeRep.size() < compteur){
            reponse.setText("");
        }
        else{
            reponse.setText(listeRep.get(compteur-1));
        }

        //Indiquer si la réponse est fausse
        if (correctList.size() == 10){    //Toutes les questions ont eu une réponse
            ImageView correct = findViewById(R.id.correct);
            ImageView wrong = findViewById(R.id.wrong);

            if (correctList.get(compteur-1)){
                wrong.setVisibility(View.INVISIBLE);
                correct.setVisibility(View.VISIBLE);
            }
            else {
                correct.setVisibility(View.INVISIBLE);
                wrong.setVisibility(View.VISIBLE);
            }
        }
    }

    public void saveRep(View view){
        //sauvegarde les réponses entrées par l'utilisateur
        EditText reponse = findViewById(R.id.addition_resultat);

        if (listeRep.size() < compteur){
            listeRep.add(reponse.getText().toString());
        }
        else{
            listeRep.set(compteur-1, reponse.getText().toString());
        }


    }

}