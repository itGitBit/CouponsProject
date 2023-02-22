package com.itai.school.dto;

import com.itai.school.enums.Gender;
import com.itai.school.enums.Profession;

public class Teacher extends Person{
    private Profession profession;

    public Teacher(String name, int age, Gender gender, Profession profession) {
        super(name, age, gender);
        this.profession = profession;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "profession=" + profession +
                '}'+super.toString();
    }
}
