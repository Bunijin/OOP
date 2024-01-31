package Hourglasses;

public class Function {
    // Initial sand amounts
    int sandA = 5000;
    int sandB = 0;
    int degrees = 1;

    // Rotate the hourglass 90 degrees to the right
    void rotate90Right() {
        degrees++;
        checkDegrees();
        sandFlow();
    }
    
    // Rotate the hourglass 180 degrees to the right
    void rotate180Right() {
        degrees += 2;
        checkDegrees();
        sandFlow();
    }
    
    // Check and adjust degrees to be within the valid range [1, 4]
    int checkDegrees() {
        if (degrees > 4) {
            degrees -= 4;
        }
        return degrees;
    }
    
    // Display the current sand state in both A and B
    void currentSandState() {
        System.out.println("[A] = " + sandA + " [B] = " + sandB);
    }

    // Simulate sand flow based on the current orientation of the hourglass
    void sandFlow() {
        switch (degrees) {
            case 1 -> {
                if (sandA != 0) {
                    // Sand transfer from A to B
                    int transferRate = 1000;
                    int transferTime = sandA / transferRate;

                    System.out.println("This hourglass is on [Side" + degrees + "] now. Start transferring sand from A to B.");
                    System.out.println("The sand transfer rate is " + transferRate + " sands/second\n    A : " + sandA + " B : " + sandB);

                    for (int t = 0; t < transferTime; t++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        sandA -= transferRate;
                        sandB += transferRate;
                        if (sandA == 0) {
                            System.out.println("    A : " + sandA + "    B : " + sandB);
                        } else {
                            System.out.println("    A : " + sandA + " B : " + sandB);
                        }
                    }
                } else {
                    System.out.println("This hourglass is on [Side" + degrees + "] now. But there's no sand in B.");
                }
            }
            case 2 -> {
                System.out.println("This hourglass is on [Side" + degrees + "]. No sand is transferring.");
            }
            case 3 -> {
                if (sandB != 0) {
                    // Sand transfer from B to A
                    int transferRate = 1000;
                    int transferTime = sandB / transferRate;

                    System.out.println("This hourglass is on [Side" + degrees + "] now. Start transferring sand from A to B.");
                    System.out.println("The sand transfer rate is " + transferRate + " sands/second\n    A : " + sandA + "    B : " + sandB);

                    for (int t = 0; t < transferTime; t++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        sandA += transferRate;
                        sandB -= transferRate;
                        System.out.println("    A : " + sandA + " B : " + sandB);
                    }
                } else {
                    System.out.println("This hourglass is on [Side" + degrees + "] now. But there's no sand in A.");
                }
            }
            case 4 -> {
                System.out.println("This hourglass is on [Side" + degrees + "]. No sand is transferring.");
            }
            default -> {
                System.out.println("ERROR");
            }
        }
    }

}