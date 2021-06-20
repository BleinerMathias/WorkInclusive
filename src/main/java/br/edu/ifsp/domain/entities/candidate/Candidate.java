package br.edu.ifsp.domain.entities.candidate;

import br.edu.ifsp.domain.entities.candidate.AcademicEducation;
import br.edu.ifsp.domain.entities.user.Abiliity;
import br.edu.ifsp.domain.entities.user.Accessibility;
import br.edu.ifsp.domain.entities.user.User;

import java.time.LocalDate;
import java.util.List;


public class Candidate extends User {
    private PersonalData personalData;
    private List<AcademicEducation> academicEducationsList;
    private List<ProfessionalExperience> professionalExperienceList;
    private List<Accessibility> accessibilities;
    private List<Abiliity> abiliities;

    public Candidate() {
    }

    public Candidate(PersonalData personalData, List<AcademicEducation> academicEducationsList, List<Accessibility> accessibilities, List<Abiliity> abiliities) {
        this(personalData, academicEducationsList,null,accessibilities,abiliities);
    }

    public Candidate(PersonalData personalData, List<AcademicEducation> academicEducationsList, List<ProfessionalExperience> professionalExperienceList, List<Accessibility> accessibilities, List<Abiliity> abiliities) {
        this.personalData = personalData;
        this.academicEducationsList = academicEducationsList;
        this.professionalExperienceList = professionalExperienceList;
        this.accessibilities = accessibilities;
        this.abiliities = abiliities;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public List<AcademicEducation> getAcademicEducationsList() {
        return academicEducationsList;
    }

    public void setAcademicEducationsList(List<AcademicEducation> academicEducationsList) {
        this.academicEducationsList = academicEducationsList;
    }

    public List<ProfessionalExperience> getProfessionalExperienceList() {
        return professionalExperienceList;
    }

    public void setProfessionalExperienceList(List<ProfessionalExperience> professionalExperienceList) {
        this.professionalExperienceList = professionalExperienceList;
    }

    public List<Accessibility> getAccessibilities() {
        return accessibilities;
    }

    public void setAccessibilities(List<Accessibility> accessibilities) {
        this.accessibilities = accessibilities;
    }

    public List<Abiliity> getAbiliities() {
        return abiliities;
    }

    public void setAbiliities(List<Abiliity> abiliities) {
        this.abiliities = abiliities;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "personalData=" + personalData +
                ", academicEducationsList=" + academicEducationsList +
                ", professionalExperienceList=" + professionalExperienceList +
                ", accessibilities=" + accessibilities +
                ", abiliities=" + abiliities +
                "} " + super.toString();
    }
}
