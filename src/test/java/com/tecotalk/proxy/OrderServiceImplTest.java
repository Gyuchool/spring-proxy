//package com.tecotalk.proxy;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import tmp.OrderRepository;
//import tmp.OrderResponse;
//import java.sql.Connection;
//import java.sql.SQLException;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import org.h2.jdbcx.JdbcConnectionPool;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class OrderServiceImplTest {
//
//    @Autowired
//    private OrderServiceImpl orderServiceImpl;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private static void loadDriver() {
//        try {
//            Class.forName("org.h2.Driver");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void getOne() throws SQLException {
//        Connection connection = null;
//        OrderResponse response = null;
//        Order savedOrder = null;
//        JdbcConnectionPool jdbcConnectionPool = null;
//        try {
//            jdbcConnectionPool = JdbcConnectionPool.create("jdbc:h2:mem:test;","sa", "");
//            connection = jdbcConnectionPool.getConnection();
//            System.out.println("connection open 후 >> " + connection);
//            savedOrder = orderRepository.save(new Order(5));
//            System.out.println("TRY 내부 " + orderServiceImpl.getClass());
//            response = orderServiceImpl.getOne(savedOrder.getId());
//        }
//        catch(Exception e) {
//            connection.rollback();
//        }
//        finally {
//            for(int i=0; i<10; i++){
//                Connection conn = jdbcConnectionPool.getConnection();
//                System.out.println("ma xc connetion >> " + jdbcConnectionPool.getMaxConnections());
//                conn.clearWarnings();
//            }
//            jdbcConnectionPool.dispose();
//        }
//
//
//        System.out.println("connection 닫은 후 >> " + jdbcConnectionPool);
//        System.out.println("TRY 외부 " + orderServiceImpl.getClass());
//        assertThat(response.getId()).isEqualTo(savedOrder.getId());
//    }
//
//}
