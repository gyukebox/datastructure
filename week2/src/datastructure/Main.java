package datastructure;

import java.util.Scanner;

public class Main {

    public static int recursiveFactorial(int n) {
        if(n == 1)
            return 1;
        else return n * recursiveFactorial(n-1);
    }

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하시오");
        int input = sc.nextInt();

        System.out.println(input + "! = " + recursiveFactorial(input));
    }
}
