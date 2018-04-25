package com.javacodegeeks.patterns.visitorpattern;

public interface Visitor {
	public void visit(HtmlElement element);
	public void visit(HtmlParentElement parentElement);
}
