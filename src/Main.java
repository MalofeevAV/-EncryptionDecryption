public class Main {
    public static void main(String[] args) {
        CLIArguments cliArguments = new CLIArguments(args);
        CryptoContext cryptoContext = new CryptoContext(cliArguments);
        cryptoContext.output();
    }
}
