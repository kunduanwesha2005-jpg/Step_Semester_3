package Stringoperations.assignment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StopWordFilteredWordFrequency {

    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    private boolean isStopWord(String word) {
        for (int i = 0; i < STOP_WORDS.length; i++) {
            if (STOP_WORDS[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    public void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }

            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());

        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        StopWordFilteredWordFrequency report = new StopWordFilteredWordFrequency();

        report.printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}