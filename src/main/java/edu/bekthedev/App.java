package edu.bekthedev;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String word = "watermelon";

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("Welcome to Java Hangman!");

        System.out.println(getHangmanArt(1));

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
