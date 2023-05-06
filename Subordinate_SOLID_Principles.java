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

    void swim() {...}

    void fly() {...}

    void breatheUnderWater() {...}

    void breatheOnLand() {...}

}

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

