package spring.study.product.dao;

import spring.study.product.domain.Product;

import java.sql.*;

public class ProductDao {

    public void add(Product product) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            //DB 연결을 위한 Connection 가져오기
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost/springbook", "root", "root");
            //SQL문을 담을 statement 만들기
            ps = con.prepareStatement("insert into product(id, name, price) values(?, ?, ?)");
            ps.setLong(1, product.getId());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getPrice());
            //statement 실행
            ps.execute();
            //작업 중 만든 Connection, statement, resultset 리소스 닫아주기
        }finally {
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }

    public void resetProductTable() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            //DB 연결을 위한 Connection 가져오기
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost/springbook", "root", "root");
            //SQL문을 담을 statement 만들기
            ps = con.prepareStatement("delete from product");
            //statement 실행
            ps.execute();
            //작업 중 만든 Connection, statement, resultset 리소스 닫아주기
        }finally {
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }

    public Product getById(Long id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //DB 연결을 위한 Connection 가져오기
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost/springbook", "root", "root");
            //SQL문을 담을 statement 만들기
            ps = con.prepareStatement("select * from product where id = ?");
            ps.setLong(1, id);
            //statement 실행
            rs = ps.executeQuery();
            Product result = new Product();
            while(rs.next()){
                result.setId(rs.getLong(1));
                result.setName(rs.getString(2));
                result.setPrice(rs.getInt(3));
            }
            return result;
            //작업 중 만든 Connection, statement, resultset 리소스 닫아주기
        }finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }

}
