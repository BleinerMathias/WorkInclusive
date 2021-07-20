package br.edu.ifsp.domain.entities.candidate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonalData {
    private String name;
    private String cpf;
    private LocalDate dateOfBirth;
    private String postCode;
    private String nationality;
    private List<Phone> phones;
    private List<Email> emails;

    public PersonalData(String name, String cpf, LocalDate dateOfBirth, String postCode, String nationality) {
        this(name, cpf, dateOfBirth, postCode, nationality,null,null);
    }

    public PersonalData(String name, String cpf, LocalDate dateOfBirth, String postCode, String nationality, List<Phone> phones, List<Email> emails) {
        this.name = name;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.postCode = postCode;
        this.nationality = nationality;
        this.phones = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    public PersonalData() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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


    @Override
    public String toString() {
        return "PersonalData{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", postCode='" + postCode + '\'' +
                ", nationality='" + nationality + '\'' +
                ", phone=" + phones +
                ", email=" + emails +
                '}';
    }
}
