package br.edu.ifsp.domain.usecases.Company;

import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateCompanyUseCase {
    private CompanyDAO companyDAO;

    public UpdateCompanyUseCase(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public boolean update(Company company){
        Validator<Company> validator = new UpdateCompanyInputValidator();
        Notification notification = validator.validate(company);

        if(notification.hasError()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        String cnpj = company.getCNPJ();
        if(companyDAO.findByCNPJ(cnpj).isEmpty()){
            throw new EntityNotFoundException("CNPJ not found.");
        }
        return companyDAO.update(company);
    }
}
