package br.edu.ifsp.domain.usecases.Candidate;

import br.edu.ifsp.domain.entities.candidate.Candidate;

import java.util.List;
import java.util.Optional;

public class FindCandidateUseCase {

    private CandidateDAO candidateDAO;

    public FindCandidateUseCase(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
    }

    public Optional<Candidate> findByCPF(String cpf){
        if (cpf == null)
            throw new IllegalArgumentException("CPF can not be null.");
        return candidateDAO.findByCPF(cpf);
    }

    public Optional<Candidate> findByUserId(Integer id){
        if (id == null)
            throw new IllegalArgumentException("UserID can not be null.");
        return candidateDAO.findByUserId(id);
    }

    public List<Candidate> findAll(){
        return candidateDAO.findAll();
    }
}
