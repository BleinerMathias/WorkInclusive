package br.edu.ifsp.domain.usecases.interview;

import br.edu.ifsp.domain.usecases.Candidate.FindCandidateUseCase;
import br.edu.ifsp.domain.usecases.Candidate.UpdateCandidateUseCase;
import br.edu.ifsp.domain.usecases.Company.FindCompanyUseCase;
import br.edu.ifsp.domain.usecases.Company.UpdateCompanyUseCase;
import br.edu.ifsp.domain.usecases.Vacancy.FindVacancyUseCase;
import br.edu.ifsp.domain.usecases.Vacancy.UpdateVacancyUseCase;

public class MeetInterviewUseCase {
    private InterviewDAO interviewDAO;
    private FindCandidateUseCase findCandidateUseCase;
    private FindVacancyUseCase findVacancyUseCase;

}
