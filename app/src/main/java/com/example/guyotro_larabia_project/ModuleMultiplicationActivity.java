package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class ModuleMultiplicationActivity extends AppCompatActivity {

    private NumberPicker picker1;
    private int picked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_module_multiplication);

        picker1 = findViewById(R.id.exercice5_picker);
        picker1.setMinValue(1);
        picker1.setMaxValue(9);
    }

    public void pickerValider(View view) {
        picker1 = findViewById(R.id.exercice5_picker);
        picked = picker1.getValue();

        Intent intent = new Intent(this, TableMultiplicationActivity.class);
        intent.putExtra("valuePicked", picked);
        startActivity(intent);
    }


}