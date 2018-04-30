package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArgumentValidatorTest {

    @Test
    public void checkArgumentsShouldReturnTrue(){

        ArgumentValidator validator = new ArgumentValidator();

        Boolean isRight = validator.checkArguments(new String[2]);

        Assert.assertTrue(isRight);
    }
}
