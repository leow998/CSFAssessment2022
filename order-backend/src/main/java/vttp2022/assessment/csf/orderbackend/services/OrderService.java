package vttp2022.assessment.csf.orderbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vttp2022.assessment.csf.dtos.OrderDto;
import vttp2022.assessment.csf.orderbackend.models.Order;
import vttp2022.assessment.csf.orderbackend.repositories.OrderRepo;
import vttp2022.assessment.responce.GeneralResponse;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public GeneralResponse saveOrder(OrderDto orderDto) {
        GeneralResponse response = new GeneralResponse();
        Order order = new Order();
        order.getOrder(orderDto);
        orderRepo.save(order);
        response.setMessage("Order placed successfully!");
        response.setStatus(HttpStatus.CREATED);
        return response;
    }

    public List<OrderDto> getOrdersByEmail(String email) {
        return orderRepo.findAllByEmail(email).stream().map(Order::orderDto).collect(Collectors.toList());
    }
}
