import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private static String[] readDict() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("resources/wordlist.txt"))) {
            String wordLine = br.readLine();
            while (wordLine != null) {
                sb.append(wordLine);
                sb.append(System.lineSeparator());
                wordLine = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in reading dictionary of words: " + e.getMessage());
        }
        return sb.toString().split("\\R");
    }

    public static void playGame(Scanner input) {
        String word;
        Set<Character> usedLetters = new HashSet<>();
        try {
            String[] words = readDict();
            word = words[(int) (Math.random() * words.length)];
            StringBuilder wordToGuess = new StringBuilder(word.replaceAll("[а-яёА-ЯЁ]", "_"));
            int numErrors = 0;
            Gallows.printGallows(numErrors);

            while (numErrors < 6 && wordToGuess.indexOf("_") != -1) {
                System.out.println("Used letters: " + usedLetters);
                System.out.println("Word: " + wordToGuess);
                System.out.print("Enter letter: ");
                char letter = input.next().charAt(0);
                letter = Character.toLowerCase(letter);

                if (!Character.toString(letter).matches("[а-яё]")) {
                    System.out.println("Invalid input! Please enter a Russian letter.");
                    continue;
                }

                if (usedLetters.contains(letter)) {
                    System.out.println("You already used this letter!");
                    continue;
                }
                usedLetters.add(letter);

                if (word.contains(String.valueOf(letter))) {
                    System.out.println("Correct!");
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (word.charAt(i) == letter) {
                            wordToGuess.setCharAt(i, letter);
                        }
                    }
                } else {
                    System.out.println("Incorrect!");
                    numErrors++;
                }
                Gallows.printGallows(numErrors);
            }

            if (wordToGuess.indexOf("_") == -1) {
                System.out.println("You win! Word was: " + word);
            } else {
                System.out.println("You lose! Word was: " + word);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred in game: " + e);
        }
    }
}