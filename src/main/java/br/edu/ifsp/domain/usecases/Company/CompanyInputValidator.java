package br.edu.ifsp.domain.usecases.Company;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.ArrayList;
import java.util.Collections;

public class CompanyInputValidator extends Validator<Company> {

    @Override
    public Notification validate(Company company) {
        Notification notification = new Notification();

        if (company == null) {
            notification.addError("Company is null");
            return notification;
        }

        if (nullOrEmpty(company.getName())) {
            notification.addError("Name is null or empty");
        }

        if (nullOrEmpty(company.getCompanyName())) {
            notification.addError("Company name is null or empty");
        }

        if (nullOrEmpty(company.getCNPJ())) {
            notification.addError("CNPJ is null or empty");
        }

        if (nullOrEmpty(company.getSector())) {
            notification.addError("Sector is null or empty");
        }
        // Test list
        if (nullOrEmpty(company.getAccessibilities())) {
            notification.addError("Accessibilities is null or empty");
        }

        if (nullOrEmpty(company.getAddress())) {
            notification.addError("Address is null or empty");
        }

        if (nullOrEmpty(company.getPostCode())) {
            notification.addError("Post code is null or empty");
        }

        if (!nullOrEmpty(company.getEmail())) {
            ArrayList<String> emails = new ArrayList<>();
            for (String email : emails) {
                if (isEmail(email)) {
                    notification.addError("Email is invalid");
                }
            }
        } else {
            notification.addError("Emails are null or empty");
        }

        if (!nullOrEmpty(Collections.singleton(company.getPhone().isEmpty()))) {
            ArrayList<String> phones = new ArrayList<>();
            for (String phone : phones) {
                if (isPhone(phone)) {
                    notification.addError("Phone is invalid");
                }
            }
        } else {
            notification.addError("Phones are null or empty");
        }
        return notification;
    }
}
