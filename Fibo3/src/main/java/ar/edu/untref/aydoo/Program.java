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

            Boolean isVertical = keyOfOption == 1 || keyOfOption == 2;

            String succession = giveShapeToFibonacci(aFibonacci, isVertical);
            String output;
            if(writeInFile(args[1])) {
                String nameOfFile = obtainNameFile(args[1]);
                FibonacciWriter fibonacciWriter = new FibonacciWriter();
                String text = obtainTextToPrint(args[2], limitSuccession, succession, aFibonacci, isVertical);
                fibonacciWriter.write(nameOfFile, text);
                output = "fibo<" + limitSuccession + "> guardado en " + nameOfFile;
            } else {
                output = obtainTextToPrint(args[1], limitSuccession, succession, aFibonacci, isVertical);
            }
            System.out.println(output);
        } else {
            System.out.println("Opciones no validas.");
        }
    }

    private static String obtainNameFile(String argument) {
        String[] arrayArgument = argument.split("=");
        return arrayArgument[1];
    }

    private static String giveShapeToFibonacci(Fibonacci aFibonacci, Boolean isVertical) {
        ShapeToFibonacci shapeToFibonacci;
        if (isVertical) {
            shapeToFibonacci = new VerticalFibonacci();
        } else {
            shapeToFibonacci = new HorizontalFibonacci();
        }
        StringBuffer sb = shapeToFibonacci.giveShape(aFibonacci.getSuccession());
        return sb.toString();
    }

    private static String obtainTextToPrint(String argument, Integer limitSuccession, String successionWithShape, Fibonacci aFibonacci, Boolean isVertical) {
        StringBuffer stringBuffer = new StringBuffer();
        if(isModeSummation(argument)) {
            stringBuffer.append("fibo<" + limitSuccession + ">s: ");
            if(isVertical) {
                stringBuffer.append("\n");
            }
            stringBuffer.append(aFibonacci.sumSuccession());
        } else {
            stringBuffer.append("fibo<" + limitSuccession + ">:");
            stringBuffer.append(successionWithShape);
        }

        return stringBuffer.toString();
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