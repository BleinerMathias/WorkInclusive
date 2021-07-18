package br.edu.ifsp.application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;

public class ConfigPageUIController {

    @FXML
    private MenuBar mbMenudefault;

    @FXML
    private ColorPicker cpTxtColor;

    @FXML
    private ColorPicker cpViewColor;

    @FXML
    private TextField txtFontSize;

    @FXML
    private Button btnSave;
}
