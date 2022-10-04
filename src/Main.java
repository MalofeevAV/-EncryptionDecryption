public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();

        System.out.println(Method.action(userInput.getOperation(), userInput.getMessage(), userInput.getKey()));
    }
}
