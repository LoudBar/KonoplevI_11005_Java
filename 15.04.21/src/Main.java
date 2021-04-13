import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Bot bot = new Bot();

        while (true) {
            System.out.println("Введите команду");
            String message = in.nextLine();
            if (message.equals("exit"))
                break;

            Object answer = bot.processUserInput(message);
            System.out.println(answer);
        }
    }
}