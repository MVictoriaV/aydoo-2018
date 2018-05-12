package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArgumentValidatorTest {

    @Test
    public void checkArgumentsShouldReturnTrue(){

        ArgumentValidator validator = new ArgumentValidator();
        String[] arguments = new String[]{"-o=vd", "-f=salida.txt", "5"};

        Boolean isRight = validator.checkArguments(arguments);

        Assert.assertTrue(isRight);
    }

    @Test
    public void checkArgumentsWithArgumentsIncorrectShouldReturnFalse(){

        ArgumentValidator validator = new ArgumentValidator();
        String[] arguments = new String[]{"-o=vd", "-f=salida.txt", "5", "NA", "NA"};

        Boolean isRight = validator.checkArguments(arguments);

        Assert.assertFalse(isRight);
    }

    @Test
    public void checkArgumentsWithOnlyAArgumentShouldReturnTrue(){

        ArgumentValidator validator = new ArgumentValidator();
        String[] arguments = new String[]{"5"};

        Boolean isRight = validator.checkArguments(arguments);

        Assert.assertTrue(isRight);
    }

    @Test
    public void checkArgumentsWithTwoArgumentShouldReturnTrue(){

        ArgumentValidator validator = new ArgumentValidator();
        String[] arguments = new String[]{"-o=vi", "5"};

        Boolean isRight = validator.checkArguments(arguments);

        Assert.assertTrue(isRight);
    }
}
