package br.edu.ifsp.domain.usecases.candidacy;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CandidacyInputValidator extends Validator<Candidacy>{

    public Notification validate(Candidacy candidacy){
        Notification notification = new Notification();

        if(candidacy == null){
            notification.addError("Candidacy is null");
            return notification;
        }

        if(candidacy.getVacancy() == null){
            notification.addError("Vacancy is null");
        }


        if(candidacy.getCandidate() == null){
            notification.addError("Candidate is null");
        }

        return notification;
    }
}
