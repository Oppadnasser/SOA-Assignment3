package org.example.app.Models;

public class KnownLanguage {
    private String LanguageName;
    private int ScoreOutOf100;
    KnownLanguage(){};

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
