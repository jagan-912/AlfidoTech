import java.util.Scanner;
class GFG {
    public static void guessingNumberGame() {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int)(100 * Math.random());
        int maxTrials = 5;
        int i, guess;

        System.out.println("A number is chosen between 1 to 100.");
        System.out.println("Guess the number within " + maxTrials + " trials.");

        for (i = 0; i < maxTrials; i++) {
            System.out.println("Trial " + (i + 1) + ": Guess the number:");
            guess = sc.nextInt();

            if (number == guess) {
                System.out.println("Congratulations! You guessed the number.");
                break;
            } else if (number > guess && i != maxTrials - 1) {
                System.out.println("The number is greater than " + guess);
            } else if (number < guess && i != maxTrials - 1) {
                System.out.println("The number is less than " + guess);
            }
        }

        if (i == maxTrials) {
            System.out.println("You have exhausted " + maxTrials + " trials.");
            System.out.println("The number was " + number);
        }
    }

    public static void main(String[] args) {
        guessingNumberGame();
    }
}