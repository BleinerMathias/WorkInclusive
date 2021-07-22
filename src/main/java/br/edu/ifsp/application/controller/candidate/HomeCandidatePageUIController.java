package br.edu.ifsp.application.controller.candidate;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.interview.Interview;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class HomeCandidatePageUIController {

    @FXML
    private Button btnhome;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnVacany;

    @FXML
    private Button btnConfig;

    @FXML
    private TableView<Interview> tableView;

    @FXML
    private TableColumn<Interview, Integer> cId;

    @FXML
    private TableColumn<Interview, LocalDate> cDateTime;

    @FXML
    private TableColumn<Interview, String> cAddress;

    @FXML
    private TableColumn<Interview, Integer> cCompany;

    private ObservableList<Interview> tableData;


    @FXML
    private void initialize(){
        bindTableViewToItemsList();
        bindColumnsToValueSources();
        loadDataAndShow();
    }

    public void initialPage(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("HomePageCandidate");
    }

    public void Account(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("AccountCandidate");
    }

    public void vacancy(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MathVacancyPage");
    }

    public void config(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("ConfigPage");
    }



    private void bindTableViewToItemsList() {
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cDateTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        cAddress.setCellValueFactory(new PropertyValueFactory<>("id"));
        cCompany.setCellValueFactory(new PropertyValueFactory<>("company_id"));
    }

    private void bindColumnsToValueSources() {
        tableData = FXCollections.observableArrayList();
        tableView.setItems(tableData);
    }

    private void loadDataAndShow() {
        //List<Interview> interviewList ;
        tableData.clear();
        //tableData.addAll(interviewList);
    }


}