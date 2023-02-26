package newProject.rep;

import newProject.entity.Person;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepImpl implements PersonRep{
    public static final String POSTRGES_DRIVER_NAME = "org.postgresql.Driver";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:";
    public static final int DATABASE_PORT = 5432;
    public static final String DATABASE_NAME = "/postgres";
    public static final String DATABASE_LOGIN = "hleb";
    public static final String DATABASE_PASSWORD = "65orevar";

    private static final String ID = "id";
    private static final String NAME = "name";



    @Override
    public List<Person> findAll() {
        final String findAllQuery = "select * from person order by id desc";

        List<Person> result = new ArrayList<>();

        registerDriver();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findAllQuery)
        ) {

            while (rs.next()) {
                result.add(parseResultSet(rs));
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    private Person parseResultSet(ResultSet rs) {

        Person person;

        try {
            person = new Person();
            person.setId(rs.getInt(ID)); //1 or id
            person.setName(rs.getString(NAME));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    private void registerDriver() {
        try {
            Class.forName(POSTRGES_DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver Cannot be loaded!");
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }
    }

    private Connection getConnection() {
        String jdbcURL = StringUtils.join(DATABASE_URL, DATABASE_PORT, DATABASE_NAME);
        try {
            return DriverManager.getConnection(jdbcURL, DATABASE_LOGIN, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
