package br.edu.ifsp.application.controller.company;

import br.edu.ifsp.application.view.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ConfigPageCompanyUIController {

    @FXML
    private Button btnhome;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnVacany;

    @FXML
    private Button btnInterviews;

    @FXML
    private Button btnConfig;

    @FXML
    private ColorPicker cpTxtColor;

    @FXML
    private ColorPicker cpViewColor;

    @FXML
    private TextField txtFontSize;

    @FXML
    private Button btnSave;

    public void initialPage(ActionEvent actionEvent) throws IOException {
        App.setRoot("HomePageCompany");
    }

    public void Account(ActionEvent actionEvent) throws IOException {
        App.setRoot("AccountCompany");
    }

    public void vacancy(ActionEvent actionEvent) throws IOException {
        App.setRoot("ListVacancyCompanyPage");
    }

    public void interviews(ActionEvent actionEvent) throws IOException {
        App.setRoot("AcceptInterviewsPage");
    }

    public void config(ActionEvent actionEvent) throws IOException {
        App.setRoot("ConfigPage");
    }
}
