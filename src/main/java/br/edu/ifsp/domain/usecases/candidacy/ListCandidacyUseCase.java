package br.edu.ifsp.domain.usecases.candidacy;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;


import java.util.List;

public class ListCandidacyUseCase {

    private CandidacyDAO candidacyDAO;

    public ListCandidacyUseCase(CandidacyDAO candidacyDAO) {
        this.candidacyDAO = candidacyDAO;
    }

    public List<Candidacy> listAllCandidacyByVacancy(Company company, Vacancy vacancy){
        // Create a Exception
        if(!company.getCNPJ().equals(vacancy.getCompany().getCNPJ()))
            return null;
        return candidacyDAO.findAllByVancancy(company, vacancy);
    }

}
