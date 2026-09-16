package polymorphism.class_problems;

public class MembershipPayment {
    static int membersEnrolled = 0;

    final String membershipNumber;
    int amountPaid;

    public MembershipPayment(int amount) {
        membersEnrolled++;
        membershipNumber = "GYM-" + (2000 + membersEnrolled);
        amountPaid = 0;
        payFee(amount);
    }

    public void payFee(int amount) {
        amountPaid += amount;
    }

    public void payFee(int amount, String mode) {
        System.out.println("Payment Mode: " + mode);
        payFee(amount);
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    public static void main(String[] args) {
        MembershipPayment payment =
                new MembershipPayment(500);

        payment.payFee(500, "UPI");

        System.out.println(payment.membershipNumber);
        System.out.println(payment.amountPaid);
        System.out.println(isValidReferralCode("G45B"));
    }
}
