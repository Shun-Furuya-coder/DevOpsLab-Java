package edu.sjsu;

public class NameChecker {
    /**
     * Checks if a given string is a valid name following these rules:
     * - Between 2 to 40 characters
     * - Contains only alphabetic characters, non-consecutive hyphens, or a single
     * quote
     * - Cannot start with a hyphen or single quote
     *
     * @param input Name to check
     * @return True if input is a valid name, else false
     */
    public static boolean check(String input) {
        // TODO: implement
        // Check if the input is null or its length is out of the allowed range
        if (input == null || input.length() < 2 || input.length() > 40) {
            return false;
        }

        // Check if the input starts with a hyphen or a single quote
        if (input.startsWith("-") || input.startsWith("'")) {
            return false;
        }

        // Check for invalid characters and consecutive hyphens
        boolean previousCharWasHyphen = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // Check for alphabetic characters or allowed punctuation
            if (!(Character.isAlphabetic(c) || c == '-' || c == '\'')) {
                return false;
            }

            // Check for consecutive hyphens
            if (c == '-') {
                if (previousCharWasHyphen) {
                    return false; // Two consecutive hyphens
                }
                previousCharWasHyphen = true;
            } else {
                previousCharWasHyphen = false;
            }
        }

        return true; // If all checks pass, the name is valid
    }
}
