void swim() {
        // decide based on the species : 

        String prompt =  "Can swim fast..";
        String alertMessage = "Can attack humans!!";

        if(species == "Tuna" || species == "Shark")
            print("Can swim.." + species + " " + prompt + alertMessage);

        else if(species == "Pigeon" || species == "Tiger")
            print("The selected species can't swim at all !!")
        else if(species == "Frog") 
	    print("I'm an amphibian, so I kinda swim !!");

        // --- --- --- --- 

        if(species.beginsWith("T")) {
            ... 
        }
    }