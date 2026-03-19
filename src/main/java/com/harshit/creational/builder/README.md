## Builder Pattern

The Builder Design Pattern is a creational pattern used to construct complex objects step-by-step.

### 1. The "Why": The Problem it Solves
In Java, when you have an object with many optional fields, you usually face two bad options:
1. #### The Telescoping Constructor Nightmare
You create multiple constructors with different combinations of parameters.
   ```java
   // Hard to read, easy to swap two String parameters by mistake
   User user = new User("John", "Doe", 25, "New York", "USA", "12345");
   ```
2. #### The JavaBean Anti-Pattern
You use a default constructor and then call ```setters```.
* **Issue**: The object is "mutated" after creation. It is not thread-safe, and an object might be in an inconsistent state halfway through the setter calls.

### 2. The Solution: Builder Pattern
The Builder pattern allows you to "build" the object using a fluent API and then call a ```build()``` method that returns a fully formed, immutable instance.


### Why static inner class?
1. **Separation of Lifecycle (The Main Reason)**

   If the inner class were non-static, it would require an instance of the outer class 
   (User) to exist before the Builder could be created.
   * **The paradox**: The whole point of the Builder is to create the ```User``` object. 
                   If the Builder is non-static, you’d need a ```User``` to create a Builder 
                   to create a ```User```
   * **The Static Solution**: A static inner class can be instantiated independently of the outer class. 
                              This allows you to call new ```User.UserBuilder()``` 
                              without having a ```User``` object yet.
   

2. **Access to Private Members**

   In Java, an inner class (static or not) has a special privilege: it can access the **private constructor and private fields** of the outer class.
   * By making the User constructor private, you prevent anyone from bypasssing the Builder.
   * The ```UserBuilder``` can still call ```new User(this)``` because it resides "inside" the ```User``` class's scope.