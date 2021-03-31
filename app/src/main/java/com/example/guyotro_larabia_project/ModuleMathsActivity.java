package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ModuleMathsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_maths);
    }


    //Navigation vers les différents module de mathématique ( voir la possibilité d'optimiser en une seule fonction)
    public void navigationToMultiplication(View view) {
        Intent intent = new Intent(this, ModuleMultiplicationActivity.class);
        startActivity(intent);
    }

    public void navigationToAdditions(View view) {
        Intent intent = new Intent(this, ModuleAdditionsActivity.class);
        startActivity(intent);
    }

    public void navigationToSoustraction(View view) {
        Intent intent = new Intent(this, ModuleSoustractionActivity.class);
        startActivity(intent);
    }

    public void navigationToQuotien(View view) {
        Intent intent = new Intent(this, ModuleQuotienActivity.class);
        startActivity(intent);
    }

    //---------------------------------------------------------------------------------------------------------------
}