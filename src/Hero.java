public class Hero {

    private int hitPoints;
    private final String name;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent) {
        double rand = Math.random();
        if (rand<0.5) opponent.hitPoints -= 10;
        else hitPoints-=10;
    }

    public void senzuBean() {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (opponent.getHitPoints()>0 && hitPoints>0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints();
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int hero = 0, opp = 0;
        for (int i = 0; i<n; i++) {
            senzuBean();
            opponent.senzuBean();
            fightUntilTheDeathHelper(opponent);
            if(hitPoints>0) hero++;
            else if(opponent.getHitPoints()>0) opp++;
        }
        return new int[]{hero,opp};
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] wins = nFightsToTheDeathHelper(opponent, n);
        String winner;
        if (wins[0]>wins[1]) { //Hero wins
            winner = name + " wins!";
        }
        else if (wins[1]>wins[0]) { //Opponent wins
            winner = opponent.getName() + " wins!";
        }
        else winner = "OMG! It was actually a draw!"; //Draw
        return name + ": " + wins[0] + " wins\n" + opponent.getName() + ": " + wins[1] + " wins\n" + winner;
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        while (opponent.getHitPoints()>0 && hitPoints>0) {
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "\t" + opponent.getName() + ": " +opponent.getHitPoints());
        }
        if(hitPoints>0) System.out.println(name + " wins!");
        else System.out.println(opponent.getName() + " wins!");
    }

}
