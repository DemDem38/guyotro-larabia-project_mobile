package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.guyotro_larabia_project.db.DatabaseClient;
import com.example.guyotro_larabia_project.db.Question;

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

    public void ajouter_question(View view) {
        mDb = DatabaseClient.getInstance(getApplicationContext());
        mDb.getAppDatabase().questionDao().insert(new Question("Comment écrit-on 'retrouver' dans la phrase : Lucie veut ' ? ' son chapeau.", "français", "Retrouver", "Retrouvé","Retrouvée"));
        mDb.getAppDatabase().questionDao().insert(new Question("Dans le dictionnaire que veut dire 'n. m. ' ?", "français", "Nom masculin", "Neige magnique","Nomination masculine"));
        mDb.getAppDatabase().questionDao().insert(new Question("Combien de personnes parlent dans un monologue ?", "français", "1", "2","3"));
        mDb.getAppDatabase().questionDao().insert(new Question("Quel est le féminin de : rédacteur ?", "français", "Rédactrice", "Rédactionniste","Rédaction"));
        mDb.getAppDatabase().questionDao().insert(new Question("Quel verbe se finit par un x à la première personne du singulier ?", "français", "Voir", "Choir","Vouloir"));
        mDb.getAppDatabase().questionDao().insert(new Question("Quel mot a le sens le plus fort ?", "français", "épouvante", "Peur","Crainte"));
        mDb.getAppDatabase().questionDao().insert(new Question("Qui dessine les dessins d'un livre ?", "français", "Illustrateur", "Auteur","Narrateur"));
        mDb.getAppDatabase().questionDao().insert(new Question("Que veut dire P-S ?", "français", "Post-scriptum", "Page significative","Patronyme supplémentaire"));
        mDb.getAppDatabase().questionDao().insert(new Question("Le contraire s'appelle aussi :", "français", "Antonyme", "Patronyme","Synonyme"));

    }
}