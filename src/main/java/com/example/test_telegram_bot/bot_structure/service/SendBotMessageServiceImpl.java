package com.example.test_telegram_bot.bot_structure.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service

public class SendBotMessageServiceImpl implements SendBotMessageService{

    @Override
    public boolean sendMessage(Long chatId, String message, AbsSender absSender) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        try {
            absSender.execute(sendMessage);
            return true;
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
