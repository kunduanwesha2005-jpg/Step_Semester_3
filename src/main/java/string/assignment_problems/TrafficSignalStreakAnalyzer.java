package string.assignment_problems;

public class TrafficSignalStreakAnalyzer {
    public void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No Signal Readings Provided");
            return;
        }

        char bestColor = signalLog.charAt(0);
        int bestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentLength++;
            } else {
                currentColor = signalLog.charAt(i);
                currentLength = 1;
            }

            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLength + " times");
    }

    public static void main(String[] args) {
        TrafficSignalStreakAnalyzer analyzer = new TrafficSignalStreakAnalyzer();

        analyzer.findLongestStreak("RRGGGYRR");
        analyzer.findLongestStreak("RRRRYYGG");
        analyzer.findLongestStreak("RYGRYG");
    }
}
