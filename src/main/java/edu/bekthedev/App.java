package edu.bekthedev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Hangman Game

        String filePath = "words.txt";
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim());
            }
        } catch(FileNotFoundException e){
            System.out.println("File Not Found!");
        } catch(IOException e) {
            System.out.println("Something Went Wrong!");
        } 


         Random random = new Random();

         String word = words.get(random.nextInt(words.size()));

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("Welcome to Java Hangman!");
      

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
