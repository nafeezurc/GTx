public class Cat extends Pet {

    private int miceCaught;

    private static final int DEFAULT_MICE_CAUGHT = 0;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = miceCaught;
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_MICE_CAUGHT);
    }

    public int getMiceCaught() {
        return miceCaught;
    }

    @Override
    public int treat() {
        int time;
        if(miceCaught < 4) {
            time = (int) Math.ceil((2*this.getPainLevel())/this.getHealth());
        }
        else if(miceCaught > 7) {
            time = (int) Math.ceil(this.getPainLevel()/(2*this.getHealth()));
        }
        else time = (int) Math.ceil(this.getPainLevel()/this.getHealth());
        heal();
        return time;
    }

    @Override
    public void speak() {
        super.speak();
        String message = (this.getPainLevel() > 5) ? "MEOW" : "meow";
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
        if(!(o instanceof Cat) || o == null) return false;
        return super.equals(o) && (miceCaught == ((Cat)o).getMiceCaught()); 
    }

}