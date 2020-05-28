public class Main {

    public static float calculate(float a, float b, float c, float d){
        return a*(b+(c/d));
    }

    public static boolean compare(int a, int b){
        return ((a+b>=10) && (a+b<=20));
    }

    public static String isPositiveOrNegative(int a){
        return a<0 ? "Отрицательное" : "Положительное";
    }

    public static boolean isNegative(int a){
        return a < 0;
    }

    public static String Hello(String a){
        return "Привет, " + a + "!";
    }

    public static boolean isYearVis(int year){
        return (year % 4 == 0 || year % 400 == 0) && (year % 100 != 0);
    }

    public static void main (String[] args){
        byte varByte;
        short varShort;
        int varInt;
        long varLong;
        float varFloat;
        double varDouble;
        char varChar;
        boolean varBoolean;


        System.out.println("calculate = "+ calculate(1,2,3,4));
        System.out.println("compare = "+ compare(5,100));
        System.out.println("isPositiveOrNegative = "+ isPositiveOrNegative(0));
        System.out.println("isNegative = "+ isNegative(-4));
        System.out.println("Hello = "+ Hello("Петя"));
        int year = 1897;
        System.out.println("isYearVis("+year+") = "+ isYearVis(year));

    }
}

