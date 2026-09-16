package AccessModifiers.assignment_problems;

public class LibraryMemberBean {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;
    private boolean membershipIdAlreadySet;

    public LibraryMemberBean() {
        membershipIdAlreadySet = false;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (membershipIdAlreadySet == false) {
            membershipId = id;
            membershipIdAlreadySet = true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {
        int hash = answer.hashCode();
        securityAnswerHash = "" + hash;
    }

    public static void main(String[] args) {
        LibraryMemberBean m = new LibraryMemberBean();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println(m.getMembershipId());

        m.setMembershipId("FAKE-0000");
        System.out.println(m.getMembershipId());

        System.out.println(m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");
    }
}










