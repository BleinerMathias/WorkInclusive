package br.edu.ifsp.application.controller;

import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


public class AccessibilitiesPageUIController {

    @FXML
    private ComboBox<Accessibility> cbAccessibilities;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnSave;
}
