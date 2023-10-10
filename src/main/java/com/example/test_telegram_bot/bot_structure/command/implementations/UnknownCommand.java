package com.example.test_telegram_bot.bot_structure.command.implementations;

import com.example.test_telegram_bot.bot_structure.command.Command;
import com.example.test_telegram_bot.bot_structure.service.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Component
@RequiredArgsConstructor
public class UnknownCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    final String UNKNOWN_MESSAGE = "Unknown message";

    @Override
    public void execute(Update update, AbsSender absSender) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), UNKNOWN_MESSAGE, absSender);
    }
}
