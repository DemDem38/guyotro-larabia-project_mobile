package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ModuleCultureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_culture);
    }

    public void lancerExerciceFr(View view) {
        String tag ="français";
        Intent exoFr = new Intent(this, ExerciceCultureActivity.class);
        exoFr.putExtra("tag", tag);
        exoFr.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exoFr);
    }

    public void lancerExerciceGeo(View view) {
        String tag ="geographie";
        Intent exoGeo = new Intent(this, ExerciceCultureActivity.class);
        exoGeo.putExtra("tag", tag);
        startActivity(exoGeo);
    }

    public void lancerExerciceHist(View view) {
        String tag = "histoire";
        Intent exoHist = new Intent(this, ExerciceCultureActivity.class);
        exoHist.putExtra("tag",tag);
        startActivity(exoHist);
    }
}