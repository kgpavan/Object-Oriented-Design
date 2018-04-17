package com.factory.test.parser;

/**
 * Created by Chaklader on 2/12/17.
 */
public class OrderXmlParser implements XmlParser{

    @Override
    public String parse() {

        System.out.println("Parsign the Order XML messages ... ");
        return "Order XML parser";
    }
}
