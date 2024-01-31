package bird;

public class Bird {

    private static String getRandomGender(int i) {
        String gender = null;
        if (i > 2) {
            gender = Math.random() < 0.5 ? "Male" : "Female";
        } else {
            if (i == 1) {
                gender = "Male"; // Assign Male gender for bird 1
            }
            if (i == 2) {
                gender = "Female"; // Assign Female gender for bird 2
            }
        }
        return gender;
    }
    
    // Method to create a new bird with specified name and gender
    private static Behavior[] newBird(String name, Behavior[] BIRDS, int in) {
        if (name != null) {
            int ages = 1;
            if (in == 1 || in == 2) {
                ages = 5;
            }
            BIRDS[in] = new Behavior(name, getRandomGender(in), ages);
            System.out.print(in + ". ");
            BIRDS[in].birdDetails();
        } else {
            System.out.println("Breeding was not successful. No new Behavior created.");
            in--;
        }
        System.out.println("Total bird " + in);
        seperator();
        return BIRDS;
    }

    private static void seperator() {
        System.out.println("=".repeat(80));
    }

    public static void main(String[] args) {
        String name;
        int index = 1;
        Behavior[] birds = new Behavior[11];
        seperator();
        //Starter parents bird
        newBird("Bear", birds, index++);
        newBird("Cow", birds, index++);
        newBird("Doggy", birds, index++);
        // BC: 1 is Male 2 is Female, breedable
        name = birds[1].breed(birds[2]);
        newBird(name, birds, index++);
        // bird 1: Test eating and pooping
        birds[1].eat("spaghetti", 20);
        birds[1].eat("pie", 50);
        birds[1].eject("spaghetti");
        seperator();
        // bird 2: Test eating until full
        birds[2].eat("steak", 30);
        birds[2].eat("chicken", 90);
        birds[2].eat("candy", 1);
        seperator();
        // bird 3: Test speaking
        birds[3].speak();
        birds[3].eat("sausage", 30);
        birds[3].speak("I like cheesecake.");
        birds[3].eat("apple", 20);
        birds[3].eject("sausage");
        seperator();
        //BD: if 3 is Female else empty
        name = birds[1].breed(birds[3]);
        newBird(name, birds, index++);
        //CB: 1 is Male 2 is Female breedable
        name = birds[2].breed(birds[1]);
        newBird(name, birds, index++);
        //CD: if 3 is Male breedable
        name = birds[2].breed(birds[3]);
        newBird(name, birds, index++);
        //Purple
        newBird("Purple",birds,index++);
        //PB: if Purple is Female
        name = birds[8].breed(birds[1]);
        newBird(name, birds, index++);
        //CP: if Purple is Male
        name = birds[2].breed(birds[8]);
        newBird(name, birds, index++);
        
        System.out.println("Every Bird details");
        for (int num = 1; num < 11; num++) {
            if (birds[num] != null) {
                System.out.print(num + ". ");
                birds[num].birdDetails();
            } else {
                System.out.println(num + ". " + "Empty");
            }
        }
    }
}
