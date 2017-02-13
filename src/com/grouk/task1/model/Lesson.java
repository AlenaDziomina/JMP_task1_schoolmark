package com.grouk.task1.model;

/**
 * Created by Alena on 12.02.2017.
 */
public class Lesson {
    private Integer id;
    private Integer day;
    private Integer number;
    private Integer subjectId;

    public Lesson(Integer id, Integer day, Integer number, Integer subjectId) {
        this.id = id;
        this.day = day;
        this.number = number;
        this.subjectId = subjectId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
