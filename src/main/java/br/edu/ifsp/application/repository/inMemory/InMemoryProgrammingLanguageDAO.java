package br.edu.ifsp.application.repository.inMemory;

import br.edu.ifsp.domain.entities.ProgammingLanguage;
import br.edu.ifsp.domain.usecases.progammingLanguage.ProgrammingLanguageDAO;

import java.util.*;

public class InMemoryProgrammingLanguageDAO implements ProgrammingLanguageDAO {

    private static Map<Integer, ProgammingLanguage> db = new LinkedHashMap<>();
    private static int id;

    @Override
    public Integer create(ProgammingLanguage progammingLanguage) {
        id++;
        progammingLanguage.setId(id);
        db.put(id,progammingLanguage);
        return null;
    }

    @Override
    public Optional<ProgammingLanguage> findOne(Integer id) {
        if(db.containsKey(id))
            return Optional.of(db.get(id));
        return Optional.empty();
    }

    @Override
    public List<ProgammingLanguage> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(ProgammingLanguage progammingLanguage) {
        Integer id =  progammingLanguage.getId();
        db.replace(id, progammingLanguage);
        return true;
    }

    @Override
    public boolean deleteByKey(Integer id) {
        db.remove(id);
        return true;
    }

    @Override
    public boolean delete(ProgammingLanguage progammingLanguage) {
        Integer id =  progammingLanguage.getId();
        return deleteByKey(id);
    }

    @Override
    public Optional<ProgammingLanguage> findByName(String name) {

        Optional<ProgammingLanguage> value = db.values().stream().
                filter(lip -> lip.getName().equals(name))
                .findAny();

        if(!value.isEmpty())
            return value;
        return Optional.empty();
    }
}
