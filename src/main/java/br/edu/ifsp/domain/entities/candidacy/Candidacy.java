package br.edu.ifsp.domain.entities.candidacy;

import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;

public class Candidacy {
    private int id;
    private Vacancy vacancy;
    private Candidate candidate;
    private StatusCandidacy statusCandidacy;

    public Candidacy() {
    }

    public Candidacy(Vacancy vacancy, Candidate candidate) {
        this(0,vacancy,candidate, null);
    }

    public Candidacy(int id, Vacancy vacancy, Candidate candidate, StatusCandidacy statusCandidacy) {
        this.id = id;
        this.vacancy = vacancy;
        this.candidate = candidate;
        this.statusCandidacy = statusCandidacy;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setStatusCandidacy(StatusCandidacy statusCandidacy) {
        this.statusCandidacy = statusCandidacy;
    }

    public StatusCandidacy getStatusCandidacy() {
        return statusCandidacy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candidacy{");
        sb.append("id=").append(id);
        sb.append(", vacancy=").append(vacancy);
        sb.append(", candidate=").append(candidate);
        sb.append(", statusCandidacy=").append(statusCandidacy);
        sb.append("'}'+'\'");
        return sb.toString();
    }
}
