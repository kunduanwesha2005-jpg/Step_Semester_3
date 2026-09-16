package polymorphism.assignment_problems;

public class MonthlyAttendanceAnnouncer {

    static class GymMember {
        String memberId;
        int monthlyFee;
        int sessionsAttended;

        GymMember(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
        }

        void attendSession() {
            sessionsAttended++;
        }

        void displayInfo() {
            System.out.println(
                    "Standard | Sessions: "
                            + sessionsAttended
            );
        }
    }

    static class PremiumMember extends GymMember {
        String trainerName;

        PremiumMember(
                String memberId,
                int monthlyFee,
                String trainerName) {

            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        void displayInfo() {
            System.out.println(
                    "Premium | Trainer: "
                            + trainerName
                            + " | Sessions: "
                            + sessionsAttended
            );
        }
    }

    static String batchPrint(GymMember[] members) {

        StringBuilder result = new StringBuilder();

        for (GymMember member : members) {

            member.displayInfo();

            result.append(
                    "Standard | Sessions: "
            );

            result.append(
                    member.sessionsAttended
            );

            if (member instanceof PremiumMember) {

                PremiumMember premium =
                        (PremiumMember) member;

                result.append(
                        " | Premium | Trainer: "
                );

                result.append(
                        premium.trainerName
                );

                result.append(
                        " | Sessions: "
                );

                result.append(
                        premium.sessionsAttended
                );

                result.append(
                        " [Trainer via downcast: "
                );

                result.append(
                        premium.trainerName
                );

                result.append("]");
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        GymMember member =
                new GymMember("MEM6", 1000);

        PremiumMember premium =
                new PremiumMember(
                        "MEM7",
                        2000,
                        "Coach Riya"
                );

        GymMember[] members = {
                member,
                premium
        };

        System.out.println(
                batchPrint(members)
        );
    }
}
