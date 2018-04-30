package ar.edu.untref.aydoo;

import java.util.HashMap;

public class Program {

    protected Program() {
    }

    public static void main(String[] args) {

        boolean isRightArgument = new ArgumentValidator().checkArguments(args);

        if (isRightArgument) {
            args = completeArguments(args);

            HashMap<Integer, String> map = getAMap();
            int limitSuccession = obtainLimitSuccession(args);

            Integer keyOfOption = getKeyOfOption(map, args[0]);
            boolean isInverted = (keyOfOption == 2 || keyOfOption == 4);

            Fibonacci aFibonacci = new Fibonacci(limitSuccession, isInverted);
            printFibonacci(args[1], keyOfOption, aFibonacci);
        } else {
            System.out.println("Opciones no validas.");
        }
    }

    private static void printFibonacci(String argument, Integer keyOfOption, Fibonacci aFibonacci) {
        if (writeInFile(argument)) {

        } else {
            if(isModeSummation(argument)) {
                SumattionFibonacciPrinter sumattionFibonacciPrinter = new SumattionFibonacciPrinter();
                sumattionFibonacciPrinter.print(aFibonacci.getSuccession());
            } else {
                if (keyOfOption == 1 || keyOfOption == 2) {
                    VerticalFibonacciPrinter verticalFibonacciPrinter = new VerticalFibonacciPrinter();
                    verticalFibonacciPrinter.print(aFibonacci.getSuccession());
                } else {
                    HorizontalFibonacciPrinter horizontalFibonacciPrinter = new HorizontalFibonacciPrinter();
                    horizontalFibonacciPrinter.print(aFibonacci.getSuccession());
                }
            }
        }
    }

    private static int obtainLimitSuccession(String[] args) {
        return Integer.valueOf(args[args.length - 1]);
    }

    private static Boolean writeInFile(String arg) {
        return arg.contains("-f");
    }

    private static Boolean isModeSummation(String arg) {
        return arg.contains("-m=s");
    }

    private static String[] completeArguments(String[] args) {
        String[] arguments = args;
        if (arguments.length == 1) {
            String value = args[0];
            arguments = new String[2];
            arguments[0] = "-o=hd";
            arguments[1] = value;

        }
        return arguments;
    }

    private static HashMap<Integer, String> getAMap(){
        HashMap<Integer, String> aMap = new HashMap<>();
        aMap.put(1, "-o=vd");
        aMap.put(2, "-o=vi");
        aMap.put(3, "-o=hd");
        aMap.put(4, "-o=hi");
        return aMap;
    }

    private static Integer getKeyOfOption(HashMap<Integer, String> aMap, String value){
        for (Integer eachKey : aMap.keySet()) {
            if(value.equals(aMap.get(eachKey).toString())){
                return eachKey;
            }
        }
        return null;
    }
}