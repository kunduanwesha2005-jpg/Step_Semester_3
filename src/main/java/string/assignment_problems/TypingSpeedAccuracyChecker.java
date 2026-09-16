package string.assignment_problems;

public class TypingSpeedAccuracyChecker {

    public void checkTypingAccuracy(String original, String typed) {

        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Invalid Input: both strings must exist and be of equal length");
            return;
        }

        if (original.isEmpty()) {
            System.out.println("...");
            return;
        }

        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;

        for (int i = 0; i < total; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
            }
        }

        double accuracy = (matched * 100.0) / total;

        String result = "Matched: " + matched + "/" + total
                + " | Accuracy: " + String.format("%.2f", accuracy) + "%";

        if (firstMismatchPos == -1) {

            result += " | No Mismatches";

        } else {

            result += " | First Mismatch at position " + firstMismatchPos
                    + " ('" + original.charAt(firstMismatchPos - 1)
                    + "' vs '" + typed.charAt(firstMismatchPos - 1) + "')";
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        TypingSpeedAccuracyChecker checker = new TypingSpeedAccuracyChecker();

        checker.checkTypingAccuracy("hello world", "hello worlt");
        checker.checkTypingAccuracy("coding", "coding");
        checker.checkTypingAccuracy("java", "jvaa");
    }
}
