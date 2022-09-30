package vttp2022.assessment.csf.orderbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vttp2022.assessment.csf.dtos.OrderDto;
import vttp2022.assessment.csf.orderbackend.services.OrderService;
import vttp2022.assessment.responce.GeneralResponse;

@RestController
public class OrderRestController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/api/order")
    public GeneralResponse saveOrder(@RequestBody OrderDto orderDto) {
        GeneralResponse response = new GeneralResponse();
        try {
            return orderService.saveOrder(orderDto);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry something went wrong!");
            return response;
        }
    }

    @GetMapping("/api/order/{email}/all")
    public GeneralResponse getOrdersByEmail(@PathVariable String email) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(orderService.getOrdersByEmail(email));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Order Fetched successfully!");
            return response;

        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry something went wrong!");
            return response;
        }
    }
}
