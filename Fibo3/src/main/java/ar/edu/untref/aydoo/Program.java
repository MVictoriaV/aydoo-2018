package ar.edu.untref.aydoo;

import java.util.HashMap;

public class Program {

    protected Program() {
    }

    public static void main(String[] args) {

        args = checkArguments(args);

        HashMap<Integer, String> map = getAMap();
        String option = args[0];

        if (map.containsValue(option)) {
            int limitSuccession = Integer.valueOf(args[1]);

            Integer keyOfOption = getKeyOfOption(map, option);
            boolean isInverted = (keyOfOption == 2 || keyOfOption == 4);

            Fibonacci aFibonacci;

            if (keyOfOption == 1 || keyOfOption == 2) {
                aFibonacci = new Fibonacci(limitSuccession, isInverted);
                SuperFibonacci aVerticalFibonacci = new VerticalFibonacci(aFibonacci);
                String result = aVerticalFibonacci.print();
                System.out.println(result);
            } else {
                aFibonacci = new Fibonacci(limitSuccession, isInverted);
                String result = aFibonacci.print();
                System.out.println(result);
            }
        } else {
            System.out.println("Opciones no validas.");
        }
    }

    private static String[] checkArguments(String[] args) {
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