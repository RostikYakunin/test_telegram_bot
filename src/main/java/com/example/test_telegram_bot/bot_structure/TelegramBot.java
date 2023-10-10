package com.example.test_telegram_bot.bot_structure;

import com.example.test_telegram_bot.bot_structure.command.Command;
import com.example.test_telegram_bot.bot_structure.manager.BotCommandManager;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    final String botName;
    private final BotCommandManager botCommandManager;

    @SneakyThrows
    public TelegramBot(@Value("${telegram-bot.token}") String botToken,
                       @Value("${telegram-bot.name}") String botName,
                       BotCommandManager botCommandManager) {
        super(botToken);
        this.botName = botName;
        this.botCommandManager = botCommandManager;
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(this);
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String text = message.getText();

        if(update.hasMessage() && message.hasText()) {
            Command command = botCommandManager.getCommand(text);
            command.execute(update, this);
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }
}
