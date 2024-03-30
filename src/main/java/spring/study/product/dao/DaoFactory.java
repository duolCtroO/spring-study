package spring.study.product.dao;

import spring.study.product.connection.ConnectionMaker;
import spring.study.product.connection.SimpleConnectionMaker;

public class DaoFactory {
    public ProductDao getProductDao(){
        ConnectionMaker cm = new SimpleConnectionMaker();
        return new ProductDao(cm);
    }
}
