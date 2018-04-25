package com.factory.test.parser;

/**
 * Created by Chaklader on 2/12/17.
 */
public class ResponseXmlParser implements XmlParser{

    @Override
    public String parse() {

        System.out.println("Parsign the response XML message");
        return "Response XML parser";
    }
}
