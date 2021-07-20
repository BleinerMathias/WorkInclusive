package br.edu.ifsp.domain.usecases.candidacy;

import br.edu.ifsp.domain.entities.candidate.Ability;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.candidate.ProfessionalExperience;
import br.edu.ifsp.domain.entities.vacancy.Abiliity;
import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.Candidate.FindCandidateUseCase;
import br.edu.ifsp.domain.usecases.Candidate.UpdateCandidateUseCase;
import br.edu.ifsp.domain.usecases.Company.FindCompanyUseCase;
import br.edu.ifsp.domain.usecases.Company.UpdateCompanyUseCase;
import br.edu.ifsp.domain.usecases.Vacancy.FindVacancyUseCase;
import br.edu.ifsp.domain.usecases.Vacancy.UpdateVacancyUseCase;
import br.edu.ifsp.domain.usecases.interview.InterviewDAO;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// This UseCase show to cadidate which vacancies he can apply
public class MatchCandidacyUseCase {
    private InterviewDAO interviewDAO;
    private FindCandidateUseCase findCandidateUseCase;
    private FindVacancyUseCase findVacancyUseCase;

    public MatchCandidacyUseCase(FindCandidateUseCase findCandidateUseCase, FindVacancyUseCase findVacancyUseCase) {
        this.findCandidateUseCase = findCandidateUseCase;
        this.findVacancyUseCase = findVacancyUseCase;
    }

       // Verificar se tem meet
       public List<Vacancy> match(Candidate candidate){
        List<Vacancy> vacancyInSystem = new ArrayList<>(findVacancyUseCase.findAll());
        List<Vacancy> vacancyAccessible = new ArrayList<>();
        List<Vacancy> vacancyMatch = new ArrayList<>();

        // vaga.remove()
        for (Vacancy vacancy : vacancyInSystem) {
           for(Accessibility vaAccessibility: candidate.getAccessibilities()){
              if (vacancy.getAccessibilityList().contains(vaAccessibility)){
                  vacancyAccessible.add(vacancy);
               }
           }
        }


        // Criar variavel para porcentagem
        for (Vacancy vm : vacancyAccessible) {
           Integer countAbility = 0;
           Integer coenfient = (vm.getAbiliityList().size() * 70)/100;

           for(Ability abiliity: candidate.getAbiliities()){
               if (vm.getAbiliityList().contains(abiliity)){
                   countAbility++;
               }
               if(coenfient <= countAbility){
                   vacancyMatch.add(vm);
                   break;
               }
           }
       }
        return vacancyMatch;
    }

}
