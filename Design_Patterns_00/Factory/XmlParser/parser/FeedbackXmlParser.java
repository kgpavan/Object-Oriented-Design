package com.factory.test.parser;

/**
 * Created by Chaklader on 2/12/17.
 */
public class FeedbackXmlParser implements  XmlParser{

    @Override
    public String parse() {

        System.out.println("Parsing the feedback XML message");
        return "Feedback XML message";
    }
}
