package com.github.säkerhetspolisen.command;

import org.javacord.api.listener.message.MessageCreateListener;

abstract class Command implements MessageCreateListener {
    abstract void handleCommand(String Command);
}
