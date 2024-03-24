package spring.study.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Interface 사용 후 에러코드 주석 처리
//public class AproductDao extends ProductDao{
//
//    @Override
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mariadb://localhost/springbook", "root", "root");
//    }
//}
