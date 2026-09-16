package AccessModifiers.assignment_problems;

class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = copyArray(bookIds);
    }

    private static String[] copyArray(String[] source) {
        String[] copy = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i];
        }
        return copy;
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return copyArray(bookIds);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] newBookIds = copyArray(bookIds);
        newBookIds[index] = newId;
        return new LoanReceipt(memberId, newBookIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

public class CirculationLedger {
    static String branchCode;

    static {
        branchCode = "PT-MAIN";
    }

    static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (int i = 0; i < receipts.length; i++) {
            LoanReceipt receipt = receipts[i];

            if (receipt == null) {
                nullSkipped = nullSkipped + 1;
                continue;
            }

            processed = processed + 1;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly = referenceOnly + 1;
            } else {
                regular = regular + 1;
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | " + regular + " regular";
    }

    public static void main(String[] args) {
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);

        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println(java.util.Arrays.toString(r.getBookIds()));
        System.out.println(java.util.Arrays.toString(corrected.getBookIds()));

        LoanReceipt[] receipts = {
                new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
                null,
                new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(processNightlyCirculation(receipts));
    }
}