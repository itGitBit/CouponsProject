package com.itai.school.dto;

import java.util.Arrays;

public class School {
    private Classroom[] classrooms;
    private String schoolName;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.classrooms = new Classroom[5];
    }

    public Classroom[] getClassrooms() {
        return classrooms;
    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void addClassrooms(Classroom classroom) {
        for (int i = 0; i < classrooms.length; i++) {
            if (this.classrooms[i] == null) {
                this.classrooms[i] = classroom;
                return;
            }
        }
    }

    public void addStudents(String classroomName, Student student) {
        for (int i = 0; i < this.classrooms.length; i++) {
            if (classroomName == this.getClassrooms()[i].getClassName()) {
                classrooms[i].addStudents(student);
            }
        }
    }

    @Override
    public String toString() {
        return "School{" +
                "classrooms=" + Arrays.toString(classrooms) +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
