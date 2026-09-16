package polymorphism.class_problems;

public class GroupClassMember extends GymMember {
    String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public void displayInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Class: " + className);
        System.out.println("Sessions: " + sessionsAttended);
    }
}
