package br.edu.ifsp.application.repository.sqlite;

import br.edu.ifsp.domain.entities.company.Company;
import br.edu.ifsp.domain.usecases.Company.CompanyDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqliteCompanyDAO implements CompanyDAO {

    @Override
    public Integer create(Company company) {

        int user_id = createUser(company);
        String sql = "INSERT INTO Company(id, name, companyName, sector, CNPJ, address, postCode)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, user_id);
            stmt.setString(2, company.getName());
            stmt.setString(3, company.getCompanyName());
            stmt.setString(4, company.getSector());
            stmt.setString(5, company.getCNPJ());
            stmt.setString(6, company.getAddress());
            stmt.setString(7, company.getPostCode());
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();
            int generatedKey = resultSet.getInt(1);
            return generatedKey;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private Integer createUser(Company company) {
        System.out.println("criando usuario");
        String sql = "INSERT INTO User(username, password, typeUser" +
                ") VALUES (?, ?, ?)";

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setString(1, company.getUsername());
            stmt.setString(2, company.getPassword());
            stmt.setInt(3, company.getTypeUser());
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
    public Optional<Company> findOne(Integer id) {
        String sql = "SELECT * FROM Company WHERE id = ?";
        Company company = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                company = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(company);
    }

    private Company resultSetToEntity(ResultSet rs) throws SQLException {
        return new Company(
                rs.getString("name"),
                rs.getString("companyCompany"),
                rs.getString("sector"),
                rs.getString("CNPJ"),
                rs.getString("address"),
                rs.getString("postCode"));
    }

    @Override
    public Optional<Company> findByCNPJ(String cnpj) {
        String sql = "SELECT * FROM Company WHERE CNPJ = ?";
        Company company = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                company = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(company);
    }

    @Override
    public Optional<Company> findByUserID(int user_id) {
        String sql = "SELECT * FROM Company WHERE id = ?";
        Company company = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                company = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(company);
    }

    @Override
    public List<Company> findAll() {
        String sql = "SELECT * FROM Company";
        List<Company> companyList = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Company company = resultSetToEntity(rs);
                companyList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyList;
    }

    @Override
    public boolean update(Company company) {

        String sql = "UPDATE Company SET name = ?, companyCompany = ?, sector = ?, CNPJ = ?, address = ?, postCode = ? WHERE id = ?";

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setString(1, company.getName());
            stmt.setString(2, company.getCompanyName());
            stmt.setString(3, company.getSector());
            stmt.setString(4, company.getCNPJ());
            stmt.setString(5, company.getAddress());
            stmt.setString(6, company.getPostCode());
            stmt.setInt(7, company.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer id) {
        String sql = "DELETE FROM Company WHERE id = ?";
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
    public boolean delete(Company company) {
        return deleteByKey(company.getId());
    }
}
