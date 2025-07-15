public class Frog {
    
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species;

    public static final String DEFAULT_SPECIES = "Rare Pepe";

    public static final int DEFAULT_AGE = 5;
    public static final double DEFAULT_TONGUE_SPEED = 5;

    public static final int DEFAULT_GROWTH = 1;

    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.isFroglet = (this.age > 1 && this.age < 7) ? true : false;
        this.species = DEFAULT_SPECIES;
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int) (ageInYears * 12), tongueSpeed);
    }

    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
    }

    public void grow(int months) {
        while(months > 0) {
            if(this.age < 12) {
                this.age++;
                this.tongueSpeed++;
                this.isFroglet = (this.age > 1 && this.age < 7) ? true : false;
                months--;
            }
            else if(this.age >= 30) {
                this.age++;
                if(this.tongueSpeed > 5) {
                    this.tongueSpeed--;
                }
                months--;
            }
            else {
                this.age++;
                months--;
            }
        }
    }

    public void grow() {
        this.grow(DEFAULT_GROWTH);
    }

    public void eat(Fly fly) {
        if(fly.isDead()) {
            return;
        }
        if(this.tongueSpeed > fly.getSpeed()) {
            if(0.5 * fly.getMass() >= this.age) {
                this.grow();
            }
            fly.setMass(0);
        }
        else {
            fly.grow(1);
        }
    }

    public static String getSpecies() {
        return species;
    }

    public static void setSpecies(String newSpecies) {
        if(newSpecies != null) {
            species = newSpecies;
        }
    }

    public String toString() {
        if(this.isFroglet == true) {
            return "My name is " + this.name + " and I’m a rare froglet! I’m " + this.age + " months old and my tongue has a speed of" + this.tongueSpeed + ".";
        }
        else {
            return "My name is " + this.name + " and I’m a rare frog. I’m " + this.age + " months old and my tongue has a speed of" + this.tongueSpeed + ".";
        }
    }

}