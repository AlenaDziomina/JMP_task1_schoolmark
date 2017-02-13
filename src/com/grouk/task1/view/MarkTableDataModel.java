package com.grouk.task1.view;

import com.grouk.task1.model.Mark;
import com.grouk.task1.util.DateConverter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

/**
 * Created by Alena on 13.02.2017.
 */
public class MarkTableDataModel {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleObjectProperty<LocalDate> date = new SimpleObjectProperty<LocalDate>();
    private final SimpleIntegerProperty subjectId = new SimpleIntegerProperty();
    private final SimpleStringProperty subject = new SimpleStringProperty();
    private final SimpleIntegerProperty mark = new SimpleIntegerProperty();
    private final SimpleStringProperty description = new SimpleStringProperty();

    public MarkTableDataModel(Mark mark) {
        setId(mark.getId());
        LocalDate localDate = DateConverter.convert(mark.getDate());
        setDate(localDate);
        setSubjectId(mark.getSubjectId());
        setMark(mark.getMark());
        setDescription(mark.getDescription());
    }

    public MarkTableDataModel(Integer id, LocalDate date, Integer subjId, String subject, Integer mark,
                              String description) {
        setId(id);
        setDate(date);
        setSubjectId(subjId);
        setSubject(subject);
        setMark(mark);
        setDescription(description);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public int getSubjectId() {
        return subjectId.get();
    }

    public void setSubjectId(int subjectId) {
        this.subjectId.set(subjectId);
    }

    public SimpleIntegerProperty subjectIdProperty() {
        return subjectId;
    }

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public SimpleStringProperty subjectProperty() {
        return subject;
    }

    public int getMark() {
        return mark.get();
    }

    public void setMark(int mark) {
        this.mark.set(mark);
    }

    public SimpleIntegerProperty markProperty() {
        return mark;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }
}
