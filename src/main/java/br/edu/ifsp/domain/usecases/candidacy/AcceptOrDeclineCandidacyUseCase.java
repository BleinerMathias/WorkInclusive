package br.edu.ifsp.domain.usecases.candidacy;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidacy.StatusCandidacy;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

public class AcceptOrDeclineCandidacyUseCase {

    private CandidacyDAO candidacyDAO;
    private FindCandidacyUseCase findCandidacyUseCase;

    public AcceptOrDeclineCandidacyUseCase(CandidacyDAO candidacyDAO, FindCandidacyUseCase findCandidacyUseCase) {
        this.candidacyDAO = candidacyDAO;
        this.findCandidacyUseCase = findCandidacyUseCase;
    }

    public boolean accept(Company company, Candidacy candidacy) {

        if(findCandidacyUseCase.findCandidacyById(candidacy.getId()).isEmpty())
            throw new EntityNotFoundException("ID candidacy not found.");

        if (company.getCNPJ().equals(candidacy.getVacancy().getCompany().getCNPJ())){
            candidacy.setStatusCandidacy(StatusCandidacy.ACCEPT);
            candidacyDAO.update(candidacy);
            return true;
        }

        return false;
    }

    public boolean decline(Company company, Candidacy candidacy){
        if (findCandidacyUseCase.findCandidacyById(candidacy.getId()).isEmpty())
            throw new EntityNotFoundException("ID candidacy not found.");

        if(company.getCNPJ().equals(candidacy.getVacancy().getCompany().getCNPJ())){
            candidacy.setStatusCandidacy(StatusCandidacy.UNACCEPT);
            candidacyDAO.update(candidacy);
            return true;
        }

        return false;
    }

}

