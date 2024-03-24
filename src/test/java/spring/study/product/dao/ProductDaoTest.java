package spring.study.product.dao;

import org.junit.jupiter.api.*;
import spring.study.product.domain.Product;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductDaoTest {
    private static ProductDao dao = new AproductDao();

    @BeforeAll
    @AfterAll
    static void resetTable() throws SQLException, ClassNotFoundException {
        dao.resetProductTable();
    }

    @Test
    @Order(1)
    void 상품_추가() throws SQLException, ClassNotFoundException {
        Product p = new Product();
        p.setId(1);
        p.setName("모자");
        p.setPrice(5000);
        dao.add(p);
    }

    @Test
    @Order(2)
    void 추가된_상품_ID_조회() throws SQLException, ClassNotFoundException {
        Product product = dao.getById(1L);
        System.out.println(product);
    }

}