package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.candidacy.StatusCandidacy;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateInterviewInputValidator extends Validator<Interview> {
    @Override
    public Notification validate(Interview interview) {
        Notification notification = new Notification();

        if (interview == null) {
            notification.addError("Interview is null");
            return notification;
        }

        if(nullOrEmpty(interview.getDateTime().toString())){
            notification.addError("Date and Time of the Interview is null or empty");
        }

        if(nullOrEmpty(interview.getAddress())){
            notification.addError("Address is null or empty");
        }

        if(interview.getCompany()==null){
            notification.addError("Company is null");
        }

        if(interview.getCandidacy() ==null){
            notification.addError("Candidate is null");
        }

        if(interview.getCandidacy() ==null){
            notification.addError("Candidate is null");
        }

        if(interview.getCandidacy().getStatusCandidacy() != StatusCandidacy.ACCEPT){
            notification.addError("Candidate was not accept to create interview");
        }

        return notification;
    }
}
