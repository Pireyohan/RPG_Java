package vscode_projectrpg;

public class Story {

    public static void printIntro() {
        Gamelogic.clearConsole();
        Gamelogic.printSeperator(1);
        System.out.println("Story");
        Gamelogic.printSeperator(1);
        System.out.println(" You are the last man standing after your village got raided by the henchmen of Empires");
        System.out.println(
                "Every single one of your friends, family got murdered, You are standing in burning ruins of his once");
        System.out.println(
                "All you want now is revenge , so you begin planning your journey to defeat the evil of Empires and free the lands");
        Gamelogic.anythingToContinue();

    }

    public static void printFirstActionIntro() {
        Gamelogic.clearConsole();
        Gamelogic.printSeperator(1);
        System.out.println("Intro");
        Gamelogic.printSeperator(1);
        System.out.println(
                " As you begin your journey you start travelling trhough the nearby woods to reach the everlasting moutain");
        System.out.println(
                "The everlasting moutains are a very dangerous place . It says nobody came back alive from there");
        System.out
                .println("After a long day of walking trhough the woods , you finally reach the everlasting moutains");
        Gamelogic.anythingToContinue();
    }

    public static void printFirstActionOutro() {
        Gamelogic.clearConsole();
        Gamelogic.printSeperator(1);
        System.out.println("Act1 outro");
        Gamelogic.printSeperator(1);
        System.out.println(" You dit it! you crossed the everlasting moutains and you're still alive");
        System.out.println(
                "as you climb down the last hill, you're more than happy to feel hard ground undermeath your feet again");
        System.out.println("\nYou feel empowered and the experience you gained allows you to learn antoher trait !");
        Gamelogic.anythingToContinue();
    }

    public static void printSecondActIntro() {
        Gamelogic.clearConsole();
        Gamelogic.printSeperator(1);
        System.out.println("Act2 Intro");
        Gamelogic.printSeperator(1);
        System.out.println(" You dit it! you crossed the everlasting moutains and you're still alive");
        System.out.println(
                "as you climb down the last hill, you're more than happy to feel hard ground undermeath your feet again");
        System.out.println("\nYou feel empowered and the experience you gained allows you to learn antoher trait !");
        Gamelogic.anythingToContinue();
    }

    public static void printSecondActOutro() {
    }

    public static void printThirdActIntro() {
    }

    public static void printThirdActOutro() {
    }

    public static void printFourActionIntro() {
        Gamelogic.clearConsole();
        Gamelogic.printSeperator(1);
        System.out.println("Act4 Intro");
        Gamelogic.printSeperator(1);
        System.out.println(" You enter the throne room of the Evil Emperor");
        System.out.println("You stares you dead in the eyes. You feel the darkness arounf you !!!");
        System.out.println("He takes out the holy sword of darkness, the mightiest weapon known to man.");
        System.out.println("All you can do know is fight for your life and pray to come out as the winner ....");
        Gamelogic.anythingToContinue();
    }

    public static void printEnd(Player player) {
        Gamelogic.clearConsole();
        Gamelogic.printSeperator(1);
        System.out.println("Act4 Intro");
        Gamelogic.printSeperator(1);
        System.out.println(" Congratulations, " + player.name + " ! You defeated the Evil Emperor and saved the world");
        System.out.println("This game was developped by Pire Yohan");
        System.out.println("I hope you enjoyed it");
    }

}
