package com.himalaya.javastream.designpattern.decorate;

public class BasicProcessor implements PriceProcessor{
    @Override
    public Price process(Price price) {
        return price;
    }
}
