package com.example.test_telegram_bot.bot_structure.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Service
public interface SendBotMessageService {
    boolean sendMessage(Long chatId, String message, AbsSender absSender);
}
