package spring.study.product;

import spring.study.product.dao.DaoFactory;
import spring.study.product.dao.ProductDao;
import spring.study.product.domain.Product;

import java.sql.SQLException;

public class ApplicationEngine {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Product product = new Product();
        product.setName("Test");
        product.setId(1L);
        product.setPrice(1000);
        ProductDao dao = new DaoFactory().getProductDao();
        dao.resetProductTable();
        dao.add(product);
        Product byIdProduct = dao.getById(1L);
        System.out.println(product);
        System.out.println(byIdProduct);
    }
}
