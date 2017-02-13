package com.grouk.task1.dao;

import com.grouk.task1.model.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alena on 12.02.2017.
 */
public class SubjectDao extends AbstractDao<Subject> {
    private static final String SQL_GET = "Select * from SUBJECT where CHILD_ID = ?;";
    private static final String SQL_CREATE = "Insert into SUBJECT (SUBJECT_NAME, CHILD_ID) values (?, ?);";
    private static final String SQL_DELETE = "Delete from SUBJECT WHERE ID_SUBJECT = ?;";
    private static final String SQL_UPDATE = "Update SUBJECT set SUBJECT_NAME = ? where ID_SUBJECT = ?;";

    public List<Subject> getSubjectListByChildId(Integer childId) {
        List<Object> parameters = Collections.singletonList(childId);
        return load(SQL_GET, parameters, rs -> new Subject(rs.getInt("ID_SUBJECT"), rs.getString("SUBJECT_NAME")));
    }

    public Integer addSubject(String name, Integer childId) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(name);
        parameters.add(childId);
        return create(SQL_CREATE, parameters);
    }

    public void deleteSubject(Integer id) {
        List<Object> parameters = Collections.singletonList(id);
        delete(SQL_DELETE, parameters);
    }

    public void updateSubject(String name, Integer id) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(name);
        parameters.add(id);
        update(SQL_UPDATE, parameters);
    }
}
