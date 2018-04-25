package com.factory.test.parser;

/**
 * Created by Chaklader on 2/12/17.
 */
public class ErrorXmlParser implements XmlParser{


    @Override
    public String parse() {
        System.out.println("Parsing the error XML messages ...");
        return "Error XML message";
    }
}
