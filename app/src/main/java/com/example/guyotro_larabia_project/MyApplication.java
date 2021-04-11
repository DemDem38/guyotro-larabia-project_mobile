package com.example.guyotro_larabia_project;

import android.app.Application;

public class MyApplication extends Application {
    private int meilleurScoreCultureFr;
    private int meilleurScoreCultureGeo;
    private int meilleurScoreCultureHist;
    private int meilleurScoreMathAdditions;
    private int meilleurScoreMathSoustration;
    private int meilleurScoreMathMutiplication;
    private int meilleurScoreMathDivision;

    public int getMeilleurScoreCultureFr() {
        return meilleurScoreCultureFr;
    }

    public void setMeilleurScoreCultureFr(int meilleurScoreCultureFr) {
        this.meilleurScoreCultureFr = meilleurScoreCultureFr;
    }

    public int getMeilleurScoreMathAdditions() {
        return meilleurScoreMathAdditions;
    }
    public void setMeilleurScoreMathAdditions(int meilleurScoreMathAdditions) {
        this.meilleurScoreMathAdditions = meilleurScoreMathAdditions;
    }

    public int getMeilleurScoreMathSoustration() {
        return meilleurScoreMathSoustration;
    }
    public void setMeilleurScoreMathSoustration(int meilleurScoreMathSoustration) {
        this.meilleurScoreMathSoustration = meilleurScoreMathSoustration;
    }

    public int getMeilleurScoreMathMutiplication() {
        return meilleurScoreMathMutiplication;
    }

    public void setMeilleurScoreMathMutiplication(int meilleurScoreMathMutiplication) {
        this.meilleurScoreMathMutiplication = meilleurScoreMathMutiplication;
    }

    public int getMeilleurScoreCultureGeo() {
        return meilleurScoreCultureGeo;
    }

    public void setMeilleurScoreCultureGeo(int meilleurScoreCultureGeo) {
        this.meilleurScoreCultureGeo = meilleurScoreCultureGeo;
    }

    public int getMeilleurScoreCultureHist() {
        return meilleurScoreCultureHist;
    }

    public void setMeilleurScoreCultureHist(int meilleurScoreCultureHist) {
        this.meilleurScoreCultureHist = meilleurScoreCultureHist;
    }

    public int getMeilleurScoreMathDivision() {
        return meilleurScoreMathDivision;
    }

    public void setMeilleurScoreMathDivision(int meilleurScoreMathDivision) {
        this.meilleurScoreMathDivision = meilleurScoreMathDivision;
    }
}
