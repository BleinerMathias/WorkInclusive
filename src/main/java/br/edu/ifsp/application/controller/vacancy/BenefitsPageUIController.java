package br.edu.ifsp.application.controller.vacancy;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


import static br.edu.ifsp.application.main.Main.createVacancyUseCase;
import static br.edu.ifsp.application.main.Main.findVacancyUseCase;

public class BenefitsPageUIController {

    @FXML
    private ComboBox<Benefits> cbBenefities;

    @FXML
    private ComboBox<Accessibility> cbAccessibility;

    @FXML
    private TableView<Benefits> benefitsTableView;

    @FXML
    private TableColumn<Benefits, Enum> cBenefits;

    @FXML
    private TableView<Accessibility> accessibilityTableView;

    @FXML
    private TableColumn<Accessibility, Enum> cAccessibility;

    ObservableList<Accessibility> accessibilityObservableList;
    ObservableList<Benefits> benefitsObservableList;

    private Company company;
    private Vacancy vacancy;

    @FXML
    private void initialize(){
        company = new Company();
        cbAccessibility.getItems().addAll(Accessibility.values());
        cbBenefities.getItems().addAll(Benefits.values());
        bindTaleViewToItemsList();
        bindColumnsToValueSources();
    }

    private void bindTaleViewToItemsList() {
        accessibilityObservableList = FXCollections.observableArrayList();
        benefitsObservableList = FXCollections.observableArrayList();

        accessibilityTableView.setItems(accessibilityObservableList);
        benefitsTableView.setItems(benefitsObservableList);
    }

    private void bindColumnsToValueSources() {
        cAccessibility.setCellValueFactory(new PropertyValueFactory<>("label"));
        cBenefits.setCellValueFactory(new PropertyValueFactory<>("label"));
    }

    public void setCandidate(Company company, Vacancy vacancy){
        this.company = company;
        this.vacancy = vacancy;
        if(vacancy != null ) {
            populateFields(vacancy);
        }
    }

    private void populateFields(Vacancy vacancy) {
        if(vacancy.getAccessibilityList() != null)
            accessibilityObservableList.addAll(vacancy.getAccessibilityList());
        if(vacancy.getBenefitsList() != null)
            benefitsObservableList.addAll(vacancy.getBenefitsList());
    }

    public void saveVacancy(ActionEvent actionEvent) {
        this.vacancy.setAccessibilityList(accessibilityObservableList);
        this.vacancy.setBenefitsList(benefitsObservableList);

        System.out.println("salvando");

        if(this.vacancy !=null)
            createVacancyUseCase.insert(vacancy);
    }

    public void backToPreviousScene(ActionEvent actionEvent) throws IOException {
        this.vacancy.setAccessibilityList(accessibilityObservableList);
        this.vacancy.setBenefitsList(benefitsObservableList);

        WindowLoader.setRoot("vacancy/vacancy");
        VacancyUIController controller = (VacancyUIController) WindowLoader.getController();
        controller.setCandidate(this.company, this.vacancy);
    }

    public void addNewBenefit(ActionEvent actionEvent) {
        benefitsObservableList.add(cbBenefities.getValue());
        this.vacancy.addBenefits(cbBenefities.getValue());
    }

    public void addNewAccessibility(ActionEvent actionEvent) {
        accessibilityObservableList.add(cbAccessibility.getValue());
        this.vacancy.addAccessibility(cbAccessibility.getValue());
    }
}
