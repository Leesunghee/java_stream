package com.himalaya.javastream.designpattern.decorate;

@FunctionalInterface
public interface PriceProcessor {

    Price process(Price price);

    default PriceProcessor andThen(PriceProcessor next) {
        return price -> next.process(process(price));

    }
}
