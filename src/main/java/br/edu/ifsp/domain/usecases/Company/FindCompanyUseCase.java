package br.edu.ifsp.domain.usecases.Company;

import br.edu.ifsp.domain.entities.company.Company;

import java.util.List;
import java.util.Optional;

public class FindCompanyUseCase {

    private CompanyDAO companyDAO;

    public FindCompanyUseCase(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public Optional<Company> findByCNPJ(String cpf){
        if (cpf == null)
            throw new IllegalArgumentException("CNPJ can not be null.");
        return companyDAO.findOne(cpf);
    }

    public List<Company> findAll(){
        return companyDAO.findAll();
    }
}
