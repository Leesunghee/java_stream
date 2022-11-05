package com.himalaya.javastream.designpattern.decorate;

public class Main {
    public static void main(String[] args) {

        Price price = new Price("original price");

        BasicProcessor basicProcessor = new BasicProcessor();
        DiscountPriceProcessor discountPriceProcessor = new DiscountPriceProcessor();
        TaxPriceProcessor taxPriceProcessor = new TaxPriceProcessor();

        PriceProcessor decoratedPriceProcessor = basicProcessor.andThen(discountPriceProcessor)
                .andThen(taxPriceProcessor)
                .andThen(price1 -> new Price(price1.getPrice() + " and then other price processor."));
        Price processedPrice = decoratedPriceProcessor.process(price);

        System.out.println("processedPrice = " + processedPrice.getPrice());


    }
}
