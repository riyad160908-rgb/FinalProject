package org.riyad;

public class Util {

    /**
     * converts a string into title case, first letter of each word is capital,
     * rest is lowercase, space between both words
     * @param str the string
     * @return the string converted into title case
     */
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
