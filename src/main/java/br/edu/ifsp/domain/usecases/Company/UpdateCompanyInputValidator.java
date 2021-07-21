package br.edu.ifsp.domain.usecases.Company;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.candidate.Email;
import br.edu.ifsp.domain.entities.candidate.Phone;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.ArrayList;

public class UpdateCompanyInputValidator extends Validator<Company> {

    @Override
    public Notification validate(Company company) {
        Notification notification = new Notification();
        if (company == null) {
            notification.addError("Company is null");
            return notification;
        }
        //(não será possível excluir o telefone ou e-mail caso só tenha um cadastrado em company tbm),
        ArrayList<Email> emails = new ArrayList<>(company.getEmail());
        if(emails.size() < 1){
            notification.addError("Email can't be null");
        }

        ArrayList<Phone> phones = new ArrayList<>(company.getPhone());
        if(phones.size() < 1){
            notification.addError("Phone can't be null");
        }
        return notification;
    }
}
