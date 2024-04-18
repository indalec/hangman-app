package hangman;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String secretWord = getSecretWord();
        //   System.out.println(secretWord);
        char[] dashedWord = getDashedWord(secretWord);


        boolean endGame = false;

        Scanner scanner = new Scanner(System.in);

        int tries = 15;


        do {

            System.out.println("You still have " + tries + " tries left.");
            System.out.println(dashedWord);
            System.out.println("Enter a letter (a-z):");
            char letter = scanner.next().charAt(0);
            boolean correctLetter = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    dashedWord[i] = letter;
                    correctLetter = true;

                }

            }
            if (!correctLetter) {
                System.out.println("Wrong letter!");
                --tries;
                if (tries == 0) {
                    System.out.println("You loose, because you're hanged! XwX");
                    endGame = true;
                }
            } else {
                boolean wonGame = !areDashes(dashedWord);
                if (wonGame) {
                    System.out.println("Congratulations, you won!");
                    endGame = true;
                }
            }
        } while (!endGame);

        System.out.println(dashedWord);

        scanner.close();

    }

    static String getSecretWord() {

        String[] words = {
                "ant", "baboon", "badger", "bat", "bear", "beaver", "camel", "cat", "clam",
                "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle",
                "ferret", "fox", "frog", "goat", "goose", "hawk", "lion", "lizard", "llama",
                "mole", "monkey", "moose", "mouse", "mule", "newt", "otter", "owl", "panda", "pangolin",
                "parrot", "pigeon", "platypus", "python", "rabbit", "ram", "rat", "raven", "rhino",
                "salmon", "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider",
                "stork", "swan", "tiger", "toad", "trout", "turkey", "turtle", "weasel",
                "whale", "wolf", "wombat", "zebra"
        };

        Random random = new Random();
        int chosenWord = random.nextInt(words.length);
        return words[chosenWord];


    }

    static char[] getDashedWord(String word) {

        int lenghtWord = word.length();

        char[] dashedWord = new char[lenghtWord];

//        for (char letter : dashedWord) {
//
//            dashedWord[letter] = '_';
//        }

        for (int i = 0; i < lenghtWord; i++) {
            dashedWord[i] = '_';


        }

        return dashedWord;
    }

    static boolean areDashes(char[] word) {
        for (char letter : word) {
            if (letter == '_') return true;
        }
        return false;

    }

}