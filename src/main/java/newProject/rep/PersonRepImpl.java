package newProject.rep;

import newProject.entity.IntegerMapper;
import newProject.entity.Person;
import newProject.entity.PersonMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class PersonRepImpl implements PersonRep{
//    public static final String POSTRGES_DRIVER_NAME = "org.postgresql.Driver";
//    public static final String DATABASE_URL = "jdbc:postgresql://localhost:";
//    public static final int DATABASE_PORT = 5432;
//    public static final String DATABASE_NAME = "/hleb_db";
//    public static final String DATABASE_LOGIN = "hleb";
//    public static final String DATABASE_PASSWORD = "65orevar";
//
//    private static final String ID = "id";
//    private static final String NAME = "name";

    @Autowired
    JdbcTemplate template;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    IntegerMapper integerMapper;





    @Override
    public List<Person> findAll() {
        final String findAllQuery = "select * from persons";

        List<Person> result = new ArrayList<>();

        result = template.query(findAllQuery, personMapper);

        return result;
    }

    @Override
    public Person findOne(int id) {
        final String findAllQuery = "select * from persons where id = ?";

        Person person = template.queryForObject(findAllQuery, personMapper, id);

        return person;
    }

    @Override
    public Person updatePerson(int id, Person person) {
        String query = "update persons set " +
                "name = '" + person.getName()  + "' " +
                "where id = " + id;

        template.update(query);

        return person;
    }

    @Override
    public void createPerson(Person person) {
        final String query = "insert into " +
                "persons (name) values ('" + person.getName() + "')";

        template.update(query);

        final String sql = "SELECT id FROM persons ORDER BY id DESC LIMIT 1";

        Integer idd = template.queryForObject(sql, (ResultSet rs, int i) -> new Integer(rs.getInt("id")));

        System.out.println(idd);

//        int id = template.queryForObject(sql, personMapper).getId();
//
//        Person person1 = this.findOne(id);
//
//        System.out.println("database - " + person1);


    }

    @Override
    public List<Person> searchByObject(Person person) {
        final String query = "select * from persons where " +
                "name like '%" + person.getName() + "%'";

        List<Person> result = new ArrayList<>();

        result = template.query(query, personMapper);

        return result;
    }

    @Override
    public void deletePerson(int id) {
        final String query = "delete from persons where id = " + id;

        template.update(query);
    }


//    private Person parseResultSet(ResultSet rs) {
//
//        Person person;
//
//        try {
//            person = new Person();
//            person.setId(rs.getInt(ID)); //1 or id
//            person.setName(rs.getString(NAME));
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return person;
//    }
//
//    private void registerDriver() {
//        try {
//            Class.forName(POSTRGES_DRIVER_NAME);
//        } catch (ClassNotFoundException e) {
//            System.err.println("JDBC Driver Cannot be loaded!");
//            throw new RuntimeException("JDBC Driver Cannot be loaded!");
//        }
//    }
//
//    private Connection getConnection() {
//        String jdbcURL = StringUtils.join(DATABASE_URL, DATABASE_PORT, DATABASE_NAME);
//        try {
//            return DriverManager.getConnection(jdbcURL, DATABASE_LOGIN, DATABASE_PASSWORD);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


}
