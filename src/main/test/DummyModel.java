import org.hibernate.validator.constraints.Length;

/**
 * Created by Balaji on 04/12/16.
 */
public class DummyModel
{
    @StringValidator.List({@StringValidator(sql = "dummy")})
    @Length.List(
            {@Length(max = 123)}
    )
    private String a;
}
