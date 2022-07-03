package vscode_projectrpg;

public class Player extends Character {

    // int to store number of upgrades/skill in each path
    public int numAtkUpgrades, numDefUpgrades;

    //additional player stats
    int gold, restsLeft, pots;

    // integer to store skill names
    public String[] atkUpgrades = { "Strength", "Power", "Might", "Godlike Strength" };
    public String[] defUpgrades = { "Heavy bones", "Stoneskin", "Scale armor", "Holy Aura" };

    // Player specific constructor
    public Player(String name) {
        // Calling constructor superclass
        super(name, 100, 0);
        // Settings of upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        //set additional stats
        this.gold=5;
        this.restsLeft=1 ;
        this.pots=0;
        // let the player choose a trait when creating a new charater
        chooseTrait();
    }

    // Player specific methods
    @Override
    public int attack() {
        return  (int) (Math.random()* (xp/4 + numAtkUpgrades *3 +3 )+ xp/10 + numAtkUpgrades *2 +numDefUpgrades+1);
    }

    @Override
    public int defend() {
        return (int) (Math.random()* (xp/4 +numDefUpgrades*3 +3)+ xp/10 +numDefUpgrades*2+ numAtkUpgrades+1);
    }

    // let the player choose a trait of either skill path
    public void chooseTrait() {
        Gamelogic.clearConsole();
        Gamelogic.printHeading("Choose a trait");
        System.out.println(" (1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println(" (2) " + defUpgrades[numDefUpgrades]);
        // get the player choice
        int input = Gamelogic.readInt("-> ", 2);
        Gamelogic.clearConsole();
        // deal with both cases
        if (input == 1) {
            Gamelogic.printHeading("You choose " + atkUpgrades[numAtkUpgrades] + " ! ");
            numAtkUpgrades++;
        } else {
            Gamelogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + " ! ");
        }
        Gamelogic.anythingToContinue();

    }

}
