package br.edu.ifsp.application.controller.company;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

import static br.edu.ifsp.application.main.Main.findVacancyUseCase;

public class ListVacancyCompanyUIController {

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
    private TableView<Vacancy> tableView;

    @FXML
    private TableColumn<Vacancy, Integer> cId;

    @FXML
    private TableColumn<Vacancy, String> cVacancy;

    @FXML
    private TableColumn<Vacancy, String> cHierarch;

    @FXML
    private TableColumn<Vacancy, Double> cSalary;

    @FXML
    private TableColumn<Vacancy,String> cStatus;

    @FXML
    private Button btnNewVacancy;

    private ObservableList<Vacancy> tableData;

    private Vacancy vacancy;

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
        cVacancy.setCellValueFactory(new PropertyValueFactory<>("name"));
        cHierarch.setCellValueFactory(new PropertyValueFactory<>("hierarchy"));
        cSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        cStatus.setCellValueFactory(new PropertyValueFactory<>("label"));
    }

    private void bindColumnsToValueSources() {
        tableData = FXCollections.observableArrayList();
        tableView.setItems(tableData);
    }

    private void loadDataAndShow() {
        List<Vacancy> vacancyList = findVacancyUseCase.findAll();
        tableData.clear();
        tableData.addAll(vacancyList);

    }

    public void addNewVacancy(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("vacancy/Vacancy");
    }
}
