package com.spartaglobal.finalweek.pages.coursePages;

import java.time.LocalDate;

public class CoursePageObject {
    private String courseName, trainerID, discipline, typeOfCourse, location;
    private int numberOfTrainers, trainerStartWeek, trainerEndWeek, row;
    private LocalDate startDate;

    public CoursePageObject(){

    }

    public CoursePageObject(CoursePageObject coursePageObject){
        courseName = "Course Name";
        numberOfTrainers = 1;
        trainerID = "JarJar Binks";
        row = 1;
        trainerStartWeek = 1;
        trainerEndWeek = 8;
        discipline = "Java";
        typeOfCourse = "Technology";
        location = "Coruscant";
        startDate = LocalDate.now();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(String trainerID) {
        this.trainerID = trainerID;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getTypeOfCourse() {
        return typeOfCourse;
    }

    public void setTypeOfCourse(String typeOfCourse) {
        this.typeOfCourse = typeOfCourse;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfTrainers() {
        return numberOfTrainers;
    }

    public void setNumberOfTrainers(int numberOfTrainers) {
        this.numberOfTrainers = numberOfTrainers;
    }

    public int getTrainerStartWeek() {
        return trainerStartWeek;
    }

    public void setTrainerStartWeek(int trainerStartWeek) {
        this.trainerStartWeek = trainerStartWeek;
    }

    public int getTrainerEndWeek() {
        return trainerEndWeek;
    }

    public void setTrainerEndWeek(int trainerEndWeek) {
        this.trainerEndWeek = trainerEndWeek;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
