package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.utils.EntityNotAvaliableException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UnacceptCombineInterview {
    private InterviewDAO interviewDAO;
    private FindInterviewUseCase findInterviewUseCase;

    public UnacceptCombineInterview(InterviewDAO interviewDAO, FindInterviewUseCase findInterviewUseCase) {
        this.interviewDAO = interviewDAO;
    }

    public boolean candidateUnacceptCombineInterview(Candidate candidate, Interview interview, LocalDateTime newDateTimeInterview) {
        if (!candidate.equals(interview.getCandidacy().getCandidate()))
            throw new EntityNotAvaliableException("Candidate not can access this interview");

        interview.candidateUnacceptCombinedInterview();

        // !! Create validator to it.
        if(!newDateTimeInterview.toLocalDate().isEqual(interview.getDateTime().toLocalDate()) &&
                !newDateTimeInterview.toLocalDate().isBefore(LocalDate.now()))  {
            interview.addNewSchedule(newDateTimeInterview);
            return interviewDAO.update(interview);
        }

        return false;
    }

    public boolean companyAcceptInterview(Company company, Interview interview, LocalDateTime newDateTimeInterview) {
        if (!company.equals(interview.getCompany()))
            throw new EntityNotAvaliableException("Company not can access this interview");

        interview.companyUnacceptCombinedInterview();

        // !! Create validator to it.
        if(!newDateTimeInterview.toLocalDate().isEqual(interview.getDateTime().toLocalDate()) &&
                !newDateTimeInterview.toLocalDate().isBefore(LocalDate.now()))  {
            interview.addNewSchedule(newDateTimeInterview);
            return interviewDAO.update(interview);
        }

        return false;
    }

}
