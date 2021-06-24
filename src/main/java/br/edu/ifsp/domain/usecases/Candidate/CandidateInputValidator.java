package br.edu.ifsp.domain.usecases.Candidate;

import br.edu.ifsp.domain.entities.candidate.AcademicEducation;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.candidate.ProfessionalExperience;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CandidateInputValidator extends Validator<Candidate> {

    @Override
    public Notification validate(Candidate candidate) {
        Notification notification = new Notification();

        if (candidate == null) {
            notification.addError("Candidate is null");
            return notification;
        }

        // Personal Data validate

        if (nullOrEmpty(candidate.getPersonalData().getCpf())) {
            notification.addError("CPF is null or empty");
        }

        if (!nullOrEmpty(candidate.getPersonalData().getEmail())) {
            ArrayList<String> emails = new ArrayList<>();
            for (String email : emails) {
                if (isEmail(email)) {
                    notification.addError("Email is invalid");
                }
            }
        } else {
            notification.addError("Emails are null or empty");
        }

        if (nullOrEmpty(candidate.getPersonalData().getNationality())) {
            notification.addError("Nationality is null or empty");
        }

        if (nullOrEmpty(candidate.getPersonalData().getName())) {
            notification.addError("Name is null or empty");
        }

        if (!nullOrEmpty(Collections.singleton(candidate.getPersonalData().getPhone().isEmpty()))) {
            ArrayList<String> phones = new ArrayList<>();
            for (String phone : phones) {
                if (isEmail(phone)) {
                    notification.addError("Phone is invalid");
                }
            }
        } else {
            notification.addError("Phones are null or empty");
        }

        if (!nullOrEmpty(candidate.getPersonalData().getPostCode()) && !isPostCode(candidate.getPersonalData().getPostCode())) {
            notification.addError("Post code is null or invalid");
        }

        if (nullOrEmpty(candidate.getPersonalData().getDateOfBirth().toString())) {
            notification.addError("BirthDate is null or empty");
        }

        if (validateDateAfterToday(candidate.getPersonalData().getDateOfBirth())) {
            notification.addError("BirthDate invalid");
        }

        // Professional Experience Validate

        List<ProfessionalExperience> professionalExperienceList = (List<ProfessionalExperience>) new ProfessionalExperience();
        for (ProfessionalExperience pe : professionalExperienceList) {
            if (nullOrEmpty(pe.getCompanyName())) {
                notification.addError("Company name is null or empty");
            }

            if (!nullOrEmpty(pe.getAdmissionDate().toString()) && !validateDateAfterToday(pe.getAdmissionDate())) {
                notification.addError("Admission date is null or invalid");
            }

            if (nullOrEmpty(pe.getOffice())) {
                notification.addError("Office is null or empty");
            }

            if (nullOrEmpty(pe.getCarriedActivities())) {
                notification.addError("CarriedActivities is null or empty");
            }
        }

        // Academic Education Validate
        List<AcademicEducation> academicEducationList = (List<AcademicEducation>) new AcademicEducation();
        for (AcademicEducation ae : academicEducationList) {
            if (nullOrEmpty(ae.getCourse())){
                notification.addError("Course is null or empty");
            }
            if (!nullOrEmpty(ae.getCourseStart().toString()) && !validateDateAfterToday(ae.getCourseStart())) {
                notification.addError("Course Start is null or invalid");
            }
            if (nullOrEmpty(ae.getCourseEnd().toString())){
                notification.addError("Course END is null or empty");
            }
            if (nullOrEmpty(ae.getAcademicInstitution())){
                notification.addError("Academic Institution is null or empty");
            }
        }

        return notification;
    }
}
