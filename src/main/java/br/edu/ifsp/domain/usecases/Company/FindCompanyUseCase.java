package br.edu.ifsp.domain.usecases.Company;

import br.edu.ifsp.domain.entities.company.Company;

import java.util.List;
import java.util.Optional;

public class FindCompanyUseCase {

    private CompanyDAO companyDAO;

    public FindCompanyUseCase(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public Optional<Company> findByCNPJ(String cnpj){
        if (cnpj == null)
            throw new IllegalArgumentException("CNPJ can not be null.");
        return companyDAO.findByCNPJ(cnpj);
    }

    public List<Company> findAll(){
        return companyDAO.findAll();
    }
}
