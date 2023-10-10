package com.example.test_telegram_bot.bot_structure.manager;

import com.example.test_telegram_bot.bot_structure.command.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class BotCommandManager {
    private final Map<String, Command> commandMap;

    public Command getCommand(String commandIdentifier) {
        String command = commandIdentifier.trim().replace("/", "").toLowerCase() + "Command";

        if (commandMap.containsKey(command)) {
            return commandMap.get(command);
        }

        throw new RuntimeException("Command not found");
    }

}
