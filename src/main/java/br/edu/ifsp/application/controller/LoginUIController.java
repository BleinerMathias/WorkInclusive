package br.edu.ifsp.application.controller;


import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginUIController {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lbUser;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCompany;

    @FXML
    private Button btnCandidate;

    private User user;

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    /*
    public void isAccess(ActionEvent event){
        //existe usuário? se sim, identificar o tipo do usuário para acessar telas da empresa ou telas do candiato
        // se não, exibir mensagem "Usuário não encontrado" na label lbUser

        String userName;
        userName = txtUsername.getText();

        conn = ConnectionFactory.createConnection();
        String sql= "SELECT * FROM user WHERE username=? AND password=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtPassword.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            return false;
        }finally {
            pst.close();
            rs.close();
        }
    }
     */

    public void createAccountCompany(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("AccountCandidate");
    }

    public void createAccountCandidate(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("AccountCompany");
    }
}
