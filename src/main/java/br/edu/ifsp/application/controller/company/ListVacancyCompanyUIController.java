package br.edu.ifsp.application.controller.company;

import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListVacancyCompanyUIController {

    @FXML
    private MenuBar mbMenudefault;

    @FXML
    private TableView<Vacancy> tableView;

    @FXML
    private TableColumn<Vacancy, Integer> cId;

    @FXML
    private TableColumn<Vacancy, String> cVacancy;

    @FXML
    private TableColumn<Vacancy, String> cHierarch;

    @FXML
    private TableColumn<Vacancy, Double> cSalary;

    @FXML
    private TableColumn<Vacancy,String> cStatus;

    @FXML
    private Button btnNewVacancy;
}
