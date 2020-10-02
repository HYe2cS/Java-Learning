package runtimeAnnotations;

import java.lang.annotation.*;

/**
 * @author Cay Horstmann
 * @version 1.00 2004-08-17
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor {
    String source();
}
