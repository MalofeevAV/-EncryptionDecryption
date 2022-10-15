import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class CLIArguments {
    private HashSet<String> defaultArgs = new HashSet<String>(Arrays.asList("mode", "key", "data", "in", "out", "alg"));
    private HashMap<String, String> arguments = new HashMap<String, String>() {
        {
            put("mode", "enc");
            put("key", "0");
            put("data", "");
        }
    };

    public void parseArguments(String[] args) {
//        for (int i=0; i<args.length; i+=2) {
//            switch (args[i]) {
//                case "-mode":
//                    if ("enc dec".contains(args[i+1])) {
//                        arguments.put("mode", args[i+1]);
//                    }
//                    break;
//                case "-key":
//                    arguments.put("key", args[i+1]);
//                    break;
//                case "-data":
//                    arguments.put("data", args[i+1]);
//                    break;
//                case "-in":
//                    arguments.put("in", args[i+1]);
//                    break;
//                case "-out":
//                    arguments.put("out", args[i+1]);
//                    break;
//            }
//        }

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

    public HashMap<String, String> getArguments() {
        return arguments;
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
}
