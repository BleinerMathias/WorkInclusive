package br.edu.ifsp.application.controller.candidate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProfessionalExperienceUIController {

    @FXML
    private TextField txtName;

    @FXML
    private DatePicker dtAdimission;

    @FXML
    private DatePicker dtResignation;

    @FXML
    private TextField txtOffice;

    @FXML
    private TextArea txtActivities;

    @FXML
    private Button btnNewProfessionalExperience;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnNext;
}
