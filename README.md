# Design patterns

Creational

  1. Factory
    a. Abstract Factory
    b. Factory Method
     
    A. Object Creation Logic becomes too convoluted
    B. Constructor is  not descriptive
      1. Name mandated by the containing type
      2. Cannot overload the same no. of arguments with different names
      3. can turn into overloading hell
      
    C. Wholesale object creation (non peicewise, unlike Builder) 
    D. Factory - A separate class
    E. Factory Method - A separate Function
 
     
  2. Singleton4
  3. Builder
  4. Prototype

     a. When its easier to copy an object to fully initialize a new one.
     b. Complicated objects are not designed from scratch.
     c. An existing design (partially or fully constructed ) is a prototype.
     d. We make a copy(clone) the prototype and customize it. Requires deep copy support.
     e. We make the cloning convenient.(e.g. via Factory)

Structural

  1. Adapter
  2. Bridge -  
     
     a. Stronger form of Encapsulation
     b. Decouple abstraction from implementation
     c. Connecting components through abstraction
     d. Bridge prevents a Cartesian product complexity explosion
     e. A mechanism that decouples interface(hierarchy) from implementation(hierarchy)
     
  3. Composite
  4. Decorator
  5. Facade
  
      a. Exposing several components through a single interface
      b. Provides a simple and easy to understand/user interface over large body of code
  
  6. Flyweight
      
      a. Space Optimization
      b. Avoid redundancy while storing data
      
  8. Proxy
  
Behavioural
  1.  Chain of Responsibilty
  2.  Command
      
      a. ordinary Java statements are perishable
      b. want an object that represents an operation
      c. uses : GUI commands ,multi level undo redo ,macro recording
      d. Contains all the info necessary  for the action to be taken
      e. An object which represents an instruction to perform a particular action
      
  3.  Iterator
  4.  Interpreter  
      a. A component that processes structured text data
         Lexing  : Generate separate lexical tokens
         Parsing : Interepreting sequences of tokens
      b. Turning String into OOP based structures in a complicated process   
      c. Examples
          -Programming Language compilers , interpreters , IDEs
          -HTML,XML parser
          -Numeric and Regular expressions 
     
  5.  Mediator 
      a. Facilitates communication between components
      b. Components may go in and out of the system at anytime.
      
  6.  Memento
  7.  Null
  8.  Observer
  9.  State
  10. Strategy
  11. Template
  12. Visitor
