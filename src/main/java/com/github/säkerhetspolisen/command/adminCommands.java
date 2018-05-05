package com.github.säkerhetspolisen.command;

import org.javacord.api.event.message.MessageCreateEvent;

public class adminCommands extends Command {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if(event.getMessage().getAuthor().isServerAdmin() || event.getMessage().getAuthor().isBotOwner()) {
            handleCommand(event.getMessage().getContent());
        }
    }

    protected void handleCommand(String command) {
        if(command.startsWith(CommandConfig.prefix + "sättSpan"))
            CommandConfig.addSpan(command.substring(10));
        if(command.startsWith(CommandConfig.prefix + "ban"))
            CommandConfig.ban(command.substring(5));
        if(command.startsWith(CommandConfig.prefix + "banWord"))
            CommandConfig.banWord(command.substring(9));
    }
}
