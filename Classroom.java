package com.itai.school.dto;

import java.util.Arrays;

public class Classroom {
    private String className;
    private Teacher teacher;
    private Student[] students;

    public Classroom(String className, Teacher teacher) {
        this.className = className;
        this.teacher = teacher;
        this.students = new Student[15];
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] == null) {
                this.students[i] = student;
                return;
            }
        }
    }

    public void addGrade(int studentId, Grade grade) {
        for (int i = 0; i < students.length; i++) {
            if (this.students[i].getStudentId() == studentId) {
                this.students[i].addGrades(grade);
            }
        }
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "className='" + className + '\'' +
                ", teacher=" + teacher +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
