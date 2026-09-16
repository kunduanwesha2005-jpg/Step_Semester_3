package polymorphism.assignment_problems;

public class PremiumLoyaltyDiscount {

    static class GymMember {
        String memberId;
        int monthlyFee;
        private int[] lateFeeHistory;
        private int feeCount;

        GymMember(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.lateFeeHistory = new int[10];
            this.feeCount = 0;
        }

        protected void chargeLateFee(int amount) {
            if (feeCount < lateFeeHistory.length) {
                lateFeeHistory[feeCount] = amount;
                feeCount++;
            }
        }

        int[] getLateFeeHistory() {
            int[] result = new int[feeCount];

            for (int i = 0; i < feeCount; i++) {
                result[i] = lateFeeHistory[i];
            }

            return result;
        }

        int getTotalLateFees() {
            int total = 0;

            for (int i = 0; i < feeCount; i++) {
                total += lateFeeHistory[i];
            }

            return total;
        }
    }

    static class PremiumMember extends GymMember {

        PremiumMember(
                String memberId,
                int monthlyFee) {

            super(memberId, monthlyFee);
        }

        @Override
        protected void chargeLateFee(int amount) {
            super.chargeLateFee(amount / 2);
        }
    }

    public static void main(String[] args) {

        PremiumMember p =
                new PremiumMember("MEM5", 2000);

        p.chargeLateFee(200);

        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();

        history[0] = 999;

        System.out.println(
                p.getLateFeeHistory()[0]
        );
    }
}
