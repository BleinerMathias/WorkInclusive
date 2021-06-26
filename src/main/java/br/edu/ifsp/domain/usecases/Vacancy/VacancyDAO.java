package br.edu.ifsp.domain.usecases.Vacancy;

import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.Optional;

public interface VacancyDAO extends DAO<Vacancy,Integer> {
    Optional<Vacancy> findOneByName(String name);
}
