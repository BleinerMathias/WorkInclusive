package br.edu.ifsp.domain.usecases.Company;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.List;
import java.util.Optional;

public interface CompanyDAO extends DAO<Company, String> {
    Optional<Company> findByCNPJ(String cnpj);
    Optional<Company> findByUserID(int user_id);
}

