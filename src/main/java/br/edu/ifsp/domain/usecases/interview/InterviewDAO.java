package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.List;
import java.util.Optional;

public interface InterviewDAO extends DAO<Interview, Integer> {
    List<Interview> findAllInterviewByCandidate(Candidate candidate);
    List<Interview> findAllCombinedInterviewByCompany(Company company);
    List<Interview> findAllCombinedInterviewByCandidate(Candidate candidate);
    List<Interview> findAllCombinedInterviewByVacancy(Vacancy vacancy);
}
