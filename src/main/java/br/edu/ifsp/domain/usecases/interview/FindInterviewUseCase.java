package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.interview.Interview;

import java.util.List;
import java.util.Optional;

public class FindInterviewUseCase {
    private InterviewDAO interviewDAO;

    public FindInterviewUseCase(InterviewDAO interviewDAO) {
        this.interviewDAO = interviewDAO;
    }

    public List<Interview> findInterviewByCandidate(Candidate candidate){

        if(candidate != null)
            return interviewDAO.findAllInterviewByCandidate(candidate);

        return null;
    }

}
