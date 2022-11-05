package com.himalaya.javastream.designpattern.chainofresponsibility;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderLine {

    private long id;
    private BigDecimal amount;

    public OrderLine(long id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }
}
