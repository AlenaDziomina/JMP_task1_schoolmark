package com.grouk.task1.dao;

import com.grouk.task1.model.Child;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alena on 11.02.2017.
 */
public class ChildDao extends AbstractDao<Child> {
    private static final String SQL_GET = "Select * from CHILD;";
    private static final String SQL_CREATE = "Insert into CHILD (CHILD_NAME) values (?);";
    private static final String SQL_DELETE = "Delete from CHILD WHERE ID_CHILD = ?;";
    private static final String SQL_UPDATE = "Update CHILD set CHILD_NAME = ? where ID_CHILD = ?;";

    public List<Child> getChildList() {
        return load(SQL_GET, null, rs -> new Child(rs.getInt("ID_CHILD"), rs.getString("CHILD_NAME")));
    }

    public Integer addChild(String name) {
        List<Object> parameters = Collections.singletonList(name);
        return create(SQL_CREATE, parameters);
    }

    public void deleteChild(Integer id) {
        List<Object> parameters = Collections.singletonList(id);
        delete(SQL_DELETE, parameters);
    }

    public void updateChild(String name, Integer id) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(name);
        parameters.add(id);
        update(SQL_UPDATE, parameters);
    }
}
