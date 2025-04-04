package edu.bekthedev;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String word = "pizza";

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("Welcome to Java Hangman!");
        System.out.println("**********************************");

        while (wrongGuesses < 6) {

            System.out.print(getHangmanArt(wrongGuesses));

            System.out.print("Word: ");

            for (char c : wordState) {
                System.out.print(c + " ");
            }

            System.out.println();

            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct Guess!!!");
                // For Loop cycles through word looking for letter
                for (int i = 0; i < word.length(); i++) {
                    // checking to see where the match is exactly
                    if (word.charAt(i) == guess) {
                        // set updates the word list of array letters
                        wordState.set(i, guess);
                    }
                }

                if(!wordState.contains('_')) {
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("You win with " + word + "!p");
                    break;
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong Guess!!");
            }
        }

        if(wrongGuesses >= 6){
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("Game Over!!!");
            System.out.println("The word was: " + word);
        }

        scanner.close();
    }

    static String getHangmanArt(int wrongGuesses) {
        return switch (wrongGuesses) {
            case 0 -> """

                    """;
            case 1 -> """
                    O

                    """;
            case 2 -> """
                    O
                    |

                    """;
            case 3 -> """
                     O
                    /|

                     """;
            case 4 -> """
                     O
                    /|\

                     """;

            case 5 -> """
                     O
                    /|\\
                    /
                     """;

            case 6 -> """
                     O
                    /|\\
                    / \\
                     """;
            default -> "";

        };

    }
}
