package com.grouk.task1.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Alena on 11.02.2017.
 */
public class TableDataModel<T extends TableDataModelEntity> {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();

    public TableDataModel(Integer id, String name) {
        setId(id);
        setName(name);
    }

    public TableDataModel(T entity) {
        setId(entity.getId());
        setName(entity.getName());
    }

    public TableDataModel() {

    }

    public Integer getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }
}
