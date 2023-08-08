package tech.demonlee.file;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Demon.Lee
 * @date 2023-08-08 10:49
 */
@Log4j2
public class FileTest {

    @Test
    public void should_create_tmp_dir() throws IOException {
        Path dir = Files.createTempDirectory("git-clone-");
        log.info("tmp dir: {}", dir);
        Assertions.assertTrue(Files.exists(dir));
        Files.delete(dir);
        Assertions.assertFalse(Files.exists(dir));
    }
}
