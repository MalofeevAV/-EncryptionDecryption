import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        UserInput userInput = new UserInput();
//        System.out.println(Method.action(userInput.getOperation(), userInput.getMessage(), userInput.getKey()));

        HashMap<String, String> arguments = CLIArguments.parseArguments(args);
        System.out.println(Method.action(arguments.get("mode"), arguments.get("data"), Integer.parseInt(arguments.get("key"))));
    }
}
