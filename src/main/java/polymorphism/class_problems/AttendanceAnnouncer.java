package polymorphism.class_problems;

public class AttendanceAnnouncer {
    public static String createMessage(GymMember member) {
        StringBuilder result = new StringBuilder();

        result.append("Member: ");
        result.append(member.memberId);
        result.append(" Sessions: ");
        result.append(member.sessionsAttended);

        if (member instanceof PremiumMember) {
            PremiumMember premium = (PremiumMember) member;
            result.append(" Trainer: ");
            result.append(premium.trainerName);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GymMember member =
                new PremiumMember("MEM6", 2000, "Riya");

        System.out.println(createMessage(member));
    }
}
