# Java Tool Belt (Belt)
Things I wish were in Java's standard library.    

# Pipes
Emulates the pipe notation from functional languages. This is useful when you want multiple operations performed sequentially on an initial input, and have no use for each intermediate step to be available as a variable in scope. This also can serve to make the code more readable.

Before:
```java
var result = operation3(operation2(operation1(input)))
System.out.println(operationD(operationC(operationB(operationA(input)))));
```

After:
```java
var result = pip.of(input)
    .pipe(operation1)
    .pipe(operation2)
    .pipe(operation3)
    .get()
pip.of(input)
    .pipe(operationA)
    .pipe(operationB)
    .pipe(operationC)
    .pipe(operationD)
    .to(System.out::println);
```

# Tuples
Useful records to represent tuples of values.

## signature
This lets Java methods return multiple values together without the developer having to create one-off classes or records to hold these values. This also provides stronger type-safety than returning an array of Objects that then need to be unsafely cast to be used. 

Before:
```java
record NameAndHeight(String name, Integer height) {}
public NameAndHeight getNameAndHeight(long id);

record HeightAndWeight(Integer height, Double weight) {}
public HeightAndWeight getHeightAndWeight(long id);

record NameAndEmail(String name, String email) {}
public NameAndEmail getNameAndEmail(long id);

record NameAndHeightAndEmail(String name, Integer height, String email) {}
public NameAndHeightAndEmail getNameAndHeightAndEmail(long id);
```

After:
```java
public Tuple2<String, Integer> getNameAndHeight(long id);
public Tuple2<Integer, Double> getHeightAndWeight(long id);
public Tuple2<String, String> getNameAndEmail(long id);
public Tuple3<String, Integer, String> getNameAndHeightAndEmail(long id);
```

## association
Easy association of values together. 

Before:
```java
void process(
    Integer idA, Person personA, String emailA, String addrA,
    Integer idB, Person personB, String emailB, String addrB); // 8 parameters

process(102, "Kon", "ko@n.com", "12 K dr USA", 204, "Unj", "un@j.com", "41 U st CA");
```

After:
```java
void process(
    Tuple4<Integer, Person, String, String> a,
    Tuple4<String, Person, String, String> b); // 2 parameters

process(tup.of(102, "Kon", "ko@n.com", "12 K dr USA"), tup.of(204, "Unj", "un@j.com", "41 U st CA"));
```

# Arrays
## map
Convenience functions to map one array to another without requiring expensive intermediate boxed objects.

Before:
```java
var input = {1, 2, 3};
var output = Arrays.stream(input)
    .map(String::valueOf)
    .toArray(String[]::new);
```

After:
```java
var input = List.of(1, 2, 3);
var output = arr.map(input, new String[input.length], String::valueOf);
```

The above avoids the intermediate Stream<Integer> object. Another use of this map function is to alter elements in place, which is otherwise only possible with an old fashioned for-loop. This can be done by offering the same array for both input and destination.

Before:
```java
var input = {1, 2, 3};
for (int inputIdx = 0; inputIdx < input.length; inputIdx++) {
    input[inputIdx] = input[inputIdx] * 2;
}
```

After:
```java
var input = {1, 2, 3};
arr.map(input, input, i -> i * 2);
```


# Lambdas
## uncheck   
Takes a Function/Consumer with a checked exception, and turns it unchecked, by wrapping the exception in a RuntimeException. This is useful for cases where you're happy having the program halt if the aforementioned exception is thrown, and don't want to deal with catching the exception or coloring your current method's signature with it. This comes especially in handy when dealing with lambdas, because using methods with checked exceptions is impossible and requires you to write out the try-catch block every time.

Before:
```java
List.of("String.class", "Integer.class", "MyBusiness.class").stream()
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

## recover   
Takes a Function/Consumer that throws a RuntimeException and suppresses it. In the case of a Consumer, it does nothing. In the case of a Function, it outputs the provided default value. This is convenient in cases where you want to process input, and ignore the errors.

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

# Collections
## fold     
Given a collection of `In`, a base object of `Out`, and a function `(Out, In) -> Out`, runs a fold operation to output the `Out` reduction. While this can be achieved using `.reduce` in the Stream API, that API requires the invoker to deal with the parallel case, meaning the user must pass in a function that defines how to combine one `Out` with another `Out` in the event that the reduction is taking place on a parallel stream. This library provides a simple linear version.    

Before:
```java
var input = List.of(5, 4, 3, 8, 7, 6, 1);
var output = 0;
for(int each : input) {
    output = output * 10 + each;
}
// output = 5_438_761
```

After:
```java
var input = List.of(5, 4, 3, 8, 7, 6, 1);
var output = col.fold(input, 0, (acc, each) -> acc + 10 + each);
// output = 5_438_761
```
