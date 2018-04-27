package design.design_patterns.composite.htmltags;


/*The Composite Pattern has four participants:
---------------------------------------------	
1. Component
2. Leaf
3. Composite
4. Client
--------------------------------------------*/

import java.util.List;

public abstract class HtmlTag {

    public abstract String getTagName();

    public abstract void setStartTag(String tag);

    public abstract void setEndTag(String tag);

    public abstract void generateHtml();

    public void setTagBody(String tagBody) {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public void addChildTag(HtmlTag htmlTag) {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public void removeChildTag(HtmlTag htmlTag) {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public List<HtmlTag> getChildren() {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

}