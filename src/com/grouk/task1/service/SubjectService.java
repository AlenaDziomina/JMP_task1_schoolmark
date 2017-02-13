package com.grouk.task1.service;

import com.grouk.task1.dao.SubjectDao;
import com.grouk.task1.model.Subject;
import com.grouk.task1.view.TableDataModel;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alena on 12.02.2017.
 */
public class SubjectService {
    private static final SubjectService SERVICE;
    private static final SubjectDao SUBJECT_DAO;

    static {
        SERVICE = new SubjectService();
        SUBJECT_DAO = new SubjectDao();
    }

    private SubjectService() {
    }

    public static SubjectService getInstance() {
        return SERVICE;
    }

    public Collection<TableDataModel> getListByChildId(Integer childId) {
        List<Subject> subjectList = SUBJECT_DAO.getSubjectListByChildId(childId);
        return subjectList.stream().map(subject -> new TableDataModel(subject)).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        SUBJECT_DAO.deleteSubject(id);
    }

    public Integer save(String name, Integer childId) {
        return SUBJECT_DAO.addSubject(name, childId);
    }

    public void update(Integer id, String name) {
        SUBJECT_DAO.updateSubject(name, id);
    }

}
