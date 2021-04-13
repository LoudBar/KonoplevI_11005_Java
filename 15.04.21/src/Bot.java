import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Bot {

    Scanner in = new Scanner(System.in);

    @Command(aliases = {"помощь", "помоги", "команды", "help"},
            description = "Выводит список команд")
    public String help(String[] args) {
        StringBuilder builder = new StringBuilder("Я умею в такие команды:\n");

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Command.class))
                continue;

            Command cmd = m.getAnnotation(Command.class);
            builder.append(Arrays.toString(cmd.aliases())).append(": ").append(cmd.description()).append(" - ").append(cmd.args()).append("\n");
        }

        return builder.toString();
    }

    @Command(aliases = {"привет", "здравствуйте"},
            description = "Здоровается")
    public String hello(String[] args) { return "Здарова"; }

    @Command(aliases = {"калькулятор"},
            args = "сложение",
            description = "Вычисляет сумму двух чисел")
    public int sum(String args) {
        System.out.println("Введите первое число");
        int a = in.nextInt();
        System.out.println("Введите второе число");
        int b = in.nextInt();

        return a + b;
    }
    
    @Command(aliases = {"калькулятор"},
            args = "умножение",
            description = "Вычисляет произведение двух чисел")
    public int mult(String args) {
        System.out.println("Введите первое число");
        int a = in.nextInt();
        System.out.println("Введите второе число");
        int b = in.nextInt();

        return a * b;
    }

    private HashMap<String, Method> commands;

    public Bot() {
        commands = new HashMap<>();

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Command.class))
                continue;

            Command cmd = m.getAnnotation(Command.class);
            for (String name : cmd.aliases())
                commands.put(name, m);
        }
    }

    public Object processUserInput(String input) {
        if (input.isEmpty())
            return "Я вас не понимаю";

        String[] splitted = input.split(" ");
        String command = splitted[0].toLowerCase();
        String[] args = Arrays.copyOfRange(splitted, 1, splitted.length);

        Method m = commands.get(command);

        if (m == null)
            return "Я вас не понимаю";

        try {
            return m.invoke(this, (Object) args);
        } catch (Exception e) {
            return "Что-то пошло не так, попробуйте ещё раз";
        }
    }

}

