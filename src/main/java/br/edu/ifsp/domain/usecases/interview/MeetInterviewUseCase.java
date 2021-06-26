package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.usecases.Candidate.FindCandidateUseCase;
import br.edu.ifsp.domain.usecases.Candidate.UpdateCandidateUseCase;
import br.edu.ifsp.domain.usecases.Company.FindCompanyUseCase;
import br.edu.ifsp.domain.usecases.Company.UpdateCompanyUseCase;

public class MeetInterviewUseCase {
    private InterviewDAO interviewDAO;
    private FindCandidateUseCase findCandidateUseCase;
    private FindCompanyUseCase findCompanyUseCase;
    private UpdateCandidateUseCase updateCandidateUseCase;
    private UpdateCompanyUseCase updateCompanyUseCase;

    public MeetInterviewUseCase(
            InterviewDAO interviewDAO,
            FindCandidateUseCase findCandidateUseCase,
            FindCompanyUseCase findCompanyUseCase,
            UpdateCandidateUseCase updateCandidateUseCase,
            UpdateCompanyUseCase updateCompanyUseCase) {

        this.interviewDAO = interviewDAO;
        this.findCandidateUseCase = findCandidateUseCase;
        this.findCompanyUseCase = findCompanyUseCase;
        this.updateCandidateUseCase = updateCandidateUseCase;
        this.updateCompanyUseCase = updateCompanyUseCase;
    }
}
