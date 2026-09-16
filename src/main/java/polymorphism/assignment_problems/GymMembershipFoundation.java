package polymorphism.assignment_problems;

public class GymMembershipFoundation {

    static class GymMember {
        String memberId;
        int monthlyFee;
        int sessionsAttended;

        GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid member ID");
            }

            if (monthlyFee <= 0) {
                throw new IllegalArgumentException("Invalid monthly fee");
            }

            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }

        void attendSession() {
            sessionsAttended++;
        }

        int getSessionsAttended() {
            return sessionsAttended;
        }
    }

    static class PremiumMember extends GymMember {
        String trainerName;

        PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }
    }

    static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        for (String memberId : memberIds) {
            try {
                new GymMember(memberId, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        PremiumMember p =
                new PremiumMember("MEM01", 2000, "Coach Riya");

        p.attendSession();
        p.attendSession();

        System.out.println(p.getSessionsAttended());

        String[] members = {
                "MEM1", "GM1", "MEM2", " ", "MEM3"
        };

        System.out.println(signUpBatch(members, 1000));
    }
}