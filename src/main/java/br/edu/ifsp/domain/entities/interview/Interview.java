package br.edu.ifsp.domain.entities.interview;
import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;

import java.time.LocalDateTime;

public class Interview {
    private Integer id;
    private LocalDateTime dateTime;
    private String address;
    private Candidacy candidacy;
    private Company company;


    public Interview(LocalDateTime dateTime, String address, Candidacy candidacy, Company company) {
        this.dateTime = dateTime;
        this.address = address;
        this.candidacy = candidacy;
        this.company = company;
    }

    public Interview(Integer id, LocalDateTime dateTime, String address, Candidacy candidacy, Company company) {
        this.id = id;
        this.dateTime = dateTime;
        this.address = address;
        this.candidacy = candidacy;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Candidacy getCandidacy() {
        return candidacy;
    }

    public void setCandidacy(Candidacy candidacy) {
        this.candidacy = candidacy;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", date=" + dateTime +
                ", address='" + address + '\'' +
                ", candidate=" + candidacy +
                ", company=" + company +
                '}';
    }
}
