package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.utils.EntityNotAvaliableException;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

public class AcceptInterview {
    private InterviewDAO interviewDAO;
    private FindInterviewUseCase findInterviewUseCase;

    public AcceptInterview(InterviewDAO interviewDAO, FindInterviewUseCase findInterviewUseCase) {
        this.interviewDAO = interviewDAO;
    }

    public boolean candidateAcceptInterview(Candidate candidate, Interview interview) {
        if (!candidate.equals(interview.getCandidacy().getCandidate()))
            throw new EntityNotAvaliableException("Candidate not can access this interview");

        interview.candidateAcceptDateTimeInterview();
        return interviewDAO.update(interview);
    }


}
