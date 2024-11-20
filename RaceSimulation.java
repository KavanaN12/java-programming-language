class Car {
    String make;
    String model;
    int topSpeed;
    int handling;
    double acceleration;

    public Car(String make, String model, int topSpeed, int handling, double acceleration) {
        this.make = make;
        this.model = model;
        this.topSpeed = topSpeed;
        this.handling = handling;
        this.acceleration = acceleration;
    }

    public double calculateLapTime(double trackLength) {
        return (trackLength / (topSpeed * handling * 0.1));
    }

    public void raceAgainst(Car opponent, double trackLength) {
        if (10 * (opponent.calculateLapTime(trackLength) - calculateLapTime(trackLength)) < 0.0) {
            System.out.println("You Won with a difference of "
                    + 10 * (calculateLapTime(trackLength) - opponent.calculateLapTime(trackLength)) + " secs");
        } else if (10 * (opponent.calculateLapTime(trackLength) - calculateLapTime(trackLength)) > 0.0) {
            System.out.println("You lost by just "
                    + 10 * (-(calculateLapTime(trackLength) - opponent.calculateLapTime(trackLength))) + " secs");
        } else {
            System.out.println("Wonderrrr! Its a draw");
        }
    }
}

public class RaceSimulation {
    public static void main(String[] args) {
        Car c1 = new Car("Toyato", "5S70", 510, 8, 30);
        Car c2 = new Car("BMW", "MH90", 380, 9, 33);
        c1.raceAgainst(c2, 100);
    }
}
