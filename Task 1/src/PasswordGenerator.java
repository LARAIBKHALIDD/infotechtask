import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Length:");
        int length = scanner.nextInt();

        System.out.println("Include Uppercase letters? (Y/N)");
        boolean includeUpper = scanner.next().equalsIgnoreCase("Y");

        System.out.println("Include Lowercase letters? (Y/N)");
        boolean includeLower = scanner.next().equalsIgnoreCase("Y");

        System.out.println("Include Numbers? (Y/N)");
        boolean includeDigits = scanner.next().equalsIgnoreCase("Y");

        System.out.println("Include Special characters? (Y/N)");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("Y");

        String password = generatePassword(length, includeUpper, includeLower, includeDigits, includeSpecial);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean includeUpper, boolean includeLower, boolean includeDigits, boolean includeSpecial) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        String charSet = "";
        if (includeUpper) charSet += UPPER;
        if (includeLower) charSet += LOWER;
        if (includeDigits) charSet += DIGITS;
        if (includeSpecial) charSet += SPECIAL;

        if (charSet.isEmpty()) {
            System.out.println("Error: Please include at least one character set.");
            return "";
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charSet.length());
            password.append(charSet.charAt(randomIndex));
        }

        return password.toString();
    }
}
