package br.edu.ifsp.domain.usecases.candidacy;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateCandidacyUseCase {

    private CandidacyDAO candidacyDAO;

    public UpdateCandidacyUseCase(CandidacyDAO candidacyDAO) {
        this.candidacyDAO = candidacyDAO;
    }

    public boolean update(Candidacy candidacy){
        Validator<Candidacy> validator = new CandidacyInputValidator();
        Notification notification = validator.validate(candidacy);

        if(notification.hasError()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        Integer id = candidacy.getId();
        if(candidacyDAO.findCandidacyById(id).isEmpty()){
            throw new EntityNotFoundException("Id not found.");
        }
        return candidacyDAO.update(candidacy);
    }

}
