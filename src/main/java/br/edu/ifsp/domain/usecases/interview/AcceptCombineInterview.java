package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.utils.EntityNotAvaliableException;

public class AcceptCombineInterview {
    private InterviewDAO interviewDAO;
    private FindInterviewUseCase findInterviewUseCase;

    public AcceptCombineInterview(InterviewDAO interviewDAO, FindInterviewUseCase findInterviewUseCase) {
        this.interviewDAO = interviewDAO;
    }

    public boolean candidateAcceptInterview(Candidate candidate, Interview interview) {
        if (!candidate.equals(interview.getCandidacy().getCandidate()))
            throw new EntityNotAvaliableException("Candidate not can access this interview");


        if(interview.isAcceptCompany() && !interview.isCombined()) {
            interview.candidateAcceptDateTimeInterview();
            interview.combined();
            return interviewDAO.update(interview);
        }

        return true;
    }

    public boolean companyAcceptInterview(Company company, Interview interview) {
        if (!company.equals(interview.getCompany()))
            throw new EntityNotAvaliableException("Company not can access this interview");

        if(interview.isAcceptCandidate() && !interview.isCombined()) {
            interview.companyAcceptDateTimeInterview();
            interview.combined();
            return interviewDAO.update(interview);
        }

        return true;
    }

}
