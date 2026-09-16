package Stringoperations.class_problems;

public class FileExtensionValidator {
    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    public String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);

        for (int i = 0; i < ACCEPTED_EXTENSIONS.length; i++) {
            if (extension.equalsIgnoreCase(ACCEPTED_EXTENSIONS[i])) {
                return "Accepted";
            }
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        FileExtensionValidator validator = new FileExtensionValidator();

        System.out.println(validator.validateFileExtension("Assignment1.PDF"));
        System.out.println(validator.validateFileExtension("notes.txt"));
        System.out.println(validator.validateFileExtension("archive.ZIP"));
    }
}
