package hangman;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String secretWord = getSecretWord();
        //   System.out.println(secretWord);
        char[] dashedWord = getDashedWord(secretWord);
        int playAgain;

        boolean endGame = reseter(playAgain);

        Scanner scanner = new Scanner(System.in);

        int tries = 6;


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



        System.out.println("do you want to play again? Enter '1' for 'yes'");

        playAgain = scanner.nextInt();




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

    static boolean reseter(int playAgain) {

        if (playAgain == 1) {
            String secretWord = getSecretWord();
            char[] dashedWord = getDashedWord(secretWord);
            int tries = 6;

            // Additional reset logic if needed
            System.out.println("Game reset! New secret word: " + secretWord);
       return false;
        }
return true;
    }

}