package br.edu.ifsp.domain.entities.company;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.candidacy.ListCandidacyUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company extends User {
    private String name;
    private String companyName;
    private String sector;
    private String CNPJ;
    private List<String> email = new ArrayList<>();
    private List<String> phone = new ArrayList<>();
    private String address;
    private String postCode;
    private List<Accessibility> accessibilities = new ArrayList<>();

    public Company(){
    }

    public Company(String name, String companyName, String sector, String CNPJ, List<String> email, List<String> phone, String address, String postCode, List<Accessibility> accessibilities) {
        this.name = name;
        this.companyName = companyName;
        this.sector = sector;
        this.CNPJ = CNPJ;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postCode = postCode;
        this.accessibilities = accessibilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public List<Accessibility> getAccessibilities() {
        return accessibilities;
    }

    public void setAccessibilities(List<Accessibility> accessibilities) {
        this.accessibilities = accessibilities;
    }

    public List<Candidacy> myListCandidateToVacancy(ListCandidacyUseCase listCandidacyUseCase, Vacancy vacancy){
        return listCandidacyUseCase.listAllCandidacyByVacancy(this, vacancy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(companyName, company.companyName) && Objects.equals(sector, company.sector) && Objects.equals(CNPJ, company.CNPJ) && Objects.equals(email, company.email) && Objects.equals(phone, company.phone) && Objects.equals(address, company.address) && Objects.equals(postCode, company.postCode) && Objects.equals(accessibilities, company.accessibilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, companyName, sector, CNPJ, email, phone, address, postCode, accessibilities);
    }
}
