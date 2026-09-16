package class_problems;

import java.util.Random;
public class RockPaperScissorsGame {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public void playGame(String[] playerMoves) {
        int rounds = playerMoves.length;
        Random random = new Random();

        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {
            computerMoves[i] = MOVES[random.nextInt(MOVES.length)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("---------------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-14s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d | %-12s | %-14s | %-14s%n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }

        System.out.println("---------------------------------------------------------");

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + String.format("%.1f", winPercentage) + "%");
    }

    public static void main(String[] args) {
        RockPaperScissorsGame game = new RockPaperScissorsGame();

        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        game.playGame(playerMoves);
    }
}
