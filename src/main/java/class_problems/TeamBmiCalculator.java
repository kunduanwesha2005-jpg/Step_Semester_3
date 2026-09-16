package class_problems;

import java.util.Random;

public class TeamBmiCalculator {
    public String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid Input: height and weight arrays must be of equal length");
            return;
        }

        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-9s | %-11s | %-12s | %-8s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-9d | %-11.2f | %-12.1f | %-8.2f | %-12s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }

        System.out.println("-----------------------------------------------------------------");
    }

    public static void main(String[] args) {
        TeamBmiCalculator calculator = new TeamBmiCalculator();

        double[] sampleHeights = {1.75, 1.60};
        double[] sampleWeights = {70.0, 90.0};

        System.out.println("Sample Check:");
        calculator.printWellnessReport(sampleHeights, sampleWeights);

        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        Random random = new Random();

        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + (random.nextDouble() * 0.45);
            weights[i] = 45.0 + (random.nextDouble() * 55.0);
        }

        System.out.println();
        System.out.println("Wellness Report (10 Employees):");
        calculator.printWellnessReport(heights, weights);
    }
}
