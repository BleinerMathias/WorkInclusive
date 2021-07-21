package br.edu.ifsp.application.controller.candidate;

import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidate.*;
import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


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
    private ComboBox<Accessibility> cbAccessibility;

    @FXML
    private TableView<Accessibility> tableAccessibility;

    @FXML
    private TableColumn<Accessibility, Enum> cAccessibility;


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
    ObservableList<Accessibility> accessibilityObservableList;

    private Candidate candidate;
    private PersonalData personalData;

    @FXML
    private void initialize(){
        candidate = new Candidate();
        personalData = new PersonalData();
        cbAccessibility.getItems().addAll(Accessibility.values());
        bindTaleViewToItemsList();
        bindColumnsToValueSources();
        // carregaDados();
    }

    private void carregaDados() {
        PersonalData p_c1 = new PersonalData("Larissa Aline", "111.111.111-11",
                LocalDate.of(1996,5,5),"13690-000","Brasileira");

        p_c1.addEmail("larissa@teste.com.br");
        p_c1.addEmail("larissa2@teste.com.br");
        p_c1.addPhone("(19) 3333-3333");
        p_c1.addPhone("(16) 3333-3333");

        Candidate c1 = new Candidate(p_c1);

        c1.createLogin("larissaaline", "123123");

        c1.addAcademicEducation(new AcademicEducation("Técnico em enfermagem", LocalDate.of(2017, 6, 5),
                LocalDate.of(2019, 6, 5),true, AcademicDegree.TECHNOLOSIT,"SENAC"));

        c1.addAcademicEducation(new AcademicEducation("Análise e desenolvimento de sistemas", LocalDate.of(2019, 1, 25),
                LocalDate.of(2022, 1, 25),false, AcademicDegree.TECHNOLOSIT,"IFSP" ));

        c1.addAccessibility(Accessibility.VISUAL_DEFICIENT);

        c1.addAbility("JAVA");
        c1.addAbility("JAVASCRIPT");
        c1.addAbility("NODEJS");
        setCandidate(c1);
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
        txtPostCode.setText(candidate.getPersonalData().getPostCode());
        txtNationality.setText(candidate.getPersonalData().getNationality());

        phones.addAll(candidate.getPersonalData().getPhone());
        emails.addAll(candidate.getPersonalData().getEmail());
        accessibilityObservableList.addAll(candidate.getAccessibilities());
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
        personalData.setEmail(emails);
        personalData.setPhone(phones);
        candidate.setPersonalData(personalData);
        candidate.setAccessibilities(accessibilityObservableList);

        WindowLoader.setRoot("candidate/AcademicEducation");
        AcademicEducationUIController controller = (AcademicEducationUIController) WindowLoader.getController();
        controller.setCandidate(candidate);
    }

    public void addAccessiblity(ActionEvent actionEvent) {
        accessibilityObservableList.add(cbAccessibility.getValue());
    }

    public void deletePhone(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
          phones.remove(tablePhones.getSelectionModel().getSelectedItem());
        }
    }

    public void deleteAccessibility(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
            accessibilityObservableList.remove(tableAccessibility.getSelectionModel().getSelectedItem());
        }
    }

    public void deleteEmail(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
            emails.remove(tableEmails.getSelectionModel().getSelectedItem());
        }
    }
}
