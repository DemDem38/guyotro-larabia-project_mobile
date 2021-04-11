package com.example.guyotro_larabia_project.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

public class DatabaseClient {

    // Instance unique permettant de faire le lien avec la base de données
    private static DatabaseClient instance;

    // Objet représentant la base de données de votre application
    private AppDatabase appDatabase;

    // Constructeur
    private DatabaseClient(final Context context) {

        // Créer l'objet représentant la base de données de votre application
        // à l'aide du "Room database builder"
        // Ecole42 est le nom de la base de données
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "Ecole42").addCallback(roomDatabaseCallback).build();

        ////////// REMPLIR LA BD à la première création à l'aide de l'objet roomDatabaseCallback
        // Ajout de la méthode addCallback permettant de populate (remplir) la base de données à sa création
        //appDatabase = Room.databaseBuilder(context, AppDatabase.class, "MyToDos").addCallback(roomDatabaseCallback).build();
    }

    // Méthode statique
    // Retourne l'instance de l'objet DatabaseClient
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    // Retourne l'objet représentant la base de données de votre application
    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    // Objet permettant de populate (remplir) la base de données à sa création
    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        // Called when the database is created for the first time.
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //valeur de l'utilisateur anonyme
            db.execSQL("INSERT INTO user (nom, prenom ) VALUES(\"Anonyme\", \"\");");
            //Question de français
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Comment écrit-on 'retrouver' dans la phrase : Lucie veut ' ? ' son chapeau.\", \"français\", \"Retrouver\", \"Retrouvé\",\"Retrouvée\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Dans le dictionnaire que veut dire 'n. m. ' ?\", \"français\", \"Nom masculin\", \"Neige magnique\",\"Nomination masculine\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Combien de personnes parlent dans un monologue ?\", \"français\", \"1\", \"2\",\"3\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Quel est le féminin de : rédacteur ?\", \"français\", \"Rédactrice\", \"Rédactionniste\",\"Rédaction\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Quel verbe se finit par un x à la première personne du singulier ?\", \"français\", \"Voir\", \"Choir\",\"Vouloir\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Quel mot a le sens le plus fort ?\", \"français\", \"épouvante\", \"Peur\",\"Crainte\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Qui dessine les dessins d'un livre ?\", \"français\", \"Illustrateur\", \"Auteur\",\"Narrateur\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Que veut dire P-S ?\", \"français\", \"Post-scriptum\", \"Page significative\",\"Patronyme supplémentaire\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Le contraire s'appelle aussi :\", \"français\", \"Antonyme\",\"Patronyme\",\"Synonyme\")");
            //Question de géographie
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"“Une ligne imaginaire tracée autour de la Terre, la séparant en deux parties égales.” De quoi s'agit-il ?\", \"geographie\", \"L'équateur\",\"L'hémisphère\",\"Le tropique du cancer\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Quel pays appelle-t-on “Pays du soleil levant” ?\", \"geographie\", \"Le Japon\", \"La Chine\",\"Le Vietnam\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Quel est le plus petit continent ?\", \"geographie\", \"L'Océanie\", \"L'Europe\",\"L'Afrique\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Lequel de ces océans est le plus grand du monde ?\", \"geographie\", \"Océan Pacifique\", \"Océan Atlantique\",\"Océan Indien\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Le Mont-Blanc mesure :\", \"geographie\", \"4 807 mètres\", \"2 105 mètres\n\",\"3 478 mètres\n\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Quel océan borde la Réunion ?\", \"geographie\", \"L'Océan Indien\", \"L'Océan Pacifique\",\"L'Océan Atlantique\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Laquelle de ces lignes imaginaires est perpendiculaire à l'équateur ?\", \"geographie\", \"Le Méridien de Greenwich\", \"Le Tropique du Capricorne\",\"Le Tropique du Cancer\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Quelle phrase à propos de Sydney est correcte ?\", \"geographie\", \"C'est la ville la plus peuplée de l'Australie\", \"C'est la capitale de l'Australie\",\"C'est la ville la plus grande du monde\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Quelle langue parlent les habitants du Brésil ?\", \"geographie\", \"Le portugais\", \"L'anglais\",\"L'espagnol\")");
            db.execSQL("INSERT INTO question( question,  tag,  reponseTrue, reponseFalse1, reponseFalse2) VALUES(\"Qu'est ce qu'un archipel ?\", \"geograph ie\", \"Un ensemble d'îles\", \"Un bras de terre dans la mer\",\"Une grande cascade\")");
        }
    };

}
