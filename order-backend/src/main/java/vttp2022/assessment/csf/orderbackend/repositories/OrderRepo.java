package vttp2022.assessment.csf.orderbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vttp2022.assessment.csf.orderbackend.models.Order;

import java.util.List;


public interface OrderRepo extends JpaRepository<Order,Long> {
    List<Order> findAllByEmail(String email);
}
