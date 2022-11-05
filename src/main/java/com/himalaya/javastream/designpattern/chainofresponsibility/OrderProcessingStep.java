package com.himalaya.javastream.designpattern.chainofresponsibility;

import java.util.Optional;
import java.util.function.Consumer;

public class OrderProcessingStep {
    private Consumer<Order> processOrder;
    private OrderProcessingStep next;

    public OrderProcessingStep(Consumer<Order> processOrder) {
        this.processOrder = processOrder;
    }

    public OrderProcessingStep setNext(OrderProcessingStep next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.setNext(next);
        }
        return this;
    }

    public void process(Order order) {
        processOrder.accept(order);
        Optional.ofNullable(next).ifPresent(nextStep -> nextStep.process(order));
    }



}
