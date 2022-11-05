package com.himalaya.javastream.designpattern.decorate;

public class DiscountPriceProcessor implements PriceProcessor{

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + " then apply discount price.");
    }
}
