package com.factory.test.display;

import com.factory.test.parser.ErrorXmlParser;
import com.factory.test.parser.XmlParser;

/**
 * Created by Chaklader on 2/12/17.
 */
public class ErrorXmlDisplayService extends DisplayService {

    @Override
    protected XmlParser getParser() {
        return new ErrorXmlParser();
    }
}
