public class Dog extends Pet {
    
    private double droolRate;

    private static final double DEFAULT_DROOL_RATE = 5.0;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if(droolRate <= 0) droolRate = 0.5;
        this.droolRate = droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_DROOL_RATE);
    }

    public double getDroolRate() {
        return droolRate;
    }

    @Override
    public int treat() {
        int time;
        if(droolRate < 3.5) {
            time = (int) Math.ceil((2*this.getPainLevel())/this.getHealth());
        }
        else if(droolRate > 7.5) {
            time = (int) Math.ceil(this.getPainLevel()/(2*this.getHealth()));
        }
        else time = (int) Math.ceil(this.getPainLevel()/this.getHealth());
        heal();
        return time;
    }

    @Override
    public void speak() {
        super.speak();
        String message = (this.getPainLevel() > 5) ? "BARK" : "bark";
        int i  = this.getPainLevel();
        while(i > 0) {
            System.out.print(message);
            if(i > 1) {
                System.out.print(" ");
            }
            i--;
        }
        System.out.print("\n");
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Dog) || o == null) return false;
        return super.equals(o) && (droolRate == ((Dog)o).getDroolRate()); 
    }

}