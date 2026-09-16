package Stringoperations.assignment_problems;

public class LibraryIsbnValidator {
    public String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return publisherCode + rest;
    }

    public String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);
        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = code.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: year and catalog number must be digits";
            }
        }

        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder display = new StringBuilder();
        display.append("[").append(publisherCode).append("] YEAR: ")
                .append(year).append(" | CATALOG: ").append(catalog);

        return display.toString();
    }

    public static void main(String[] args) {
        LibraryIsbnValidator validator = new LibraryIsbnValidator();

        String raw1 = " pen2026004251 ";
        String normalized1 = validator.normalizeCode(raw1);
        System.out.println(validator.validateAndFormat(normalized1));

        String raw2 = "12N2026004251";
        String normalized2 = validator.normalizeCode(raw2);
        System.out.println(validator.validateAndFormat(normalized2));
    }
}
