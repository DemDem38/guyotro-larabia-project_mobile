package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.guyotro_larabia_project.db.DatabaseClient;
import com.example.guyotro_larabia_project.db.Question;

import java.util.ArrayList;

public class ChoixMatiereActivity extends AppCompatActivity {
    private DatabaseClient mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_matiere);
    }

    public void navigationToMaths(View view) {
        Intent toMath = new Intent(this, ModuleMathsActivity.class);
        startActivity(toMath);
    }

    public void navigationToFr(View view) {
        Intent toFr = new Intent(this, ModuleCultureActivity.class);
        startActivity(toFr);
    }
}