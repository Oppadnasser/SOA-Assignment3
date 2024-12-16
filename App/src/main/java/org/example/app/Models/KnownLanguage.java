package org.example.app.Models;

import java.util.Scanner;

public class KnownLanguage {
    private String LanguageName;
    private int ScoreOutOf100;
    public KnownLanguage(){};
    public KnownLanguage(String name, int score){
        LanguageName = name;
        ScoreOutOf100 = score;
    }

    // Getters and Setters
    public String getLanguageName() {
        return LanguageName;
    }

    public void setLanguageName(String languageName) {
        LanguageName = languageName;
    }

    public int getScoreOutOf100() {
        return ScoreOutOf100;
    }

    public void setScoreOutOf100(int scoreOutOf100) {
        ScoreOutOf100 = scoreOutOf100;
    }
}
