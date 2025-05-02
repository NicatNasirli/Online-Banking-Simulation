package test.server.utilities;

public class CardNumberGenerator {

    public static String generateCardNumber() {
        String identifier = "1234"; // MyBank identifier

        StringBuilder elevenDigitString = new StringBuilder(identifier);
        for (int i = 0; i < 11; i++) {
            elevenDigitString.append((int) (Math.random() * 10));
        }

        String partialNumber = elevenDigitString.toString();
        int checkDigit = getLuhnCheckDigit(partialNumber);
        elevenDigitString.append(checkDigit);

        return elevenDigitString.toString();
    }

    private static int getLuhnCheckDigit(String number) {
        int sum = 0;
        boolean alternate = true;
        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) n -= 9;
            }
            sum += n;
            alternate = !alternate;
        }
        return (10 - (sum % 10)) % 10;
    }
}
