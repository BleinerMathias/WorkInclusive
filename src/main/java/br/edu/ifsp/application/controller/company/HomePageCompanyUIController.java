package br.edu.ifsp.application.controller.company;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.interview.Interview;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static br.edu.ifsp.application.main.Main.findInterviewUseCase;

public class HomePageCompanyUIController {

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
    private TableColumn<Interview, String> cAddress;

    @FXML
    private TableColumn<Interview, String> cCandidate;

    private ObservableList<Interview> tableData;

    private Interview interview;

    public void initialPage(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("company/HomePageCompany");
    }

    public void Account(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("company/AccountCompany");
    }

    public void vacancy(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("company/ListVacancyCompanyPage");
    }

    public void interviews(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("company/AcceptInterviewsPage");
    }

    public void config(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("company/ConfigPage");
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
        cAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        cCandidate.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    private void bindColumnsToValueSources() {
        tableData = FXCollections.observableArrayList();
        tableView.setItems(tableData);
    }

    private void loadDataAndShow() {
        //List<Interview> interviewList = findInterviewUseCase  ;
        tableData.clear();
        //tableData.addAll(interviewList);
    }


}
