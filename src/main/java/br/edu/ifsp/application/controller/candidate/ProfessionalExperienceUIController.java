package br.edu.ifsp.application.controller.candidate;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.candidate.Email;
import br.edu.ifsp.domain.entities.candidate.ProfessionalExperience;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;

public class ProfessionalExperienceUIController {

    @FXML
    private TextField txtCompanyName;

    @FXML
    private DatePicker dtAdimission;

    @FXML
    private DatePicker dtResignation;

    @FXML
    private TextField txtOffice;

    @FXML
    private TableView<ProfessionalExperience> professionalExperienceTableView;

    @FXML
    private TableColumn<ProfessionalExperience, String> cCompanyName;

    @FXML
    private TableColumn<ProfessionalExperience, LocalDate> cAdmissionDate;

    @FXML
    private TableColumn<ProfessionalExperience, LocalDate> cResignationDate;

    @FXML
    private TableColumn<ProfessionalExperience, String> cOffice;

    @FXML
    private TableColumn<ProfessionalExperience, String> cCarriedActivities;

    @FXML
    private TextArea txtActivities;

    @FXML
    private Button btnNewProfessionalExperience;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnNext;

    private Candidate candidate;
    private ProfessionalExperience professionalExperience;

    ObservableList<ProfessionalExperience> professionalExperienceList;


    @FXML
    private void initialize(){
        candidate = new Candidate();
        bindTaleViewToItemsList();
        bindColumnsToValueSources();
    }

    private void bindTaleViewToItemsList() {
        professionalExperienceList = FXCollections.observableArrayList();
        professionalExperienceTableView.setItems(professionalExperienceList);
    }

    private void bindColumnsToValueSources() {
        cCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        cAdmissionDate.setCellValueFactory(new PropertyValueFactory<>("admissionDate"));
        cResignationDate.setCellValueFactory(new PropertyValueFactory<>("resignationDate"));
        cOffice.setCellValueFactory(new PropertyValueFactory<>("office"));
        cCarriedActivities.setCellValueFactory(new PropertyValueFactory<>("carriedActivities"));
    }

    public void setCandidate(Candidate candidate){
        this.candidate = candidate;
        if(candidate.getProfessionalExperienceList() != null)
            professionalExperienceList.addAll(candidate.getProfessionalExperienceList());
    }

    public void backToPreviousScene(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("candidate/AcademicEducation");
        AcademicEducationUIController controller = (AcademicEducationUIController) WindowLoader.getController();
        controller.setCandidate(candidate);
    }

    public void nextToAddLIP(ActionEvent actionEvent) throws IOException {
        candidate.setProfessionalExperienceList(professionalExperienceList);
        WindowLoader.setRoot("candidate/AbilitiesPage");
        AbilitiesPageUIController controller = (AbilitiesPageUIController) WindowLoader.getController();
        controller.setCandidate(candidate);
    }

    public void addNewProfessionalExperience(ActionEvent actionEvent) {
        ProfessionalExperience professionalExperience = new ProfessionalExperience();
        professionalExperience.setCompanyName(txtCompanyName.getText());
        professionalExperience.setAdmissionDate(dtAdimission.getValue());
        professionalExperience.setResignationDate(dtResignation.getValue());
        professionalExperience.setOffice(txtOffice.getText());
        professionalExperience.setCarriedActivities(txtActivities.getText());

        professionalExperienceList.add(professionalExperience);
        System.out.println(candidate);
        clearFields();
    }

    private void clearFields() {
        txtCompanyName.clear();
        txtActivities.clear();
        txtActivities.clear();
        txtOffice.clear();
    }
}
