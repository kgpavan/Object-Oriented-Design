

There are times when you feel a need of a tree data structure in your code. There are many variations to the tree data structure, but sometimes there is a need of a tree in which both branches as well as leafs of the tree should be treated as uniformly.

The Composite Pattern allows you to compose objects into a tree structure to represent the part-whole hierarchy which means you can create a tree of objects that is made of different parts, but that can be treated as a whole one big thing. Composite lets clients to treat individual objects and compositions of objects uniformly, that’s the intent of the Composite Pattern.


The Composite Pattern has four participants:

    Component

    Leaf

    Composite

    Client



------------------------------------------------------------------------------------------

## Intent
Compose objects into tree structures to represent part-whole
hierarchies. Composite lets clients treat individual objects and compositions
of objects uniformly.

## Explanation

Real world example

> Every sentence is composed of words which are in turn composed of characters. Each of these objects is printable and they can have something printed before or after them like sentence always ends with full stop and word always has space before it

In plain words

> Composite pattern lets clients treat the individual objects in a uniform manner.

Wikipedia says

> In software engineering, the composite pattern is a partitioning design pattern. The composite pattern describes that a group of objects is to be treated in the same way as a single instance of an object. The intent of a composite is to "compose" objects into tree structures to represent part-whole hierarchies. Implementing the composite pattern lets clients treat individual objects and compositions uniformly.

**Programmatic Example**

Taking our sentence example from above. Here we have the base class and different printable types

```
public abstract class LetterComposite {
  private List<LetterComposite> children = new ArrayList<>();
  public void add(LetterComposite letter) {
    children.add(letter);
  }
  public int count() {
    return children.size();
  }
  protected void printThisBefore() {}
  protected void printThisAfter() {}
  public void print() {
    printThisBefore();
    for (LetterComposite letter : children) {
      letter.print();
    }
    printThisAfter();
  }
}

public class Letter extends LetterComposite {
  private char c;
  public Letter(char c) {
    this.c = c;
  }
  @Override
  protected void printThisBefore() {
    System.out.print(c);
  }
}

public class Word extends LetterComposite {
  public Word(List<Letter> letters) {
    for (Letter l : letters) {
      this.add(l);
    }
  }
  @Override
  protected void printThisBefore() {
    System.out.print(" ");
  }
}

public class Sentence extends LetterComposite {
  public Sentence(List<Word> words) {
    for (Word w : words) {
      this.add(w);
    }
  }
  @Override
  protected void printThisAfter() {
    System.out.print(".");
  }
}
```

Then we have a messenger to carry messages

```
public class Messenger {
  LetterComposite messageFromOrcs() {
    List<Word> words = new ArrayList<>();
    words.add(new Word(Arrays.asList(new Letter('W'), new Letter('h'), new Letter('e'), new Letter('r'), new Letter('e'))));
    words.add(new Word(Arrays.asList(new Letter('t'), new Letter('h'), new Letter('e'), new Letter('r'), new Letter('e'))));
    words.add(new Word(Arrays.asList(new Letter('i'), new Letter('s'))));
    words.add(new Word(Arrays.asList(new Letter('a'))));
    words.add(new Word(Arrays.asList(new Letter('w'), new Letter('h'), new Letter('i'), new Letter('p'))));
    words.add(new Word(Arrays.asList(new Letter('t'), new Letter('h'), new Letter('e'), new Letter('r'), new Letter('e'))));
    words.add(new Word(Arrays.asList(new Letter('i'), new Letter('s'))));
    words.add(new Word(Arrays.asList(new Letter('a'))));
    words.add(new Word(Arrays.asList(new Letter('w'), new Letter('a'), new Letter('y'))));
    return new Sentence(words);
  }

  LetterComposite messageFromElves() {
    List<Word> words = new ArrayList<>();
    words.add(new Word(Arrays.asList(new Letter('M'), new Letter('u'), new Letter('c'), new Letter('h'))));
    words.add(new Word(Arrays.asList(new Letter('w'), new Letter('i'), new Letter('n'), new Letter('d'))));
    words.add(new Word(Arrays.asList(new Letter('p'), new Letter('o'), new Letter('u'), new Letter('r'), new Letter('s'))));
    words.add(new Word(Arrays.asList(new Letter('f'), new Letter('r'), new Letter('o'), new Letter('m'))));
    words.add(new Word(Arrays.asList(new Letter('y'), new Letter('o'), new Letter('u'), new Letter('r'))));
    words.add(new Word(Arrays.asList(new Letter('m'), new Letter('o'), new Letter('u'), new Letter('t'), new Letter('h'))));
    return new Sentence(words);
  }
}
```

And then it can be used as

```
LetterComposite orcMessage = new Messenger().messageFromOrcs();
orcMessage.print(); // Where there is a whip there is a way.
LetterComposite elfMessage = new Messenger().messageFromElves();
elfMessage.print(); // Much wind pours from your mouth.
```

## Applicability
Use the Composite pattern when

* you want to represent part-whole hierarchies of objects
* you want clients to be able to ignore the difference between compositions of objects and individual objects. Clients will treat all objects in the composite structure uniformly

## Real world examples

* [java.awt.Container] 
* [java.awt.Component]
* [Apache Wicket] Component(https://github.com/apache/wicket) component tree, 
* [Apache Wicket] MarkupContainer(https://github.com/apache/wicket) MarkupContainer 

