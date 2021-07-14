package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidacy.StatusCandidacy;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.candidacy.FindCandidacyUseCase;
import br.edu.ifsp.domain.usecases.candidacy.UpdateCandidacyUseCase;
import br.edu.ifsp.domain.usecases.utils.EntityNotAvaliableException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.time.LocalDateTime;
import java.util.Optional;

public class CreateInterviewUseCase{
    private InterviewDAO interviewDAO;
    private FindCandidacyUseCase findCandidacyUseCase;
    private UpdateCandidacyUseCase updateCandidacyUseCase;

    public CreateInterviewUseCase(InterviewDAO interviewDAO, FindCandidacyUseCase findCandidacyUseCase, UpdateCandidacyUseCase updateCandidacyUseCase) {
        this.interviewDAO = interviewDAO;
        this.findCandidacyUseCase = findCandidacyUseCase;
    }

    public Integer createNewInterview(Company company, Candidacy candidacy, LocalDateTime date_time, String address){

        if(!candidacy.getVacancy().getCompany().equals(company)){
            throw new EntityNotAvaliableException("Action is not permited");
        }

        Optional<Candidacy> candidacyToInterview = findCandidacyUseCase.findCandidacyById(candidacy.getId());

        // Accept candidate to interview
        // candidacyToInterview.get().setStatusCandidacy(StatusCandidacy.ACCEPT);

        // Create interview



    }
}
