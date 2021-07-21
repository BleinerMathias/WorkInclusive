package br.edu.ifsp.application.repository.inMemory;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.usecases.Candidate.CandidateDAO;

import java.util.*;

public class InMemoryCandidateDAO implements CandidateDAO {

    private static final Map<Integer, Candidate> db = new LinkedHashMap<>();
    private static int id;

    @Override
    public Optional<Candidate> findByCPF(String cpf) {
        return db.values().stream()
                .filter(candidate -> candidate.getPersonalData().getCpf().equals(cpf))
                .findAny();
    }


    @Override
    public Integer create(Candidate candidate) {
        id++;
        db.put(id,candidate);
        return id;
    }

    @Override
    public Optional<Candidate> findOne(Integer id) {
       if(db.containsKey(id)){
           return Optional.of(db.get(id));
       }
        return Optional.empty();
    }

    @Override
    public List<Candidate> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Candidate candidate) {
        Integer id = candidate.getId();
        if(db.containsKey(id)){
            db.replace(id, candidate);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer id) {
        if (db.containsKey(id)) {
            db.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Candidate candidate) {
        return deleteByKey(candidate.getId());
    }
}
