package de.tjorven.commandhandler;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private CommandRegistry() {
    }

    private static final Map<String, ICommand> REGISTERED = new HashMap<>();

    public static void registerCommand(String label, ICommand command) {
        REGISTERED.put(label, command);
    }

    public static ICommand getCommand(String label) {
        return REGISTERED.get(label);
    }

}
