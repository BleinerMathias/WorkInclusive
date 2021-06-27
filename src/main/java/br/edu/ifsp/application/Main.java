package br.edu.ifsp.application;

import br.edu.ifsp.application.repository.InMemoryCandidateDAO;
import br.edu.ifsp.application.repository.InMemoryCompanyDAO;
import br.edu.ifsp.application.repository.InMemoryVacancyDAO;
import br.edu.ifsp.domain.entities.candidate.AcademicDegree;
import br.edu.ifsp.domain.entities.candidate.AcademicEducation;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.candidate.PersonalData;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.Abiliity;
import br.edu.ifsp.domain.entities.vacancy.Accessibility;
import br.edu.ifsp.domain.usecases.Candidate.CandidateDAO;
import br.edu.ifsp.domain.usecases.Candidate.CreateCandidateUseCase;
import br.edu.ifsp.domain.usecases.Candidate.FindCandidateUseCase;
import br.edu.ifsp.domain.usecases.Candidate.UpdateCandidateUseCase;
import br.edu.ifsp.domain.usecases.Company.CompanyDAO;
import br.edu.ifsp.domain.usecases.Company.CreateCompanyUseCase;
import br.edu.ifsp.domain.usecases.Company.FindCompanyUseCase;
import br.edu.ifsp.domain.usecases.Company.UpdateCompanyUseCase;
import br.edu.ifsp.domain.usecases.Vacancy.*;

import java.time.LocalDate;
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


    public static void main(String[] args) {
        configureInjection();

        // Candidate

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

        List<Accessibility> accessibilityList = new ArrayList<>();
        accessibilityList.add(Accessibility.VISUAL_DEFICIENT);

        List<Abiliity> abiliityList = new ArrayList<>();
        abiliityList.add(Abiliity.JAVA);
        abiliityList.add(Abiliity.JAVASCRIPT);
        abiliityList.add(Abiliity.NODEJS);
        
        Candidate c1 = new Candidate(p_c1,aE_c1,null,accessibilityList,abiliityList);
        createCandidateUseCase.insert(c1);

        // Company

        List<String> emails_comp1 = new ArrayList<>();
        emails_comp1.add("groupcomp@company.com.br");
        emails_comp1.add("group@company.com.br");

        List<String> phones_comp1 = new ArrayList<>();
        phones_comp1.add("(16) 3343-3343");
        phones_comp1.add("(19) 3434-2233");

        List<Accessibility> acc_comp1 = new ArrayList<>();
        acc_comp1.add(Accessibility.VISUAL_DEFICIENT);
    
        Company comp1 = new Company("Gruop", "Group Company", "Computing", "13.146.255/0001-09", emails_comp1, phones_comp1, "Rua Manoel Vasques Pineda, 717", "18114-440", acc_comp1);
        createCompanyUseCase.insert(comp1);
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

    }


}
