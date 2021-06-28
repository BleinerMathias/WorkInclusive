package br.edu.ifsp.domain.usecases.candidacy;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;

public class CandidateSubscribeInVacancy {

    CandidacyDAO candidacyDAO;

    public CandidateSubscribeInVacancy(CandidacyDAO candidacyDAO) {
        this.candidacyDAO = candidacyDAO;
    }

    public Integer subscribe(Candidate candidate, Vacancy vacancy){
       if(candidate!=null && vacancy!=null){
           Candidacy candidacy = new Candidacy(vacancy,candidate);
           return candidacyDAO.create(candidacy);
       }
        return null;
    }
}
