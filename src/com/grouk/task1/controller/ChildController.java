package com.grouk.task1.controller;

import com.grouk.task1.service.ChildService;
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
 * Created by Alena on 11.02.2017.
 */
public class ChildController implements Initializable {
    private static final Logger LOGGER = Logger.getLogger(ChildController.class);

    @FXML
    private TableView<TableDataModel> chdList;

    @FXML
    private TableColumn<TableDataModel, Integer> chdId;

    @FXML
    private TableColumn<TableDataModel, String> chdName;

    @FXML
    private TextField nameFld;

    private ObservableList<TableDataModel> data;

    private ChildService childService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        childService = ChildService.getInstance();
        data = chdList.getItems();

        chdId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        chdName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        data.setAll(childService.getList());
    }

    @FXML
    private void onDeleteButtonClick() {
        try {
            TableDataModel child = getSelectedChild();
            if (child != null) {
                Integer id = child.getId();
                childService.delete(id);
                data.remove(child);
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
                Integer id = childService.save(newName);

                TableDataModel newChild = new TableDataModel(id, newName);
                data.add(newChild);
            }
        } catch (Exception e) {
            logException(e);
        }
    }

    @FXML
    private void onUpdateButtonClick() {
        try {
            TableDataModel child = getSelectedChild();
            String newName = nameFld.getText();
            if (child != null && newName != null && !newName.isEmpty()) {
                Integer id = child.getId();
                childService.update(id, newName);
                child.setName(newName);
                chdList.refresh();
            }
        } catch (Exception e) {
            logException(e);
        }
    }

    @FXML
    private void onTableClick() {
        try {
            TableDataModel child = getSelectedChild();
            String newName = null;
            if (child != null) {
                newName = child.getName();
            }
            nameFld.setText(newName);
        } catch (Exception e) {
            logException(e);
        }
    }

    private TableDataModel getSelectedChild() {
        return chdList.getSelectionModel().getSelectedItem();
    }

    private void logException(Exception e) {
        LOGGER.error(e.getMessage(), e);
    }
}

