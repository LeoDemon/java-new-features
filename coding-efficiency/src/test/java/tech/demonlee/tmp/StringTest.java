package tech.demonlee.tmp;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author Demon.Lee
 * @date 2023-06-12 16:36
 */
@Log4j2
public class StringTest {

    @Test
    public void testIntegerConvert() {
        Integer aa = null;
        String aaa = Objects.toString(aa, null);
        System.out.println("aaa: " + aaa);

        aa = 30;
        aaa = Objects.toString(aa, null);
        System.out.println("aaa: " + aaa);
    }

    @Test
    public void testLineBreak() {
        String lineBreak = System.getProperty("line.separator");
        log.info("lineBreak:[{}]", lineBreak);
    }
}
