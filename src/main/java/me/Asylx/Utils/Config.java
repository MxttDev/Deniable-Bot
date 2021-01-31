package me.Asylx.Utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Locale;

public class Config {

    public static final Dotenv dotenv = Dotenv.load();

    public static String get(String key) {
        return dotenv.get(key.toUpperCase());
    }
}
