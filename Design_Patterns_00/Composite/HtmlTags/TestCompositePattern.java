package design.design_patterns.composite.htmltags;


public class TestCompositePattern {

/*
    <html>
        <body>
            <p>
                Testing html tag library
            </p>
            <p>
                Paragraph 2
            </p>
        </body>
    </html>
*/    

    public static void main(String[] args) {

        // parent elements
        HtmlTag htmlTag = new HtmlParentElement("<html>");
        htmlTag.setStartTag("<html>");
        htmlTag.setEndTag("</html>");

        HtmlTag bodyTag = new HtmlParentElement("<body>");
        bodyTag.setStartTag("<body>");
        bodyTag.setEndTag("</body>");

        htmlTag.addChildTag(bodyTag);

        // insider elements of from the parent
        HtmlTag paragraphTag = new HtmlElement("<p>");
        paragraphTag.setStartTag("<p>");
        paragraphTag.setEndTag("</p>");
        paragraphTag.setTagBody("Testing html tag library");
        bodyTag.addChildTag(paragraphTag);

        paragraphTag = new HtmlElement("<p>");
        paragraphTag.setStartTag("<p>");
        paragraphTag.setEndTag("</p>");
        paragraphTag.setTagBody("Paragraph 2");
        bodyTag.addChildTag(paragraphTag);

        htmlTag.generateHtml();
    }
}


