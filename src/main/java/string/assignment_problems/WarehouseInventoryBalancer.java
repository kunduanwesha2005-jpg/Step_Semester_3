package string.assignment_problems;

public class WarehouseInventoryBalancer {
    public void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null
                || sectionA.length == 0 || sectionA.length != sectionB.length) {
            System.out.println("Invalid Input: both sections must be non-empty and of equal length");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int highest = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + highest
                + " (" + highestSection + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {
        WarehouseInventoryBalancer balancer = new WarehouseInventoryBalancer();

        balancer.analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
        balancer.analyzeInventory(new int[]{10, 20, 30}, new int[]{5, 15, 45});
    }
}

