package vscode_projectrpg;

import java.util.Scanner;

public class Gamelogic {

    static Scanner scanner = new Scanner(System.in);
    static Player player;

    public static boolean isRunning;

    // random ecounters
    public static String[] encounters = { "Battle", "Battle", "Battle", "Reste", "Reste" };

    // enemy names
    public static String[] ennemies = { "Ogre", "Ogre", "Gobelin", "Gobelin", "Stone Elemental" };
    // Story elements
    public static int place = 0, act = 1;
    public static String[] places = { "Everlasting mountains", "lmkml", "ohiho", "Throne Room" };

    // Method tu get user input from console
    public static int readInt(String prompt, int userChoice) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());

            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an int !");
            }
        } while (input < 1 || input > userChoice);
        return input;
    }

    // method to simulate clearing out the console
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    // methode to print a separator whit length n
    public static void printSeperator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("-");
        }
    }

    // Method to print header
    public static void printHeading(String title) {
        printSeperator(1);
        System.out.println(title);
        printSeperator(1);
    }

    // Method to stop the game until users enters anything
    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

    // Method to start the game
    public static void startGame() {
        boolean nameSet = false;
        ;
        String name;
        // print title
        clearConsole();
        printSeperator(1);
        printSeperator(1);
        System.out.println("AGE of Empires");
        printSeperator(1);
        printSeperator(1);
        anythingToContinue();

        // getting the player name
        do {
            clearConsole();
            printHeading("What's your name ?");
            name = scanner.next();
            // asking the player if he wants to correct his choice
            clearConsole();
            System.out.println("Your name is " + name + ".\nIs that correct ?");
            System.out.println("(1) Yes");
            System.out.println("(2) No, i want to change this");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }

        } while (!nameSet);
        // print story intro
        Story.printIntro();

        // create new player whith the name
        player = new Player(name);

        // Print first story act intro
        Story.printFirstActionIntro();

        // setting isRunning to true, so the game loop can continue
        isRunning = true;

        // start main game loop
        gameLoop();
    }

    // method that changes the game's values based on player xp
    public static void checkAct() {
        // change acts based on xp
        if (player.xp >= 10 && act == 1) {
            // increment act and place
            act = 2;
            place = 1;
            // story
            Story.printFirstActionOutro();
            // let the player level up
            player.chooseTrait();
            // Story
            Story.printSecondActIntro();
            ennemies[0] = "Evil Mercenary";
            ennemies[1] = "Evil Mercenary";
            ennemies[2] = "Evil Mercenary Pack";
            ennemies[3] = "Henchmen Evil Emperor";
            ennemies[4] = "Henchmen Evil Emperor Stranger";
            // assign new
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Shop";

        } else if (player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            Story.printSecondActOutro();
            player.chooseTrait();
            Story.printThirdActIntro();
            ennemies[0] = "Evil Mercenary";
            ennemies[1] = "goblin";
            ennemies[2] = "Holve Pack";
            ennemies[3] = "Henchmen Evil Emperor";
            ennemies[4] = "Scary Stranger";
            // assign new
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
            // Fully heal the player
            player.hp = player.maxHp;
        } else if (player.xp >= 100 && act == 3) {
            act = 4;
            place = 3;
            Story.printThirdActOutro();
            player.chooseTrait();
            Story.printFourActionIntro();
            player.hp = player.maxHp;
            finalBattle();
        }
    }

    // Method to calculate a random encounter
    public static void randomEncounter() {
        int encounter = (int) (Math.random() * encounters.length);
        // Calling methods
        if (encounters[encounter].equals("Battle")) {
            randomBattle();
        } else if (encounters[encounter].equals("Rest")) {
            takeRest();
        } else {
            shop();
        }
    }

    // method to continue the journey (more next part)
    public static void continueJourney() {
        // check if act must be increased
        checkAct();
        // check if game isn't in last act
        if (act != 4) {
            randomEncounter();
        }

    }

    public static void characterInfo() {
        clearConsole();
        printHeading("Charater infos");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        System.out.println("XP: " + player.xp);
        printSeperator(1);
        // player xp and gold
        System.out.println("XP! " + player.xp + "\tGold: " + player.gold);
        printSeperator(1);
        // # of pots
        System.out.println("# of Potions: " + player.pots);
        printSeperator(1);

        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);

        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);

        }
        anythingToContinue();
    }

    // shopping/encountering a travelling trader
    public static void shop() {
        clearConsole();
        printHeading("You meet a mysterious stranger. \nHe offers you something.");
        int price = (int) (Math.random() * (10 + player.pots * 3) + 10 + player.pots);
        System.out.println(" - Magic Potion: " + price + " gold.");
        printSeperator(1);
        // askthe player to buy one
        System.out.println(" Do you want to buy one ? \n(1) Yes ! \n(2) No, thanks.");
        int input = readInt("=>", 2);
        if (input == 1) {
            clearConsole();
            // check if player has enough gold
            if (player.gold >= price) {
                printHeading("You bought a magical potion for " + price + " gold");
                player.pots++;
                player.gold -= price;
            } else {
                printHeading("You don't have enough gold to buy this.....");
                anythingToContinue();
            }
        }
    }
    // methode taking a rest

    public static void takeRest() {
        clearConsole();
        if (player.restsLeft >= 1) {
            printHeading("Do you want to take a rest ?  (" + player.restsLeft + " rest(s) left).");
            System.out.println("(1)Yes \n(2) No , not now.");
            int input = readInt("=> ", 2);
            if (input == 1) {
                // player actually takes rest
                clearConsole();
                if (player.hp < player.maxHp) {
                    int hpRestored = (int) (Math.random() * (player.xp / 4 + 1) + 10);
                    player.hp += hpRestored;
                    if (player.hp > player.maxHp) {
                        player.hp = player.maxHp;
                        System.out.println(" You took a rest and restored up to " + hpRestored + " health");
                        System.out.println("You're now at " + player.hp + "/ " + player.maxHp + " health.");
                        player.restsLeft--;
                    }
                }
            } else {
                System.out.println("You're at full health , You don't need to rest now");
                anythingToContinue();

            }
        }
    }

    // Creating a random battle
    public static void randomBattle() {
        clearConsole();
        printHeading("You encountered an evil minded creature , You'll jave to fight it !");
        anythingToContinue();
        battle(new Ennemy(ennemies[(int) (Math.random() * ennemies.length)], player.xp));
    }

    // the main battle method
    public static void battle(Ennemy enemy) {
        // Main battle loop
        while (true) {
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action ");
            printSeperator(1);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
            int input = readInt("-> ", 3);
            // react accordingly to player input
            if (input == 1) {
                // Fight
                // Calculate dmg and dmgTook (dmg enemy deals to player)
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                // check that dmg ad dmgTook isnt negativ
                if (dmgTook < 0) {
                    // add some dmg if player defends very well
                    dmg -= dmgTook / 2;
                    dmgTook = 0;
                }
                if (dmg < 0)
                    dmg = 0;
                // deal damge to both parties
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                // print info of this battle round
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You dealt " + dmg + " damage to the " + enemy.name + " . ");
                printSeperator(1);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you ");
                anythingToContinue();
                // check if player is still alive or dead
                if (player.hp <= 0) {
                    playerDied();// method to end the game
                    break;
                } else if (enemy.hp <= 0) {
                    // tell the player => he won
                    clearConsole();
                    printHeading("You defeated the " + enemy.name + "!");
                    // increase player xp
                    player.xp += enemy.xp;
                    System.out.println("You earned" + enemy.xp + " XP!");
                    // random drops
                    boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random() * enemy.xp);
                    if (addRest) {
                        player.restsLeft++;
                        System.out.println("You earned the chance to get an additional rest!");
                    }
                    if (goldEarned > 0) {
                        player.gold += goldEarned;
                        System.out.println("You collect " + goldEarned + " gold from the " + enemy.name + "'s corpse!");
                    }
                    anythingToContinue();
                    break;
                }
            } else if (input == 2) {
                // use potion
                clearConsole();
                if (player.pots > 0 && player.hp < player.maxHp) {
                    // player can take a potion
                    // make sure player wants to drink the potion
                    printHeading("Do you want to drink a potion ? (" + player.pots + " left).");
                    System.out.println("(1) Yes\n(2) No, maybe later");
                    input = readInt(" => ", 2);
                    if (input == 1) {
                        // player actually took it
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You drank a magic potion . It restored your health back to " + player.maxHp);
                        anythingToContinue();
                    }
                } else {
                    // player cannot take a potion
                    printHeading(" You don't have any potions or you're at full health");
                    anythingToContinue();
                }

            } else {
                // Run awway
                clearConsole();
                // check that player isn't in last act(final boss battle)
                if (act != 4) {
                    // chance of 35% to escape
                    if (Math.random() * 10 + 1 <= 3.5) {
                        printHeading("You ran away from the " + enemy.name + " !");
                        anythingToContinue();
                        break;
                    } else {
                        printHeading("You didn't manage to escape");
                        // calculate dmage the player takes
                        int dmgTook = enemy.attack();
                        System.out.println("In your hurry you took 0 " + dmgTook + " damage!");
                        anythingToContinue();
                        // check if player's still alive
                        if (player.hp <= 0)
                            playerDied();
                    }
                } else {
                    printHeading("You cannot be escape the boss of Empires");
                    anythingToContinue();
                }

            }

        }
    }

    // Printing the main menu
    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action ");
        System.out.println("(1) Continue on your journey ");
        System.out.println("(2) Character Info ");
        System.out.println("(3) Exit Game ");
    }

    // the final (last) battle of the entire game
    public static void finalBattle() {
        // creating the Emperor and letting the player fight against him
        battle(new Ennemy("The Emperor", 300));
        // printing the proper ending
        Story.printEnd(player);
        isRunning = false;
    }

    // method that gets called when the player is dead
    public static void playerDied() {
        clearConsole();
        printHeading(" You died ...");
        printHeading("You earned " + player.xp + " XP on your journey Try to earn more next time!");
        System.out.println("Thank you for player to my game. I hopeyou enjoyed it :=) ");
        isRunning = false;
    }

    // main game loop
    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("->", 3);
            if (input == 1) {
                continueJourney();

            } else if (input == 2) {
                characterInfo();

            } else
                isRunning = false;

        }
    }
}
