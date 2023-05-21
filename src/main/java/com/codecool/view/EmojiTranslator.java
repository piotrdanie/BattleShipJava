package com.codecool.view;

import java.util.HashMap;
import java.util.Map;

public class EmojiTranslator {
    private static final Map<Character, String> translationCharToEmoji;

    static {
        translationCharToEmoji = new HashMap<>();
        translationCharToEmoji.put('#', "🧱");
        translationCharToEmoji.put('@', "🧍");
        translationCharToEmoji.put('&', "🧚");
        translationCharToEmoji.put('!', "👾");
        translationCharToEmoji.put('>', "🚪");
        translationCharToEmoji.put('*', "🍕");
        translationCharToEmoji.put('%', "🔫");
        translationCharToEmoji.put('^', "⚡");
        translationCharToEmoji.put('+', "💎");
        translationCharToEmoji.put('?', "🧛");
        translationCharToEmoji.put('1', "1️⃣");
        translationCharToEmoji.put('2', "2️⃣");
        translationCharToEmoji.put('3', "3️⃣");
        translationCharToEmoji.put(' ', "  ");
    }

    public static String translateCharToEmoji(char character) {
        return translationCharToEmoji.getOrDefault(character, "");
    }

    public static void main(String[] args) {
        char[] characters = {'#', '@', '&', '!', '>', '*', '%', '^', '+', '?', '1', '2', '3', ' '};

        for (char ch : characters) {
            String emoji = translateCharToEmoji(ch);
            System.out.println(ch + " -> " + emoji);
        }
    }
}
