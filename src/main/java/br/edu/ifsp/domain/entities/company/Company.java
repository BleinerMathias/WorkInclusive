package br.edu.ifsp.domain.entities.company;

import br.edu.ifsp.domain.entities.candidate.Email;
import br.edu.ifsp.domain.entities.candidate.Phone;
import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import br.edu.ifsp.domain.entities.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company extends User {
    private String name;
    private String companyName;
    private String sector;
    private String CNPJ;
    private List<Email> emails;
    private List<Phone> phones;
    private String address;
    private String postCode;
    private List<Accessibility> accessibilities;

    public Company(){

    }

    public Company(String name, String companyName, String sector, String CNPJ, String address, String postCode) {
        this(name,companyName,sector,CNPJ, null, null,address,postCode,null);
    }

    public Company(String name, String companyName, String sector, String CNPJ, List<Phone> phones, List<Email> emails,  String address, String postCode, List<Accessibility> accessibilities) {
        this.name = name;
        this.companyName = companyName;
        this.sector = sector;
        this.CNPJ = CNPJ;
        this.emails = new ArrayList<>();
        this.phones = new ArrayList<>();
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

    // ?
    public List<Phone> getPhone() {
        return phones;
    }
    public void setPhone(List<Phone> phones) {
        this.phones = phones;
    }
    public List<Email> getEmail() {
        return emails;
    }
    public void setEmail(List<Email> emails) {
        this.emails = emails;
    }
    //?

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
        phones.add(new Phone(phoneNumber));
    }
    public void removePhone(String phoneNumber){
        phones.remove(phoneNumber);
    }

    public void addEmail(String emailAddress){
        emails.add(new Email(emailAddress));
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

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void setAccessibilities(List<Accessibility> accessibilities) {
        this.accessibilities = accessibilities;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", sector='" + sector + '\'' +
                ", CNPJ='" + CNPJ + '\'' +
                ", emails=" + emails +
                ", phones=" + phones +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", accessibilities=" + accessibilities +
                '}';
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
