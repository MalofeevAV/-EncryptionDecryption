import java.util.Scanner;

public class UserInput {

    private String operation, message;
    private int key;
    private Scanner sc;

    public UserInput() {
        sc = new Scanner(System.in);
        this.operation = operation;
        this.takeOperation();
        this.message = message;
        this.takeMessage();
        this.key = key;
        this.takeKey();
    }

    public void takeOperation() {
        operation = sc.nextLine();

        while (!(operation.equals("enc") || operation.equals("dec"))) {
            System.out.println("Wrong operation, try again!\nEnter \"enc\" for encryption or \"dec\" for decryption: ");
            operation = sc.nextLine();
        }
    }

    public String getOperation() {
        return operation;
    }

    public void takeMessage() {
        message = sc.nextLine();
    }

    public String getMessage() {
        return message;
    }

    public void takeKey() {
        boolean flag = true;

        while (flag) {
            try {
                key = sc.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Only positive integer numbers available! Try again: ");
            } finally {
                flag = (key == (int) key) ? false : true;
            }
        }
    }

    public int getKey() {
        return key;
    }
}
