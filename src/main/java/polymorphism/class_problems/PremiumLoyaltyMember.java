package polymorphism.class_problems;

public class PremiumLoyaltyMember extends GymMember {
    private int lateFee;

    public PremiumLoyaltyMember(String memberId, int monthlyFee) {
        super(memberId, monthlyFee);
    }

    protected void chargeLateFee(int amount) {
        lateFee += amount;
    }

    public int getLateFee() {
        return lateFee;
    }

    public static void main(String[] args) {
        PremiumLoyaltyMember member =
                new PremiumLoyaltyMember("MEM5", 2000);

        member.chargeLateFee(100);

        System.out.println(member.getLateFee());
    }
}
