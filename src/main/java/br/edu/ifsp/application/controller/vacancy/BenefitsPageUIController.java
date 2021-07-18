package br.edu.ifsp.application.controller.vacancy;

import br.edu.ifsp.domain.entities.vacancy.Benefits;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class BenefitsPageUIController {

    @FXML
    private ComboBox<Benefits> cbBenefities;

    @FXML
    private Button btnNewBenefities;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnNext;
}
