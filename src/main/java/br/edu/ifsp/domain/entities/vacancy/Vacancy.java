package br.edu.ifsp.domain.entities.vacancy;

public class Vacancy {
    private Integer Id;
    private String name;
    private String description;
    private Hierarchy hierarchy;
    private Integer compatibilidade;
    private Double Salary;
    private Benefits benefits;
    private Accessibility accessibility;
    private Abiliity abiliity;
    private StatusVacancy statusVacancy;

    public Vacancy(String name, String description, Hierarchy hierarchy, Integer compatibilidade, Double salary, Benefits benefits, Accessibility accessibility, Abiliity abiliity, StatusVacancy statusVacancy) {
        this(null, name, description, hierarchy, compatibilidade, salary, benefits, accessibility, abiliity, statusVacancy) ;
    }

    public Vacancy(Integer id, String name, String description, Hierarchy hierarchy, Integer compatibilidade, Double salary, Benefits benefits, Accessibility accessibility, Abiliity abiliity, StatusVacancy statusVacancy) {
        this.Id = id;
        this.name = name;
        this.description = description;
        this.hierarchy = hierarchy;
        this.compatibilidade = compatibilidade;
        this.Salary = salary;
        this.benefits = benefits;
        this.accessibility = accessibility;
        this.abiliity = abiliity;
        this.statusVacancy = statusVacancy;
    }

    public Vacancy() {
        compatibilidade = 0;
        statusVacancy = StatusVacancy.AVAILABLE;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public Benefits getBenefits() {
        return benefits;
    }

    public void setBenefits(Benefits benefits) {
        this.benefits = benefits;
    }

    public Accessibility getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Accessibility accessibility) {
        this.accessibility = accessibility;
    }

    public Abiliity getAbiliity() {
        return abiliity;
    }

    public void setAbiliity(Abiliity abiliity) {
        this.abiliity = abiliity;
    }

    public StatusVacancy getStatusVacancy() {
        return statusVacancy;
    }

    public void setStatusVacancy(StatusVacancy statusVacancy) {
        this.statusVacancy = statusVacancy;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hierarchy=" + hierarchy +
                ", compatibilidade=" + compatibilidade +
                ", Salary=" + Salary +
                ", benefits=" + benefits +
                ", accessibility=" + accessibility +
                ", abiliity=" + abiliity +
                ", statusVacancy=" + statusVacancy +
                '}';
    }
}
