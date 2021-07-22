package br.edu.ifsp.application.repository.inMemory;

import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.usecases.Company.CompanyDAO;

import java.util.*;

public class InMemoryCompanyDAO implements CompanyDAO {
    private static final Map<Integer, Company> db = new LinkedHashMap<>();
    private static int id;
    @Override
    public Optional<Company> findByCNPJ(String cnpj) {
        return db.values().stream()
                .filter(company -> company.getCNPJ().equals(cnpj))
                .findAny();
    }

    @Override
    public Optional<Company> findByUserID(int user_id) {
        return Optional.empty();
    }

    @Override
    public Optional<Company> findByLogin(String userName, String password) {
        return Optional.empty();
    }

    @Override
    public Integer create(Company company) {
        id++;
        db.put(id, company);
        return id;
    }

    @Override
    public Optional<Company> findOne(Integer id) {
      if(db.containsKey(id)){
          return Optional.of(db.get(id));
      }
      return Optional.empty();
    }

    @Override
    public List<Company> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Company company) {
        Integer id =  company.getId();
        if(db.containsKey(id)){
            db.replace(id,company);
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
    public boolean delete(Company company) {
        return deleteByKey(company.getId());
    }
}
