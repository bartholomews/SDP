## BBK SDP 2016 - Week 3
###Exercises on Design Patterns
####The Basics

#### Short form questions

1. Write down three differences between abstract classes and interfaces in Java 8.   
Provide examples to illustrate your answer.   

2. Are the following true or false?   
    (a) Every interface must have at least one method.  
    (b) An interface can declare instance fields that an implementing class must also declare.   
    (c) Although you can’t instantiate an interface, an interface definition can declare constructor methods that require   
    an implementing class to provide constructors with given signatures.   
    Provide examples to illustrate your answers.   

3. Provide an example of an interface with methods that do not imply responsibility on the part of the implementing class   
to take action on behalf of the caller or to return a value.

4. What is the value of a stub class like `WindowAdapter` which is composed of methods that do nothing?

```
"stub/WindowListener.java"

package stub;

public interface WindowListener {

    void windowOpened();
    void windowClosing();
    void windowClosed();
    void windowIconified();
    void windowDeiconified();
    void windowActivated();
    void windowDeactivated();

}
```

```
"stub/WindowAdapter.java"
￼￼￼
package stub;

public class WindowAdapter implements WindowListener {

    @Override
    public void windowOpened() {}
    @Override
    public void windowClosing() {}
    @Override
    public void windowClosed() {}
    @Override
    public void windowIconified() {}
    @Override
    public void windowDeiconified() {}
    @Override
    public void windowActivated() {}
    @Override
    public void windowDeactivated() {}

}
```

5. How can you prevent other developers from constructing new instances of your class?   
Provide appropriate examples to illustrate your answer.

6. Why might you decide to lazy-initialise a singleton instance rather than initialise   
it in its field declaration? Provide examples of both approaches to illustrate your answer.

7. Using the `java.util.Observable` and `java.util.Observer` classes/interfaces  
show how one object can be informed of updates to another object.

8. “The Observer pattern supports the MVC pattern”.  
State if this statement is true or false and support your answer by use of an appropriate example.

9. Provide examples of two commonly used Java methods that return a new object. 

10. What are the signs that a Factory Method is at work?    

11. If you want to direct output to `System.out` instead of to a file,   
you can create a `Writer` object that directs its output to `System.out`:   

```
Writer out = new PrintWriter(System.out);
```

Write a code example to define a `Writer` object that wraps text at 15 characters,   
centres the text, sets the text to random casing, and directs the output to System.out.  
Which design pattern are you using? 

#### Long form questions    

1. The FACTORY METHOD design pattern.   

The FACTORY METHOD pattern gives us a way to encapsulate the instantiations of concrete types;   
it encapsulates the functionality required to select and instantiate an appropriate class, 
inside a designated method referred to as a factory method. 
The factory method selects an appropriate class from a class hierarchy based on the application context 
and other contributing factors and it then instantiates the selected class 
and returns it as an instance of the parent class type. 

The advantage of this approach is that the application objects can make use of the factory method   
to gain access to the appropriate class instance. This eliminates the need for an application object     
to deal explicitly with the varying class selection criteria.   
You are required to implement the following classes:    

`Product` defines the interface of objects the factory method creates.  
  
`ConcreteProduct` implements the `Product` interface.   

`Creator` declares the factory method, which returns an object of type `Product`.   
    
`Creator` may also define a default implementation of the factory method that returns a default `ConcreteProduct` object.
 We may call the factory method to create a `Product` object.   
 
`ConcreteCreator` overrides the factory method to return an instance of a `ConcreteProduct`.    
  
Factory methods therefore eliminate the need to bind application-specific classes into your code.    
The code only deals with the `Product` interface (in this case);     
therefore it can work with any user-defined `ConcreteProduct` classes.  

(*created package [**factory_method***] [1])

2. The SINGLETON design pattern.    

If you didn’t provide implementations of a lazy and eager singleton pattern in *Question 6* 
do so now. (You should provide a static `getInstance` method).  

Imagine that we now wish to use the code in a *multi-threaded environment*. 
Two threads concurrently access the class, thread t1 gives the first call to the `getInstance()` 
method, it will check if the static variable that holds the reference to the singleton instance is null 
and then gets interrupted due to some reason. Another thread t2 calls the `getInstance()` method 
successfully passes the instance check and instantiates the object. 
Then, thread t1 wakes and it also creates the object. At this time, there would be two objects 
of this class which was supposedly a singleton. 

(a) How could we use the synchronized keyword to the getInstance() method to operate correctly. 

(b) The synchronised version comes with a price as it will decrease the performance of the code — why?  

(c) If the call to the getInstance() method isn’t causing a substantial overhead for your application, then you can forget about it.    

(d) If you want to use synchronisation (or need to), then there is another technique known as double-checked locking which reduces the use of synchronisation. 
With double-checked locking, we first check to see if an instance is created, and if not, then we synchronise.  

Provide a sample implementation of this technique. There are some other ways to break the singleton pattern:   
     • If the class is Serializable.
     • If it is Cloneable.
     • It can be broken by reflection.
     • If the class is loaded by multiple class loaders.
     
   Try and write a class SingletonProtected that addresses some (all?) of these issues.

(*created package **[singleton]** [2])

3. The ADAPTER design pattern.

A software developer, Max, has worked on an e-commerce website. 
The website allows users to shop and pay online. 
The site is integrated with a third party payment gateway, 
through which users can pay their bills using their credit card. 
Everything was going well, until his manager called him for a change in the project.    

The manager has told him that they are planning to change the payment gateway vendor, 
and Max has to implement that in the code. The problem that arises here is that the site 
is attached to the **Xpay** payment gateway which takes an **Xpay** type of object. 
The new vendor, **PayD**, only allows the **PayD** type of objects to allow the process. 
Max doesn’t want to change the whole set of a hundred classes which have reference 
to an object of type **XPay**. He cannot change the third party tool provided by the payment 
gateway. The problem arises due to the incompatible interfaces between the two different parts 
of the code. To get the process to work, Max needs to find a way to make the code compatible with 
the vendor’s provided API. 

The current code interface is not compatible with the new vendor’s interface. 
What Max needs here is an Adapter which can sit in between the code and the vendor’s API, 
enabling the transaction to proceed.

```
package xpay;

    public interface Xpay {
        String getCreditCardNo();
        
        void setCreditCardNo(String creditCardNo);
        
        String getCustomerName();
        
        void setCustomerName(String customerName);
        
        String getCardExpMonth();
        
        void setCardExpMonth(String cardExpMonth);
        
        String getCardExpYear();
        
        void setCardExpYear(String cardExpYear);
        
        Short getCardCVVNo();
  
        void setCardCVVNo(Short cardCVVNo);
   
        Double getAmount();
 
        void setAmount(Double amount);
    }
```

The **Xpay** interface contains setter and getter methods to get the information about 
the credit card and customer name. The interface is implemented in the following code 
which is used to instantiate an object of this type, and exposes the object to the vendor’s API.

```
package xpay;

@lombok.Data
public class XpayImpl implements Xpay {
    private String creditCardNo;
    private String customerName;
    private String cardExpMonth;
    private String cardExpYear;
    private Short cardCVVNo;
    private Double amount;
    
}
```

New vendor’s interface looks like this:

```
package xpay;

public interface PayD {
    String getCustCardNo();
    
    void setCustCardNo(String custCardNo);
    
    String getCardOwnerName();
    
    void setCardOwnerName(String cardOwnerName);
    
    String getCardExpMonthDate();
    
    void setCardExpMonthDate(String cardExpMonthDate);
    
    Integer getCVVNo();
    
    void setCVVNo(Integer cVVNo);
    
    Double getTotalAmount();
    
    void setTotalAmount(Double totalAmount);

}
```

As you can see, this interface has a set of different methods which need to be implemented in the code. 
However, **Xpay** objects are created by most parts of the code, and it is difficult (and risky) 
to change the entire set of classes. We need some way, that’s able to fulfil the vendor’s requirement 
to process the payment and also make less or no change to the current code base.
Your are required to use the Adapter pattern to implement a **XpayToPayDAdapter** class to meet the requirements.



[1]: https://github.com/f-bartholomews/exercises/tree/master/w03_Design-Patterns/src/factory_method
[2]: https://github.com/f-bartholomews/exercises/tree/master/w03_Design-Patterns/src/singleton