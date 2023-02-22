package com.itai.school.dto;

import com.itai.school.enums.Profession;

public class Grade {
   private int gradeScore;
    private Profession profession;
    //קונסטרקטור לקלאס כדי שיהיה ניתן לקרוא לו מבחוץ
    public Grade(int gradeScore, Profession profession) {
        this.gradeScore = gradeScore;
        this.profession = profession;
    }
//עשיתי GETTER ו SETTER לשניהם כי מקצועות וציונים הם דברים שמשתנים.
    public void setGradeScore(int gradeScore) {
        this.gradeScore = gradeScore;
    }

    public int getGradeScore() {
        return gradeScore;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Profession getProfession() {
        return profession;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeScore=" + gradeScore +
                ", profession=" + profession +
                '}';
    }
}
