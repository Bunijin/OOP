package glass;

public class Glass {
    
    public int capacity;
    private int volume;
    
    public Glass() {
        capacity = 1000;
        volume = 0;
    }
    
    int maxWater() {
        return capacity;
    }
    int currentWater() {
        return volume;
    }

    void checkWater() {
        if (volume > capacity) {
            volume = capacity;
        }
        if (volume < 0) {
            volume = 0;
        }
    }

    void fillWater() {
        volume = capacity;
    }

    void pourWater() {
        volume = 0;
    }

    void fillWater(int volume) {
        this.volume += volume;
        checkWater();
    }
   
    void pourWater(int volume) {
        this.volume -= volume;
        checkWater();
    }
    
    void pourWaterTo(Glass temp) {
        if (this.volume == 0) {
            System.out.println("There is no water in this glass.");
            return;
        }
        int volume = currentWater();
        pourWater();
        temp.fillWater(volume);
        System.out.println("Successfully transferred the water.");
    }

    void pourWaterTo(Glass temp, int volume) {
        if (this.volume == 0) {
            System.out.println("There is no water in this glass.");
        } else if (volume > this.volume) {
            System.out.println("Not enough water in this glass to transfer " + volume + "ml but managed to transfer " + this.volume + "ml");
            temp.fillWater(this.volume);
            pourWater();
            return;
        }
        this.volume -= volume;
        temp.fillWater(volume);
        System.out.println("Successfully transferred the water.");
    }
}
