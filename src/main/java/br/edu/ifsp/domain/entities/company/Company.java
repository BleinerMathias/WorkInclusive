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
    private List<String> emails;
    private List<String> phones;
    private String address;
    private String postCode;
    private List<Accessibility> accessibilities;

    public Company(){
    }

    public Company(String name, String companyName, String sector, String CNPJ,  String address, String postCode) {
        this.name = name;
        this.companyName = companyName;
        this.sector = sector;
        this.CNPJ = CNPJ;
        this.emails = new ArrayList<>();
        this.phones = new ArrayList<>();;
        this.address = address;
        this.postCode = postCode;
        this.accessibilities = new ArrayList<>();
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
        return emails;
    }

    public void setEmail(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getPhone() {
        return phones;
    }

    public void setPhone(List<String> phones) {
        this.phones = phones;
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


    public void addPhone(String phoneNumber){
        phones.add(phoneNumber);
    }
    public void removePhone(String phoneNumber){
        phones.remove(phoneNumber);
    }

    public void addEmail(String emailAddress){
        emails.add(emailAddress);
    }
    public void removeEmail(String emailAddress){
        emails.remove(emailAddress);
    }

    public void addAccessibility(Accessibility accessibility){
        accessibilities.add(accessibility);
    }
    public void removeAccessibility(Accessibility accessibility){
        accessibilities.remove(accessibility);
    }

    public void createLogin(String username, String password){
        this.setUsername(username);
        this.setPassword(password);
        this.setTypeUser(2);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(companyName, company.companyName) && Objects.equals(sector, company.sector) && Objects.equals(CNPJ, company.CNPJ) && Objects.equals(emails, company.emails) && Objects.equals(phones, company.phones) && Objects.equals(address, company.address) && Objects.equals(postCode, company.postCode) && Objects.equals(accessibilities, company.accessibilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, companyName, sector, CNPJ, emails, phones, address, postCode, accessibilities);
    }

}
