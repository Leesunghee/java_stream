package com.himalaya.javastream.designpattern.decorate;

public class TaxPriceProcessor implements PriceProcessor{

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + " then apply tax price.");
    }
}
