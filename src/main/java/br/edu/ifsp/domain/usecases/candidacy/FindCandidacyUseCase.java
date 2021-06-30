package br.edu.ifsp.domain.usecases.candidacy;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;

import java.util.Optional;

public class FindCandidacyUseCase {

    CandidacyDAO candidacyDAO;

    public FindCandidacyUseCase(CandidacyDAO candidacyDAO) {
        this.candidacyDAO = candidacyDAO;
    }

    public Optional<Candidacy> findCandidacyById(Integer id){
        return candidacyDAO.findCandidacyById(id);
    }


}
