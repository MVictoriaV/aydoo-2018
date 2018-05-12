package ar.edu.untref.aydoo;

public class ArgumentValidator {

    private final static String OPTION_VD = "-o=vd";
    private final static String OPTION_VI = "-o=vi";
    private final static String OPTION_HD = "-o=hd";
    private final static String OPTION_HI = "-o=hi";

    public Boolean checkArguments(String[] arguments) {
        if (arguments.length == 2) {
            return checkFirstArgument(arguments[0]);
        }
        return arguments.length <= 4;
    }

    private Boolean checkFirstArgument(String firstArgument) {
        return (firstArgument.equals(OPTION_VD) || firstArgument.equals(OPTION_VI) || firstArgument.equals(OPTION_HD) || firstArgument.equals(OPTION_HI));
    }
}