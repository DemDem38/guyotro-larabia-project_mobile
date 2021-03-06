package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ErreurOpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur_op);


        Intent mIntent = getIntent();
        int nbErrors = mIntent.getIntExtra("nbErrors",0);

        TextView erreurs = findViewById(R.id.nbErreurs);
        erreurs.setText("Nombre d'erreurs: "+ nbErrors);
    }

    public void err_Corriger(View view) {
        this.finish();
    }

    public void err_changeOp(View view) {
        Intent intent = new Intent(this, ModuleMathsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}