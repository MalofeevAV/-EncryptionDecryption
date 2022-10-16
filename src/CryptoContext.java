import java.util.HashMap;

public class CryptoContext {
    private final HashMap<String, String> cliArguments;
    private CryptoStrategy algorithm;

    public CryptoContext(CLIArguments cliArguments) {
        this.cliArguments = cliArguments.getArguments();
        setAlgorithm();
    }

    private void setAlgorithm() {
        switch (cliArguments.get("alg")) {
            case "unicode":
                algorithm = new UnicodeStrategy();
                break;
            default:
                algorithm = new ShiftStrategy();
                break;
        }
    }

    private String executeAlgorithm() {
        String message = input();
        if (cliArguments.get("mode").equals("enc")) {
            return algorithm.encrypt(message, Integer.parseInt(cliArguments.get("key")));
        } else {
            return algorithm.decrypt(message, Integer.parseInt(cliArguments.get("key")));
        }
    }

    private String input() {
        if (cliArguments.get("data").equals("") && cliArguments.containsKey("in")) {
            return WorkWithFiles.intupFromTheFile(cliArguments.get("in"));
        } else {
            return cliArguments.get("data");
        }
    }

    public void output() {
        if (cliArguments.containsKey("out")) {
            WorkWithFiles.outputToTheFile(executeAlgorithm(), cliArguments.get("out"));
        } else {
            System.out.println(executeAlgorithm());
        }
    }

}
