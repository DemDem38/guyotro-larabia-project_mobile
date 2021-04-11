package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FelicitationCultureActivity extends AppCompatActivity {


    private int nbTrue;
    private int nbQuestion;

    private ArrayList<Integer> resultat = new ArrayList<Integer>();

    //View
    private Button button_correction;
    private TextView text_resultat;
    private RelativeLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitation_culture);

        //Sortir les bonnes valeurs du tableau
        resultat = getIntent().getIntegerArrayListExtra("resultat");
        nbTrue = resultat.get(0);
        nbQuestion = resultat.get(1);

        //Initialiser les objets de la view
        text_resultat = findViewById(R.id.text_felcitation_culuture_resultat);
        text_resultat.setText("Vous avez obtenu un score de " + nbTrue + "/" + nbQuestion);
    }

    public void navigationToModuleCulture(View view) {
        Intent toModuleCulture = new Intent(this, ModuleCultureActivity.class);
        toModuleCulture.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(toModuleCulture);
    }

}