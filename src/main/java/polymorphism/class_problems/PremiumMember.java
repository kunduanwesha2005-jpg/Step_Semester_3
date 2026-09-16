package polymorphism.class_problems;

public class PremiumMember extends GymMember {
    String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Fee: " + monthlyFee);
        System.out.println("Trainer: " + trainerName);
        System.out.println("Sessions: " + sessionsAttended);
    }
}
