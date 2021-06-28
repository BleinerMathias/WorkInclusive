package br.edu.ifsp.domain.usecases.candidacy;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.company.Company;

import java.util.List;

public class ListCandidacyUseCase {

    CandidacyDAO candidacyDAO;

    public ListCandidacyUseCase(CandidacyDAO candidacyDAO) {
        this.candidacyDAO = candidacyDAO;
    }

    public List<Candidacy> listAllCandidacy(Company company){
        return candidacyDAO.findByCompany(company.getCNPJ());
    }


}
