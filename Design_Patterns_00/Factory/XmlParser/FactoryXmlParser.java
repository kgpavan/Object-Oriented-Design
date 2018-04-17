package com.factory.test;

import com.factory.test.display.*;

public class FactoryXmlParser {


    public static void main(String[] args) {

        System.out.println("My Awesome XML Parser");

        DisplayService displayService = new ResponseXmlDisplayService();
        displayService.display();

        displayService = new ErrorXmlDisplayService();
        displayService.display();


        displayService = new OrderXmlDisplayService();
        displayService.display();


        displayService = new FeedbackXmlDisplayService();
        displayService.display();
    }
}
