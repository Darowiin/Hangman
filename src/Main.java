import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to the Hangman game!");
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Do you want to play? (Y/N)");
            String response = input.nextLine().trim().toLowerCase();
            running = switch (response) {
                case "yes", "y" -> {
                    Game.playGame(input);
                    input.nextLine();
                    yield true;
                }
                case "no", "n" -> {
                    System.out.println("Goodbye!");
                    yield false;
                }
                default -> {
                    System.out.println("Invalid input");
                    yield false;
                }
            };
        }
        input.close();
    }
}
