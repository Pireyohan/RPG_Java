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
        System.out.println(" You begin travelling across the landlines of this once sell populated countryside");
        System.out.println( "You collected some gold from the monsters you killed along the way");
        System.out.println("Luckily you kown that every onece in a while a travelling tradercomes acress these landlines");
        System.out.println("You kown exactly where the castle of the evil emperor is , but you to cross therse haunted landlins first...");
        Gamelogic.anythingToContinue();
    }

    public static void printSecondActOutro() {
        Gamelogic.clearConsole();
        Gamelogic.printSeperator(1);
        System.out.println("Act 2 OUtro");
        Gamelogic.printSeperator(1);
        System.out.println(" You managed to cross these haunted landlines and you're still alive! ");
        System.out.println("You are just a few hours away from your final destination, the castle of Evil EMperor.");
        System.out.println("You know that you probably can't rest there, so you make a last break to restore some health");
        System.out.println("After all you've seen you feel empowered to learn another trait");
        Gamelogic.anythingToContinue();
    }

    public static void printThirdActIntro() {
        Gamelogic.clearConsole();
        Gamelogic.printSeperator(1);
        System.out.println("Act 3 Intro");
        Gamelogic.printSeperator(1);
        System.out.println(" You see the huge black castle in front of you  ");
        System.out.println("As you sta,d inf front of the gates , you know there's no going back");
        System.out.println(" You 're disguised as a mercenary and enter the castle . You don't know how much time you have left before someone");
        System.out.println("All you can do know is fight for you life and pray to come out as the winner ....");
        Gamelogic.anythingToContinue();
    }

    public static void printThirdActOutro() {
        Gamelogic.clearConsole();
        Gamelogic.printSeperator(1);
        System.out.println("Act3 Outro");
        Gamelogic.printSeperator(1);
        System.out.println(" You came so far. You defeated all of the Evil Emperor's minions");
        System.out.println("As you stand in front of the door to his throne room , you know there's no going back.");
        System.out.println(" YOu recall you lost power and restore your health.");
        System.out.println("You get the chance to learn a last trait before entering the throne room");
        Gamelogic.anythingToContinue();
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
