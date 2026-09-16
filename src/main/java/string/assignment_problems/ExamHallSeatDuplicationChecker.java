package string.assignment_problems;

public class ExamHallSeatDuplicationChecker {

    public void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Seat Numbers Provided");
            return;
        }

        boolean foundAny = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            boolean alreadyReported = false;

            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }

            if (alreadyReported) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println(
                            "Duplicate Seat Number Found: " + seatNumbers[i]
                    );
                    foundAny = true;
                    break;
                }
            }
        }

        if (!foundAny) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {

        ExamHallSeatDuplicationChecker checker =
                new ExamHallSeatDuplicationChecker();

        checker.checkDuplicateSeats(
                new int[]{101, 102, 103, 102, 105}
        );

        checker.checkDuplicateSeats(
                new int[]{101, 102, 103, 104, 105}
        );

        checker.checkDuplicateSeats(
                new int[]{101, 102, 102, 103, 103}
        );
    }
}