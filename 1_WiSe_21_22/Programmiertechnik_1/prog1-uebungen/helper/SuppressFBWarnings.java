
package helper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Supress FindBugs Warning
 * @author Christopher Mogler
 * @version 03.11.2021
 */
@Retention(RetentionPolicy.CLASS)
public @interface SuppressFBWarnings {
    /**
     * The set of FindBugs warnings that are to be suppressed in
     * annotated element. The value can be a bug category, kind or pattern.
     * @return gibt value zurück
     */
    String[] value() default {};

    /**
     * Optional documentation of the reason why the warning is suppressed
     * @return gibt was zurück
     */
    String justification() default "";
}