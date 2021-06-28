package br.edu.ifsp.domain.usecases.Vacancy;

import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import java.util.List;
import java.util.Optional;

public class FindVacancyUseCase {
    private VacancyDAO vacancyDAO;

    public FindVacancyUseCase(VacancyDAO vacancyDAO) {
        this.vacancyDAO = vacancyDAO;
    }

    public Optional<Vacancy> findOne(Integer id){
        if (id == null)
            throw new IllegalArgumentException("ID can not be null.");
        return vacancyDAO.findOne(id);
    }

    public List<Vacancy> findAll(){
        return vacancyDAO.findAll();
    }

}
