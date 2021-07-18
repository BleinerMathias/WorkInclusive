package br.edu.ifsp.application.controller;

import br.edu.ifsp.domain.entities.user.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LoginUIController {

    @FXML
    TableColumn<User, String> txtUsername;

    @FXML
    TableColumn<User, String> txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCompany;

    @FXML
    private Button btnCandidate;


}
