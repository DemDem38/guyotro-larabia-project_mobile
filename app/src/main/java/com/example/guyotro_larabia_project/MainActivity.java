package com.example.guyotro_larabia_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.example.guyotro_larabia_project.db.DatabaseClient;
import com.example.guyotro_larabia_project.db.User;

public class MainActivity extends AppCompatActivity {

    //
    private static final int REQUEST_CODE_ADD = 0;

    // DATA
    private DatabaseClient mDb;
    private UserAdapter adapter;

    // VIEW
    private Button buttonAdd;
    private ListView listTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        listTask = findViewById(R.id.listUser);
        buttonAdd = findViewById(R.id.button_add);

        // Lier l'adapter au listView
        adapter = new UserAdapter(this, new ArrayList<User>());
        listTask.setAdapter(adapter);

        // Ajouter un événement au bouton d'ajout
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD);
            }
        });

        // EXEMPLE : Ajouter un événement click à la listView
        listTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Récupération de la tâche cliquée à l'aide de l'adapter
                User user = adapter.getItem(position);

                // Navigation vers la fenêtre de choix de la matière
                Intent intent = new Intent(MainActivity.this, ChoixMatiereActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getTasks() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetTasks extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = mDb.getAppDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                // Mettre à jour l'adapter avec la liste de taches
                adapter.clear();
                adapter.addAll(users);

                // Now, notify the adapter of the change in source
                adapter.notifyDataSetChanged();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        // Création d'un objet de type GetTasks et execution de la demande asynchrone
        GetTasks gt = new GetTasks();
        gt.execute();
    }


    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des taches
        getTasks();

    }

    public void addUser(View view) {

    }

    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {
//
//            // Mise à jour des taches
//            getTasks();
//        }
//    }
}