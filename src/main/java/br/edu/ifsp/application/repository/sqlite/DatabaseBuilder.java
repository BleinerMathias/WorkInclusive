package br.edu.ifsp.application.repository.sqlite;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuilder {

    public void buildDatabaseIfMissing(){
        if(isDatabaseMissing()){
            System.out.println("Database is missing. Building batabase: \n");
            buildTables();
        }
    }

    private boolean isDatabaseMissing() {
        return !Files.exists(Paths.get("database.db"));
    }

    private void buildTables() {
        try(Statement statement = ConnectionFactory.createStatement()){
            statement.addBatch(createUser());
            statement.addBatch(createCandidate());
            statement.addBatch(createAcademicEducationCandidates());
            statement.addBatch(createProfessionalExperienceCandidates());
            statement.addBatch(createAbilityCandidates());
            statement.addBatch(createAccessibilityCandidates());
            statement.addBatch(createCompany());
            statement.addBatch(createVacancy());
            statement.addBatch(createBenefitsListVacancy());
            statement.addBatch(createAccessibilityListVacancy());
            statement.addBatch(createAbilityListVacancy());
            statement.addBatch(createCandidacy());
            statement.addBatch(createInterview());
            statement.addBatch(createSchedulesHistory());
            statement.executeBatch();

            System.out.println("Database successfully created.");
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    private String createUser(){
        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE User(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sqlBuilder.append("username TEXT NOT NULL UNIQUE, \n");
        sqlBuilder.append("password TEXT NOT NULL, \n");
        sqlBuilder.append("typeUser INTEGER NOT NULL \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }
    private String createCandidate() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE Candidate(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY UNIQUE, \n");
        sqlBuilder.append("name TEXT NOT NULL, \n ");
        sqlBuilder.append("cpf TEXT NOT NULL, \n");
        sqlBuilder.append("dateOfBirth TEXT NOT NULL, \n");
        sqlBuilder.append("postCode TEXT NOT NULL, \n");
        sqlBuilder.append("nationality TEXT NOT NULL, \n");
        sqlBuilder.append("FOREIGN KEY(id) REFERENCES User(id) \n");

        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }
    private String createAcademicEducationCandidates() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE AcademicEducationCandidate(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("user_id NOT NULL, \n");
        sqlBuilder.append("course TEXT NOT NULL, \n ");
        sqlBuilder.append("courseStart TEXT NOT NULL, \n");
        sqlBuilder.append("courseEnd TEXT NOT NULL, \n");
        sqlBuilder.append("completed INTEGER NOT NULL, \n");
        sqlBuilder.append("academicDegree TEXT NOT NULL, \n");
        sqlBuilder.append("academicInstituion TEXT NOT NULL, \n");
        sqlBuilder.append("FOREIGN KEY(user_id) REFERENCES User(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }

    private String createAccessibilityCandidates() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE AccessibilityCandidates(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("user_id NOT NULL, \n");
        sqlBuilder.append("name TEXT NOT NULL, \n ");
        sqlBuilder.append("FOREIGN KEY(user_id) REFERENCES User(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }


    private String createProfessionalExperienceCandidates() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE ProfessionalExperienceCandidate(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("user_id NOT NULL, \n");
        sqlBuilder.append("companyName TEXT NOT NULL, \n ");
        sqlBuilder.append("admissionDate TEXT NOT NULL, \n");
        sqlBuilder.append("resignationDate TEXT, \n");
        sqlBuilder.append("office TEXT NOT NULL, \n");
        sqlBuilder.append("carriedActivities TEXT NOT NULL, \n");
        sqlBuilder.append("FOREIGN KEY(user_id) REFERENCES User(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }

    private String createAbilityCandidates() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE AbilityCandidates(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("user_id NOT NULL, \n");
        sqlBuilder.append("name TEXT NOT NULL, \n ");
        sqlBuilder.append("FOREIGN KEY(user_id) REFERENCES User(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }

    private String createCompany() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE Company(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY, \n");
        sqlBuilder.append("name TEXT NOT NULL, \n ");
        sqlBuilder.append("companyName TEXT NOT NULL, \n");
        sqlBuilder.append("sector TEXT NOT NULL, \n");
        sqlBuilder.append("CNPJ TEXT NOT NULL UNIQUE, \n");
        sqlBuilder.append("address TEXT NOT NULL, \n");
        sqlBuilder.append("postCode TEXT NOT NULL, \n");
        sqlBuilder.append("FOREIGN KEY(id) REFERENCES User(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }
    private String createVacancy() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE Vacancy(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("name TEXT NOT NULL, \n");
        sqlBuilder.append("description TEXT NOT NULL, \n");
        sqlBuilder.append("hierarchy TEXT NOT NULL, \n");
        sqlBuilder.append("compatibility INTEGER NOT NULL, \n");
        sqlBuilder.append("salary TEXT NOT NULL, \n");
        sqlBuilder.append("statusVacancy TEXT NOT NULL, \n");
        sqlBuilder.append("company_id INTEGER NOT NULL, \n");
        sqlBuilder.append("FOREIGN KEY(company_id) REFERENCES Company(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }
    private String createBenefitsListVacancy() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE BenefitsListVacancy(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("vacancy_id NOT NULL, \n");
        sqlBuilder.append("name TEXT NOT NULL, \n ");
        sqlBuilder.append("FOREIGN KEY(vacancy_id) REFERENCES Vacancy(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }
    private String createAccessibilityListVacancy() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE AccessibilityListVacancy(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("vacancy_id NOT NULL, \n");
        sqlBuilder.append("name TEXT NOT NULL, \n ");
        sqlBuilder.append("FOREIGN KEY (vacancy_id) REFERENCES Vacancy(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }
    private String createAbilityListVacancy() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE AbilityListVacancy(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("vacancy_id NOT NULL, \n");
        sqlBuilder.append("name TEXT NOT NULL, \n ");
        sqlBuilder.append("FOREIGN KEY(vacancy_id) REFERENCES Vacancy(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }
    private String createCandidacy() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE Candidacy(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("vacancy_id INTEGER NOT NULL, \n ");
        sqlBuilder.append("candidate_id INTEGER NOT NULL, \n");
        sqlBuilder.append("statusCandidacy TEXT NOT NULL, \n");
        sqlBuilder.append("FOREIGN KEY(vacancy_id) REFERENCES Vacancy(id), \n");
        sqlBuilder.append("FOREIGN KEY(candidate_id) REFERENCES Candidate(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }
    private String createInterview() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE Interview(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("candidacy_id INTEGER NOT NULL, \n ");
        sqlBuilder.append("company_id INTEGER NOT NULL, \n");
        sqlBuilder.append("dateTime TEXT NOT NULL, \n");
        sqlBuilder.append("address TEXT NOT NULL, \n");
        sqlBuilder.append("acceptCompany INTEGER NOT NULL, \n");
        sqlBuilder.append("acceptCandidate INTEGER NOT NULL, \n");
        sqlBuilder.append("combined INTEGER NOT NULL, \n");
        sqlBuilder.append("FOREIGN KEY(candidacy_id) REFERENCES Candidacy(id), \n");
        sqlBuilder.append("FOREIGN KEY(company_id) REFERENCES Company(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }
    private String createSchedulesHistory() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE SchedulesHistory(\n");
        sqlBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        sqlBuilder.append("interview_id INTEGER NOT NULL, \n ");
        sqlBuilder.append("suggestedIn TEXT NOT NULL, \n");
        sqlBuilder.append("suggestedDate TEXT NOT NULL, \n");
        sqlBuilder.append("FOREIGN KEY(interview_id) REFERENCES Interview(id) \n");
        sqlBuilder.append(");");

        System.out.println(sqlBuilder.toString());
        return sqlBuilder.toString();
    }



}
