package com.github.säkerhetspolisen.command;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class messageValidator implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if(!event.getMessage().getAuthor().isYourself()) {
            String user = event.getMessage().getAuthor().getName();
            String[] message = event.getMessage().getContent().split(" ");
            user = user.toLowerCase();
            if(CommandConfig.isBanned(user)) {
                event.deleteMessage();
            } else if(CommandConfig.isOnSpan(user)) {
                event.getChannel().sendMessage("**SÄKERHETSPOLISEN RAPPORTERAR**\n"
                        + event.getMessage().getCreationTimestamp() + "\n\n"
                        + user + " har skrivit \""
                        + event.getMessage().getContent() + "\"");
                System.out.println(user + " is on span.");
            }

            for(int i = 0; i < message.length; i++) {
                if(CommandConfig.isBannedWord(message[i]) && !event.getMessage().getContent().contains("!banWord")) {
                    event.deleteMessage();
                    event.getChannel().sendMessage(":police_car:**SÄKERHETSPOLISEN HAR UPPTÄCKT ETT LAGBROTT**:police_car:\n" +
                            event.getMessage().getAuthor().getName() + " försökte skriva ett bannat ord. Detta ord har censurerats och en anmälan" +
                            " har gjorts. Vill du överklaga detta beslut så kan du gå och knulla dig själv.");
                }
            }
        }
    }
}