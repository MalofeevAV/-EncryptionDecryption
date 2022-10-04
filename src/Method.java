public class Method {
    private static StringBuilder newMessage = new StringBuilder();

    public static StringBuilder action(String operation, String message, int key){
        key = operation.equals("enc") ? key : -key;

        for (char chr : message.toCharArray()) {
            newMessage.append((char) (chr + key));
        }
        return newMessage;
    }
}
