package br.edu.ifsp.domain.usecases.Vacancy;

import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateVacancyUseCase {

    private VacancyDAO vacancyDAO;

    public CreateVacancyUseCase(VacancyDAO vacancyDAO) {
        this.vacancyDAO = vacancyDAO;
    }

    public Integer insert(Vacancy vacancy){
        Validator<Vacancy> validator = new CreateVacancyInputValidator();
        Notification notification = validator.validate(vacancy);

        if(notification.hasError()){
            throw new IllegalArgumentException(notification.errorMessage());
        }
        return vacancyDAO.create(vacancy);
    }
}
