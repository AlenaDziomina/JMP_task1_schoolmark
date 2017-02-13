package com.grouk.task1.model;

import java.util.Date;

/**
 * Created by Alena on 12.02.2017.
 */
public class Mark {
    private Integer id;
    private Date date;
    private Integer subjectId;
    private Integer mark;
    private String description;

    public Mark(Integer id, Date date, Integer subjectId, Integer mark, String description) {
        this.id = id;
        this.date = date;
        this.subjectId = subjectId;
        this.mark = mark;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
