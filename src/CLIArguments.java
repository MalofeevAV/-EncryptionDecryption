import java.util.HashMap;


public class CLIArguments {

    public static HashMap<String, String> parseArguments(String[] args) {
        HashMap<String, String> arguments = new HashMap<String, String>() {
            {
                put("mode", "enc");
                put("key", "0");
                put("data", "");
            }
        };

        for (int i=0; i<args.length; i+=2) {
            switch (args[i]) {
                case "-mode":
                    if ("enc dec".contains(args[i+1])) {
                        arguments.put("mode", args[i+1]);
                    }
                    break;
                case "-key":
                    arguments.put("key", args[i+1]);
                    break;
                case "-data":
                    arguments.put("data", args[i+1]);
                    break;
            }

//            try {
//                String arg = args[i].substring(2);
//                if (arguments.containsKey(arg)) {
//                    arguments.put(arg, args[i+=1]);
//                }
//            } catch (IndexOutOfBoundsException e) {
//                System.out.printf("%s - is wrong argument. Correct arguments are: \"-mode\", \"-key\", \"-data\"\n", args[i]);
//            }
        }
        return arguments;
    }
}
