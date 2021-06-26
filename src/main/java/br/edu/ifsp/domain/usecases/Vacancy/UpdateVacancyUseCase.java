package br.edu.ifsp.domain.usecases.Vacancy;

import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.Company.CompanyDAO;
import br.edu.ifsp.domain.usecases.Company.UpdateCompanyInputValidator;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateVacancyUseCase {
    private VacancyDAO vacancyDAO;

    public UpdateVacancyUseCase(VacancyDAO vacancyDAO) {
        this.vacancyDAO = vacancyDAO;
    }

    public boolean update(Vacancy vacancy){

        String name = vacancy.getName();
        if(vacancyDAO.findOneByName(name).isEmpty()){
            throw new EntityNotFoundException("Name not found.");
        }
        return vacancyDAO.update(vacancy);
    }
}
