package polymorphism.class_problems;

public class MembershipAccessChecker {
    public static String checkMember(GymMember member) {
        if (member instanceof EliteMember) {
            return "Elite Member";
        }

        if (member instanceof PremiumMember) {
            return "Premium Member";
        }

        if (member instanceof GroupClassMember) {
            return "Group Class Member";
        }

        return "Standard Member";
    }

    public static void main(String[] args) {
        GymMember member = new GymMember("MEM1", 1000);
        PremiumMember premium = new PremiumMember("MEM2", 2000, "Riya");
        EliteMember elite = new EliteMember("MEM3", 3000, "Arjun", "L12");
        GroupClassMember group = new GroupClassMember("MEM4", 1500, "Zumba");

        System.out.println(checkMember(member));
        System.out.println(checkMember(premium));
        System.out.println(checkMember(elite));
        System.out.println(checkMember(group));
    }
}
