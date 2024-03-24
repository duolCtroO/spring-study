package spring.study.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AproductDao extends ProductDao{
    // ProductDao 추상 클래스를 일반 클래스로 바꾼뒤 에러코드 추석처리
//    @Override
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mariadb://localhost/springbook", "root", "root");
//    }
}
