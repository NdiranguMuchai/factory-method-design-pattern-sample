# Factory Design Pattern 

<img width="1042" alt="factory" src="https://github.com/NdiranguMuchai/factory-method-design-pattern-sample/assets/47880944/4dcd06f6-f5b1-4ff8-be92-a70e286ee36d">

Factory design is a pattern that falls under the `Creational Design Pattern`.
It is a popular pattern in Java and used not only in the JDK, but also across many open source projects such as `Spring`. 
The pattern is useful for creating objects in Java, providing better control over the object creation process as an alternative to constructors. 

##  Implementation

The underlying principle is to create objects without exposing the creation logic to the client,
rather defining a common interface to refer to the newly created objects.
The interface will now defer to more concrete subclasses which will decide which class to instantiate.
As is apparent, this pattern follows `encapsulation` principle of object-oriented programming.

### How this is achieved

1. Create an interface
2. Create concrete subclasses that will implement the interface
3. Create a factory to generate objects

## Code Sample

This is a simple project that creates `Persons` you would typically associate with in a football world.
Here is a breakdown of each step defined above:

### Interface

```
public interface Person {
    String getJob();
}
```
The interface class could also be created as an abstract class as well.

### Concrete Subclasses
```
public class Coach implements Person{
    @Override
    public String getJob() {
        return "Bark out instructions";
    }
}
```


```
public class Fan implements  Person {
    @Override
    public String getJob() {
        return "Cheer for team";
    }
}
```

Two more concrete classes; `Player` and `VAROfficial` are also included in the project


### Factory

```
public class PersonFactory {

    public static Person createPerson(String type){
        if (type.equalsIgnoreCase("coach")){
            return new Coach();
        } else if (type.equalsIgnoreCase("fan")) {
            return new Fan();
        } else if (type.equalsIgnoreCase("player")) {
            return new Player();
        } else if (type.equalsIgnoreCase("var")) {
            return new VAROfficial();
        }

        throw new IllegalArgumentException("No such person.");
    }
}

```

### Testing it out
We can test this out in a "client" class which will mimic the client's operations.

```
 public static void main(String[] args) {
        String type = "var";

        Person official = PersonFactory.createPerson(type);

        System.out.println(official.getJob());
    }
```

The client need only pass a String and the factory class will delegate to its concrete subclasses which will now
create and object of type `VAROfficial.java`

## Advantages of this approach
* It promotes loose-coupling by removing the need to bind application-specific classes into the code.
* It encourages consistency of code
* Subclasses are responsible for choosing which objects to create.


## So when is it best to use the Factory Design Pattern?
* A class wants its subclasses to specify the objects to be creates.
* Some or all of the objects can be created in multiple ways, or we want to leave open the option that in the future there may be new ways to create the concrete product.
* We have to create an object of any one of the subclasses depending on the data provided.