package br.edu.ifsp.application.repository.inMemory;

import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.Vacancy.VacancyDAO;

import java.util.*;

public class InMemoryVacancyDAO implements VacancyDAO {

    private static final Map<Integer, Vacancy> db = new LinkedHashMap<>();
    private static int id;

    @Override
    public Integer create(Vacancy vacancy) {
        id++;
        vacancy.setId(id);
        db.put(id,vacancy);
        return id;
    }

    @Override
    public Optional<Vacancy> findOne(Integer id) {
        if(db.containsKey(id)){
            return Optional.of(db.get(id));
        }
        return Optional.empty();
    }

    @Override
    public List<Vacancy> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Vacancy vacancy) {
        Integer id = vacancy.getId();
        if(db.containsKey(id)){
            db.replace(id, vacancy);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer id) {
        if(db.containsKey(id)){
            db.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Vacancy vacancy) {
        return deleteByKey(vacancy.getId());
    }
}
