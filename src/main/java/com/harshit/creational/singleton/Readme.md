# Singleton Design Pattern Implementations in Java
This repository contains various ways to implement the Singleton Design Pattern in Java. The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.

## 🚀 Implementations & Trade-offs
### 1. Eager Initialization
   The instance is created at the time of class loading.

* **Pros**: Simple, thread-safe without synchronization.

* **Cons**: Resource Waste. The instance is created even if it’s never used.

### 2. Lazy Initialization (Non-Thread Safe)
   The instance is created only when getInstance() is called.

* **Pros**: Saves resources until needed.

* **Cons**: Race Conditions. Not suitable for multi-threaded environments.

### 3. Synchronized Method
   Thread-safe lazy initialization using the synchronized keyword.

* **Pros**: Thread-safe.

* **Cons**: Performance Bottleneck. Every call to getInstance() requires a lock, which is expensive.

### 4. Double-Checked Locking (DCL)
   Reduces synchronization overhead by checking the instance twice.

* **Pros**: High performance and thread-safe.

* **Cons**: 
  1. Complexity. It is easy to forget the volatile keyword. Without it, a thread might see 
  a half-initialized object because the JVM might reorder the assignment before the 
  constructor finishes.
  2. Even with volatile and synchronized, a developer can use Java Reflection to break the Singleton.
  3. If your Singleton class implements Serializable, the default Java deserialization process will 
  create a new instance every time the object is read from a file or network stream.

### 5. Bill Pugh Singleton (Static Inner Class)
   Uses a helper inner class to hold the instance.

* **Pros**: Best for most Java apps. Lazy-loaded and thread-safe without explicit synchronization.

* **Cons**: Vulnerable to Reflection. Constructors can be accessed via Java Reflection API.

### 6. Enum Singleton
   The most robust way to implement a Singleton.

* **Pros**: Reflection-proof, handles serialization automatically, and thread-safe by the JVM.

* **Cons**: Inflexible. Does not support lazy initialization and cannot extend other classes.

## 📊 Summary Table

| Implementation | Lazy Loading  | Thread Safe | Performance |
|----------------|---------------|-------------|-------------|
| Eager          | ❌             | ✅           | High        |
| Lazy (Simple)  | ✅             | ❌           | High        |
| Synchronized   | ✅             | ✅           | Low         |
| Double-Checked | ✅             | ✅           | High        |
| Bill Pugh      | ✅             | ✅           | High        |
| Enum           | ❌             | ✅           | High        |