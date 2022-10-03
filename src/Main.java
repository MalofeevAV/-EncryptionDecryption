import java.util.Scanner;

public class Main {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static String message, key;
    private static StringBuilder encryptedMessage = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        message = sc.nextLine();
        key = sc.nextLine();

        System.out.println(encryptionMethod(message, key));
    }

    static StringBuilder encryptionMethod(String message, String key){
        char encryptedChar;

        for (char chr : message.toCharArray()) {
            if (Character.isAlphabetic(chr)) {
                encryptedChar = ALPHABET.charAt((ALPHABET.indexOf(chr) + Integer.parseInt(key))%26);
                encryptedMessage.append(encryptedChar);
            } else {
                encryptedMessage.append(chr);
            }
        }
        return encryptedMessage;
    }
}
