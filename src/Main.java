public class Main {
    private static final String message = "we found a treasure!";
    private static StringBuilder encryptedMessage = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(encryptionMethod());
    }

    static StringBuilder encryptionMethod(){
        int min = (int) 'a';
        int max = (int) 'z';
        char encryptedChar;

        for (char chr : message.toCharArray()) {
            if (Character.isAlphabetic(chr)) {
                encryptedChar = (char) (max - (int) chr + min);
                encryptedMessage.append(encryptedChar);
            } else {
                encryptedMessage.append(chr);
            }
        }
        return encryptedMessage;
    }
}
