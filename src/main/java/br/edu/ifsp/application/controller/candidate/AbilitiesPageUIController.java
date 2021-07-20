package br.edu.ifsp.application.controller.candidate;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidate.Ability;
import br.edu.ifsp.domain.entities.candidate.AcademicDegree;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.createCandidateUseCase;

public class AbilitiesPageUIController {

    @FXML
    private TextField txtAbility;

    @FXML
    private Button btnNewAbility;

    @FXML
    private TableView<Ability> tableAbility;

    @FXML
    private TableColumn<Ability, String> cAbility;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnNext;

    private Candidate candidate;
    private Ability ability;

    ObservableList<Ability> abilityObservableList;

    @FXML
    private void initialize(){
        candidate = new Candidate();
        ability = new Ability();
        bindTaleViewToItemsList();
        bindColumnsToValueSources();
    }

    private void bindTaleViewToItemsList() {
        abilityObservableList = FXCollections.observableArrayList();
        tableAbility.setItems(abilityObservableList);
    }

    private void bindColumnsToValueSources() {
        cAbility.setCellValueFactory(new PropertyValueFactory<>("ability"));
    }

    public void setCandidate(Candidate candidate){
        this.candidate = candidate;

        if(candidate.getAbiliities() != null)
            abilityObservableList.addAll(candidate.getAbiliities());
    }

    public void backToPreviousScene(ActionEvent actionEvent) throws IOException {
        candidate.setAbiliities(abilityObservableList);
        WindowLoader.setRoot("candidate/ProfessionalExperience");
        ProfessionalExperienceUIController controller = (ProfessionalExperienceUIController) WindowLoader.getController();
        controller.setCandidate(candidate);
    }

    public void SaveCandidate(ActionEvent actionEvent) {
        if(candidate!=null){
            createCandidateUseCase.insert(candidate);
        }
    }

    public void addNewAbility(ActionEvent actionEvent) {
        ability.setAbility(txtAbility.getText());
        abilityObservableList.add(ability);
        txtAbility.clear();
        txtAbility.requestFocus();
    }
}
