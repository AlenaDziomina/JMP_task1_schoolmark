package com.grouk.task1.dao;

import com.grouk.task1.model.Mark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Alena on 12.02.2017.
 */
public class MarkDao extends AbstractDao<Mark> {
    private static final String SQL_GET = "Select * from MARK where CHILD_ID = ?;";
    private static final String SQL_CREATE = "Insert into MARK (CHILD_ID, SUBJECT_ID, DATE, MARK, DESCRIPTION) values" +
            " (?, ?, ?, ?, ?);";
    private static final String SQL_DELETE = "Delete from MARK WHERE ID_MARK = ?;";
    private static final String SQL_UPDATE = "Update MARK set SUBJECT_ID = ?, DATE = ?, MARK = ?, DESCRIPTION = ? " +
            "where ID_MARK = ?;";

    public List<Mark> getMarkListByChildId(Integer childId) {
        List<Object> parameters = Collections.singletonList(childId);
        return load(SQL_GET, parameters, rs -> new Mark(rs.getInt("ID_MARK"), new Date(rs.getDate("DATE").getTime()),
                rs.getInt("SUBJECT_ID"), rs.getInt("MARK"), rs.getString("DESCRIPTION")));
    }

    public Integer addMark(Integer childId, Date date, Integer subjectId, Integer mark, String description) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(childId);
        parameters.add(subjectId);
        parameters.add(date);
        parameters.add(mark);
        parameters.add(description);
        return create(SQL_CREATE, parameters);
    }

    public void deleteMark(Integer id) {
        List<Object> parameters = Collections.singletonList(id);
        delete(SQL_DELETE, parameters);
    }

    public void updateMark(Integer id, Date date, Integer subjectId, Integer mark, String description) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(subjectId);
        parameters.add(date);
        parameters.add(mark);
        parameters.add(description);
        parameters.add(id);
        update(SQL_UPDATE, parameters);
    }
}
