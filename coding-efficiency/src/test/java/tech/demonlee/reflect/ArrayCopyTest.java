package tech.demonlee.reflect;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Demon.Lee
 * @date 2023-08-05 17:02
 */
@Log4j2
public class ArrayCopyTest {

    @Test
    public void should_failed_copy_array_with_bad_way() {
        String[] aa = new String[]{"Tom", "Dick", "Harry"};
        Object[] bb = badCopyOf(aa, 5);
        log.info("Object[] bb: {}", Arrays.stream(bb).filter(Objects::nonNull).collect(Collectors.toList()));
        // java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast to class [Ljava.lang.String;
        try {
            String[] cc = (String[]) bb;
        } catch (Exception ex) {
            Assertions.assertTrue(ex instanceof ClassCastException);
        }
    }

    @Test
    public void should_copy_array() {
        int[] aa = new int[]{1, 22, 33, 55, 66};
        int[] bb = (int[]) goodeCopyOf(aa, 10);
        log.info("bb is: {}", List.of(bb));

        String[] cc = new String[]{"Tom", "Dick", "Harry"};
        String[] dd = (String[]) goodeCopyOf(cc, 10);
        log.info("dd is: {}", Arrays.stream(dd).filter(Objects::nonNull).collect(Collectors.toList()));
    }

    public static Object goodeCopyOf(Object arr, int newLen) {
        Class<?> clazz = arr.getClass();
        if (!clazz.isArray()) {
            return null;
        }
        Class<?> componentType = clazz.getComponentType();
        log.info("array class: {}, item class: {}", clazz.getName(), componentType.getName());

        // get array length
        int arrLen = Array.getLength(arr);
        // new array by array item's type
        Object newArr = Array.newInstance(componentType, newLen);
        System.arraycopy(arr, 0, newArr, 0, Math.min(arrLen, newLen));
        return newArr;
    }

    public static Object[] badCopyOf(Object[] arr, int newLen) {
        var newArray = new Object[newLen];
        System.arraycopy(arr, 0, newArray, 0, Math.min(arr.length, newLen));
        return newArray;
    }
}
