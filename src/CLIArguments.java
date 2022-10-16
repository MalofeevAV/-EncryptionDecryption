import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class CLIArguments {
    private HashSet<String> defaultArgs = new HashSet<>(Arrays.asList("mode", "key", "data", "in", "out", "alg"));
    private HashMap<String, String> arguments = new HashMap<String, String>() {
        {
            put("mode", "enc");
            put("key", "0");
            put("data", "");
            put("alg", "shift");
        }
    };

    public CLIArguments(String[] args) {
        parseArguments(args);
    }

    private void parseArguments(String[] args) {
        for (int i=0; i<args.length; i+=2) {
            if (checkArgs(args[i])) {
                String arg = args[i].substring(1);
                if (defaultArgs.contains(arg)) {
                    if ("enc dec".contains(args[i+1])) {
                        arguments.put("mode", args[i+1]);
                    } else {
                        arguments.put(arg, args[i+1]);
                    }
                }
            }
        }
    }

    private boolean checkArgs(String arg) {
        boolean flag = true;
        try {
            arg.substring(1);
        } catch (IndexOutOfBoundsException e) {
            flag = false;
            System.out.printf(
                "%s - is wrong argument. Correct arguments are: \"-mode\", \"-key\", \"-data\", \"-in\", \"-out\", \"-alg\"\n", arg
            );
        }
        return flag;
    }

    public HashMap<String, String> getArguments() {
        return arguments;
    }
}
