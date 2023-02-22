package com.itai.school;

import com.itai.school.dto.School;
import com.itai.school.enums.Profession;
import com.itai.school.mockdata.MockDataGenerator;
import com.itai.school.statistics.Staistics;

public class Main {
    public static void main(String[] args) {
        School school = MockDataGenerator.generateSchool();
        System.out.println(school.toString());
        Staistics.runAllStatistics(school);
        System.out.println(Staistics.getAverageOfGradesPerProfession(Profession.CHEMISTRY,school));
    }

}
