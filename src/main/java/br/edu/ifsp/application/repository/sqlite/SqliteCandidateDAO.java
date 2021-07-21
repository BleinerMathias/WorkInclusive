package br.edu.ifsp.application.repository.sqlite;

import br.edu.ifsp.domain.entities.candidacy.Candidacy;
import br.edu.ifsp.domain.entities.candidate.*;
import br.edu.ifsp.domain.entities.vacancy.*;
import br.edu.ifsp.domain.usecases.Candidate.CandidateDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.edu.ifsp.application.main.Main.findCandidateUseCase;

public class SqliteCandidateDAO implements CandidateDAO {

    private Candidate resultSetToEntity(ResultSet rs) throws SQLException {

        int user_id = rs.getInt("id");

        List<Accessibility> accessibiltyList = findAcessibility(user_id);
        List<ProfessionalExperience> professionalExperiences = professionalExperience(user_id);
        List<AcademicEducation> academicEducationList = findAcademicEducation(user_id);
        List<Ability> abiliityList = findAbility(user_id);

        System.out.println(findAbility(user_id));

        System.out.println("Id -> " + user_id);
        PersonalData personalData = new PersonalData(
                rs.getString("name"),
                rs.getString("cpf"),
                LocalDate.parse(rs.getString("dateOfBirth")),
                rs.getString("postCode"),
                rs.getString("nationality"));

        Candidate c1 = new Candidate();
        c1.setPersonalData(personalData);
        c1.setAbiliities(abiliityList);
        c1.setAccessibilities(accessibiltyList);
        c1.setAcademicEducationsList(academicEducationList);
        c1.setProfessionalExperienceList(professionalExperiences);

        return c1;
    }

    private List<AcademicEducation> findAcademicEducation(int id) {
        String sql = "SELECT * FROM AcademicEducationCandidate WHERE user_id = ? ";
        List<AcademicEducation> academicEducationList = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                AcademicEducation pe = resultSetAcademicEducation(rs);
                academicEducationList.add(pe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return academicEducationList;

    }

    private AcademicEducation resultSetAcademicEducation(ResultSet rs) throws SQLException {

        boolean completed;
        if(rs.getInt("completed") == 1){
            completed = true;
        } else{
            completed = false;
        }

        return new AcademicEducation(
                rs.getString("course"),
                LocalDate.parse(rs.getString("courseStart")),
                LocalDate.parse(rs.getString("courseEnd")),
                completed,
                AcademicDegree.toEnum(rs.getString("academicDegree")),
                rs.getString("academicInstituion")
        );

    }

    private List<Ability> findAbility(int id) {
        String sql = "SELECT * FROM AbilityCandidates WHERE user_id = ? ";
        List<Ability> accessibilityList = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                accessibilityList.add(new Ability(rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accessibilityList;
    }

    private List<Accessibility> findAcessibility(int id) {
        String sql = "SELECT * FROM AccessibilityCandidates WHERE user_id = ? ";
        List<Accessibility> accessibilityList = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                accessibilityList.add(Accessibility.toEnum(rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accessibilityList;
    }
    private List<ProfessionalExperience> professionalExperience(int id) {
        String sql = "SELECT * FROM AccessibilityCandidates WHERE user_id = ? ";
        List<ProfessionalExperience> professionalExperienceList = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ProfessionalExperience pe = resultSetPersonalExperience(rs);
                professionalExperienceList.add(pe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professionalExperienceList;
    }

    private List<ProfessionalExperience> a(int id) {
        String sql = "SELECT * FROM ProfessionalExperienceCandidate WHERE user_id = ? ";
        List<ProfessionalExperience> professionalExperienceList = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ProfessionalExperience pe = resultSetPersonalExperience(rs);
                professionalExperienceList.add(pe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professionalExperienceList;
    }

    private ProfessionalExperience resultSetPersonalExperience(ResultSet rs) throws SQLException {


        return new ProfessionalExperience(
                rs.getString("companyName"),
                LocalDate.parse(rs.getString("admissionDate")),
                LocalDate.parse(rs.getString("resignationDate")),
                rs.getString("office"),
                rs.getString("carriedActivities")
        );
    }

    @Override
    public Integer create(Candidate candidate) {

        int user_id = createUser(candidate);
        createCandidate(user_id, candidate);
        insertAcademicEducationCandidate(user_id, candidate);
        insertProfessionalExperienceCandidate(user_id, candidate);
        insertAbilityCandidate(user_id, candidate);
        insertAccessibilityCandidate(user_id, candidate);
        return user_id;
    }

    private boolean insertAccessibilityCandidate(int user_id, Candidate candidate) {
        String sql = "INSERT INTO AccessibilityCandidates(user_id, name) VALUES (?, ?)";

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, user_id);
            for(Accessibility ac : candidate.getAccessibilities()){
                stmt.setString(2, ac.toString());
                stmt.execute();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean insertAbilityCandidate(int user_id, Candidate candidate) {
        String sql = "INSERT INTO AbilityCandidates(user_id, name) VALUES (?, ?)";

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, user_id);
            for(Ability ab : candidate.getAbiliities()){
                stmt.setString(2, ab.getAbility());
                stmt.execute();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
