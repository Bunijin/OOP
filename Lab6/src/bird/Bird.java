package bird;

public class Bird {

    private static String getRandomGender(int i) {
        String A = null;
        if (i > 2) {
            A = Math.random() < 0.5 ? "M" : "F";
        } else {
            if (i == 1) {
                A = "M";
            }
            if (i == 2) {
                A = "F";
            }
        }
        return A;
    }

    private static Behavior[] newBird(String name, Behavior[] B, int i) {
        if (name != null) {
            B[i] = new Behavior(name, getRandomGender(i), 1);
            System.out.print(i + ". ");
            B[i].details();
        } else {
            System.out.println("Breeding was not successful. No new Behavior created.");
            i--;
        }
        System.out.println("Total bird " + i);
        text();
        return B;
    }

    private static void text() {
        System.out.println("=".repeat(80));
    }

    public static void main(String[] args) {
        String name;
        int i = 1;
        Behavior[] b = new Behavior[11];
        text();
        //Starter parents bird
        newBird("Cow", b, i++);
        newBird("Bear", b, i++);
        newBird("Doggy", b, i++);
        //New bird
        name = b[1].breed(b[2]);
        newBird(name, b, i++);
        //bird 1. test eating and pooping
        b[1].eat("spaghetti", 20);
        b[1].eat("pie", 50);
        b[1].eject("spaghetti");
        text();
        //bird 2. test eating until full
        b[2].eat("steak", 30);
        b[2].eat("chicken", 90);
        b[2].eat("candy", 1);
        text();
        //bird 2. test speaking
        b[3].speak();
        b[3].eat("sausage", 30);
        b[3].speak("I like cheesecake.");
        b[3].eat("apple", 20);
        b[3].eject("sausage");
        text();
        name = b[1].breed(b[3]);
        newBird(name, b, i++);
        name = b[2].breed(b[1]);
        newBird(name, b, i++);
        name = b[2].breed(b[3]);
        newBird(name, b, i++);
        //newBird name
        newBird("Purple",b,i++);
        name = b[8].breed(b[3]);
        newBird(name, b, i++);
        name = b[3].breed(b[8]);
        newBird(name, b, i++);
        System.out.println("Every Bird details");
        for (int num = 1; num < 11; num++) {
            if (b[num] != null) {
                System.out.print(num + ". ");
                b[num].details();
            } else {
                System.out.println(num + ". " + "Empty");
            }
        }
    }
}
