package tech.demonlee.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Demon.Lee
 * @date 2023-08-04 13:36
 */
@Log4j2
public class FileUtilTest {

    private static final String rootPath = "/Users/leostudio/Downloads/vifile/idea-plugin";

    @Test
    public void should_copy_dir_success() {
        Path srcPath = Paths.get(rootPath, "tmp");
        Path destPath = Paths.get(rootPath, "tmp2");
        // FileUtil.copyContent(srcPath, destPath); // cn.hutool.core.io.IORuntimeException: FileAlreadyExistsException:
        // FileUtil.copyContent(srcPath, destPath,
        // StandardCopyOption.REPLACE_EXISTING); // cn.hutool.core.io .IORuntimeException: DirectoryNotEmptyException
        FileUtil.copyContent(srcPath.toFile(), destPath.toFile(), true);
        List<String> fileNames = FileUtil.listFileNames(destPath.toString());
        log.info("---------fileNames: " + fileNames);
    }

    @Test
    public void should_del_dir_success() {
        Path destPath = Paths.get(rootPath, "tmp2");
        FileUtil.del(destPath);
        Assert.isFalse(destPath.toFile().exists());
    }
}
