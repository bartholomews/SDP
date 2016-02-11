## BBK SDP 2016 - Week 5
###Exercises on Design Patterns II

#### 1.
    
   (a) Briefly describe the Strategy Design Pattern?
        *A context object uses strategy objects to execute their functionality:
        different strategy objects encapsulate different algorithms,
        so the behaviour of the context object can change dynamically
        depending on the particular strategy assigned, and it's not bounded to 
        a particular functionality but just to a common interface implemented
        by the various strategy objects*
    
   (b) When is it appropriate to use the STRATEGY DESIGN PATTERN?
        *When it is reasonable to assume that the class implemented's 
        behaviour is going to change depending on different factors,
        so the same code would select a particular strategy algorithm
        for different situations.*

#### 2.

Create a text formatter for a text editor. A text editor can have different text
formatters to format text. We can create different text formatters and then pass the
required one to the text editor, so that the editor will able to format the text as
required.

The text editor will hold a reference to a common interface for the text formatter
and the editor’s job will be to pass the text to the formatter to format the text.
You are required to implement this outline using the STRATEGY DESIGN PATTERN
which will make the code flexible and maintainable

Below is the `TextFormatter` interface which is implemented by all the concrete 
formatters.

```
package strategy;

public interface TextFormatter {
    void format(String text);
}
```

The above interface contains only one method, `format`, used to format the text.
Some sample test code might look like:

```
package strategy;

public class TestStrategyPattern {
    
    public static void main(String[] args) {
        TextFormatter formatter = new CapTextFormatter();
        TextEditor editor = new TextEditor(formatter);
        editor.publishText("Testing text in caps formatter");
        formatter = new LowerTextFormatter();
        editor = new TextEditor(formatter);
        editor.publishText("Testing text in lower formatter");
    }
}
```

The above code will result to the following output:

```
[CapTextFormatter]: TESTING TEXT IN CAPS FORMATTER
[LowerTextFormatter]: testing text in lower formatter
```

(*created package [strategy_java] [1]*)

#### 3.

   When is it appropriate to use the Abstract Factory design pattern?
   
   **
   
#### 4.

A product company, BIGFISH, has changed the way they take orders from their
clients. The company uses an application to take orders from them. They receive
orders, errors in orders, feedback for the previous order, and responses to the order,
in an XML format.
Now the clients don’t want to follow the company’s specific XML rules. The
clients want to use their own XML rules to communicate with BIGFISH. This means
that for every client, the company should have client specific XML parsers. 
For example, for the NYC client there should be four specific types of XML parsers, 
i.e., `NYCErrorXMLParser`, `NYCFeedbackXML`, `NYCOrderXMLParser`, `NYCResponseXMLParser`,
and four different parsers for the London client.
The company has asked you to change the application according to the new requirements.
To develop the parser for the original application they used a FACTORY
METHOD design pattern in which the exact object to use is decided by the subclasses
according to the type of parser. Now, to implement the new requirements, you are
required to use a factory of factories, i.e., an ABSTRACT FACTORY.

**Note:** You will need parsers according to client specific XMLs, so you will create
different factories for different clients which will provide the client specific XML to
parse. You will achieve this by creating an ABSTRACT FACTORY and then implement
the factory to provide a client specific XML factory. Then you will use that factory
to get the desired client specific XML parser object.
To implement the pattern you first need to create an interface that will be implemented
by all the concrete factories:
 
```
package abstractfactory;

public interface AbstractParserFactory {

    public XMLParser getParserInstance(String parserType);

}
```
 
The above interface is implemented by the client specific concrete factories 
which will provide the XML parser object to the client object. 
The `getParserInstance` method takes the `parserType` as an argument which is 
used to get the message specific (error parser, order parser etc) parser object.
The following is a test class for the resulting code:

```
package abstractfactory;

public class TestAbstractFactoryPattern {
    
    public static void main(String[] args) {
        AbstractParserFactory parserFactory = ParserFactoryProducer.getFactory("NYCFactory");
        XMLParser parser = parserFactory.getParserInstance("NYCORDER");
        String msg = "";
        msg = parser.parse();
        System.out.println(msg);
        System.out.println("************************************");
        parserFactory = ParserFactoryProducer.getFactory("LondonFactory");
        parser = parserFactory.getParserInstance("LondonFEEDBACK");
        msg = parser.parse();
        System.out.println(msg);
    }
}
```

The above code will result to the following output:

```
NYC Parsing order XML...
NYC Order XML Message
************************************
London Parsing feedback XML...
London Feedback XML Message
```

(**)

#### 5.

“In general, the details of object construction, such as instantiating and
initialising the components that comprise the object, are kept within the
object, often as part of its constructor.”

Comment on this statement with reference to *modularity* and *construction bloat*.

(**)

[1]: 
