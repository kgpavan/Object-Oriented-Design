package com.factory.test.display;

import com.factory.test.parser.XmlParser;

/**
 * Created by Chaklader on 2/12/17.
 */
public abstract class DisplayService {

    public void display(){

        XmlParser xmlParser = getParser();
        String message = xmlParser.parse();
        System.out.println(message);
    }

    protected abstract XmlParser getParser();
}
