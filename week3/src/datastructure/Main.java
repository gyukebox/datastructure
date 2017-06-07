package datastructure;

public class Main {

    public static int StringCounter(String s, char target) {
        if(s.length() == 1) {
            if(s.charAt(s.length()-1) == target)
                return 1;
            else return 0;
        } else {
            if(s.charAt(s.length()-1) == target) {
                return 1 + StringCounter(s.substring(0, s.length()-1), target);
            } else {
                return StringCounter(s.substring(0, s.length()-1), target);
            }
        }
    }

    public static int StringCounterBinary(String s, char target) {
        int length = s.length();
        int pivot = s.length()/2;

        if(length == 1) {
            if(s.charAt(0) == target) {
                return 1;
            } else return 0;
        } else {
            return StringCounterBinary(s.substring(0, pivot), target) + StringCounterBinary(s.substring(pivot, length), target);
        }
    }

    public static void main(String[] args) {
        String str = "my mom loves me!";

        try {
            System.out.println(StringCounter(str, 'm'));
        } catch (Exception e) {
            System.out.println("string counter linear error!");
            e.printStackTrace();
        }

        try {
            System.out.println(StringCounterBinary(str, 'm'));
        } catch (Exception e) {
            System.out.println("string counter binary error!");
            e.printStackTrace();
        }

    }

}

