package br.edu.ifsp.application;

import br.edu.ifsp.application.repository.InMemoryCandidateDAO;
import br.edu.ifsp.application.repository.InMemoryCompanyDAO;
import br.edu.ifsp.application.repository.InMemoryInterviewDAO;
import br.edu.ifsp.application.repository.InMemoryVacancyDAO;
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
import br.edu.ifsp.domain.usecases.interview.InterviewDAO;
import br.edu.ifsp.domain.usecases.interview.MatchInterviewUseCase;

import java.time.LocalDate;
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

    private static MatchInterviewUseCase matchInterviewUseCase;


    public static void main(String[] args) {
        configureInjection();

        // Create a new Candidate
        List<String> phones_c1 = new ArrayList<>();
        phones_c1.add("(19) 3333-3333");
        phones_c1.add("(16) 3333-3333");

        List<String> emails_c1 = new ArrayList<>();
        emails_c1.add("larissa@teste.com.br");
        emails_c1.add("larissa2@teste.com.br");

        PersonalData p_c1 = new PersonalData("Larissa Aline", "111.111.111-11",
                LocalDate.of(1996,5,5),"13690-000","Brasileira", phones_c1, emails_c1);
        
        List<AcademicEducation> aE_c1 = new ArrayList<>();
        AcademicEducation ae1 = new AcademicEducation("Técnico em enfermagem", LocalDate.of(2017, 6, 5),
                LocalDate.of(2019, 6, 5),true, AcademicDegree.TECHNOLOSIT,"SENAC");
        
        AcademicEducation ae2 = new AcademicEducation("Análise e desenolvimento de sistemas", LocalDate.of(2019, 1, 25),
                LocalDate.of(2022, 1, 25),false, AcademicDegree.TECHNOLOSIT,"IFSP" );
        
        
        aE_c1.add(ae1);
        aE_c1.add(ae2);

        List<Accessibility> acc_c1 = new ArrayList<>();
        acc_c1.add(Accessibility.VISUAL_DEFICIENT);

        List<Abiliity> abiliityList = new ArrayList<>();
        abiliityList.add(Abiliity.JAVA);
        abiliityList.add(Abiliity.JAVASCRIPT);
        abiliityList.add(Abiliity.NODEJS);
        
        Candidate c1 = new Candidate(p_c1,aE_c1,null,acc_c1,abiliityList);
        createCandidateUseCase.insert(c1);

        // Create a new Company
        List<String> emails_comp1 = new ArrayList<>();
        emails_comp1.add("grupoempresa@company.com.br");
        emails_comp1.add("grupo@company.com.br");

        List<String> phones_comp1 = new ArrayList<>();
        phones_comp1.add("(16) 3343-3343");
        phones_comp1.add("(19) 3434-2233");

        List<Accessibility> acc_comp1 = new ArrayList<>();
        acc_comp1.add(Accessibility.VISUAL_DEFICIENT);
    
        Company comp1 = new Company("Grupo", "Grupo Empresa", "Informática", "13.146.255/0001-09", emails_comp1, phones_comp1, "Rua Manoel Vasques Pineda, 717", "18114-440", acc_comp1);
        createCompanyUseCase.insert(comp1);


        // create new vacancies
        // Vacancy 1
        List<Benefits> be_v1 = new ArrayList<>();
        be_v1.add(Benefits.FOOD_VOUCHER);
        be_v1.add(Benefits.MEAL_VOUCHER);
        be_v1.add(Benefits.MEDICAL_PLAN);

        List<Accessibility> acc_v1 = new ArrayList<>();
        acc_v1.add(Accessibility.VISUAL_DEFICIENT);

        List<Abiliity> abiliityList_v1 = new ArrayList<>();
        abiliityList_v1.add(Abiliity.JAVA);
        abiliityList_v1.add(Abiliity.JAVASCRIPT);
        abiliityList_v1.add(Abiliity.NODEJS);

        Vacancy v1 = new Vacancy("Analista JR","Irá trabalhar com equipe de desenvolvimento em NODE.JS", Hierarchy.JUNIOR, 2900.0,
                be_v1, acc_v1,abiliityList_v1,StatusVacancy.AVAILABLE,comp1);
        createVacancyUseCase.insert(v1);

        // Vacancy 2
        List<Benefits> be_v2 = new ArrayList<>();
        be_v2.add(Benefits.FOOD_VOUCHER);
        be_v2.add(Benefits.MEDICAL_PLAN);

        List<Accessibility> acc_v2 = new ArrayList<>();
        acc_v2.add(Accessibility.FISIC_DEFICIENT);

        List<Abiliity> abiliityList_v2 = new ArrayList<>();
        abiliityList_v2.add(Abiliity.ANDROID);

        abiliityList_v2.add(Abiliity.ANDROID);

        Vacancy v2 = new Vacancy("Desenvolvedor Senior","Irá desenvolvedor aplicativo android", Hierarchy.SENIOR, 4500.0,
                be_v2, acc_v2,abiliityList_v2,StatusVacancy.AVAILABLE,comp1);
        createVacancyUseCase.insert(v2);

        // Vacancy 3
        List<Benefits> be_v3 = new ArrayList<>();
        be_v3.add(Benefits.MEDICAL_PLAN);

        List<Accessibility> acc_v3 = new ArrayList<>();
        acc_v3.add(Accessibility.VISUAL_DEFICIENT);

        List<Abiliity> abiliityList_v3 = new ArrayList<>();
        abiliityList_v3.add(Abiliity.JAVA);
        abiliityList_v3.add(Abiliity.JAVASCRIPT);        

        Vacancy v3 = new Vacancy("Estágio","Irá trabalhar com equipe de desenvolvimento em JAVA", Hierarchy.TRAINEE, 1500.00,
                be_v3, acc_v3,abiliityList_v3,StatusVacancy.AVAILABLE,comp1);
        createVacancyUseCase.insert(v3);

        // Find the vacancy 1
       // System.out.println(findVacancyUseCase.findOne(v1.getId()));
        System.out.println("Vacancy Avaliable to me: \n"+ matchInterviewUseCase.match(c1));
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
        matchInterviewUseCase = new MatchInterviewUseCase(findCandidateUseCase,findVacancyUseCase);

    }


}
