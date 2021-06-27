package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.usecases.Company.CompanyDAO;

import java.util.*;

public class InMemoryCompanyDAO implements CompanyDAO {
    private static final Map<String, Company> db = new LinkedHashMap<>();
    @Override
    public Optional<Company> findByCNPJ(String cnpj) {
        return db.values().stream()
                .filter(company -> company.getCNPJ().equals(cnpj))
                .findAny();
    }

    @Override
    public String create(Company company) {
        db.put(company.getCNPJ(), company);
        return company.getCNPJ();
    }

    @Override
    public Optional<Company> findOne(String cnpj) {
      if(db.containsKey(cnpj)){
          return Optional.of(db.get(cnpj));
      }
      return Optional.empty();
    }

    @Override
    public List<Company> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Company company) {
        String cnpj =  company.getCNPJ();
        if(db.containsKey(cnpj)){
            db.replace(cnpj,company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(String cnpj) {
        if(db.containsKey(cnpj)){
            db.remove(cnpj);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Company company) {
        return deleteByKey(company.getCNPJ());
    }
}
