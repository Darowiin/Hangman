import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Game {
    public static void playGame(Scanner input) {
        String word;
        char[] usedLetters = new char[33];

        try {
            BufferedReader br = new BufferedReader(new FileReader("resources/wordlist.txt"));
            StringBuilder sb = new StringBuilder();
            String wordLine = br.readLine();
            while (wordLine != null) {
                sb.append(wordLine);
                sb.append(System.lineSeparator());
                wordLine = br.readLine();
            }
            br.close();
            String[] words = sb.toString().split("\\R");

            word = words[(int) (Math.random() * words.length)];
            String wordToGuess = word.replaceAll("[^a-zA-Z]", "_");
            int numErrors = 0;
            Gallows.printGallows(numErrors);

            while (numErrors < 6 && wordToGuess.contains("_")) {
                System.out.println("Word: " + wordToGuess);
                System.out.print("Enter letter: ");
                char letter = input.next().charAt(0);
                letter = Character.toLowerCase(letter);

                int index = -1;
                if (letter == 'ё') {
                    index = 32;
                } else if (letter >= 'а' && letter <= 'я') {
                    index = letter - 'а';
                } else {
                    System.out.println("Invalid input! Please enter a Russian letter.");
                    continue;
                }

                if (usedLetters[index] == letter) {
                    System.out.println("You already used this letter!");
                    continue;
                }
                usedLetters[index] = letter;

                if (word.contains(String.valueOf(letter))) {
                    System.out.println("Correct!");
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (word.charAt(i) == letter) {
                            wordToGuess = wordToGuess.substring(0, i) + letter + wordToGuess.substring(i + 1);
                        }
                    }
                } else {
                    System.out.println("Incorrect!");
                    numErrors++;
                }
                Gallows.printGallows(numErrors);
            }

            if (!wordToGuess.contains("_")) {
                System.out.println("You win! Word was: " + word);
            } else {
                System.out.println("You lose! Word was: " + word);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred in game: " + e);
        }
    }
}