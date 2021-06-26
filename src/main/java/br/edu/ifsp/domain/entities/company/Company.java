package br.edu.ifsp.domain.entities.company;

import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import br.edu.ifsp.domain.entities.user.User;

import java.util.List;

public class Company extends User {
    private String name;
    private String companyName;
    private String sector;
    private String CNPJ;
    private List<String> email;
    private List<String> phone;
    private String address;
    private String postCode;
    private List<Accessibility> accessibilities;

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
}
