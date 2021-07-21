package br.edu.ifsp.application.controller.company;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.company.Company;
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

import static br.edu.ifsp.application.main.Main.createCompanyUseCase;

public class AcceptInterviewsPageUIController {

    @FXML
    private Button btnhome;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnVacany;

    @FXML
    private Button btnInterviews;

    @FXML
    private Button btnConfig;

    @FXML
    private TableView<Interview> tableView;

    @FXML
    private TableColumn<Interview, Integer> cId;

    @FXML
    private TableColumn<Interview, LocalDate> cDateTime;

    @FXML
    private TableColumn<Interview, String> cCandidate;

    @FXML
    private TableColumn<Interview, String> cStatus;

    @FXML
    private Button btnDecline;

    @FXML
    private Button btnAccept;

    private ObservableList<Interview> tableData;


    public void initialPage(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("HomePageCompany");
    }

    public void Account(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("AccountCompany");
    }

    public void vacancy(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("ListVacancyCompanyPage");
    }

    public void interviews(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("AcceptInterviewsPage");
    }

    public void config(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("ConfigPage");
    }

    @FXML
    private void initialize(){
        bindTableViewToItemsList();
        bindColumnsToValueSources();
        loadDataAndShow();
    }

    private void bindTableViewToItemsList() {
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cDateTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        cCandidate.setCellValueFactory(new PropertyValueFactory<>("name"));
        cStatus.setCellValueFactory(new PropertyValueFactory<>("label"));
    }

    private void bindColumnsToValueSources() {
        tableData = FXCollections.observableArrayList();
        tableView.setItems(tableData);
    }

    private void loadDataAndShow() {
        //List<Interview> interviewList = ;
        tableData.clear();
        //tableData.addAll(interviewList);
    }

}
