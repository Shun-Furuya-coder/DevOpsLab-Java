package edu.sjsu;

import java.util.regex.Pattern;

public class NameChecker {
    // 正規表現を使用して名前検証ルールを定義
    // 条件: 2〜40文字、アルファベット、非連続ハイフン、単一のシングルクォート、シングルクォートの前後にアルファベットが必要
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile(
            "^[A-Za-z]+(?:['-][A-Za-z]+)*$");

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
        // nullチェックと長さチェック
        if (input == null || input.length() < 2 || input.length() > 40) {
            return false;
        }
        // 正規表現によるパターンマッチングで名前を検証
        return VALID_NAME_PATTERN.matcher(input).matches();
    }
}
