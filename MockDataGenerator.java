package com.itai.school.mockdata;

import com.itai.school.dto.*;
import com.itai.school.enums.Gender;
import com.itai.school.enums.Profession;

import java.util.Random;

public class MockDataGenerator {

    private static String[] classroomNames = {"A", "B", "C", "D", "E", "F", "G"};
    private static String[] maleNames = {"John", "Jack", "Jim", "Patrick", "Tal", "Tim", "Tony", "Mike", "Michael", "David", "Curtis"};
    private static String[] femaleNames = {"Joan", "Jacky", "Jennifer", "Patrice", "Tal", "Tanya", "Torri", "Michelle", "Monica", "Donna", "Karen"};
    private static int i = 0;
    private static int professionPicker = 0;

    public static School generateSchool() {
        School school = new School("Golda");
        fillSchoolWithMockClassrooms(school);
        fillSchoolWithMockStudents(school);
        return school;
    }

    public static Classroom generateClassrooms() {
        String className = generateClassroomName();
        Teacher teacher = generateTeacher();
        return new Classroom(className, teacher);
    }


    public static Teacher generateTeacher() {
        Gender gender = generateGender();
        String name = generatePersonName(gender);
        int age = generateAge();
        Profession profession = generateProfession();
        return new Teacher(name, age, gender, profession);
    }

    private static Profession generateProfession() {
        Random random = new Random();
        return switch (random.nextInt(Profession.values().length)) {
            case 1 -> Profession.MATH;
            case 2 -> Profession.CHEMISTRY;
            case 3 -> Profession.GEOGRAPHY;
            case 4 -> Profession.LITERATURE;
            case 5 -> Profession.PHYSICS;
            default -> Profession.SPORTS;
        };
    }

    public static int generateAge() {
        Random random = new Random();
        return random.nextInt(100) + 20;
    }

    public static String generatePersonName(Gender gender) {
        Random random = new Random();
        if (gender == Gender.FEMALE) {
            int randomNamePicker = random.nextInt(femaleNames.length);
            return femaleNames[randomNamePicker];
        }
        int randomNamePicker = random.nextInt(maleNames.length);
        return maleNames[randomNamePicker];
    }

    public static Gender generateGender() {
        Random rnd = new Random();
        int randomGender = rnd.nextInt(2);
        if (randomGender == 1) {
            return Gender.MALE;
        }
        return Gender.FEMALE;
    }

    public static String generateClassroomName() {
        i++;
        return classroomNames[i];
    }

    public static void fillSchoolWithMockClassrooms(School school) {
        for (int j = 0; j < school.getClassrooms().length; j++) {
            school.addClassrooms(generateClassrooms());
        }
    }

    public static void fillSchoolWithMockStudents(School school) {
        for (int index = 0; index < school.getClassrooms().length; index++) {
            for (int studentIndex = 0; studentIndex < school.getClassrooms()[index].getStudents().length; studentIndex++) {
                Student student = generateStudent();
                for (int j = 0; j < Profession.values().length; j++) {
                    Grade grade = generateGrade();
                    student.addGrades(grade);
                }
                school.addStudents(school.getClassrooms()[index].getClassName(), student);
            }
        }
    }

    public static Student generateStudent() {
        Gender gender = generateGender();
        String name = generatePersonName(gender);
        int age = generateAge();
        int studentId = generateStudentId();
        return new Student(name, studentId, age, gender);
    }

    public static int generateStudentId() {
        i++;
        return i;
    }

    public static Grade generateGrade() {
        int gradeScore = generateRandomGradePerProfession();
        Profession profession = chooseProfession();
        return new Grade(gradeScore, profession);
    }

    public static Profession chooseProfession() {
        professionPicker++;
        return switch (professionPicker) {
            case 1 -> Profession.MATH;
            case 2 -> Profession.CHEMISTRY;
            case 3 -> Profession.GEOGRAPHY;
            case 4 -> Profession.LITERATURE;
            case 5 -> Profession.PHYSICS;
            default -> Profession.SPORTS;
        };
    }

    private static int generateRandomGradePerProfession() {
        Random rnd = new Random();
        return rnd.nextInt(60) + 40;

    }
}
