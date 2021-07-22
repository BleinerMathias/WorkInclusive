package br.edu.ifsp.application.controller;


import br.edu.ifsp.application.controller.candidate.AcademicEducationUIController;
import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.entities.vacancy.Hierarchy;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static br.edu.ifsp.application.main.Main.findCompanyUseCase;
import static br.edu.ifsp.application.main.Main.findCandidateUseCase;
public class LoginUIController {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lbUser;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCompany;

    @FXML
    private Button btnCandidate;



    @FXML
    private void initialize(){

    }

    public void createAccountCompany(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("candidate/AccountCandidate");
    }

    public void createAccountCandidate(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("company/AccountCompany");
    }

    public void acessCompany(ActionEvent actionEvent) {
        System.out.println(findCompanyUseCase.findByLogin(txtUsername.getText(), txtPassword.getText()));
    }

    public void accessCandidate(ActionEvent actionEvent) throws IOException {

        WindowLoader.setRoot("candidate/HomePageCandidate");
        AcademicEducationUIController controller = (AcademicEducationUIController) WindowLoader.getController();
        Candidate candidateLogin = findCandidateUseCase.findByLogin(txtUsername.getText(), txtPassword.getText()).get();
        controller.setCandidate(candidateLogin);


    }
}
