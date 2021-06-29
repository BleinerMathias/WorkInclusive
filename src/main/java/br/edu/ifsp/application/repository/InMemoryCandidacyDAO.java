package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.candidacy.CandidacyDAO;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryCandidacyDAO implements CandidacyDAO {

    private static final Map<Integer, Candidacy> db = new LinkedHashMap<>();
    private static int id;


    @Override
    public Integer create(Candidacy candidacy) {
        id++;
        candidacy.setId(id);
        db.put(id, candidacy);
        return id;
    }

    @Override
    public Optional<Candidacy> findOne(Integer id) {
        if(db.containsKey(id)){
            return Optional.of(db.get(id));
        }
        return Optional.empty();
    }

    @Override
    public List<Candidacy> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Candidacy candidacy) {
        return false;
    }

    @Override
    public boolean deleteByKey(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Candidacy type) {
        return false;
    }


    @Override
    public List<Candidacy> findAllByVancancy(Company company, Vacancy vacancy) {
        return new ArrayList<>(db.values().stream()
                .filter(candidacy -> candidacy.getVacancy().getCompany().getCNPJ().equals(company.getCNPJ()))
                .filter(candidacy -> candidacy.getVacancy().getId().equals(vacancy.getId()))
                .collect(Collectors.toList()));
    }
}
