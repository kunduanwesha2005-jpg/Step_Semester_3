package polymorphism.class_problems;

public class MembershipSettlement {
    public static String processMembers(GymMember[] members) {
        int processed = 0;
        int skipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members) {
            if (member == null) {
                skipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        return "Processed: " + processed
                + " | Skipped: " + skipped
                + " | Group: " + group
                + " | Individual: " + individual;
    }

    public static void main(String[] args) {
        GymMember[] members = {
                new GymMember("MEM1", 1000),
                new GroupClassMember("MEM2", 1500, "Yoga"),
                null,
                new PremiumMember("MEM3", 2000, "Riya")
        };

        System.out.println(processMembers(members));
    }
}
