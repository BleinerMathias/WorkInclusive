package br.edu.ifsp.domain.usecases.candidacy;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.List;


public interface CandidacyDAO extends DAO<Candidacy, Integer> {
    List<Candidacy> findAllByVancancy(Company company, Vacancy vacancy);

}
