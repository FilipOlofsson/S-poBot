package com.github.säkerhetspolisen.command;

import java.util.LinkedList;
import java.util.List;

public class CommandConfig {
    private static List<String> spanList = new LinkedList<>();
    private static List<String> bannedList = new LinkedList<>();
    private static List<String> bannedWords = new LinkedList<>();

    static String prefix = "!";

    public static boolean isBanned(String user) {
        return bannedList.contains(user);
    }

    public static boolean isBannedWord(String word) {
        return bannedWords.contains(word);
    }

    public static boolean isOnSpan(String user) {
        return CommandConfig.spanList.contains(user);
    }

    static void addSpan(String user) {
        user = user.toLowerCase();
        if(spanList.contains(user))
            spanList.remove(user);
        else
            spanList.add(user);
    }

    static void banWord(String word) {
        word = word.toLowerCase();
        if(bannedWords.contains(word))
            bannedWords.remove(word);
        else
            bannedWords.add(word);
    }

    static void ban(String user) {
        user = user.toLowerCase();
        if(bannedList.contains(user))
            bannedList.remove(user);
        else
            bannedList.add(user);
    }
}
