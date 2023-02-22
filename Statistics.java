package com.itai.school.statistics;

import com.itai.school.dto.Classroom;
import com.itai.school.dto.School;
import com.itai.school.enums.Profession;

public class Statistics {

    public static void runAllStatistics(School school) {
        System.out.println("The average grade of all student in the school is "+getAverageOfGradesPerSchool(school));
        System.out.println(getNumberOfStudentAtARangeOfAgesAndTheirGradeAverage(school));

    }

    public static float getAverageOfGradesPerProfession(Profession profession, School school) {
        int sumOfAllGrades = 0;
        int studentCounter = 0;
        for (int i = 0; i < school.getClassrooms().length; i++) {
            for (int j = 0; j < school.getClassrooms()[i].getStudents().length; j++) {
                for (int k = 0; k < school.getClassrooms()[i].getStudents()[j].getGrades().length; k++) {
                    if (school.getClassrooms()[i].getStudents()[j].getGrades()[k].getProfession() == profession) {
                        sumOfAllGrades = sumOfAllGrades + school.getClassrooms()[i].getStudents()[j].getGrades()[k].getGradeScore();
                        studentCounter++;
                    }

                }

            }

        }
        if (studentCounter==0){
            return 1;
        }
        return sumOfAllGrades / studentCounter;
    }

    public static float getAverageOfGradesPerClassroom(Classroom classroom) {
        int sumOfAllGradesPerClassroom = 0;
        int studentsCounter = 0;
        for (int i = 0; i < classroom.getStudents().length; i++) {
            for (int j = 0; j < classroom.getStudents()[i].getGrades().length; j++) {
                sumOfAllGradesPerClassroom = sumOfAllGradesPerClassroom + classroom.getStudents()[i].getGrades()[j].getGradeScore();
                studentsCounter++;
            }
        }
        return sumOfAllGradesPerClassroom / studentsCounter;
    }

    public static float getAverageOfGradesPerSchool(School school) {
        int sumOfAllGrades = 0;
        int studentsCounter = 0;
        for (int i = 0; i < school.getClassrooms().length; i++) {
            for (int j = 0; j < school.getClassrooms()[i].getStudents().length; j++) {
                for (int k = 0; k < school.getClassrooms()[i].getStudents()[j].getGrades().length; k++) {
                    sumOfAllGrades = sumOfAllGrades + school.getClassrooms()[i].getStudents()[j].getGrades()[k].getGradeScore();
                    studentsCounter++;
                }

            }

        }
        return sumOfAllGrades / studentsCounter;
    }

    public static float getNumberOfStudentAtARangeOfAgesAndTheirGradeAverage(School school) {
        float gradeOfStudentsAtDesiredAge = 0;
        int studentCounter = 0;
        for (int i = 0; i < school.getClassrooms().length; i++) {
            for (int j = 0; j < school.getClassrooms()[i].getStudents().length; j++) {
                for (int k = 0; k < school.getClassrooms()[i].getStudents()[j].getGrades().length; k++) {
                    if (school.getClassrooms()[i].getStudents()[j].getAge() > 20 && school.getClassrooms()[i].getStudents()[j].getAge() < 30) {
                        gradeOfStudentsAtDesiredAge = gradeOfStudentsAtDesiredAge + school.getClassrooms()[i].getStudents()[j].getGrades()[k].getGradeScore();
                        studentCounter++;
                    }
                }
            }

        }
        return gradeOfStudentsAtDesiredAge / studentCounter;
    }


}
