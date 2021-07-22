module br.edu.ifsp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;


    opens br.edu.ifsp.application.view to javafx.fxml;
    opens br.edu.ifsp.application.view.candidate to javafx.fxml;
    opens br.edu.ifsp.application.view.company to javafx.fxml;
    opens br.edu.ifsp.application.view.vacancy to javafx.fxml;

    opens br.edu.ifsp.application.controller to javafx.fxml;
    opens br.edu.ifsp.application.controller.candidate to javafx.fxml;
    opens br.edu.ifsp.application.controller.company to javafx.fxml;
    opens br.edu.ifsp.application.controller.interview to javafx.fxml;
    opens br.edu.ifsp.application.controller.vacancy to javafx.fxml;


    exports br.edu.ifsp.application.view;
    exports br.edu.ifsp.application.controller;
    exports br.edu.ifsp.application.controller.candidate;
    exports br.edu.ifsp.application.controller.company;

    exports br.edu.ifsp.domain.entities.candidate;
    exports br.edu.ifsp.domain.entities.vacancy;

    opens br.edu.ifsp.domain.entities.vacancy to javafx.fxml;
    opens br.edu.ifsp.domain.entities.candidate to javafx.fxml;

}