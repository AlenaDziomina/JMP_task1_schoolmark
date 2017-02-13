package com.grouk.task1.service;

import com.grouk.task1.dao.ChildDao;
import com.grouk.task1.model.Child;
import com.grouk.task1.view.TableDataModel;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alena on 11.02.2017.
 */
public class ChildService {

    private static final ChildService SERVICE;
    private static final ChildDao CHILD_DAO;

    static {
        SERVICE = new ChildService();
        CHILD_DAO = new ChildDao();
    }

    private ChildService() {
    }

    public static ChildService getInstance() {
        return SERVICE;
    }

    public Collection<TableDataModel> getList() {
        List<Child> childList = CHILD_DAO.getChildList();
        return childList.stream().map(child -> new TableDataModel(child)).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        CHILD_DAO.deleteChild(id);
    }

    public Integer save(String name) {
        return CHILD_DAO.addChild(name);
    }

    public void update(Integer id, String name) {
        CHILD_DAO.updateChild(name, id);
    }

}
