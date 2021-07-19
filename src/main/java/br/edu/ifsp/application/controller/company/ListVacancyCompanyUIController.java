package br.edu.ifsp.application.controller.company;

import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

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

    public void initialPage(ActionEvent actionEvent) throws IOException {
        App.setRoot("HomePageCompany");
    }

    public void Account(ActionEvent actionEvent) throws IOException {
        App.setRoot("AccountCompany");
    }

    public void vacancy(ActionEvent actionEvent) throws IOException {
        App.setRoot("ListVacancyCompanyPage");
    }

    public void interviews(ActionEvent actionEvent) throws IOException {
        App.setRoot("AcceptInterviewsPage");
    }

    public void config(ActionEvent actionEvent) throws IOException {
        App.setRoot("ConfigPage");
    }
}
