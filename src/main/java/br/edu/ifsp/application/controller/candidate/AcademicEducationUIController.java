package br.edu.ifsp.application.controller.candidate;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidate.AcademicDegree;
import br.edu.ifsp.domain.entities.candidate.AcademicEducation;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;

public class AcademicEducationUIController {

    @FXML
    private TextField txtCourse;

    @FXML
    private DatePicker dtCourseStart;

    @FXML
    private DatePicker dtCourseEnd;

    @FXML
    private ComboBox cbAcademicDegree;

    @FXML
    private TextField txtAcademicInstitution;

    @FXML
    private TableView<AcademicEducation> academicEducationTableView;

    @FXML
    private TableColumn<AcademicEducation, String> cCourse ;

    @FXML
    private TableColumn<AcademicEducation, LocalDate> cDateStart ;

    @FXML
    private TableColumn<AcademicEducation, LocalDate> cDateEnd ;

    @FXML
    private TableColumn<AcademicEducation, String> cStatus ;

    @FXML
    private TableColumn<AcademicEducation, String> cAcademicDegree ;

    @FXML
    private TableColumn<AcademicEducation, String> cInstitution ;

    @FXML
    private ToggleGroup statusAcademicEducation;

    @FXML
    private Button btnNewAcademicEducation;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnNext;

    private Candidate candidate;

    ObservableList<AcademicEducation> academicEducationObservableList;


    @FXML
    private void initialize(){
        candidate = new Candidate();
        cbAcademicDegree.getItems().addAll(AcademicDegree.values());
        bindTaleViewToItemsList();
        bindColumnsToValueSources();
    }

    private void bindTaleViewToItemsList() {
        academicEducationObservableList = FXCollections.observableArrayList();
        academicEducationTableView.setItems(academicEducationObservableList);
    }

    private void bindColumnsToValueSources() {
        cCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        cDateStart.setCellValueFactory(new PropertyValueFactory<>("courseStart"));
        cDateEnd.setCellValueFactory(new PropertyValueFactory<>("courseEnd"));
        cStatus.setCellValueFactory(new PropertyValueFactory<>("completed"));
        cAcademicDegree.setCellValueFactory(new PropertyValueFactory<>("academicDegree"));
        cInstitution.setCellValueFactory(new PropertyValueFactory<>("academicInstitution"));
    }


    public void setCandidate(Candidate candidate){
        this.candidate = candidate;
        if(candidate.getAcademicEducationsList() != null ) {
            academicEducationObservableList.addAll(candidate.getAcademicEducationsList());
        }
    }


    public void backToPreviousScene(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("candidate/AccountCandidate");
        AccountCandidatetUIController controller = (AccountCandidatetUIController) WindowLoader.getController();
        controller.setCandidate(candidate);
    }

    public void nextAddProfessionalEducation(ActionEvent actionEvent) throws IOException {
        candidate.setAcademicEducationsList(academicEducationObservableList);
        WindowLoader.setRoot("candidate/ProfessionalExperience");
        ProfessionalExperienceUIController controller = (ProfessionalExperienceUIController) WindowLoader.getController();
        controller.setCandidate(candidate);
    }

    public void addNewAcademicEducation(ActionEvent actionEvent) {

        RadioButton radioButton = (RadioButton) statusAcademicEducation.getSelectedToggle();

        AcademicEducation academicEducation = new AcademicEducation();
        academicEducation.setCourse(txtCourse.getText());
        academicEducation.setCourseStart(dtCourseStart.getValue());
        academicEducation.setCourseEnd(dtCourseEnd.getValue());
        academicEducation.setAcademicDegree((AcademicDegree) cbAcademicDegree.getValue());

        if(radioButton.getText().equals("SIM")){
            academicEducation.setCompleted(true);
        } else{
            academicEducation.setCompleted(false);
        }

        academicEducation.setAcademicInstitution(txtAcademicInstitution.getText());
        academicEducationObservableList.add(academicEducation);
        System.out.println(candidate);

        clearFields();
    }

    private void clearFields() {
        txtCourse.clear();
        txtAcademicInstitution.clear();
        cbAcademicDegree.setSelectionModel(null);

    }
}
