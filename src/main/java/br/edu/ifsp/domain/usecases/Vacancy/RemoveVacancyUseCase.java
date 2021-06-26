package br.edu.ifsp.domain.usecases.Vacancy;

import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

public class RemoveVacancyUseCase {
    private VacancyDAO vacancyDAO;

    public RemoveVacancyUseCase(VacancyDAO vacancyDAO) {
        this.vacancyDAO = vacancyDAO;
    }

    public boolean remove(Integer id){
        if(id == null || vacancyDAO.findOne(id).isEmpty()){
            throw  new EntityNotFoundException("Vacancy not found");
        }

        return vacancyDAO.deleteByKey(id);
    }

    public boolean remove(Vacancy vacancy){
        if (vacancy == null || vacancyDAO.findOne(vacancy.getId()).isEmpty()){
            throw new EntityNotFoundException("Vacancy not found");
        }
        return vacancyDAO.delete(vacancy);
    }
}
