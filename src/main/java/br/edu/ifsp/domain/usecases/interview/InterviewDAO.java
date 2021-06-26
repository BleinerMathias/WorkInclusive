package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.interview.Interview;

import java.util.Optional;

public interface InterviewDAO {

    Optional<Interview> findInterviewByCandidateCPF(String cpf);
}
