public class RedAstronaut extends Player implements Imposter {
    
    private String skill;

    private static final int DEFAULT_SUS_LEVEL = 15;
    private final String DEFAULT_SKILL_LEVEL = "experienced";

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String name) {
        super(name, DEFAULT_SUS_LEVEL);
        this.skill = DEFAULT_SKILL_LEVEL;
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
    public void freeze(Player p) {
        if(p instanceof Imposter || p.isFrozen() || this.isFrozen()) return; // don't execute if either is frozen already or target is an imposter
        if(this.getSusLevel() < p.getSusLevel()) p.setFrozen(true);
        else this.setSusLevel(2*this.getSusLevel());
        this.gameOver();
    }

    @Override
    public void sabotage(Player p) {
        if(p instanceof Imposter || p.isFrozen() || this.isFrozen()) return; // don't execute if either is frozen already or target is an imposter
        if(this.getSusLevel() < 20) p.setSusLevel((int)(1.5 * p.getSusLevel()));
        else p.setSusLevel((int)(1.25 * p.getSusLevel()));
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof RedAstronaut)) return false; // if o isn't a red astronaut we already know they aren't the same
        RedAstronaut copy = (RedAstronaut) o;
        if(copy.getName().equals(this.getName()) && copy.isFrozen() == this.isFrozen() && copy.getSusLevel() == this.getSusLevel() && copy.skill.equals(this.skill))
            return true;
        return false;
    }

    @Override
    public String toString() {
        String out = String.format("My name is %s, and I have a suslevel of %d. I am currently %s. I am an %s player!", this.getName(), this.getSusLevel(), this.isFrozen() ? "frozen":"not frozen", this.skill);
        if(this.getSusLevel() > 15) return out.toUpperCase();
        return out;
    }

}
