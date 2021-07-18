package br.edu.ifsp;

import br.edu.ifsp.application.repository.*;
import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.interview.Interview;
import br.edu.ifsp.domain.entities.interview.SchedulesHistory;
import br.edu.ifsp.domain.usecases.candidacy.*;
import br.edu.ifsp.domain.entities.candidate.AcademicDegree;
import br.edu.ifsp.domain.entities.candidate.AcademicEducation;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.candidate.PersonalData;
import br.edu.ifsp.domain.entities.company.Company;
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
import br.edu.ifsp.domain.usecases.interview.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class Main {

    private static CreateCandidateUseCase createCandidateUseCase;
    private static FindCandidateUseCase   findCandidateUseCase;
    private static UpdateCandidateUseCase updateCandidateUseCase;

    private static CreateCompanyUseCase createCompanyUseCase;
    private static FindCompanyUseCase findCompanyUseCase;
    private static UpdateCompanyUseCase updateCompanyUseCase;

    private static CreateVacancyUseCase createVacancyUseCase;
    private static FindVacancyUseCase findVacancyUseCase;
    private static UpdateVacancyUseCase updateVacancyUseCase;
    private static RemoveVacancyUseCase removeVacancyUseCase;

    private static CandidateSubscribeInVacancy candidateSubscribeInVacancy;
    private static MatchCandidacyUseCase matchCandidacyUseCase;
    private static ListCandidacyUseCase listCandidacyUseCase;
    private static AcceptOrDeclineCandidacyUseCase acceptOrDeclineCandidacyUseCase;
    private static FindCandidacyUseCase findCandidacyUseCase;
    private static UpdateCandidacyUseCase updateCandidacyUseCase;


    private static CreateInterviewUseCase createInterviewUseCase;
    private static FindInterviewUseCase findInterviewUseCase;
    private static AcceptCombineInterview acceptCombineInterview;
    private static FindCombinedInterview findCombinedInterview;
    private static UnacceptCombineInterview unacceptCombineInterview;



    public static void main(String[] args) throws InterruptedException {
        configureInjection();


        PersonalData p_c1 = new PersonalData("Larissa Aline", "111.111.111-11",
                LocalDate.of(1996,5,5),"13690-000","Brasileira");

        p_c1.addEmail("larissa@teste.com.br");
        p_c1.addEmail("larissa2@teste.com.br");
        p_c1.addPhone("(19) 3333-3333");
        p_c1.addPhone("(16) 3333-3333");

        Candidate c1 = new Candidate(p_c1);

        c1.addAcademicEducation(new AcademicEducation("Técnico em enfermagem", LocalDate.of(2017, 6, 5),
                LocalDate.of(2019, 6, 5),true, AcademicDegree.TECHNOLOSIT,"SENAC"));

        c1.addAcademicEducation(new AcademicEducation("Análise e desenolvimento de sistemas", LocalDate.of(2019, 1, 25),
                LocalDate.of(2022, 1, 25),false, AcademicDegree.TECHNOLOSIT,"IFSP" ));

        c1.addAccessibility(Accessibility.VISUAL_DEFICIENT);

        c1.addAbility("JAVA");
        c1.addAbility("JAVASCRIPT");
        c1.addAbility("NODEJS");

        createCandidateUseCase.insert(c1);

        // Create a second candidate

        PersonalData p_c2 = new PersonalData("Bleiner Bertoluci", "444.444.444-44",
                LocalDate.of(1999,4,19),"13690-000","Brasileira");

        p_c2.addEmail("bleiner@teste.com.br");
        p_c2.addEmail("bleiner@teste.com.br");
        p_c2.addPhone("(19) 3333-3333");
        p_c2.addPhone("(16) 3333-3333");

        Candidate c2 = new Candidate(p_c2);

        c2.addAcademicEducation(new AcademicEducation("Técnico em mecatronica", LocalDate.of(2018, 12, 24),
                LocalDate.of(2019, 6, 5),true, AcademicDegree.TECHNOLOSIT,"SENAC"));

        c2.addAcademicEducation(new AcademicEducation("Análise e desenolvimento de sistemas", LocalDate.of(2019, 1, 25),
                LocalDate.of(2022, 1, 25),false, AcademicDegree.TECHNOLOSIT,"IFSP" ));

        c2.addAccessibility(Accessibility.FISIC_DEFICIENT);

        c2.addAbility("ANDROID");
        c2.addAbility("JAVASCRIPT");
        c2.addAbility("NODEJS");

        createCandidateUseCase.insert(c2);

        // Create a new Company
        Company comp1 = new Company("Grupo", "Grupo Empresa", "Informática", "13.146.255/0001-09", "Rua Manoel Vasques Pineda, 717", "18114-440");


        List<String> emails_comp1 = new ArrayList<>();
        comp1.addEmail("grupoempresa@company.com.br");
        comp1.addEmail("grupo@company.com.br");
        comp1.addPhone("(16) 3343-3343");
        comp1.addPhone("(19) 3434-2233");
        comp1.addAccessibility(Accessibility.VISUAL_DEFICIENT);
        createCompanyUseCase.insert(comp1);


        // create new vacancies


        // Vacancy 1
        Vacancy v1 = new Vacancy("Analista JR","Irá trabalhar com equipe de desenvolvimento em NODE.JS", Hierarchy.JUNIOR, 2900.0,
                StatusVacancy.AVAILABLE,comp1);

        v1.addBenefits(Benefits.FOOD_VOUCHER);
        v1.addBenefits(Benefits.MEAL_VOUCHER);
        v1.addBenefits(Benefits.MEDICAL_PLAN);

        v1.addAccessibility(Accessibility.VISUAL_DEFICIENT);

        v1.addAbiliity("JAVA");
        v1.addAbiliity("JAVASCRIPT");
        v1.addAbiliity("NODEJS");

        createVacancyUseCase.insert(v1);


        Vacancy v2 = new Vacancy("Desenvolvedor Senior","Irá desenvolvedor aplicativo android", Hierarchy.SENIOR, 4500.0,
                StatusVacancy.AVAILABLE,comp1);

        v2.addBenefits(Benefits.FOOD_VOUCHER);
        v2.addBenefits(Benefits.MEDICAL_PLAN);

        v2.addAccessibility(Accessibility.FISIC_DEFICIENT);

        v2.addAbiliity("ANDROID");

        createVacancyUseCase.insert(v2);

        // Vacancy 3
        Vacancy v3 = new Vacancy("Estágio","Irá trabalhar com equipe de desenvolvimento em JAVA", Hierarchy.TRAINEE, 1500.00,
              StatusVacancy.AVAILABLE,comp1);

        v3.addBenefits(Benefits.MEDICAL_PLAN);

        v3.addAccessibility(Accessibility.VISUAL_DEFICIENT);

        v3.addAbiliity("JAVA");
        v3.addAbiliity("JAVASCRIPT");

        createVacancyUseCase.insert(v3);


        // Match Vacancy Candidate 1
        List<Vacancy> myMatchVacancyC1 = matchCandidacyUseCase.match(c1);

        // Show Match List Vacancy - Candidate 1
        System.out.println("Vagas disponíveis (candidata: Larissa): \n"+ myMatchVacancyC1);

        // Candidate subscribe in vacancy índice 0
        candidateSubscribeInVacancy.subscribe(c1,myMatchVacancyC1.get(0)); //
        candidateSubscribeInVacancy.subscribe(c1,myMatchVacancyC1.get(1)); //

        // Match Vacancy Candidate 1
        List<Vacancy> myMatchVacancyC2 = matchCandidacyUseCase.match(c2);
        // Show Match List Vacancy - Candidate 2
        System.out.println("\nVagas disponíveis (candidato: Bleiner): \n"+ myMatchVacancyC2);

        // Candidate subscribe in vacancy índice 0
        candidateSubscribeInVacancy.subscribe(c2,myMatchVacancyC2.get(0)); //

        System.out.println("\n Candidatos inscritos para a vaga de id 1 da empresa comp1");
        System.out.println(listCandidacyUseCase.listAllCandidacyByVacancy(comp1,v1));

        System.out.println("\n Candidatos inscritos para a vaga de id 2 da empresa comp1");
        System.out.println(listCandidacyUseCase.listAllCandidacyByVacancy(comp1,v2));

        System.out.println("\n Candidatos inscritos para a vaga de id 3 da empresa comp1");
        System.out.println(listCandidacyUseCase.listAllCandidacyByVacancy(comp1,v3));


        System.out.println("\n" + findCandidacyUseCase.findCandidacyById(2));

        // Comp accept candidacy of the Larissa
        Optional<Candidacy> candidacy_larissa = findCandidacyUseCase.findCandidacyById(1);
        acceptOrDeclineCandidacyUseCase.accept(comp1, candidacy_larissa.get());

        createInterviewUseCase.createNewInterview(comp1,candidacy_larissa.get(), LocalDateTime.from(LocalDateTime.now()),"Rua das lagoas, 11, Centro,Google");

        System.out.println("\n\nMostrando entrevistas marcadas para Larissa");
        System.out.println(findInterviewUseCase.findInterviewByCandidate(c1));


        System.out.println("\n\nMostrando entrevista codigo 1");
        System.out.println(findInterviewUseCase.findInterviewById(1));


        System.out.println("\n\nMostrando entrevistas combinadas");
        System.out.println(findCombinedInterview.findAllCombinedInterviewByCompany(comp1));


        Interview interviewLarissa = findInterviewUseCase.findInterviewById(1).get();
        System.out.println("\n\n Candidato não aceita data da entrevista");
        unacceptCombineInterview.candidateUnacceptCombineInterview(c1, interviewLarissa,LocalDateTime.of(2021, Month.DECEMBER,15,10,0));

        System.out.println("\n\nMostrando entrevistas combinadas");
        System.out.println(findCombinedInterview.findAllCombinedInterviewByCompany(comp1));

        System.out.println("\n\nEmpresa nega data passada pelo o candidato, e propõe nova data");
        unacceptCombineInterview.companyAcceptInterview(comp1, findInterviewUseCase.findInterviewById(1).get(),LocalDateTime.of(2021, Month.OCTOBER,20,10,0));

        System.out.println("\n\n Candidata Larissa aceita combinação de data e horario");
        acceptCombineInterview.candidateAcceptInterview(c1, findInterviewUseCase.findInterviewById(1).get());

        System.out.println("\n\nMostrando entrevistas combinadas");
        System.out.println(findCombinedInterview.findAllCombinedInterviewByCompany(comp1));


        System.out.println("\n\nMostrando histórico de entrevistas");
        for(SchedulesHistory schedulesHistory : findInterviewUseCase.findInterviewById(1).get().getSchedulesHistoryList()){
            System.out.println(schedulesHistory);
        }

        System.out.println("\n\nMostrando entrevistas combinadas de Larissa");
        System.out.println(findCombinedInterview.findCombinedInterviewByCandidate(c1));

        acceptCombineInterview.candidateAcceptInterview(c1, findInterviewUseCase.findInterviewById(1).get());

    }

    private static void configureInjection(){
        CandidateDAO candidateDAO = new InMemoryCandidateDAO();
        createCandidateUseCase = new CreateCandidateUseCase(candidateDAO);
        updateCandidateUseCase = new UpdateCandidateUseCase(candidateDAO);
        findCandidateUseCase = new FindCandidateUseCase(candidateDAO);

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

        CandidacyDAO candidacyDAO = new InMemoryCandidacyDAO();
        candidateSubscribeInVacancy = new CandidateSubscribeInVacancy(candidacyDAO);
        listCandidacyUseCase = new ListCandidacyUseCase(candidacyDAO);
        acceptOrDeclineCandidacyUseCase = new AcceptOrDeclineCandidacyUseCase(candidacyDAO,findCandidacyUseCase);
        findCandidacyUseCase = new  FindCandidacyUseCase(candidacyDAO);
        updateCandidacyUseCase = new UpdateCandidacyUseCase(candidacyDAO);

        findInterviewUseCase = new FindInterviewUseCase(interviewDAO);
        createInterviewUseCase = new CreateInterviewUseCase(interviewDAO,findCandidacyUseCase, updateCandidacyUseCase);
        acceptCombineInterview = new AcceptCombineInterview(interviewDAO, findInterviewUseCase);
        findCombinedInterview = new FindCombinedInterview(interviewDAO);
        unacceptCombineInterview = new UnacceptCombineInterview(interviewDAO, findInterviewUseCase);


    }

}
