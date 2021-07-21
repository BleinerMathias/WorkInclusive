package br.edu.ifsp.application.repository.sqlite;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidacy.StatusCandidacy;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.*;
import br.edu.ifsp.domain.usecases.Company.CompanyDAO;
import br.edu.ifsp.domain.usecases.Vacancy.VacancyDAO;
import br.edu.ifsp.domain.usecases.candidacy.CandidacyDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.edu.ifsp.application.main.Main.*;

public class SqliteVacancyDAO implements VacancyDAO {


    @Override
    public Integer create(Vacancy vacancy) {
        Integer vacancy_id  = createNewVacancy(vacancy);
        vacancy.setId(vacancy_id);
        insertBenefits(vacancy);
        insertAccessibility(vacancy);
        insertAbility(vacancy);
        return vacancy_id;
    }

    private void insertBenefits(Vacancy vacancy) {
        String sql = "INSERT INTO BenefitsListVacancy(vacancy_id, name) VALUES (?, ?)";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, vacancy.getId());
            for(Benefits benefits : vacancy.getBenefitsList()) {
                stmt.setString(2, benefits.toString());
                stmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertAccessibility(Vacancy vacancy) {
        String sql = "INSERT INTO AccessibilityListVacancy(vacancy_id, name) VALUES (?, ?)";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, vacancy.getId());
            for(Accessibility accessibility : vacancy.getAccessibilityList()) {
                stmt.setString(2, accessibility.toString());
                stmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void insertAbility(Vacancy vacancy) {
        String sql = "INSERT INTO AbilityListVacancy(vacancy_id, name) VALUES (?, ?)";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, vacancy.getId());
            for(ProgrammingLanguage lip : vacancy.getAbiliityList()) {
                stmt.setString(2, lip.getName());
                stmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Integer createNewVacancy(Vacancy vacancy) {
        String sql = "INSERT INTO Vacancy(name, description, hierarchy, compatibility" +
                ", salary, statusVacancy, company_id  ) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, vacancy.getName());
            stmt.setString(2, vacancy.getDescription());
            stmt.setString(3, vacancy.getHierarchy().toString());
            stmt.setInt(4, vacancy.getCompatibilidade());
            stmt.setString(5, vacancy.getSalary().toString());
            stmt.setString(6, vacancy.getStatusVacancy().toString());
            stmt.setInt(7, vacancy.getCompany().getId());
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();
            int generatedKey = resultSet.getInt(1);
            return generatedKey;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Vacancy> findOne(Integer id) {
        String sql = "SELECT * FROM Vacancy WHERE id = ?";
        Vacancy vacancy = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                vacancy = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(vacancy);
    }

    private Vacancy resultSetToEntity(ResultSet rs) throws SQLException {

        int user_id = rs.getInt("company_id");

       // Company company = findCompanyUseCase.findByUserID(user_id).get();

        List<Benefits> benefits = findBenefits(rs.getInt("id"));
        List<Accessibility> accessibilty = findAccessibility(rs.getInt("id"));
        List<ProgrammingLanguage> abiliityList = findAbility(rs.getInt("id"));

        return new Vacancy(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                Hierarchy.valueOf(rs.getString("hierarchy")),
                rs.getInt("compatibility"),
                Double.valueOf(rs.getString("salary")),
                benefits,
                accessibilty,
                abiliityList,
                StatusVacancy.valueOf(rs.getString("statusVacancy")),
                null
               );
    }

    private List<ProgrammingLanguage> findAbility(int id) {
        String sql = "SELECT * FROM AbilityListVacancy WHERE vacancy_id = ? ";
        List<ProgrammingLanguage> abilityList = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                abilityList.add(new ProgrammingLanguage(rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abilityList;
    }

    private List<Accessibility> findAccessibility(int id) {
        String sql = "SELECT * FROM AccessibilityListVacancy WHERE vacancy_id = ? ";
        List<Accessibility> accessibilityList = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                accessibilityList.add(Accessibility.valueOf(rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accessibilityList;
    }

    private List<Benefits> findBenefits(int id) {
        String sql = "SELECT * FROM BenefitsListVacancy WHERE vacancy_id = ? ";
        List<Benefits> benefits = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                 benefits.add(Benefits.valueOf(rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benefits;
    }


    @Override
    public List<Vacancy> findAll() {
        String sql = "SELECT * FROM Vacancy";
        List<Vacancy> vacancyList = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Vacancy vacancy = resultSetToEntity(rs);
                vacancyList.add(vacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacancyList;
    }

    @Override
    public boolean update(Vacancy vacancy) {
        String sql = "UPDATE Candidacy SET statusCandidacy  = ? WHERE id = ?";
/*
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, candidacy.getStatusCandidacy().toString());
            stmt.setInt(2, candidacy.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
  */
        return false;
    }

    @Override
    public boolean deleteByKey(Integer id) {
        String sql = "DELETE FROM Vacancy WHERE id = ?";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Vacancy vacancy) {
        return deleteByKey(vacancy.getId());
    }


}
