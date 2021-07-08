package br.edu.ifsp.domain.usecases.progammingLanguage;

import br.edu.ifsp.domain.entities.ProgammingLanguage;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class InsertProgrammingLanguageInputValidator extends Validator<ProgammingLanguage> {

    @Override
    public Notification validate(ProgammingLanguage progammingLanguage) {

        Notification notification = new Notification();

        if (progammingLanguage == null) {
            notification.addError("Interview is null");
            return notification;
        }

        if(nullOrEmpty(progammingLanguage.getName())){
            notification.addError("Name the programming language is null or empty.");
        }
        return notification;
    }
}
