package br.edu.ifsp.application.main;

import br.edu.ifsp.application.repository.inMemory.*;
import br.edu.ifsp.application.repository.sqlite.DatabaseBuilder;
import br.edu.ifsp.application.repository.sqlite.SqliteCandidacyDAO;
import br.edu.ifsp.application.repository.sqlite.SqliteCandidateDAO;
import br.edu.ifsp.application.view.WindowLoader;
import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidate.AcademicDegree;
import br.edu.ifsp.domain.entities.candidate.AcademicEducation;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.candidate.PersonalData;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.entities.interview.SchedulesHistory;
import br.edu.ifsp.domain.entities.vacancy.*;
import br.edu.ifsp.domain.usecases.Candidate.CandidateDAO;
import br.edu.ifsp.domain.usecases.Candidate.CreateCandidateUseCase;
import br.edu.ifsp.domain.usecases.Candidate.FindCandidateUseCase;
import br.edu.ifsp.domain.usecases.Candidate.UpdateCandidateUseCase;
import br.edu.ifsp.domain.usecases.Company.CompanyDAO;
import br.edu.ifsp.domain.usecases.Company.CreateCompanyUseCase;
import br.edu.ifsp.domain.usecases.Company.FindCompanyUseCase;
import br.edu.ifsp.domain.usecases.Company.UpdateCompanyUseCase;
import br.edu.ifsp.domain.usecases.Vacancy.*;
import br.edu.ifsp.domain.usecases.candidacy.*;
import br.edu.ifsp.domain.usecases.interview.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static CreateCandidateUseCase createCandidateUseCase;
    public static FindCandidateUseCase   findCandidateUseCase;
    public static UpdateCandidateUseCase updateCandidateUseCase;

    public static CreateCompanyUseCase createCompanyUseCase;
    public static FindCompanyUseCase findCompanyUseCase;
    public static UpdateCompanyUseCase updateCompanyUseCase;

    public static CreateVacancyUseCase createVacancyUseCase;
    public static FindVacancyUseCase findVacancyUseCase;
    public static UpdateVacancyUseCase updateVacancyUseCase;
    public static RemoveVacancyUseCase removeVacancyUseCase;

    public static CandidateSubscribeInVacancy candidateSubscribeInVacancy;
    public static MatchCandidacyUseCase matchCandidacyUseCase;
    public static ListCandidacyUseCase listCandidacyUseCase;
    public static AcceptOrDeclineCandidacyUseCase acceptOrDeclineCandidacyUseCase;
    public static FindCandidacyUseCase findCandidacyUseCase;
    public static UpdateCandidacyUseCase updateCandidacyUseCase;


    public static CreateInterviewUseCase createInterviewUseCase;
    public static FindInterviewUseCase findInterviewUseCase;
    public static AcceptCombineInterview acceptCombineInterview;
    public static FindCombinedInterview findCombinedInterview;
    public static UnacceptCombineInterview unacceptCombineInterview;



    public static void main(String[] args) throws InterruptedException {
        configureInjection();
        setupDatabase();
        WindowLoader.main(args);
    }



    private static void setupDatabase() {
        DatabaseBuilder dbBuilder = new DatabaseBuilder();
        dbBuilder.buildDatabaseIfMissing();
    }

    private static void configureInjection(){
        SqliteCandidateDAO sqliteCandidateDAO = new SqliteCandidateDAO();
        createCandidateUseCase = new CreateCandidateUseCase(sqliteCandidateDAO);
        updateCandidateUseCase = new UpdateCandidateUseCase(sqliteCandidateDAO);
        findCandidateUseCase = new FindCandidateUseCase(sqliteCandidateDAO);


        CompanyDAO companyDAO = new InMemoryCompanyDAO();
        createCompanyUseCase = new CreateCompanyUseCase(companyDAO);
        updateCompanyUseCase = new UpdateCompanyUseCase(companyDAO);
        findCompanyUseCase = new FindCompanyUseCase(companyDAO);

        VacancyDAO vacancyDAO = new InMemoryVacancyDAO();
        createVacancyUseCase = new CreateVacancyUseCase(vacancyDAO);
        updateVacancyUseCase = new UpdateVacancyUseCase(vacancyDAO);
        findVacancyUseCase = new FindVacancyUseCase(vacancyDAO);
        removeVacancyUseCase = new RemoveVacancyUseCase(vacancyDAO);

        InterviewDAO interviewDAO = new InMemoryInterviewDAO();

        matchCandidacyUseCase = new MatchCandidacyUseCase(findCandidateUseCase,findVacancyUseCase);

        SqliteCandidacyDAO sqliteCandidacyDAO = new SqliteCandidacyDAO();
        candidateSubscribeInVacancy = new CandidateSubscribeInVacancy(sqliteCandidacyDAO);
        listCandidacyUseCase = new ListCandidacyUseCase(sqliteCandidacyDAO);
        acceptOrDeclineCandidacyUseCase = new AcceptOrDeclineCandidacyUseCase(sqliteCandidacyDAO,findCandidacyUseCase);
        findCandidacyUseCase = new  FindCandidacyUseCase(sqliteCandidacyDAO);
        updateCandidacyUseCase = new UpdateCandidacyUseCase(sqliteCandidacyDAO);

        findInterviewUseCase = new FindInterviewUseCase(interviewDAO);
        createInterviewUseCase = new CreateInterviewUseCase(interviewDAO,findCandidacyUseCase, updateCandidacyUseCase);
        acceptCombineInterview = new AcceptCombineInterview(interviewDAO, findInterviewUseCase);
        findCombinedInterview = new FindCombinedInterview(interviewDAO);
        unacceptCombineInterview = new UnacceptCombineInterview(interviewDAO, findInterviewUseCase);


    }

}
