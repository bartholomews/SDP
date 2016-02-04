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

