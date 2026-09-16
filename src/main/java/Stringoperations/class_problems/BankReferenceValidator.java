package Stringoperations.class_problems;

public class BankReferenceValidator {
    public String normalizeReference(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return bankCode + rest;
    }

    public String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String body = reference.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: date and sequence must be digits";
            }
        }

        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        String day = date.substring(0, 2);
        String month = date.substring(2, 4);
        String year = date.substring(4, 6);

        StringBuilder display = new StringBuilder();
        display.append("[").append(bankCode).append("] DATE: ")
                .append(day).append("/").append(month).append("/").append(year)
                .append(" | SEQ: ").append(sequence);

        return display.toString();
    }

    public static void main(String[] args) {
        BankReferenceValidator validator = new BankReferenceValidator();

        String raw1 = " hdf03022600042 ";
        String normalized1 = validator.normalizeReference(raw1);
        System.out.println(validator.validateAndFormat(normalized1));

        String raw2 = "12F03022600042";
        String normalized2 = validator.normalizeReference(raw2);
        System.out.println(validator.validateAndFormat(normalized2));
    }
}
