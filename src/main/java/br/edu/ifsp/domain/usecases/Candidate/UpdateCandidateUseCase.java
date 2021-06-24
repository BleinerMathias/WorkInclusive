package br.edu.ifsp.domain.usecases.Candidate;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateCandidateUseCase {

    private CandidateDAO candidateDAO;

    public UpdateCandidateUseCase(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
    }

    public boolean update(Candidate candidate){
        Validator<Candidate> validator = new UpdateCandidateInputValidator();
        Notification notification = validator.validate(candidate);

        if(notification.hasError()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        String cpf = candidate.getPersonalData().getCpf();
        if(candidateDAO.findByCPF(cpf).isEmpty()){
            throw new EntityNotFoundException("CPF not found.");
        }
        return candidateDAO.update(candidate);
    }

}
