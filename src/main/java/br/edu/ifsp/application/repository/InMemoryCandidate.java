package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.usecases.Candidate.CandidateDAO;

import java.util.*;

public class InMemoryCandidate implements CandidateDAO {

    private static final Map<String, Candidate> db = new LinkedHashMap<>();

    @Override
    public Optional<Candidate> findByCPF(String cpf) {
        return db.values().stream()
                .filter(candidate -> candidate.getPersonalData().getCpf().equals(cpf))
                .findAny();
    }

    @Override
    public String create(Candidate candidate) {
        db.put(candidate.getPersonalData().getCpf(),candidate);
        return candidate.getPersonalData().getCpf();
    }

    @Override
    public Optional<Candidate> findOne(String cpf) {
       if(db.containsKey(cpf)){
           return Optional.of(db.get(cpf));
       }
        return Optional.empty();
    }

    @Override
    public List<Candidate> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Candidate candidate) {
        String cpf = candidate.getPersonalData().getCpf();
        if(db.containsKey(cpf)){
            db.replace(cpf, candidate);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(String cpf) {
        if (db.containsKey(cpf)) {
            db.remove(cpf);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Candidate candidate) {
        return deleteByKey(candidate.getPersonalData().getCpf());
    }
}
