
--------------------------
INTERPRETOR DESIGN PATTERN 
--------------------------


The Interpreter Design Pattern is a heavy-duty pattern. It’s all about putting together your own programming language, or handling an existing one, by creating an interpreter for that language. To use this pattern, you have to know a fair bit about formal grammars to put together a language. As you can imagine, this is one of those patterns that developers don’t really use every day, because creating your own language is not something many people do.

For example, defining an expression in your new language might look something like the following snippet in terms of formal grammars:

expression ::= <command> | <repetition> | <sequence>

Each expression in your new language, then, might be made up of commands, repetitions of commands, and sequences expressions. Each item might be represented as an object with an interpret method to translate your new language into something you can run in Java.

To illustrate the use of Interpreter Design Pattern let’s create an example to solve simple mathematical expressions, but before that, let’s discuss some details about the Interpreter Design Pattern in the section below.


Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

In general, languages are made up of a set of grammar rules. Different sentences can be constructed by following these grammar rules. Sometimes an application may need to process repeated occurrences of similar requests that are a combination of a set of grammar rules. These requests are distinct but are similar in the sense that they are all composed using the same set of rules.

A simple example of this would be the set of different arithmetic expressions submitted to a calculator program. Though each such expression is different, they are all constructed using the basic rules that make up the grammar for the language of arithmetic expressions.

In such cases, instead of treating every distinct combination of rules as a separate case, it may be beneficial for the application to have the ability to interpret a generic combination of rules. The Interpreter pattern can be used to design this ability in an application so that other applications and users can specify operations using a simple language defined by a set of grammar rules.

A class hierarchy can be designed to represent the set of grammar rules with every class in the hierarchy representing a separate grammar rule. An Interpreter module can be designed to interpret the sentences constructed using the class hierarchy designed above and carries out the necessary operations.

Because a different class represents every grammar rule, the number of classes increases with the number of grammar rules. A language with extensive, complex grammar rules requires a large number of classes. The Interpreter pattern works best when the grammar is simple. Having a simple grammar avoids the need to have many classes corresponding to the complex set of rules involved, which are hard to manage and maintain.


------------------------------------------------------------------------------------
AbstractExpression
------------------
Declares an abstract Interpret operation that is common to all nodes in the abstract syntax tree.

TerminalExpression
------------------
Implements an Interpret operation associated with terminal symbols in the grammar.
An instance is required for every terminal symbol in a sentence.

NonterminalExpression
---------------------
One such class is required for every rule R ::= R1 R2 ... Rn in the grammar.
Maintains instance variables of type AbstractExpression for each of the symbols R1 through Rn.
Implements an Interpret operation for non terminal symbols in the grammar. Interpret typically calls itself recursively on the variables representing R1 through Rn.

Context
-------
Contains information that’s global to the interpreter.

Client
------
Builds (or is given) an abstract syntax tree representing a particular sentence in the language that the grammar defines. The abstract syntax tree is assembled from instances of the NonterminalExpression and TerminalExpression classes. Invokes the Interpret operation.
------------------------------------------------------------------------------------






--------------------------------------------------------------------------------------
------
INTENT
------

Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.
Map a domain to a language, the language to a grammar, and the grammar to a hierarchical object-oriented design.

PROBLEM
-------
A class of problems occurs repeatedly in a well-defined and well-understood domain. If the domain were characterized with a "language", then problems could be easily solved with an interpretation "engine".


DISCUSSION
----------

The Interpreter pattern discusses: defining a domain language (i.e. problem characterization) as a simple language grammar, representing domain rules as language sentences, and interpreting these sentences to solve the problem. The pattern uses a class to represent each grammar rule. And since grammars are usually hierarchical in structure, an inheritance hierarchy of rule classes maps nicely.

An abstract base class specifies the method interpret(). Each concrete subclass implements  interpret() by accepting (as an argument) the current state of the language stream, and adding its contribution to the problem solving process.
------------------------------------------------------------------------------------------



