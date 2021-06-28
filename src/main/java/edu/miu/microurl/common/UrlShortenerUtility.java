package edu.miu.microurl.common;

import java.util.Random;

public class UrlShortenerUtility {
    private final Random random = new Random();
    private static final int SHORT_URL_LENGTH = 7;
    private static final String ALLOWED_CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String randomShortUrl() {
        char[] result = new char[SHORT_URL_LENGTH];
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHAR_SET.length() - 1);
            result[i] = ALLOWED_CHAR_SET.charAt(randomIndex);
        }
        return new String(result);
    }

    private static class PlaceHolder {
        private static final UrlShortenerUtility INSTANCE = new UrlShortenerUtility();
    }

    public static UrlShortenerUtility getInstance() {
        return PlaceHolder.INSTANCE;
    }
}
