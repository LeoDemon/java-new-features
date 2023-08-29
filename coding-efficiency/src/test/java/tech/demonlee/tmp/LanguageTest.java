package tech.demonlee.tmp;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author Demon.Lee
 * @date 2023-08-29 17:05
 */
public class LanguageTest {

    @Test
    public void isChinese() {
        String a = "123&*)))Hello---";
        String b = "123ni好👌2333";
        String c = "～！@#¥%……&*（）——+國---～@@##";
        containsChinese(a);
        containsChinese(b);
        containsChinese(c);

        System.out.println("a: " + containsChineseCharacter(a));
        System.out.println("b: " + containsChineseCharacter(b));
        System.out.println("c: " + containsChineseCharacter(c));
    }

    private boolean containsChinese(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.UnicodeScript.of(c) == Character.UnicodeScript.HAN) {
                System.out.println(c + "：是中文字符");
                return true;
            }
        }
        System.out.println(str + "：不包含中文字符");
        return false;
    }

    private boolean containsChineseCharacter(String str) {
        if (Objects.isNull(str)) {
            return false;
        }
        return str.codePoints().anyMatch(this::isChineseCharacter);
    }

    private boolean isChineseCharacter(int c) {
        return Character.UnicodeScript.of(c) == Character.UnicodeScript.HAN;
    }
}
