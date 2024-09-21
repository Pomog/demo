1.	- What is Method Overloading vs Method Overriding?
        Overloading - methods in the same class with the same name, but with different types of paramaters or different number of paramerets.
        Overriding - chield class can implement it's own version of method inherited form parent.
2.	- What are the differences between Heap and Stack Memory?
        Heap Memory - memory grows and shrinks dynamically as programm runs.
        Stack Memory - memory allocated for each individual programm, fixed space.
3.	- Explain the expected output of the following code segment?
        System.out.println(100 + 100 +"KeepOnCoding"); -> 200 + String
        System.out.println("KeepOnCoding" + 100 + 100); -> StringStringString
4.	- What are shallow copy and deep copy?
        Shallow copy -  a new object instance variables are the same as the original object's instance variables, copied references to parent objects. A changes made to the original or the shallow copy will affect both.
        Deep copy - a copied object is a complete copy of the original object, including creating copies of the objects referenced by the instance variables.
5.	- What is the Garbage Collector and how does it work?
        the Garbage Collector - free up memory space that is not is use, wich cause the heap memory shrinks.
6.	- What are the differences between constructor and method of a class in Java?
        Constuctor - has the Class name, no return, involved implicitly, not inherited. A constructor is a method but not vice versa.
7.	- Explain the 'this' keyword in Java.
        this - reference to the current object
8.	- What is an abstract class?
        An Adstract class - cannot be instantiated, but can be subclassed.
9.	- Explain the 'super' keyword in Java.
        super -  is a reference variable which is used to refer immediate parent class object.
10.	- Why are generics used in Java Programming?
         Generics in Java eliminate the need for type casting on objects and provide compile-time type safety.
11.	- How is the final keyword applied differently between variables, methods, and classes?
         Final in variables - can not be changed, CONST.
         Final in methods - can nor be overriden.
         Final in classes - can not be parent class.
12.	- What is 'protected'?
         Protected - an access modifier that allows access to the members of a class within the same package and also to subclasses, even if they are in different packages..
13.	- What is the difference between equals() and == in Java?
         equals() - method.
         == - comparison operator, refference comparison.
14.	- Is Java "Pass by Reference" or "Pass by Value"?
         Java is strictly "pass by value". This allows the method to modify the object referred to, but not the reference itself.
15.	- What is a Singleton class and how do you ensure class is a Singleton?
         Singleton - is a class that allows only one instance to exist. This is ensured by making the constructor private and providing a static method that returns the reference to the single instance.
16.	- What are Composition and Aggregation? State the difference.
         Aggregation - implies a relationship where the child can exist independently of the parent.
         Composition - implies a relationship where the child cannot exist independently of the parent.
17.	- Explain static block.
         Static block - executed on class loading.
18.	- Why is the remove method faster in the linked list than in an arraylist?
         In an ArrayList, the elements are stored in a contiguous block of memory. When an element is removed, all subsequent elements need to be shifted. O(1) < O(n)
19.	- How does the size of ArrayList grow dynamically? And also state how it works internally?
         ArrayList - The capacity grows automatically as elements are added to an array list. Because reallocations are costly in terms of time, preventing unnecessary ones improves performance:
         void ensureCapacity(int cap)
         void trimToSize( )
20.	- What is a Comparator and Comparable in Java?
         Comparator - functional interface with method int compare(Object o1, Object o2) 	which imposes a total ordering on some collection of objects.
         Comparable - interface with method  int compateTo(Object o), imposes a total 	ordering on the objects of each class that implements it.


dfs learning
