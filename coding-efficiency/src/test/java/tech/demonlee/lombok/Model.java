package tech.demonlee.lombok;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author Demon.Lee
 * @date 2023-04-13 10:28
 */

// @Setter annotation has been disabled in lombok.config,
// if enable @Setter annotation, will cause an error:  Use of @Setter is flagged according to lombok configuration.
// @Setter
@With
@Getter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(staticName = "of")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Model {
    private Integer id;
    private String name;
    private String type;
}
