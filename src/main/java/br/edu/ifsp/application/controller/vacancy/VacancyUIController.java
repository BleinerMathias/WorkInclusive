package br.edu.ifsp.application.controller.vacancy;

import br.edu.ifsp.domain.entities.vacancy.Hierarchy;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VacancyUIController {

    @FXML
    private TextField txtNameCompany;

    @FXML
    private TextField txtNameVacancy;

    @FXML
    private TextArea txtDescripition;

    @FXML
    private ComboBox<Hierarchy> cbHierarchy;

    @FXML
    private TextField txtCompatibility;

    @FXML
    private TextField txtSalary;

    @FXML
    private CheckBox ckAvailable;

    @FXML
    private CheckBox ckUnavailable;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnNext;


}
