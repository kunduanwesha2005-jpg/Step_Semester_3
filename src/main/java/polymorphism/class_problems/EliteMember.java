package polymorphism.class_problems;

public class EliteMember extends PremiumMember {
    String lockerNumber;

    public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Trainer: " + trainerName);
        System.out.println("Locker: " + lockerNumber);
        System.out.println("Sessions: " + sessionsAttended);
    }
}
