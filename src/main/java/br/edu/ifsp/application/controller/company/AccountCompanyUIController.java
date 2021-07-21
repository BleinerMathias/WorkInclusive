package br.edu.ifsp.application.controller.company;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidate.Email;
import br.edu.ifsp.domain.entities.candidate.Phone;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.createCompanyUseCase;


public class AccountCompanyUIController {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtSector;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhone;

    @FXML
    private TableView tableEmails;

    @FXML
    private TableColumn<Email, String> cEmail;

    @FXML
    private TableView tablePhones;

    @FXML
    private TableColumn<Phone, String> cNumber;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtPostCode;

    @FXML
    private ComboBox<Accessibility> cbAccessibility;

    @FXML
    private TableView tableAccessibility;

    @FXML
    private TableColumn<Accessibility, String> cAccessibility;

    @FXML
    private Button btnAddEmail;

    @FXML
    private Button btnAddPhone;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    ObservableList<Phone> phones;
    ObservableList<Email> emails;
    ObservableList<Accessibility> accessibilityObservableList;

    private Company company;

    @FXML
    private void initialize(){
        company = new Company();
        cbAccessibility.getItems().addAll(Accessibility.values());
        bindTaleViewToItemsList();
        bindColumnsToValueSources();
        //carregaDados();
    }

    private void carregaDados() {
        // Create a Company
        Company comp1 = new Company("Grupo", "Grupo Empresa", "Informática", "13.146.255/0001-09", "Rua Manoel Vasques Pineda, 717", "18114-440");

        comp1.addEmail("grupoempresa@company.com.br");
        comp1.addEmail("grupo@company.com.br");
        comp1.addPhone("(16) 3343-3343");
        comp1.addPhone("(19) 3434-2233");
        comp1.addAccessibility(Accessibility.VISUAL_DEFICIENT);
        comp1.createLogin("grupo1", "12233");

        setCompany(comp1);
    }

    private void bindTaleViewToItemsList() {
        phones = FXCollections.observableArrayList();
        emails = FXCollections.observableArrayList();
        accessibilityObservableList = FXCollections.observableArrayList();

        tablePhones.setItems(phones);
        tableEmails.setItems(emails);
        tableAccessibility.setItems(accessibilityObservableList);
    }

    private void bindColumnsToValueSources() {
        cNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cAccessibility.setCellValueFactory(new PropertyValueFactory<>("label"));
    }

    public void setCompany(Company company){
        this.company = company;
        if(company != null){
            populateFields(company);
        }
    }

    private void populateFields(Company company) {
        txtUsername.setText(company.getUsername());
        txtPassword.setText(company.getUsername());
        txtName.setText(company.getName());
        txtCompanyName.setText(company.getCompanyName());
        txtSector.setText(company.getSector());
        txtCNPJ.setText(company.getCNPJ());
        txtAddress.setText(company.getAddress());
        txtPostCode.setText(company.getPostCode());
        phones.addAll(company.getPhone());
        emails.addAll(company.getEmail());
    }

    public void addPhone(ActionEvent actionEvent) {
        phones.add(new Phone(txtPhone.getText()));
        txtPhone.clear();
    }

    public void addEmail(ActionEvent actionEvent) {
        emails.add(new Email(txtEmail.getText()));
        txtEmail.clear();
    }

    public void addAccessibility(ActionEvent actionEvent) {
        accessibilityObservableList.add(cbAccessibility.getValue());
    }

    public void deletePhone(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
            phones.remove(tablePhones.getSelectionModel().getSelectedItem());
        }
    }

    public void deleteEmail(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
            emails.remove(tableEmails.getSelectionModel().getSelectedItem());
        }
    }

    public void deleteAccessibility(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
            accessibilityObservableList.remove(tableAccessibility.getSelectionModel().getSelectedItem());
        }
    }

    public void backToPreviousScene(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("company/HomePageCompany");
    }

    public void saveCompany(ActionEvent actionEvent) {
        if(company!=null){
            createCompanyUseCase.insert(company);
        }
    }


}
