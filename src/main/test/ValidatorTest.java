import org.hibernate.validator.constraints.NotBlank;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

/**
 * Created by Balaji on 03/11/16.
 */
public class ValidatorTest
{
    @NotBlank
    public String name;

    public String notBlankMethod(@NotBlank String a, @NotNull String b)
    {

        System.out.println(a + b);
        return "";
    }

    public static void main(String[] args) throws NoSuchMethodException
    {

        ValidatorTest validatorTest = new ValidatorTest();
        validatorTest.notBlankMethod("3", null);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ValidatorTest>> constraints = validator
                .validate(validatorTest);


        /*
         * constraints.size() > 0
         * If violations size is greater than zero, it has errors
        */
        for (ConstraintViolation<ValidatorTest> constraint : constraints)
        {
            System.out.println(constraint.getPropertyPath() + " :::: " + constraint.getMessage());
        }
    }
}
