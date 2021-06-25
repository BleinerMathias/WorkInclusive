package br.edu.ifsp.domain.usecases.Company;


import br.edu.ifsp.domain.entities.company.Company;

import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateCompanyUseCase {
    private CompanyDAO companyDAO;

    public CreateCompanyUseCase(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public String insert(Company company){
        Validator<Company> validator = new CompanyInputValidator();
        Notification notification = validator.validate(company);

        if(notification.hasError()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        String cnpj = company.getCNPJ();
        if(companyDAO.findCNPJ(cnpj).isPresent()){
            throw new EntityAlreadyExistsException("This CNPJ is already in use.");
        }
        return companyDAO.create(company);
    }
}
