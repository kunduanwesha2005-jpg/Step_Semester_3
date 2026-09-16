package polymorphism.class_problems;

public class GymMember {
    String memberId;
    int monthlyFee;
    int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("Invalid fee");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public void displayInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Fee: " + monthlyFee);
        System.out.println("Sessions: " + sessionsAttended);
    }
}
