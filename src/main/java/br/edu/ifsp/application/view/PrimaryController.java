package br.edu.ifsp.application.view;

import java.io.IOException;

import br.edu.ifsp.application.view.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("Login");
    }
}
