package spring.study.product.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 단순히 DB Connection 객체를 만들어 리턴하는 클래스
 */
public class SimpleConnectionMaker implements ConnectionMaker{

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mariadb://localhost/springbook", "root", "root");
    }
}
