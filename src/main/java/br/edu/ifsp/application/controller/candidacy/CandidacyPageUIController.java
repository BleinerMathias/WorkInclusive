package br.edu.ifsp.application.controller.candidacy;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class CandidacyPageUIController {

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
    private TableView<User> tableView;

    @FXML
    private TableColumn<Candidacy, Integer> cId;

    @FXML
    private TableColumn<Candidacy, String> cVacancy;

    @FXML
    private TableColumn<Candidacy, String> cCandidate;

    @FXML
    private TableColumn<Candidacy, String> cStatus;

    @FXML
    private Button btnDecline;

    @FXML
    private Button btnAccept;


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
