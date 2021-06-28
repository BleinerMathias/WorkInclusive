package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.interview.InterviewDAO;

import java.util.Optional;

public class InMemoryInterviewDAO implements InterviewDAO {

    @Override
    public Optional<Interview> findInterviewByCandidateCPF(String cpf) {
        return Optional.empty();
    }

}
