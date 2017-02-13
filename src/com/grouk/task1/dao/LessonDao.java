package com.grouk.task1.dao;

import com.grouk.task1.model.Lesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alena on 12.02.2017.
 */
public class LessonDao extends AbstractDao<Lesson> {
    private static final String SQL_GET = "Select * from LESSON where CHILD_ID = ?;";
    private static final String SQL_CREATE = "Insert into LESSON (CHILD_ID, SUBJECT_ID, DAY, NUMBER) values (?, ?, ?, ?);";
    private static final String SQL_DELETE = "Delete from LESSON WHERE ID_LESSON = ?;";
    private static final String SQL_UPDATE = "Update LESSON set SUBJECT_ID = ? where ID_LESSON = ?;";

    public List<Lesson> getScheduleByChildId(Integer childId) {
        List<Object> parameters = Collections.singletonList(childId);
        return load(SQL_GET, parameters, rs -> new Lesson(rs.getInt("ID_LESSON"), rs.getInt("DAY"), rs.getInt
                ("NUMBER"), rs.getInt("SUBJECT_ID")));
    }

    public Integer addLesson(Integer childId, Integer subjectId, Integer day, Integer number) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(childId);
        parameters.add(subjectId);
        parameters.add(day);
        parameters.add(number);
        return create(SQL_CREATE, parameters);
    }

    public void deleteLesson(Integer id) {
        List<Object> parameters = Collections.singletonList(id);
        delete(SQL_DELETE, parameters);
    }

    public void updateLesson(Integer subjectId, Integer id) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(subjectId);
        parameters.add(id);
        update(SQL_UPDATE, parameters);
    }
}
