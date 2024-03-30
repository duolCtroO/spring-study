package spring.study.product;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.study.product.dao.DaoFactory;
import spring.study.product.dao.ProductDao;
import spring.study.product.domain.Product;

import java.sql.SQLException;

public class ApplicationEngine {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DaoFactory.class);
        ProductDao productDao = ac.getBean("productDao", ProductDao.class);
        Product product = new Product();
        product.setId(1L);
        product.setName("test");
        product.setPrice(1000);
        productDao.resetProductTable();
        productDao.add(product);
        Product byId = productDao.getById(1L);
        System.out.println(byId);

    }
}
