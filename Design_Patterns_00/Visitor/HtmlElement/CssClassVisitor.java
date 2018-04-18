package com.javacodegeeks.patterns.visitorpattern;

public class CssClassVisitor implements Visitor{

	@Override
	public void visit(HtmlElement element) {
		element.setStartTag(element.getStartTag().replace(">", " class='visitor'>"));
		
	}

	@Override
	public void visit(HtmlParentElement parentElement) {
		parentElement.setStartTag(parentElement.getStartTag().replace(">", " class='visitor'>"));
	}

}
