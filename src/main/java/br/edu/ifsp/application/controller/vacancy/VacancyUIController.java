package br.edu.ifsp.application.controller.vacancy;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidate.AcademicDegree;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.Hierarchy;
import br.edu.ifsp.domain.entities.vacancy.ProgrammingLanguage;
import br.edu.ifsp.domain.entities.vacancy.StatusVacancy;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class VacancyUIController {

    @FXML
    private TextField txtNameVacancy;

    @FXML
    private TextArea txtDescripition;

    @FXML
    private TextField txtNewAbility;

    @FXML
    private ComboBox<Hierarchy> cbHierarchy;

    @FXML
    private CheckBox chbAvaliable;

    @FXML
    private TextField txtCompatibility;

    @FXML
    private TextField txtSalary;

    @FXML
    private TableView<ProgrammingLanguage> languageTableView;

    @FXML
    private TableColumn<ProgrammingLanguage,String> cLIP;

    private Company company;
    private Vacancy vacancy;

    ObservableList<ProgrammingLanguage> programmingLanguageObservableList;


    @FXML
    private void initialize(){
        company = new Company();
        vacancy = new Vacancy();
        cbHierarchy.getItems().addAll(Hierarchy.values());
        bindTaleViewToItemsList();
        bindColumnsToValueSources();

    }

    private void bindTaleViewToItemsList() {
        programmingLanguageObservableList = FXCollections.observableArrayList();
        languageTableView.setItems(programmingLanguageObservableList);
    }

    private void bindColumnsToValueSources() {
        cLIP.setCellValueFactory(new PropertyValueFactory<>("name"));
    }


    public void setCandidate(Company company, Vacancy vacancy){
        this.company = company;
        this.vacancy = vacancy;
        if(vacancy != null ) {
            System.out.println(vacancy);
            populateFields(vacancy);
        }
    }

    private void populateFields(Vacancy vacancy) {
        txtNameVacancy.setText(vacancy.getName());
        txtDescripition.setText(vacancy.getDescription());
        txtSalary.setText(vacancy.getSalary().toString());

        if (vacancy.getStatusVacancy().equals(StatusVacancy.AVAILABLE)) {
            chbAvaliable.setSelected(true);
        } else {
            chbAvaliable.setSelected(false);
        }

        if(vacancy.getAbiliityList()!=null)
            programmingLanguageObservableList.addAll(vacancy.getAbiliityList());

        txtCompatibility.setText(vacancy.getCompatibilidade().toString());
        cbHierarchy.getSelectionModel().select(vacancy.getHierarchy());

    }


    public void backMainCompanyUI(ActionEvent actionEvent) {
    }

    public void nextAddMoreInfo(ActionEvent actionEvent) throws IOException {
        this.vacancy.setName(txtNameVacancy.getText());
        this.vacancy.setDescription(txtDescripition.getText());
        this.vacancy.setSalary(Double.parseDouble(txtSalary.getText()));
        this.vacancy.setSalary(Double.parseDouble(txtSalary.getText()));
        this.vacancy.setCompatibilidade(Integer.parseInt(txtCompatibility.getText()));
        this.vacancy.setAbiliityList(programmingLanguageObservableList);
        this.vacancy.setHierarchy(cbHierarchy.getValue());
        if (chbAvaliable.isSelected()) {
            this.vacancy.setAvaliable();
        } else {
            this.vacancy.setUnavaliable();
        }
        this.vacancy.setCompany(this.company);

        WindowLoader.setRoot("vacancy/BenefitsPage");
        BenefitsPageUIController controller = (BenefitsPageUIController) WindowLoader.getController();
        controller.setCandidate(this.company, this.vacancy);
    }

    public void addLIP(ActionEvent actionEvent) {
        programmingLanguageObservableList.add(new ProgrammingLanguage(txtNewAbility.getText()));
        txtNewAbility.clear();
    }
}
