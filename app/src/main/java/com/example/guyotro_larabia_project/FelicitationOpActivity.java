package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FelicitationOpActivity extends AppCompatActivity {

    public static String OPERATOR_KEY = "operator";
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitation_op);

        operator = getIntent().getCharExtra(OPERATOR_KEY,'x');
    }

    public void feli_Restart(View view) {
        Intent intent = new Intent(this, ModuleAdditionsActivity.class);
        intent.putExtra(FelicitationOpActivity.OPERATOR_KEY, operator);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void feli_changeOp(View view) {
        Intent intent = new Intent(this, ModuleMathsActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}