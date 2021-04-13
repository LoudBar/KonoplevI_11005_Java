import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Command {

    String[] aliases();
    String args() default "";
    String description() default "";
}
