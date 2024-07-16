package de.tjorven.commandhandler;

import java.io.InputStream;
import java.util.Scanner;

public class CommandHandler {

    private CommandHandler() {
    }

    public static void init() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
            parse(scanner.nextLine());
    }

    public static void init(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        while (scanner.hasNext())
            parse(scanner.nextLine());
    }

    private static void parse(String string) {
        String[] split = string.split(" ");
        String label = split[0];
        String[] args = new String[split.length - 1];
        System.arraycopy(split, 1, args, 0, args.length);
        ICommand command = CommandRegistry.getCommand(label);
        if (command != null)
            command.run(label, args);
    }
}
