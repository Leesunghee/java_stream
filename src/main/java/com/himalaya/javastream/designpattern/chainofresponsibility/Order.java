package com.himalaya.javastream.designpattern.chainofresponsibility;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Order {

    private long id;
    private OrderStatus orderStatus;
    private List<OrderLine> orderLines = new ArrayList<>();

    private BigDecimal amount;

    public Order(long id, OrderStatus orderStatus, List<OrderLine> orderLines) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.orderLines = orderLines;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
