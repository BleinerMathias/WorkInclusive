package br.edu.ifsp.domain.usecases.Vacancy;

import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateVacancyUseCase {
    private VacancyDAO vacancyDAO;

    public CreateVacancyUseCase(VacancyDAO vacancyDAO) {
        this.vacancyDAO = vacancyDAO;
    }

    public String insert(Vacancy vacancy){
        Validator<Vacancy> validator = new VacancyInputValidator();
        Notification notification = validator.validate(vacancy);

        if(notification.hasError()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        String name = vacancy.getName();
        if(vacancyDAO.findOneByName(name).isPresent()){
            throw new EntityAlreadyExistsException("This name is already in use.");
        }
        return vacancyDAO.create(vacancy);
    }
}
