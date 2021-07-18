package br.edu.ifsp.application.controller.candidacy;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.user.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CandidacyPageUIController {

    @FXML
    private MenuBar mbMenudefault;

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<Candidacy, Integer> cId;

    @FXML
    private TableColumn<Candidacy, String> cVacancy;

    @FXML
    private TableColumn<Candidacy, String> cCandidate;

    @FXML
    private TableColumn<Candidacy, String> cStatus;

    @FXML
    private Button btnDecline;

    @FXML
    private Button btnAccept;
}
