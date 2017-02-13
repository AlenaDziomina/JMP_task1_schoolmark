package com.grouk.task1.controller;

import com.grouk.task1.service.SubjectService;
import com.grouk.task1.view.TableDataModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alena on 12.02.2017.
 */
public class SubjectController implements InitDataController<Integer>, Initializable {
    private static final Logger LOGGER = Logger.getLogger(SubjectController.class);

    @FXML
    private TableView<TableDataModel> sbjList;

    @FXML
    private TableColumn<TableDataModel, Integer> sbjId;

    @FXML
    private TableColumn<TableDataModel, String> sbjName;

    @FXML
    private TextField nameFld;

    @FXML
    private ResourceBundle resources;

    private ObservableList<TableDataModel> data;

    private SubjectService subjectService;

    private Integer childId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subjectService = SubjectService.getInstance();
        data = sbjList.getItems();

        sbjId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        sbjName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    }

    @Override
    public void initData(Integer childId) {
        this.childId = childId;
        data.setAll(subjectService.getListByChildId(childId));
    }

    @FXML
    private void onDeleteButtonClick() {
        try {
            TableDataModel subject = getSelectedSubject();
            if (subject != null) {
                Integer id = subject.getId();
                subjectService.delete(id);
                data.remove(subject);
            }
        } catch (Exception e) {
            logException(e);
        }
    }

    @FXML
    private void onAddButtonClick() {
        try {
            String newName = nameFld.getText();
            if (newName != null && !newName.isEmpty()) {
                Integer id = subjectService.save(newName, childId);

                TableDataModel newSubject = new TableDataModel(id, newName);
                data.add(newSubject);
            }
        } catch (Exception e) {
            logException(e);
        }
    }

    @FXML
    private void onUpdateButtonClick() {
        try {
            TableDataModel subject = getSelectedSubject();
            String newName = nameFld.getText();
            if (subject != null && newName != null && !newName.isEmpty()) {
                Integer id = subject.getId();

                subjectService.update(id, newName);
                subject.setName(newName);
                sbjList.refresh();
            }
        } catch (Exception e) {
            logException(e);
        }
    }

    @FXML
    private void onTableClick() {
        try {
            TableDataModel subject = getSelectedSubject();
            String newName = null;
            if (subject != null) {
                newName = subject.getName();
            }
            nameFld.setText(newName);
        } catch (Exception e) {
            logException(e);
        }
    }

    private TableDataModel getSelectedSubject() {
        return sbjList.getSelectionModel().getSelectedItem();
    }

    private void logException(Exception e) {
        LOGGER.error(e.getMessage(), e);
    }
}
