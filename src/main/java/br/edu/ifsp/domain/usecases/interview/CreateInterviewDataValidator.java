package br.edu.ifsp.domain.usecases.interview;


import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CreateInterviewDataValidator extends Validator<Interview> {

    @Override
    public Notification validate(Interview interview) {
        Notification notification = new Notification();

        if (interview == null) {
            notification.addError("Interview is null");
            return notification;
        }

        if (nullOrEmpty((Collection) interview.getCompany())) {
            notification.addError("Name is null or empty");
        }

        if (nullOrEmpty(interview.getAddress().toString())) {
            notification.addError("Address is null or empty");
        }

        if (nullOrEmpty(interview.getDateTime().toString())) {
            notification.addError("DateTime is null or empty");
        }

        if (nullOrEmpty((Collection) interview.getCompany())) {
            notification.addError("Company is null or empty");
        }

        if (nullOrEmpty((Collection) interview.getCandidacy())) {
            notification.addError("Candidacy is null or empty");
        }

        if (interview.getCandidacy().getVacancy().getCompany().equals(interview.getCompany())) {
            notification.addError("Company to Vacancy is diferent this Interview Company");
        }

        return notification;
    }
}
