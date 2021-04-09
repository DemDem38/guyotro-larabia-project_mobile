package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ModuleOperationsActivity extends AppCompatActivity {

    boolean[] checkList = {false, false, true, false, false, true};
    public static String OPERATOR_KEY = "operator";
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_operations);

        operator = getIntent().getCharExtra(OPERATOR_KEY,'k');
        TextView textOp = findViewById(R.id.textOperandes);
        textOp.setText(Character.toString(operator));

        if(operator == 'x'){
            Button tableButton = findViewById(R.id.tableButton);
            tableButton.setVisibility(View.VISIBLE);
        }
    }

    public void onCheckboxClicked(View view) {
        //La box est cochée ?
        boolean checked = ((CheckBox) view).isChecked();

        //Quelle box est cochée ?
        switch (view.getId()) {
            case R.id.G_100Button:
                checkList[0] = checked;
                break;
            case R.id.G_10Button:
                checkList[1] = checked;
                break;
            case R.id.G_1Button:
                checkList[2] = checked;
                break;
            case R.id.D_100Button:
                checkList[3] = checked;
                break;
            case R.id.D_10Button:
                checkList[4] = checked;
                break;
            case R.id.D_1Button:
                checkList[5] = checked;
                break;
        }
    }

    public void validerOperandes (View view) {
        Intent intent = new Intent(this, OperationActivity.class);
        intent.putExtra(OperationActivity.CHECKLIST_KEY, checkList);
        intent.putExtra(OperationActivity.OPERATOR_KEY, operator);
        startActivity(intent);
    }

    public void versTable (View view) {
        Intent intent = new Intent(this, ModuleMultiplicationActivity.class);
        startActivity(intent);
    }

    public void retourMod(View view){
        this.finish();
    }
}