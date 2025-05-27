import java.util.ArrayList;
import java.util.List;

public class Gallows {
    private static final List<String> gallows = new ArrayList<>();
    static {
        gallows.add("""
                          +---+
                          |   |
                              |
                              |
                              |
                              |
                        =========''']""");
        gallows.add("""
                          +---+
                          |   |
                          O   |
                              |
                              |
                              |
                        =========''']""");
        gallows.add("""
                          +---+
                          |   |
                          O   |
                          |   |
                              |
                              |
                        =========''']""");
        gallows.add("""
                          +---+
                          |   |
                          O   |
                         /|   |
                              |
                              |
                        =========''']""");
        gallows.add("""
                          +---+
                          |   |
                          O   |
                         /|\\  |
                              |
                              |
                        =========''']""");
        gallows.add("""
                          +---+
                          |   |
                          O   |
                         /|\\  |
                         /    |
                              |
                        =========''']""");
        gallows.add("""
                          +---+
                          |   |
                          O   |
                         /|\\  |
                         / \\  |
                              |
                        =========''']""");
    }
    public static void printGallows(int numErrors) {
        System.out.println("Errors count: " + numErrors);
        System.out.println(gallows.get(numErrors));
    }
}