package com.example.guyotro_larabia_project.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Question implements Serializable {

    public Question(String question, String tag, String reponseTrue, String reponseFalse1, String reponseFalse2){
        this.question = question;
        this.tag = tag;
        this.reponseTrue = reponseTrue;
        this.reponseFalse1 = reponseFalse1;
        this.reponseFalse2 = reponseFalse2;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "question")
    private String question;

    @ColumnInfo(name = "tag")
    private String tag;

    @ColumnInfo(name = "reponseTrue")
    private String reponseTrue;

    @ColumnInfo(name = "reponseFalse1")
    private String reponseFalse1;

    @ColumnInfo(name = "reponseFalse2")
    private String reponseFalse2;


    /*
     * Getters and Setters
     * */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag(){return tag;}

    public void setTag(String tag) {this.tag = tag;}

    public String getQuestion() {return question;}

    public void setQuestion(String question) {this.question = question;}

    public String getReponseTrue() {
        return reponseTrue;
    }

    public void setReponseTrue(String reponseTrue) {this.reponseTrue = reponseTrue;}

    public String getReponseFalse1(){return reponseFalse1;}

    public void setReponseFalse1(String reponseFalse1) {this.reponseFalse1 = reponseFalse1;}

    public String getReponseFalse2(){return reponseFalse2;}

    public void setReponseFalse2(String reponseFalse2) {this.reponseFalse2 = reponseFalse2;}
}