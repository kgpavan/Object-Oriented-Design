package com.factory.test.display;

import com.factory.test.parser.FeedbackXmlParser;
import com.factory.test.parser.XmlParser;

/**
 * Created by Chaklader on 2/12/17.
 */
public class FeedbackXmlDisplayService extends DisplayService {

    @Override
    protected XmlParser getParser() {
        return new FeedbackXmlParser();
    }
}
