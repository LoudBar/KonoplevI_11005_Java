import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Bot {

    @Command(aliases = {"помощь", "помоги", "help"},
            description = "Выводит список команд",
            id = 1)
    public String help(String[] args) {
        StringBuilder builder = new StringBuilder("Я умею в такие команды:\n");

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Command.class))
                continue;

            Command cmd = m.getAnnotation(Command.class);

            if (args.length > 0)
                for (String alias : cmd.aliases())
                    if (alias.equals(args[0])) {
                        builder = new StringBuilder("Информация о команде " + cmd.aliases()[0] + ":");
                        builder.append("\n").append(cmd.description());
                        if (cmd.workingMethod().length() > 0)
                           builder.append(". ").append(cmd.workingMethod());
                        if (cmd.args().length > 0) {
                            String str = Arrays.toString(cmd.args());
                            str = str.replaceAll("[\\[\\]]","");
                            if (!str.isEmpty())
                                builder.append("\n").append("Аргументы: ").append(str);
                        }
                        return builder.toString();
                    }
            builder.append(Arrays.toString(cmd.aliases())).append(": ").append(cmd.description()).append(" - ").append(Arrays.toString(cmd.args())).append("\n");
        }

        return builder.toString();
    }

    @Command(aliases = {"привет", "здравствуйте", "хай"},
            description = "Здоровается",
            id = 2)
    public String hello(String[] args) { return "Здарова"; }

    @Command(aliases = {"калькулятор", "вычилсить", "посчитать"},
            args = {"сложение", "вычитание", "умножение", "деление"},
            description = "Выполняет вычислительные операции",
            workingMethod = "Напишите два числа, затем аргумент",
            id = 3)
    public String calc(String[] args) {

        if (args.length < 3) return "Недостаточно аргументов";

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        if (args[2].equals("+")) return "" + (a + b);
        if (args[2].equals("-")) return "" + (a - b);
        if (args[2].equals("*")) return "" + (a * b);
        if (args[2].equals("/")) return "" + (a / b);

        return "Некорректный ввод";
    }

    @Command(aliases = {"число", "рандом"},
            args = {"нижняя граница", "нерхняя граница"},
            description = "Генерирует случайное число в заданных границах",
            workingMethod = "Введите сначала нижнюю, затем верхнюю границу",
            id = 4)
    public String rand(String[] args) {

        Random random = new Random();
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int x = a + random.nextInt(b - a + 1);

        return "" + x;
    }

    @Command(aliases = {"пока", "покеда", "досвидания"},
            description = "Прощается",
            id = 5)
    public String bye(String[] args) { return "Прощай"; }

    @Command(aliases = {"команды"},
            description = "Выводит список доступных реализованных команд, потом список команд, которые находятся в разработке",
            id = 6)
    public String commands(String[] args) {

        StringBuilder commandsTrue = new StringBuilder("Доступные команды:\n");
        StringBuilder commandsFalse = new StringBuilder("Команды, находящиеся в разработке:\n");

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Command.class))
                continue;

            Command cmd = m.getAnnotation(Command.class);

            if (cmd.inProgress()) commandsFalse.append(cmd.aliases()[0]).append("\n");
            else commandsTrue.append(cmd.aliases()[0]).append("\n");
        }
        return commandsTrue + "\n" + commandsFalse;
    }

    @Command(aliases = {"создать квантовый суперкомпьютер"},
            description = "создает квантовый суперкомпьютер",
            inProgress = true)
    public int troll(String[] args) { return 0;}

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

