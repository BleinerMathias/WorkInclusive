package br.edu.ifsp.domain.entities.candidate;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PersonalData {
    private String name;
    private String cpf;
    private LocalDate dateOfBirth;
    private String postCode;
    private String nacionalidade;
    private List<String> phone;
    private List<String> email;

    public PersonalData(String name, String cpf, LocalDate dateOfBirth, String postCode, String nationality, List<String> phone, List<String> email) {
        this.name = name;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.postCode = postCode;
        this.nacionalidade = nacionalidade;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", postCode='" + postCode + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", phone=" + phone +
                ", email=" + email +
                '}';
    }
}
