public class Fly {

    private double mass;
    private double speed;

    public static final double DEFAULT_MASS = 5;
    public static final double DEFAULT_SPEED = 10;

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    public double getMass() {
        return this.mass;
    }

    public void setMass(double newMass) {
        if(newMass >= 0) {
            this.mass = newMass;
        }
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double newSpeed) {
        if(newSpeed >= 0) {
            this.speed = newSpeed;
        }
    }

    public String toString() {
        if(this.mass == 0) {
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", this.speed);
        }
        return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
    }

    public void grow(int gain) {
        while(gain > 0) {
            if(this.mass < 20) {
                this.mass++;
                this.speed++;
                gain--;
            }
            else {
                this.mass++;
                this.speed -= 0.5;
                gain--;
            }
        }
    }

    public boolean isDead() {
        if(this.mass == 0) {
            return true;
        }
        return false;
    }

}