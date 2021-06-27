package br.edu.ifsp.domain.entities.candidate;

import br.edu.ifsp.domain.entities.vacancy.Abiliity;
import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import br.edu.ifsp.domain.entities.user.User;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Candidate extends User{
    private PersonalData personalData;
    private List<AcademicEducation> academicEducationsList  = new ArrayList<>();
    private List<ProfessionalExperience> professionalExperienceList = new ArrayList<>();
    private List<Accessibility> accessibilities  = new ArrayList<>();
    private List<Abiliity> abiliities  = new ArrayList<>();

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
