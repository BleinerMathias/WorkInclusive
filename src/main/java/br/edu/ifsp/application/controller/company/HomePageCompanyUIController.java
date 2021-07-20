package br.edu.ifsp.application.controller.company;


import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.company.Company;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.time.LocalDate;

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
    private TableView<Company> tableView;

    @FXML
    private TableColumn<Company, Integer> cId;

    @FXML
    private TableColumn<Company, LocalDate> cDateTime;

    @FXML
    private TableColumn<Company, String> cAddress;

    @FXML
    private TableColumn<Company, String> cCandidate;

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


}
