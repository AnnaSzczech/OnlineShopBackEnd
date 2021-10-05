package team.java.auction.house.service;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.OrderEntity;
import team.java.auction.house.domain.QOrderEntity;
import team.java.auction.house.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager em;

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<OrderEntity> findByCustomerId(Long customerId) {
        JPAQuery<OrderEntity> query = new JPAQuery<>(em);
        QOrderEntity order = QOrderEntity.orderEntity;
        return query.from(order)
                .where(order.customersId.customerId.eq(customerId))
                .fetch();
    }

    public Optional<OrderEntity> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void saveOrder(OrderEntity order) {
        orderRepository.save(order);
    }

    public void deleteOrder(OrderEntity order) {
        orderRepository.delete(order);
    }
}
