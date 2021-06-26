package br.edu.ifsp.domain.usecases.Vacancy;

import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class VacancyInputValidator extends Validator<Vacancy> {

    public Notification validate(Vacancy vacancy) {
        Notification notification = new Notification();
        if (vacancy == null) {
            notification.addError("Vacancy is null");
            return notification;
        }

        if (nullOrEmpty(vacancy.getName())) {
            notification.addError("Name is null or empty");
        }

        if (nullOrEmpty(vacancy.getDescription())) {
            notification.addError("Description is null or empty");
        }

        if (nullOrEmpty(vacancy.getSalary().toString())) {
            notification.addError("Salary is null or empty");
        }
    return notification;
    }
}
