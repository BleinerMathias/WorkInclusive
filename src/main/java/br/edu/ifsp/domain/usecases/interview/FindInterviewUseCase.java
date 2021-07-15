package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

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

    public Optional<Interview> findInterviewById(Integer id){
       if(interviewDAO.findOne(id).isEmpty())
           throw new EntityNotFoundException("Interview is not found!");

       return interviewDAO.findOne(id);
    }


}
