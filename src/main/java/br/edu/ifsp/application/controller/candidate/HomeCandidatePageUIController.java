package br.edu.ifsp.application.controller.candidate;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class HomeCandidatePageUIController {

    @FXML
    private MenuBar mbMenudefacult;

    @FXML
    private TableView<Candidate> tableView;

    @FXML
    private TableColumn<Candidate, Integer> cId;

    @FXML
    private TableColumn<Candidate, LocalDate> cDateTime;

    @FXML
    private TableColumn<Candidate, String> cAddress;

    @FXML
    private TableColumn<Candidate, String> cCompany;
}
