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
    private List<Benefits> benefitsList = new ArrayList<>();
    private List<Accessibility> accessibilityList = new ArrayList<>();
    private List<Abiliity> abiliityList = new ArrayList<>();
    private StatusVacancy statusVacancy;
    private Company company;

    public Vacancy(String name, String description, Hierarchy hierarchy, Double salary, List<Benefits> benefitsList, List<Accessibility> accessibilityList, List<Abiliity> abiliityList, StatusVacancy statusVacancy, Company company) {
      this(null, name, description, hierarchy, 0,salary,benefitsList, accessibilityList, abiliityList, statusVacancy, company);
    }

    public Vacancy(Integer id, String name, String description, Hierarchy hierarchy, Integer compatibilidade, Double salary, List<Benefits> benefitsList, List<Accessibility> accessibilityList, List<Abiliity> abiliityList, StatusVacancy statusVacancy, Company company) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hierarchy = hierarchy;
        this.compatibilidade = compatibilidade;
        this.salary = salary;
        this.benefitsList = benefitsList;
        this.accessibilityList = accessibilityList;
        this.abiliityList = abiliityList;
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

    public List<Abiliity> getAbiliityList() {
        return abiliityList;
    }

    public void setAbiliityList(List<Abiliity> abiliityList) {
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

    public Integer getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(Integer compatibilidade) {
        this.compatibilidade = compatibilidade;
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
