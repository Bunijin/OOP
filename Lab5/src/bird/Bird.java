package bird;

public class Bird {
    
    public static void seperator() {
        System.out.println("=".repeat(80));
    }
    
    public static void main(String[] args) {
        int i = 0;
        Behavior[] birds = new Behavior[11];
        seperator();
        birds[i++] = new Behavior("Chicken","Male");    //Chicken
        birds[i++] = new Behavior("Bear","Female",3);   //Bear
        birds[i++] = birds[0].breed(birds[1]);          //CB
        seperator();
        // bird 1: Test eating and pooping
        birds[0].eat("spaghetti", 20);
        birds[0].eat("pie", 50);
        birds[0].eject("spaghetti");
        seperator();
        // bird 2: Test eating until full
        birds[1].eat("steak", 30);
        birds[1].eat("chicken", 90);
        birds[1].eat("candy", 1);
        seperator();
        // bird 3: Test speaking
        birds[2].speak();
        birds[2].eat("sausage", 30);
        birds[2].speak("I like cheesecake.");
        birds[2].eat("apple", 20);
        birds[2].eject("sausage");
        seperator();
        birds[i++] = birds[0].breed(birds[2]);  //CC if [2] is Female
        birds[i++] = birds[1].breed(birds[0]);  //BC
        birds[i++] = new Behavior("Purple",7);  //Purple
        birds[i++] = birds[5].breed(birds[0]);  //PC if Purple is Female
        birds[i++] = birds[1].breed(birds[5]);  //BP if Purple is Male
        System.out.println("Every Bird details");
        for (int num = 0; num < i; num++) {
            if (birds[num] != null) {
                System.out.println(num + ". " + birds[num].birdDetails());
            } else {
                System.out.println(num + ". " + "Empty");
            }
        }
    }
}
