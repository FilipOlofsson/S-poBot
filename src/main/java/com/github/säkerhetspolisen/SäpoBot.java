package com.github.säkerhetspolisen;

import com.github.säkerhetspolisen.command.adminCommands;
import com.github.säkerhetspolisen.command.messageValidator;
import com.github.säkerhetspolisen.command.ownerCommands;
import com.github.säkerhetspolisen.command.userCommands;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class SäpoBot {
    public static void main(String[] args) {
        DiscordApi api = new DiscordApiBuilder().setToken("NDQxNzE2MDA1MzA4MzM0MTAw.Dc0Tpg.Gul-E42GY4pI3m6ODcfTS0dmkIs").login().join();
        System.out.println("Invite link: " + api.createBotInvite());
        api.addMessageCreateListener(new userCommands());
        api.addMessageCreateListener(new adminCommands());
        api.addMessageCreateListener(new ownerCommands());
        api.addMessageCreateListener(new messageValidator());
    }
}
