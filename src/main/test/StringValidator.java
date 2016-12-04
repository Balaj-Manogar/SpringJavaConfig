import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Created by Balaji on 04/12/16.
 */
@Documented
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StrungValid.class)
public @interface StringValidator
{
    public abstract String message() default "Invalid value. This is not permitted.";
    public abstract Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default {};
    public abstract String sql() default "";

    @java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    @java.lang.annotation.Documented
    static @interface List {
        StringValidator[] value();
    }
}
