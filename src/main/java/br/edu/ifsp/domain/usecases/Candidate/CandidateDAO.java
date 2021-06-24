package br.edu.ifsp.domain.usecases.Candidate;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.Optional;

public interface CandidateDAO extends DAO<Candidate, String> {
    Optional<Candidate> findByCPF(String cpf);
}
