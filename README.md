# jbelt
Things I wish were in Java's standard library.    

# **Pipes**
Emulates the pipe notation from Functional languages. 


# **Lambdas**
**uncheck** -- Takes a Function/Consumer with a checked exception, and turns it unchecked, by wrapping the exception in a RuntimeException. This is useful for cases where you're happy having the program halt if the aforementioned exception is thrown, and don't want to deal with catching the exception or coloring your current method's signature with it. This comes especially in handy when dealing with lambdas, because using methods with checked exceptions is impossible and requires you to write out the try-catch block every time.

Before:
```java
List.of("String.class", "Integer.class", "MyFunction.class").stream()
    .map(s -> {
        try {
            return Class.forName(s);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    })
    .toList();
```

After:
```java
List.of("String.class", "Integer.class", "MyFunction.class").stream()
    .map(lambdas.uncheck(Class::forName))
    .toList();
```

- **recover** -- Takes a Function/Consumer that throws a RuntimeException and suppresses it. In the case of a Consumer, it does nothing. In the case of a Function, it outputs the provided default value. This is valuable in cases where you want to process input, and ignore the errors.

Before:
```java
List.of("504", "200", "403", "oops", "123").stream()
    .map(s -> {
      try {
        return Integer.parseInt(s);
      } catch (NumberFormatException e) {
        return -1;
      })
    .toList();
```

After:
```java
List.of("504", "200", "403", "oops", "123").stream()
    .map(lambdas.recover(Integer::parseInt, -1))
    .toList();
```

**Collections**
- **fold** -- given a collection of `I`, a base object of `O`, and a function `(O, I) -> O`, runs a fold operation to output the `O` reduction.
