package org.riyad;

public class Util {
    public static String toTitleCase(String str) {
        if (str == null || str.isBlank()) {
            return str;
        }
        String[] words = str.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            result += w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase();

            if (i < words.length - 1) {
                result += " ";
            }
        }
        return result;
    }
}
