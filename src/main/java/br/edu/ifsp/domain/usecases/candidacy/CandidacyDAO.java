package br.edu.ifsp.domain.usecases.candidacy;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.List;


public interface CandidacyDAO extends DAO<Candidacy, Integer> {
    List<Candidacy> findByCompany(String cnpj);

}
