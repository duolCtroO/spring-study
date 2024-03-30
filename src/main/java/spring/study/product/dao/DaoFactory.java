package spring.study.product.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.study.product.connection.ConnectionMaker;
import spring.study.product.connection.SimpleConnectionMaker;

@Configuration
public class DaoFactory {
    @Bean
    public ProductDao productDao(){
        return new ProductDao(connectionMaker());
    }
    @Bean
    public ConnectionMaker connectionMaker(){
        return new SimpleConnectionMaker();
    }
}
