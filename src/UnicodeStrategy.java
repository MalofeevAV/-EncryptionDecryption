public class UnicodeStrategy implements CryptoStrategy{
    private static StringBuilder newMessage = new StringBuilder();
    @Override
    public String encrypt(String message, int key) {
        for (char chr : message.toCharArray()) {
            newMessage.append((char) (chr + key));
        }
        return String.valueOf(newMessage);
    }

    @Override
    public String decrypt(String message, int key) {
        return encrypt(message, -key);
    }
}
