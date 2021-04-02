package com.example.guyotro_larabia_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guyotro_larabia_project.operate.Multiplication;
import com.example.guyotro_larabia_project.operate.TableDeMultiplication;

import java.util.ArrayList;
import java.util.Iterator;

public class TableMultiplicationActivity extends AppCompatActivity {

    private int picked = 0;
    private ArrayList<EditText> editList = new ArrayList<>();
    TableDeMultiplication table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        Intent mIntent = getIntent();
        picked = mIntent.getIntExtra("valuePicked",0);

        table = new TableDeMultiplication(picked);

        LinearLayout linear = findViewById(R.id.linearMain);

        // 1. Boucler pour générer la table
        for(Multiplication multiplication : table.getMultiplications()){

            // 2. Création de la ligne temporaire
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);

            // 3. Création du texte décrivant l'opération
            TextView calcul = (TextView) linearTMP.findViewById(R.id.template_calcul);
            calcul.setText(multiplication.getOperande1() + " x " + multiplication.getOperande2() + " = ");

            // 4. Création de l'éditText permettant d'intéragir avec l'utilisateur
            EditText resultat = (EditText) linearTMP.findViewById(R.id.template_resultat);
            //resultat.setText(Integer.toString(multiplication.getOperande1() * multiplication.getOperande2()));
            editList.add(resultat);


            // 5. Ajout au linear principal
            linear.addView(linearTMP);

        }
    }

    public void btnTableValider(View view) {
        Iterator aIterator = table.getMultiplications().iterator();
        Iterator bIterator = editList.iterator();

        int nbErr = 0;
        //On itère à travers table et editList en comparant les résultats
        while (aIterator.hasNext() && bIterator.hasNext()){

            Multiplication aItem = (Multiplication) aIterator.next();
            EditText bItem = (EditText) bIterator.next();

            // Test du résultat. Si aucune réponse n'est entrée, on attrape l'erreur et on augment nbErr
            try {
                if (Integer.valueOf(bItem.getText().toString()) != aItem.getResultat()){
                    nbErr ++;
                }
            }
            catch (Exception e){
                nbErr ++;
            }
        }

        if (nbErr == 0){
            Intent intent = new Intent(this, FelicitationActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, ErreurActivity.class);
            intent.putExtra("nbErrors", nbErr);
            startActivity(intent);
        }
    }
}