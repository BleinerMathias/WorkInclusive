package br.edu.ifsp.application.repository.sqlite;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidate.AcademicDegree;
import br.edu.ifsp.domain.entities.candidate.AcademicEducation;
import br.edu.ifsp.domain.entities.candidate.Candidate;
import br.edu.ifsp.domain.entities.candidate.ProfessionalExperience;
import br.edu.ifsp.domain.usecases.Candidate.CandidateDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.edu.ifsp.application.main.Main.findCandidateUseCase;

public class SqliteCandidateDAO implements CandidateDAO {

    private Candidate resultSetToEntity(ResultSet rs) throws SQLException {

        Candidate candidateRS = findCandidateUseCase.findByUserId(rs.getInt("id")).get();
        return new Candidate(
                candidateRS.getPersonalData(),
                candidateRS.getAcademicEducationsList(),
                candidateRS.getProfessionalExperienceList(),
                candidateRS.getAccessibilities(),
                candidateRS.getAbiliities());
    }

    @Override
    public Integer create(Candidate candidate) {

        int user_id = createUser(candidate);
        createCandidate(user_id, candidate);
        insertAcademicEducationCandidate(user_id, candidate);
        insertProfessionalExperienceCandidate(user_id, candidate);
        return user_id;
    }


    private boolean insertAcademicEducationCandidate(int userID, Candidate candidate) {
        String sql = "INSERT INTO AcademicEducationCandidate(user_id, course, courseStart, courseEnd," +
                "completed, academicDegree, academicInstituion) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, userID);
            for(AcademicEducation ae : candidate.getAcademicEducationsList()){
                stmt.setString(2, ae.getCourse());
                stmt.setString(3, ae.getCourseStart().toString());
                stmt.setString(4, ae.getCourseEnd().toString());
                stmt.setInt(5, ae.isCompleted()?1:0);
                stmt.setString(6, ae.getAcademicDegree().toString());
                stmt.setString(7, ae.getAcademicInstitution());
                stmt.execute();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean insertProfessionalExperienceCandidate(int userID, Candidate candidate) {
        String sql = "INSERT INTO ProfessionalExperienceCandidate(user_id, companyName, admissionDate, resignationDate," +
                "office, carriedActivities) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, userID);
            for(ProfessionalExperience pe : candidate.getProfessionalExperienceList()){
                stmt.setString(2, pe.getCompanyName());
                stmt.setString(3, pe.getAdmissionDate().toString());
                stmt.setString(4, pe.getResignationDate().toString());
                stmt.setString(5, pe.getOffice());
                stmt.setString(6, pe.getCarriedActivities());
                stmt.execute();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Boolean createCandidate(Integer userID, Candidate candidate) {

        String sql = "INSERT INTO Candidate(id, name, cpf, dateOfBirth," +
                "postCode, nationality) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, userID);
            stmt.setString(2, candidate.getPersonalData().getName());
            stmt.setString(3, candidate.getPersonalData().getCpf());
            stmt.setString(4, candidate.getPersonalData().getDateOfBirth().toString());
            stmt.setString(5, candidate.getPersonalData().getPostCode());
            stmt.setString(6, candidate.getPersonalData().getNationality());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<Candidate> findOne(Integer id) {
        String sql = "SELECT * FROM Candidate WHERE id = ?";
        Candidate candidate = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                candidate = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(candidate);
    }

    private Integer createUser(Candidate candidate) {
        System.out.println("criando usuario");
        String sql = "INSERT INTO User(username, password, typeUser" +
                ") VALUES (?, ?, ?)";

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setString(1, candidate.getUsername());
            stmt.setString(2, candidate.getPassword());
            stmt.setInt(3, candidate.getTypeUser());
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
    public List<Candidate> findAll() {
        String sql = "SELECT * FROM Candidate";
        List<Candidate> candidateList = new ArrayList<>();

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Candidate candidate = resultSetToEntity(rs);
                candidateList.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidateList;
    }

    @Override
    public Optional<Candidate> findByCPF(String cpf) {
        String sql = "SELECT * FROM Candidate WHERE cpf = ?";

        Candidate candidate = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                candidate = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(candidate);
    }

    @Override
    public Optional<Candidate> findByUserId(Integer id) {
        List<Candidate> candidates = findCandidateUseCase.findAll();
        return candidates.stream().filter(candidate -> candidate.getId().equals(id))
                .findAny();
    }

    @Override
    public boolean update(Candidate candidate) {
        String sql = "UPDATE Candidate SET name = ?, cpf = ?, dateOfBirth = ? WHERE id = ?";

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setString(1, candidate.getPersonalData().getName());
            stmt.setString(2, candidate.getPersonalData().getCpf());
            stmt.setString(3, candidate.getPersonalData().getDateOfBirth().toString());
            stmt.setInt(4, candidate.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean deleteByKey(Integer id){
        String sql = "DELETE FROM Candidate WHERE id = ?";
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
    public boolean delete(Candidate candidate) {
        return deleteByKey(candidate.getId());
    }


}
