package com.itai.school.dto;

import com.itai.school.enums.Gender;

import java.util.Arrays;

public class Student extends Person {
    private Grade[] grades;
    //1 = MATH,  2= CHEMISTRY, 3= GEOGRAPHY, 4= LITERATURE, 5= PHYSICS, 6 = SPORTS
    private int studentId;

    public Student(String name, int studentId, int age, Gender gender) {
        super(name, age, gender);
        this.grades = new Grade[6];
        this.studentId = studentId;
    }

    public Grade[] getGrades() {
        return grades;
    }

    public int getStudentId() {
        return studentId;
    }

    public void addGrades(Grade grade) {
        for (int i = 0; i < this.grades.length; i++) {
            if (this.grades[i] == null) {
                this.grades[i] = grade;
                return;
                //כמעט שכחתי RETURN אבל אז נזכרתי את השיעור שבו אבי צעק!!! RETURN או שכל הכיתה תהיה אותו תלמיד!!
            }
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "grades=" + Arrays.toString(grades) +
                ", studentId=" + studentId +
                '}' + super.toString();
    }
}
