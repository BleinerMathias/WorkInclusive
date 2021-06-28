package br.edu.ifsp.domain.entities.interview;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;

import java.time.LocalDateTime;

public class Interview {
    private Integer id;
    private LocalDateTime date;
    private LocalDateTime timeOfInterview;
    private String address;
    private Candidate candidate;
    private Company company;


    public Interview(LocalDateTime date, LocalDateTime timeOfInterview, String address, Candidate candidate, Company company) {
        this.date = date;
        this.timeOfInterview = timeOfInterview;
        this.address = address;
        this.candidate = candidate;
        this.company = company;
    }

    public Interview(Integer id, LocalDateTime date, LocalDateTime timeOfInterview, String address, Candidate candidate, Company company) {
        this.id = id;
        this.date = date;
        this.timeOfInterview = timeOfInterview;
        this.address = address;
        this.candidate = candidate;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getTimeOfInterview() {
        return timeOfInterview;
    }

    public void setTimeOfInterview(LocalDateTime timeOfInterview) {
        this.timeOfInterview = timeOfInterview;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
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
                ", date=" + date +
                ", timeOfInterview=" + timeOfInterview +
                ", address='" + address + '\'' +
                ", candidate=" + candidate +
                ", company=" + company +
                '}';
    }
}
