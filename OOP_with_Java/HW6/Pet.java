public abstract class Pet {

    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        if(health >= 1.0) {
            this.health = 1.0;
        }
        else if(health <= 0) {
            this.health = 0.0;
        }
        else {
            this.health = health;
        }
        if(painLevel >= 10) {
            this.painLevel = 10;
        }
        else if(painLevel < 0) {
            this.painLevel = 0;
        }
        else {
            this.painLevel = painLevel;
        }
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getPainLevel() {
        return painLevel;
    }

    abstract int treat();

    public void speak() {
        String message = "Hello! My name is " + name;
        if(painLevel > 5) {
            message = message.toUpperCase();
        }
        System.out.println(message);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Pet) || o == null) return false;
        if(name.equals(((Pet)o).getName())) {
            return true;
        }
        return false;
    }

    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }

}