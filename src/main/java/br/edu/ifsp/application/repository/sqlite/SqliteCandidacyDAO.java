package br.edu.ifsp.application.repository.sqlite;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidacy.StatusCandidacy;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.entities.vacancy.Vacancy;
import br.edu.ifsp.domain.usecases.candidacy.CandidacyDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.edu.ifsp.application.main.Main.*;

public class SqliteCandidacyDAO implements CandidacyDAO {


    @Override
    public Integer create(Candidacy candidacy) {
        String sql = "INSERT INTO Candidacy(vancancy_id, candidate_id, statusCandidacy" +
                ") VALUES (?, ?, ?)";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, candidacy.getVacancy().getId());
            stmt.setInt(2, candidacy.getCandidate().getId());
            stmt.setString(3, candidacy.getStatusCandidacy().toString());
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
    public Optional<Candidacy> findOne(Integer id) {
        String sql = "SELECT * FROM Candidacy WHERE id = ?";
        Candidacy candidacy = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                candidacy = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(candidacy);
    }

    private Candidacy resultSetToEntity(ResultSet rs) throws SQLException {

        int user_id = rs.getInt("user_id");
        Candidate candidate = findCandidateUseCase.findByUserId(user_id).get();

        int vacancy_id = rs.getInt("vacancy_id");
        Vacancy vacancy = findVacancyUseCase.findOne(vacancy_id).get();

        return new Candidacy(
                rs.getInt("id"),
                vacancy,
                candidate,
                StatusCandidacy.valueOf(rs.getString("statusCandidacy")));
    }

    @Override
    public List<Candidacy> findAll() {
        String sql = "SELECT * FROM Candidacy";
        List<Candidacy> candidacyList = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Candidacy candidacy = resultSetToEntity(rs);
                candidacyList.add(candidacy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidacyList;
    }

    @Override
    public List<Candidacy> findAllByVancancy(Company company, Vacancy vacancy) {
        String sql = "SELECT * FROM Candidacy WHERE vacancy_id = ?";
        List<Candidacy> candidacyList = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Candidacy candidacy = resultSetToEntity(rs);
                candidacyList.add(candidacy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidacyList.stream().filter(candidacy -> candidacy.getVacancy().getCompany().equals(company))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Candidacy> findCandidacyById(Integer id) {
        String sql = "SELECT * FROM Candidacy WHERE id = ?";
        Candidacy candidacy = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                candidacy = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(candidacy);
    }

    @Override
    public boolean update(Candidacy candidacy) {
        String sql = "UPDATE Candidacy SET statusCandidacy  = ? WHERE id = ?";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, candidacy.getStatusCandidacy().toString());
            stmt.setInt(2, candidacy.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer id) {
        String sql = "DELETE FROM Candidacy WHERE id = ?";
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
    public boolean delete(Candidacy candidacy) {
        return deleteByKey(candidacy.getId());
    }
}
