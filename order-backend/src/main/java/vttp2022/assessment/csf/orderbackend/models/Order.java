package vttp2022.assessment.csf.orderbackend.models;


import vttp2022.assessment.csf.dtos.OrderDto;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String size;

    private String base;

    private String sauce;

    private String toppings;

    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void getOrder(OrderDto orderDto) {
        this.name = orderDto.getName();
        this.email = orderDto.getEmail();
        this.size = orderDto.getSize();
        this.base = orderDto.getBase();
        this.sauce = orderDto.getSauce();
        this.toppings = orderDto.getToppings();
        this.comment = orderDto.getComment();
    }

    public OrderDto orderDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setName(name);
        orderDto.setEmail(email);
        orderDto.setSize(size);
        orderDto.setSauce(sauce);
        orderDto.setToppings(toppings);
        orderDto.setComment(comment);
        return orderDto;
    }
}
