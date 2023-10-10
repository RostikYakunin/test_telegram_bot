package com.example.test_telegram_bot.bot_structure.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface Command {
    void execute(Update update, AbsSender absSender);
}
