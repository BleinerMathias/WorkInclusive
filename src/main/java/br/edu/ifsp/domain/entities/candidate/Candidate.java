package br.edu.ifsp.domain.entities.candidate;

import br.edu.ifsp.domain.entities.vacancy.Abiliity;
import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.candidacy.MatchCandidacyUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Candidate extends User{
    private PersonalData personalData;
    private List<AcademicEducation> academicEducationsList;
    private List<ProfessionalExperience> professionalExperienceList;
    private List<Accessibility> accessibilities;
    private List<String> abiliities;

    public Candidate() {
    }

    public Candidate(PersonalData personalData) {
        this(personalData, null,null,null,null);
    }

    public Candidate(PersonalData personalData, List<AcademicEducation> academicEducationsList, List<ProfessionalExperience> professionalExperienceList, List<Accessibility> accessibilities, List<String> abiliities) {
        this.personalData = personalData;
        this.academicEducationsList = new ArrayList<>();
        this.professionalExperienceList = new ArrayList<>();
        this.accessibilities = new ArrayList<>();
        this.abiliities = new ArrayList<>();
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

    public List<String> getAbiliities() {
        return abiliities;
    }

    public void setAbiliities(List<String> abiliities) {
        this.abiliities = abiliities;
    }

    public void addAcademicEducation(AcademicEducation academicEducation){
        academicEducationsList.add(academicEducation);
    }
    public void removeAcademicEducation(AcademicEducation academicEducation){
        academicEducationsList.add(academicEducation);
    }

    public void addProfessionalExperience(ProfessionalExperience professionalExperience){
        professionalExperienceList.add(professionalExperience);
    }
    public void removeProfessionalExperience(ProfessionalExperience professionalExperience){
        professionalExperienceList.remove(professionalExperience);
    }

    public void addAccessibility(Accessibility accessibility){
        accessibilities.add(accessibility);
    }
    public void removeAccessibility(Accessibility accessibility){
        accessibilities.remove(accessibility);
    }

    public void addAbility(String abiliity){
        abiliities.add(abiliity);
    }
    public void removeAbility(String abiliity){
        abiliities.remove(abiliity);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(personalData, candidate.personalData) && Objects.equals(academicEducationsList, candidate.academicEducationsList) && Objects.equals(professionalExperienceList, candidate.professionalExperienceList) && Objects.equals(accessibilities, candidate.accessibilities) && Objects.equals(abiliities, candidate.abiliities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalData, academicEducationsList, professionalExperienceList, accessibilities, abiliities);
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
