package br.edu.ifsp.application.controller.candidate;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidate.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.IOException;
import java.time.LocalDate;

public class AccountCandidatetUIController {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtCpf;

    @FXML
    private DatePicker dtBirthday;

    @FXML
    private TextField txtPostCode;

    @FXML
    private TextField txtNationality;

    @FXML
    private TableView<Phone> tablePhones;

    @FXML
    private TableColumn<Phone, Integer> cId;
    @FXML
    private TableColumn<Phone, String> cNumber;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TableView<Email> tableEmails;

    @FXML
    private TableColumn<Email, String> cEmail;

    @FXML
    private Button btnAddPhone;

    @FXML
    private Button btnAddEmail;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    ObservableList<Phone> phones;
    ObservableList<Email> emails;

    private Candidate candidate;
    private PersonalData personalData;

    @FXML
    private void initialize(){
        candidate = new Candidate();
        personalData = new PersonalData();
        bindTaleViewToItemsList();
        bindColumnsToValueSources();
    }

    private void bindTaleViewToItemsList() {
        phones = FXCollections.observableArrayList();
        emails = FXCollections.observableArrayList();
        tablePhones.setItems(phones);
        tableEmails.setItems(emails);

        personalData.setPhone(phones);
        personalData.setEmail(emails);

    }

    private void bindColumnsToValueSources() {
        cNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }


    public void saveOrUpdate(ActionEvent actionEvent) throws IOException {

    }

    public void setCandidate(Candidate candidate){
        this.candidate = candidate;
        if(candidate.getPersonalData()!=null){
          populateFields(candidate);
        }

    }

    private void populateFields(Candidate candidate) {
        txtUsername.setText(candidate.getUsername());
        txtPassword.setText(candidate.getPassword());
        txtName.setText(candidate.getPersonalData().getName());
        txtCpf.setText(candidate.getPersonalData().getCpf());
        dtBirthday.setValue(candidate.getPersonalData().getDateOfBirth());
        txtPostCode.setText(candidate.getPersonalData().getCpf());
        txtNationality.setText(candidate.getPersonalData().getNationality());

        phones.addAll(candidate.getPersonalData().getPhone());
        emails.addAll(candidate.getPersonalData().getEmail());
    }

    public void addPhone(ActionEvent actionEvent) {
        phones.add(new Phone(txtPhone.getText()));
        txtPhone.clear();
    }

    public void backToPreviousScene(ActionEvent actionEvent) {
    }

    public void addEmail(ActionEvent actionEvent) {
        emails.add(new Email(txtEmail.getText()));
        txtEmail.clear();
    }

    public void nxtUserData(ActionEvent actionEvent) throws IOException {
        candidate.createLogin(txtUsername.getText(),txtPassword.getText());
        candidate.setTypeUser(1);

        personalData.setName(txtName.getText());
        personalData.setCpf(txtCpf.getText());
        personalData.setDateOfBirth(LocalDate.parse(dtBirthday.getValue().toString()));
        personalData.setNationality(txtNationality.getText());
        personalData.setPostCode(txtPostCode.getText());
        candidate.setPersonalData(personalData);

        WindowLoader.setRoot("candidate/AcademicEducation");
        AcademicEducationUIController controller = (AcademicEducationUIController) WindowLoader.getController();
        controller.setCandidate(candidate);
    }

}
