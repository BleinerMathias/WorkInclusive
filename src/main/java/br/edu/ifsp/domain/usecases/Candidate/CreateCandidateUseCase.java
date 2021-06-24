package br.edu.ifsp.domain.usecases.Candidate;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateCandidateUseCase {

    private CandidateDAO candidateDAO;

    public CreateCandidateUseCase(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
    }

    public String insert(Candidate candidate){
        Validator<Candidate> validator = new CandidateInputValidator();
        Notification notification = validator.validate(candidate);

        if(notification.hasError()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        String cpf = candidate.getPersonalData().getCpf();
        if(candidateDAO.findByCPF(cpf).isPresent()){
            throw new EntityAlreadyExistsException("This CPF is already in use.");
        }
        return candidateDAO.create(candidate);
    }

}
