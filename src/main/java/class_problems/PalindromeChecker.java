package class_problems;

public class PalindromeChecker {
    public boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public boolean isPalindromeArrayReversal(String text) {
        char[] characters = text.toCharArray();
        char[] reversed = new char[characters.length];

        for (int i = 0; i < characters.length; i++) {
            reversed[i] = characters[characters.length - 1 - i];
        }

        String reversedText = new String(reversed);

        return text.equals(reversedText);
    }

    public void checkAll(String text) {
        String iterative = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String recursive = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String arrayReversal = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";

        System.out.println("Input: \"" + text + "\"");
        System.out.println("Iterative: " + iterative
                + " | Recursive: " + recursive
                + " | Array Reversal: " + arrayReversal);
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        checker.checkAll("madam");
        checker.checkAll("hello");
        checker.checkAll("racecar");
    }
}
