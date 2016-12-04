import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Balaji on 04/12/16.
 */
public class StrungValid implements ConstraintValidator<StringValidator, String>
{


    @Override
    public void initialize(StringValidator stringValidator)
    {

    }

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext)
    {
        return false;
    }
}
