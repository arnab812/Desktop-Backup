class Animal {
    
    // attributes [properties]

    String species; 
    double weight;
    String colour;
    int numberOfLegs;
    boolean hasWings;
    boolean hasFins;

    // behaviour [methods]

    void eat() {...}

    // void swim() {...}

    void swim() {
        // decide based on the species : 

        String prompt =  

        if(species == "Tuna" || species == "Shark")
            print("Can swim..");
        else if(species == "Pigeon" || species == "Tiger")
            print("The selected species can't swim at all !!")
        else if(species == "Frog") 
	    print("I'm an amphibian, so I kinda swim !!");

        // --- --- --- --- 

        if(species.beginsWith("T")) {
            ... 
        }
    }

    void fly() {...}

    void breatheUnderWater() {...}

    void breatheOnLand() {...}

    // ------------------------------------------------------------------------------- //

    // => Testing : 

    boolean testTunaSwimming() {
        // create an Animal [object] with species == "Tuna"
        // after that, call the swim() method on that object 
    }

    boolean testTigerSwimming() {
        // create an Animal [object] with species == "Tiger"
        // after that, call the swim() method on that object
    }

    boolean testPigeonSwimming() {
        // create an Animal [object] with species == "Tiger"
        // after that, call the swim() method on that object
    }

}

/*
    For interface members (fields and methods), the default access is public.
    But note that the interface declaration itself defaults to package private.
*/

// Solution to maintain the code using 'Single Responsibility Principle' ->   

class Tuna extends Animal {
    @override 
    void swim() {
        print("Swim fishy swim but do not attack humans !!");
    }
}

class Shark extends Animal {
    @override 
    void swim() {
        print("....");
    }
}

/* --------------------------------------------------------------------------------------- */
/* -------------------------------------- End of part-1 ---------------------------------- */
/* --------------------------------------------------------------------------------------- */

// Create a class for "Bird" that is also an Animal :- 
class Bird extends Animal {
    
    // inherits the string 'species' from the 'Animal' class

    void fly() {...}

}

// Configure the 'Bird' class for all the different bird species available in the zoo. 
class Bird extends Animal {
    // same if-else ladder to decide how the bird flies -> 
    if(species == "Sparrow")
        print("Fly low");
    else if(species == "Eagle") 
        print("Glide elegantly");
    else if(species == "Albatros") 
        print("Fly with Physics hack !!"); 
}

// Library : 
[library] Zoo
    class Bird extends Animal {
    // same if-else ladder to decide how the bird flies -> 
    if(species == "Sparrow")
        print("Fly low");
    else if(species == "Eagle") 
        print("Glide elegantly");
    else if(species == "Albatros") 
        print("Fly with Physics hack !!"); 
    }

/* ----------------------------------------Part : 2--------------------------------------------- */

// Executable client code : 
[executable] Client {

    // import library - 
    import Zoo.Bird;

    class Main() {
        void func {
            Bird parrot = new Bird();
            parrot.fly();

            // Can the client add a new species? 
            // Ans. No, because the code that the client is getting by importing the library
            // is not their code. Therefore, they don't have any access on that particular code base.  
        }

    }
}

// Instead of having the above code pattern (Library + Client) :

// Library : 
[library] Open_Close_Principle_Zoo
class Sparrow extends Bird {
    @override
    void fly() {
        print("I love to fly around..");
    }
}

// Client code : 
[executable] Client {
    import Open_Close_Principle_Zoo;

    class main() {
        void main {
            class Peacock extends Bird {
                @override 
                void fly() {
                    print("Pe-hens (female) can fly, but males can not !!");
                }
            }
        }
    }
}

/* ------------------------------------------------------------------------------------- */

abstract class Bird extends Animal {
    abstract void fly() {...}
}

class Kiwi extends Bird {
    @override
    // As the 'Kiwi' is not able to fly, what will happen if we just don't implement the 'fly' method
    // in the class? 
    /* 
        1. What if we just don't implement the fly() method? 
      Ans. This is not allowed. The compiler will complain.
           By saying, this class/method is 'abstract', you're telling the compiler that I don't know how this 
           really works! Whoever(whiche ever bird) is going to extend this, they must supply the 'fly' method.
           If they don't supply the fly() method, then - they themselves are incomplete. 
           
        => The complier will say - either the class 'Kiwi' must implement the abstract method 'fly' or 
           class 'Kiwi' must be marked abstract itself! 

        2. Throw an exception if the fly() method is just called inside the 'Kiwi' class?
        => Violates expectations! "Code with hidden surprises. Code with hidden landmines!!"
    */

    // 2. Throw an exception : 
        void fly() {
            throw new nonFlyingBirdException(String species) {
                (species + " don't fly");
            }
        }

        // consider a specific scenario : 
        [executable] Client {
            class Main() {
                void main() {
                    Bird bird;
                    bird = getBirdFromUserChoice(); // might be any 'Bird' subclass
                    bird.fly();
                }
            }
        }

        // How should we redesign the above scenario to follow the LSP? 
        
/* ------------------------------------------------------------------------------------------------------- */

// => Liskov principle : 

    abstract class Bird extends Animal {
        String Species

        // Bird attributes - 
        int numberOfWings;
        boolean hasBeak; 

        // Bird behaviours - 
        void speak;

        // no fly() method is here, because we know that 'all birds can't fly'

    }

    // segregate the behaviours (functionalities) using interface 
    interface ICanFly {
        void fly();
    }

    class Eagle extends Bird implements ICanFly {
        @Override 
        void fly() {
            print("Glide elegantly");
        }
    }

    class Kiwi extends Bird {
        // We don't have to provide the fly() method by implementing the 'ICanFly' interface , because 'Kiwi' can't fly
    }

// In Java, an interface specifies the behavior of a class by providing an abstract type. As one of Java's core concepts,
// abstraction, polymorphism, and multiple inheritance are supported through this technology. Interfaces are used in Java to achieve abstraction. 
    
    /*
      To start flight the bird will -> 
        - flap it's wings 
        - kick off the ground to take off 
    */ 

    // Should these additional methods be part of the ICanFly interface ?
        interface I_CanFly {
        
            void fly();

            void flapWings();

            void kickToTakeOff();
    }

    class Eagle extends Bird implements I_CanFly {
        // override all these methods
    }

    /* ----------------------------------------- End of Part 3 ---------------------------------------------- */

    // -> Now, just assume what the other things that can fly to understand the Interface Segregation Principle properly : 

    // ***** Interface Segregation Principle : 
        /* 
        - Keep your interfaces minimal 
        - No code should be forced to implement a method that it does not read
        */ 

    // => Design a cage : 
    interface IBowl {...}
    class MeatBowl implements IBowl {...}
    class FruitBowl implements IBowl {...}

    interface IDoor {...}
    class IronDoor implements IDoor {...}
    class WoodenDoor implements IDoor {...}

    // for Tigers -> '
    class Cage1 {
        MeatBowl bowl;
        WoodenDoor door;

        List<Tiger> tigers;
        
        public Cage1 {
            // add 5 tigers inside : 
            for(int i = 0; i < 5; i++)
                tigers.add(new Tiger(...));
        }
    }

    class Cage2 {
        FruitBowl bowl;
        WoodenDoor door;

        List<Sparrow> sparrows; 

        public Cage2 () {...}
    }

    // Instead of using the below code : 
    interface IBowl;
    class MeatBowl implements IBowl {...}
    class FruitBowl implements IBowl {...}

    interface Door{...}
    class IronDoor implements Door{...}
    class WoodenDoor implements Door{...}

    // implement this : 
    class Cage {
        IBowl bowl;
        IDoor door;

        List<Animal> animals;

        // constructor : 
        public Cage(IBowl bowl, IDoor door, List<Animal> habitants) {
            this.bowl = bowl;
            this.door = door;
            this.animals.addAll(habitats);
        }
    }

    // Advantage of the above code : assume that the below code is an executable client code
    //  where we're implementing this cages for different species using Dependency Inversion : 
    class Main {
        void main() {
            // creating a cage for tigers : 
            Cage cage1 = new Cage (new MeatBowl(),
                                   new Irondoor(),
                                   Arrays.toList(new Tiger(T1),(T2)))
        }

        // in the same manner - create a cage for sparrows : 
           Cage cage2 = new Cage (new FruitBowl(),
                                  new Woodendoor(),
                                  Arrays.toList(new Sparrow(SP1),(SP2)))
        }  
    }
    