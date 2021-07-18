package br.edu.ifsp.application.controller.company;

import br.edu.ifsp.domain.entities.company.Company;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class AcceptInterviewsPageUIController {

    @FXML
    private MenuBar mbMenudefault;

    @FXML
    private TableView<Company> tableView;

    @FXML
    private TableColumn<Company, Integer> cId;

    @FXML
    private TableColumn<Company, LocalDate> cDateTime;

    @FXML
    private TableColumn<Company, String> cCandidate;

    @FXML
    private TableColumn<Company, String> cStatus;

    @FXML
    private Button btnDecline;

    @FXML
    private Button btnAccept;

}
