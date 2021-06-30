package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.candidacy.FindCandidacyUseCase;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.time.LocalDateTime;

public class CreateInterviewUseCase{
    InterviewDAO interviewDAO;
    FindCandidacyUseCase findCandidacyUseCase;

    public CreateInterviewUseCase(InterviewDAO interviewDAO, FindCandidacyUseCase findCandidacyUseCase) {
        this.interviewDAO = interviewDAO;
        this.findCandidacyUseCase = findCandidacyUseCase;
    }

    public Integer createNewInterview(Company company, Candidacy candidacy, LocalDateTime date_time, String address){

        String cnpjCandidacy = candidacy.getVacancy().getCompany().getCNPJ();
        if(cnpjCandidacy.equals(company.getCNPJ())){

            Interview interview = new Interview(date_time, address,candidacy, company);

            Validator<Interview> validator = new CreateInterviewInputValidator();
            Notification notification = validator.validate(interview);

            if(notification.hasError()){
                throw new IllegalArgumentException(notification.errorMessage());
            }

            return interviewDAO.create(interview);
        }
        return null;
    }
}
