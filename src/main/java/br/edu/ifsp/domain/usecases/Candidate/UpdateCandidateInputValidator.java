package br.edu.ifsp.domain.usecases.Candidate;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.candidate.Email;
import br.edu.ifsp.domain.entities.candidate.Phone;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class UpdateCandidateInputValidator extends Validator<Candidate> {

    @Override
    public Notification validate(Candidate candidate) {
        Notification notification = new Notification();
        if (candidate == null) {
            notification.addError("Candidate is null");
            return notification;
        }

        ArrayList<Email> emails = new ArrayList<>(candidate.getPersonalData().getEmail());
        if(emails.size() < 1){
            notification.addError("Email can't be null");
        }

        ArrayList<Phone> phones = new ArrayList<>(candidate.getPersonalData().getPhone());
        if(phones.size() < 1){
            notification.addError("Phone can't be null");
        }
        return notification;
    }
}
