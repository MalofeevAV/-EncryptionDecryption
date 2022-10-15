import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        UserInput userInput = new UserInput();
//        System.out.println(Method.action(userInput.getOperation(), userInput.getMessage(), userInput.getKey()));

        CLIArguments CLIarguments = new CLIArguments();
        CLIarguments.parseArguments(args);
        HashMap<String, String> arguments = CLIarguments.getArguments();

        if (arguments.containsKey("out")) {
            if (arguments.get("data").length() > 0 && !arguments.containsKey("in")) {
                WorkWithFiles.outputToTheFile(
                        Method.action(
                                arguments.get("mode"),
                                arguments.get("data"),
                                Integer.parseInt(arguments.get("key"))
                        ), arguments.get("out")
                );
            } else {
                try {
                    WorkWithFiles.outputToTheFile(
                            Method.action(
                                    arguments.get("mode"),
                                    WorkWithFiles.intupFromTheFile(arguments.get("in")),
                                    Integer.parseInt(arguments.get("key"))
                            ), arguments.get("out")
                    );
                } catch (IOException e) {
                    System.out.printf("Error: %s\n", e);
                }
            }
        } else {
            if (arguments.get("data").length() > 0 && !arguments.containsKey("in")) {
                System.out.println(
                    Method.action(
                        arguments.get("mode"),
                        arguments.get("data"),
                        Integer.parseInt(arguments.get("key"))
                    )
                );
            } else {
                try {
                    System.out.println(
                        Method.action(
                            arguments.get("mode"),
                            WorkWithFiles.intupFromTheFile(arguments.get("in")),
                            Integer.parseInt(arguments.get("key"))
                            )
                    );
                } catch (IOException e) {
                    System.out.printf("Error: %s\n", e);
                }
            }
        }
    }
}
