package br.edu.ifsp.domain.usecases.progammingLanguage;

import br.edu.ifsp.domain.entities.ProgammingLanguage;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class InsertProgammingLanguageUseCase {

    private ProgrammingLanguageDAO programmingLanguageDAO;

    public InsertProgammingLanguageUseCase(ProgrammingLanguageDAO programmingLanguageDAO) {
        this.programmingLanguageDAO = programmingLanguageDAO;
    }

    public Integer insertStack(ProgammingLanguage progammingLanguage){

        Validator<ProgammingLanguage> validator = new InsertProgrammingLanguageInputValidator();
        Notification notification = validator.validate(progammingLanguage);

        validator.validate(progammingLanguage);

        if(notification.hasError()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        String nameLanguageProgramming = progammingLanguage.getName();;
        if(programmingLanguageDAO.findByName(nameLanguageProgramming).isPresent()){
            throw new EntityAlreadyExistsException("This language has already been inserted");
        }
        return programmingLanguageDAO.create(progammingLanguage);
    }
}
