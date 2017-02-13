package com.grouk.task1.model;

import com.grouk.task1.view.TableDataModelEntity;

/**
 * Created by Alena on 12.02.2017.
 */
public class Subject implements TableDataModelEntity {
    private Integer id;
    private String name;

    public Subject() {

    }

    public Subject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
