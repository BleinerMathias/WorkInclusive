package br.edu.ifsp.domain.entities.interview;
import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Interview {
    private Integer id;
    private LocalDateTime dateTime;
    private String address;
    private Candidacy candidacy;
    private Company company;
    private List<SchedulesHistory> schedulesHistoryList;
    private boolean acceptCompany = false;
    private boolean acceptCandidate = false;
    private boolean combined = false;

    public Interview(LocalDateTime dateTime, String address, Candidacy candidacy, Company company) {
        this(null,dateTime,address,candidacy,company);
    }

    public Interview(Integer id, LocalDateTime dateTime, String address, Candidacy candidacy, Company company) {
        this.id = id;
        this.dateTime = dateTime;
        this.address = address;
        this.candidacy = candidacy;
        this.company = company;
        this.schedulesHistoryList = new ArrayList<>();
        addNewSchedule(dateTime);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(id, interview.id) && Objects.equals(dateTime, interview.dateTime) && Objects.equals(address, interview.address) && Objects.equals(candidacy, interview.candidacy) && Objects.equals(company, interview.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, address, candidacy, company);
    }

    public void addNewSchedule(LocalDateTime dateTime){

        schedulesHistoryList.add(new SchedulesHistory(dateTime));
        setDateTime(dateTime);
    }

    public void candidateAcceptDateTimeInterview(){
        acceptCandidate = true;
    }

    public void companyAcceptDateTimeInterview(){
        acceptCompany = true;
    }

    public boolean isAcceptCompany() {
        return acceptCompany;
    }

    public boolean isAcceptCandidate() {
        return acceptCandidate;
    }

    public void candidateUnacceptCombinedInterview(){
        acceptCompany = false;
        candidateAcceptDateTimeInterview();
    }

    public void companyUnacceptCombinedInterview(){
        acceptCandidate = false;
        companyAcceptDateTimeInterview();
    }
    public void combined(){
        combined = true;
    }

    public boolean isCombined() {
        return combined;
    }

    public List<SchedulesHistory> getSchedulesHistoryList() {
        return schedulesHistoryList;
    }
    public void addNewDateTime(LocalDateTime newDateTime){

    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", name= " + candidacy.getCandidate().getPersonalData().getName() +
                ", date interview= " + dateTime.getDayOfMonth() +"/"+ dateTime.getMonthValue() + "/" + dateTime.getYear() +
                ", hour interview= " + dateTime.getHour() +":"+ dateTime.getMinute()  +
                ", empresa aceitou = " + acceptCompany +
                ", candidato aceitou = " + acceptCandidate +
                ", address='" + address + '\'' +
                ", vaga=" + candidacy.getVacancy().getDescription() +
                ", company=" + company.getCompanyName() +
                '}';
    }
}
