package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.guyotro_larabia_project.db.DatabaseClient;
import com.example.guyotro_larabia_project.db.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciceCultureActivity extends AppCompatActivity {
    private DatabaseClient mDb;
    private int numQuestion = 0;
    ArrayList<Question> listeQuestion = new ArrayList<Question>();
    //ArrayList<Question> listErreur = new ArrayList<Question>();
    private int nbQuestionRepondu = 0;
    ArrayList<Integer> resultat = new ArrayList<Integer>() ;

    //Paramètre a envoyer à la fenêtre de résultat
    private int nbTrue = 0;
    private int nbQuestion = 0;

    //View
    private TextView question;
    private RadioButton reponse1;
    private RadioButton reponse2;
    private RadioButton reponse3;
    private RadioGroup reponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_culture);
        getQuestions();

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        //Initialiser chaque variable à ça vue correspondante
        question = findViewById(R.id.question);
        reponse1 = findViewById(R.id.reponse1);
        reponse2 = findViewById(R.id.reponse2);
        reponse3 = findViewById(R.id.reponse3);
        reponses = findViewById(R.id.reponses);

    }

    private void maj_affichage(){
        ArrayList<String> list_reponse = new ArrayList<String>();

        question.setText(listeQuestion.get(numQuestion).getQuestion());

        list_reponse.add(listeQuestion.get(numQuestion).getReponseTrue());
        list_reponse.add(listeQuestion.get(numQuestion).getReponseFalse1());
        list_reponse.add(listeQuestion.get(numQuestion).getReponseFalse2());

        Collections.shuffle(list_reponse);

        reponse1.setText(list_reponse.get(0));
        reponse2.setText(list_reponse.get(1));
        reponse3.setText(list_reponse.get(2));
        reponses.clearCheck();
    }

    public void reponseValider(View view) {
           String reponseTrue = listeQuestion.get(numQuestion).getReponseTrue();
           RadioGroup radioGroup = (RadioGroup) findViewById(R.id.reponses);
           RadioButton button_checked = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

           if (button_checked != null){
               if (button_checked.getText().toString() == reponseTrue ){
                   nbTrue += 1;
               }
           }

           numQuestion += 1;

           if(numQuestion >= listeQuestion.size()){
            Intent intent = new Intent(this, FelicitationCultureActivity.class);
            resultat.add(nbTrue);
            resultat.add(nbQuestion);
            intent.putExtra("resultat", resultat);
            startActivity(intent);
           }else{
               maj_affichage();
           }


    }

    private void getQuestions() {
        class GetQuestions extends AsyncTask<Void, Void, List<Question>> {
            @Override
            protected List<Question> doInBackground(Void... voids) {
                String tag = getIntent().getStringExtra("tag");
                List<Question> questionList = mDb.getAppDatabase()
                        .questionDao()
                        .getTagQuestion(tag);
                return questionList;
            }

            @Override
            protected void onPostExecute(List<Question> questions) {
                super.onPostExecute(questions);
                listeQuestion = (ArrayList<Question>) questions;
                maj_affichage();
                nbQuestion = questions.size();
                nbTrue = 0;
            }
        }
        GetQuestions gq = new GetQuestions();
        gq.execute();
    }
}