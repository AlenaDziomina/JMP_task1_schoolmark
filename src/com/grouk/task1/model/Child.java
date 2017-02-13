package com.grouk.task1.model;

import com.grouk.task1.view.TableDataModelEntity;

/**
 * Created by Alena on 11.02.2017.
 */
public class Child implements TableDataModelEntity {
    private Integer id;
    private String name;

    public Child(Integer id, String name) {
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
