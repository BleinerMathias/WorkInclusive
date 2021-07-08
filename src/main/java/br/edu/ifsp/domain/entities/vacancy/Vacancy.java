package br.edu.ifsp.domain.entities.vacancy;

import br.edu.ifsp.domain.entities.company.Company;

import java.util.ArrayList;
import java.util.List;

public class Vacancy {
    private Integer id;
    private String name;
    private String description;
    private Hierarchy hierarchy;
    private Integer compatibilidade;
    private Double salary;
    private List<Benefits> benefitsList;
    private List<Accessibility> accessibilityList;
    private List<String> abiliityList;
    private StatusVacancy statusVacancy;
    private Company company;

    public Vacancy(String name, String description, Hierarchy hierarchy, Double salary, StatusVacancy statusVacancy, Company company) {
      this(null, name, description, hierarchy, 0,salary,null,null,null, statusVacancy, company);
    }

    public Vacancy(Integer id, String name, String description, Hierarchy hierarchy, Integer compatibilidade, Double salary, List<Benefits> benefitsList, List<Accessibility> accessibilityList, List<String> abiliityList, StatusVacancy statusVacancy, Company company) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hierarchy = hierarchy;
        this.compatibilidade = compatibilidade;
        this.salary = salary;
        this.benefitsList = new ArrayList<>();
        this.accessibilityList= new ArrayList<>();
        this.abiliityList = new ArrayList<>();
        this.statusVacancy = statusVacancy;
        this.company = company;
    }

    public Vacancy() {
        compatibilidade = 0;
        statusVacancy = StatusVacancy.AVAILABLE;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Benefits> getBenefitsList() {
        return benefitsList;
    }

    public void setBenefitsList(List<Benefits> benefitsList) {
        this.benefitsList = benefitsList;
    }

    public List<Accessibility> getAccessibilityList() {
        return accessibilityList;
    }

    public void setAccessibilityList(List<Accessibility> accessibilityList) {
        this.accessibilityList = accessibilityList;
    }

    public List<String> getAbiliityList() {
        return abiliityList;
    }

    public void setAbiliityList(List<String> abiliityList) {
        this.abiliityList = abiliityList;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

    public StatusVacancy getStatusVacancy() {
        return statusVacancy;
    }

    public void setStatusVacancy(StatusVacancy statusVacancy) {
        this.statusVacancy = statusVacancy;
    }

    public Company getCompany() {
        return company;
    }

    public void addBenefits(Benefits benefits){
        benefitsList.add(benefits);
    }
    public void removeBenefits(Benefits benefits){
        benefitsList.remove(benefits);
    }

    public void addAccessibility(Accessibility accessibility){
        accessibilityList.add(accessibility);
    }
    public void removeAccessibility(Accessibility accessibility){
        accessibilityList.remove(accessibility);
    }

    public void addAbiliity(String abiliity){
        abiliityList.add(abiliity);
    }
    public void removeAbiliity(String abiliity){
        abiliityList.remove(abiliity);
    }



    @Override
    public String toString() {
        return "Vacancy{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hierarchy=" + hierarchy +
                ", compatibilidade=" + compatibilidade +
                ", Salary=" + salary +
                ", benefits=" + benefitsList +
                ", accessibility=" + accessibilityList +
                ", abiliity=" + abiliityList +
                ", company=" + company.getCompanyName() +
                ", statusVacancy=" + statusVacancy +
                '}'+ '\n';
    }
}
