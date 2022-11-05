package com.himalaya.javastream.designpattern.chainofresponsibility;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        OrderProcessingStep initializeStep = new OrderProcessingStep(order -> {
            if (order.getOrderStatus() == OrderStatus.CREATED) {
                System.out.println("Start processing order :: " + order.getId());
            }
            order.setOrderStatus(OrderStatus.IN_PROCESS);
        });

        OrderProcessingStep serOrderAmountStep = new OrderProcessingStep(order -> {
            if (order.getOrderStatus() == OrderStatus.IN_PROCESS) {
                System.out.println("Setting amount of order :: " + order.getId());
                order.setAmount(order.getOrderLines().stream()
                        .map(orderLine -> orderLine.getAmount())
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                );
            }
        });

        OrderProcessingStep verifyOrderStep = new OrderProcessingStep(order -> {
            if (order.getOrderStatus() == OrderStatus.IN_PROCESS) {
                System.out.println("Verifying order :: " + order.getId());
                if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                    order.setOrderStatus(OrderStatus.ERROR);
                }
            }
        });

        OrderProcessingStep processPayment = new OrderProcessingStep(order -> {
            if (order.getOrderStatus() == OrderStatus.IN_PROCESS) {
                System.out.println("Processing payment of order :: " + order.getId());
                order.setOrderStatus(OrderStatus.PROCESSED);
            }
        });

        OrderProcessingStep handleErrorStep = new OrderProcessingStep(order -> {
            if (order.getOrderStatus() == OrderStatus.ERROR) {
                System.out.println("Sending out 'Fail to process order' alert for order " + order.getId());
            }
        });

        OrderProcessingStep completeProcessingOrderStep = new OrderProcessingStep(order -> {
            if (order.getOrderStatus() == OrderStatus.PROCESSED) {
                System.out.println("Finished processing order :: " + order.getId());
            }
        });

        OrderProcessingStep chainedOrderProcessingSteps = initializeStep
                .setNext(serOrderAmountStep)
                .setNext(verifyOrderStep)
                .setNext(handleErrorStep)
                .setNext(processPayment)
                .setNext(completeProcessingOrderStep);

        Order order = new Order(
                1001L,
                OrderStatus.CREATED,
                Arrays.asList(
                        new OrderLine(1L, BigDecimal.valueOf(1000)),
                        new OrderLine(2L, BigDecimal.valueOf(2000))
                )
        );

        Order failOrder = new Order(
                1001L,
                OrderStatus.CREATED,
                Arrays.asList(
                        new OrderLine(1L, BigDecimal.valueOf(1000)),
                        new OrderLine(2L, BigDecimal.valueOf(-2000))
                )
        );

        chainedOrderProcessingSteps.process(order);
        System.out.println("=================================");
        chainedOrderProcessingSteps.process(failOrder);
    }
}
