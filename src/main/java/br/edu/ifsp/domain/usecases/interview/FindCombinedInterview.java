package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

import java.util.List;

public class FindCombinedInterview {
    private InterviewDAO interviewDAO;

    public FindCombinedInterview(InterviewDAO interviewDAO) {
        this.interviewDAO = interviewDAO;
    }

    public List<Interview> findAllCombinedInterviewByCompany(Company company){
        if(company == null)
            throw new EntityNotFoundException("Company is null");
        return interviewDAO.findAllCombinedInterviewByCompany(company);
    }

    public List<Interview> findCombinedInterviewByCandidate(Candidate candidate){
        if(candidate == null)
            throw new EntityNotFoundException("Candidate is null");
        return interviewDAO.findAllCombinedInterviewByCandidate(candidate);
    }
}

