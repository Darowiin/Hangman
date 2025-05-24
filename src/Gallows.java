public class Gallows {
    public static void printGallows(int numErrors) {
        switch (numErrors) {
            case 0:
                System.out.println("""
                          +---+
                          |   |
                              |
                              |
                              |
                              |
                        =========''']""");
                System.out.println("Errors count: " + numErrors);
                break;
            case 1:
                System.out.println("""
                          +---+
                          |   |
                          O   |
                              |
                              |
                              |
                        =========''']""");
                System.out.println("Errors count: " + numErrors);
                break;
            case 2:
                System.out.println("""
                          +---+
                          |   |
                          O   |
                          |   |
                              |
                              |
                        =========''']""");
                System.out.println("Errors count: " + numErrors);
                break;
            case 3:
                System.out.println("""
                          +---+
                          |   |
                          O   |
                         /|   |
                              |
                              |
                        =========''']""");
                System.out.println("Errors count: " + numErrors);
                break;
            case 4:
                System.out.println("""
                          +---+
                          |   |
                          O   |
                         /|\\  |
                              |
                              |
                        =========''']""");
                System.out.println("Errors count: " + numErrors);
                break;
            case 5:
                System.out.println("""
                          +---+
                          |   |
                          O   |
                         /|\\  |
                         /    |
                              |
                        =========''']""");
                System.out.println("Errors count: " + numErrors);
                break;
            case 6:
                System.out.println("""
                          +---+
                          |   |
                          O   |
                         /|\\  |
                         / \\  |
                              |
                        =========''']""");
                System.out.println("Errors count: " + numErrors);
                break;
        }
    }
}