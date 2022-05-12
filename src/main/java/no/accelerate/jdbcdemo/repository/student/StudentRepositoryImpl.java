package no.accelerate.jdbcdemo.repository.student;

import no.accelerate.jdbcdemo.models.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * Implementation of Student repository with JDBC and Prepared Statements.
 * Values for url, user, and password are injected by Springs IoC from application.properties.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private String url;
    private String user;
    private String password;

    public StudentRepositoryImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String user,
            @Value("${spring.datasource.password}") String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(Integer id) {
        Student student = null;
        String sql = "SELECT * FROM student WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(url,user,password)){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("professor_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public int insert(Student object) {
        return 0;
    }

    @Override
    public int update(Student object) {
        return 0;
    }

    @Override
    public int delete(Student object) {
        return 0;
    }

    @Override
    public int deleteById(Integer integer) {
        return 0;
    }
}
