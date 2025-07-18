public class BlueAstronaut extends Player implements Crewmate {
    
    private int numTasks;
    private int taskSpeed;

    private static final int DEFAULT_SUS_LEVEL = 15;
    private final int DEFAULT_TASKS = 6;
    private final int DEFAULT_SPEED = 10;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        if(taskSpeed > 0) this.taskSpeed = taskSpeed;
        else this.taskSpeed = DEFAULT_SPEED;
    }

    public BlueAstronaut(String name) {
        super(name, DEFAULT_SUS_LEVEL);
        this.numTasks = DEFAULT_TASKS;
        this.taskSpeed = DEFAULT_SPEED;
    }

    @Override
    public void emergencyMeeting() {
        if(this.isFrozen()) return; // if player is frozen already, invalid emergency meeting

        int maxSus = -1;
        int susIndex = -1;
        Player[] arr = Player.getPlayers();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].isFrozen() || arr[i].equals(this)) continue;
            if(arr[i].getSusLevel() == maxSus) return; // exit condition where two players have same sus level
            if(arr[i].getSusLevel() > maxSus) {
                maxSus = arr[i].getSusLevel();
                susIndex = i;
            }
        }

        arr[susIndex].setFrozen(true);
        this.gameOver();
    }

    @Override
    public void completeTask() {
        if(this.isFrozen() || this.numTasks == 0) return;
        if(this.taskSpeed > 20) {
            this.numTasks -= 2;
            if(this.numTasks < 0) this.numTasks = 0;
        }
        else this.numTasks--;
        if(this.numTasks == 0) {
            System.out.println("I have completed all my tasks");
            this.setSusLevel((int)(0.5*this.getSusLevel()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof BlueAstronaut)) return false; // if o isn't a blue astronaut we already know they aren't the same
        BlueAstronaut copy = (BlueAstronaut) o;
        if(copy.getName().equals(this.getName()) && copy.isFrozen() == this.isFrozen() && copy.getSusLevel() == this.getSusLevel() && copy.numTasks == this.numTasks && copy.taskSpeed == this.taskSpeed)
            return true;
        return false;
    }

    @Override
    public String toString() {
        String out = String.format("My name is %s, and I have a suslevel of %d. I am currently %s. I have %d left over.", this.getName(), this.getSusLevel(), this.isFrozen() ? "frozen" : "not frozen", this.numTasks);
        if(this.getSusLevel() > 15) return out.toUpperCase();
        return out;
    }

}
