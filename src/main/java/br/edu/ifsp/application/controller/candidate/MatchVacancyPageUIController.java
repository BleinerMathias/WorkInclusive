package br.edu.ifsp.application.controller.candidate;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.candidate.PersonalData;
import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;

import java.io.IOException;
import java.util.List;

import static br.edu.ifsp.application.main.Main.findCandidateUseCase;
import static  br.edu.ifsp.application.main.Main.matchCandidacyUseCase;
public class MatchVacancyPageUIController {

    @FXML
    private Button btnhome;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnVacany;

    @FXML
    private Button btnConfig;

    @FXML
    private Label lbNameVacancy;

    @FXML
    private Label lbCompany;

    @FXML
    private Label lbDesc;

    @FXML
    private Label lbHierarch;

    @FXML
    private Label lbSalary;

    @FXML
    private Label lbBenefities;

    @FXML
    private Button btnDecline;

    @FXML
    private Button btnAccept;

    private Candidate candidate;


    @FXML
    private void initialize(){
        candidate = new Candidate();
        candidate = new Candidate();
        System.out.println("Mostrando usuarios");
        System.out.println(findCandidateUseCase.findByUserId(4));

        // carregaDados();
        List<Vacancy> myMatchVacancyC1 = matchCandidacyUseCase.match(candidate);
        System.out.println(myMatchVacancyC1);
    }





    public void initialPage(ActionEvent actionEvent) throws IOException {
    }

    public void setCandidate(Candidate candidate) throws IOException {
        this.candidate = candidate;
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

}
