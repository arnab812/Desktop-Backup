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

void swim() {
        // decide based on the species: 
        if(species == "Tuna" || species == "Shark")
            print("Can swim..");
        else if(species == "Pigeon" || species == "Tiger")
            print("The selected species can't swim at all !!")
    }

void swim() {
        // decide based on the species : 

        String prompt =  "Can swim fast..";

        if(species == "Tuna" || species == "Shark")
            print("Can swim.." + species + " " + prompt);
            
        else if(species == "Pigeon" || species == "Tiger")
            print("The selected species can't swim at all !!")
        else if(species == "Frog") 
	    print("I'm an amphibian, so I kinda swim !!");

        // --- --- --- --- 

        if(species.beginsWith("T")) {
            ... 
        }
    }

void swim() {
        // decide based on the species : 
        if(species == "Tuna" || species == "Shark")
            print("Can swim..");
        else if(species == "Pigeon" || species == "Tiger")
            print("The selected species can't swim at all !!")
	else if(species == "Frog") 
	    print("I'm an amphibian, so I kinda swim !!");
    }



