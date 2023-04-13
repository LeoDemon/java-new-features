package tech.demonlee.tmp;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Demon.Lee
 * @date 2023-04-13 09:32
 */
@Log4j2
public class StreamTest {

    @Test
    public void stream_list_convert_simple() {
        List<Integer> intList = List.of(1, 3, 6, 180, 333);
        List<Integer> expectedList = List.of(2, 6, 12, 360, 666);

        // jdk-8
        List<Integer> outList1 = intList.stream().map(i -> i * 2).collect(Collectors.toList());
        Assertions.assertEquals(expectedList, outList1);
        Assertions.assertDoesNotThrow(() -> outList1.add(9999));

        // jdk-11
        List<Integer> outList2 = intList.stream().map(i -> i * 2).collect(Collectors.toUnmodifiableList());
        Assertions.assertEquals(expectedList, outList2);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> outList2.add(9999));

        // jdk-17
        List<Integer> outList3 = intList.stream().map(i -> i * 2).toList();
        Assertions.assertEquals(expectedList, outList3);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> outList3.add(9999));
    }
}
