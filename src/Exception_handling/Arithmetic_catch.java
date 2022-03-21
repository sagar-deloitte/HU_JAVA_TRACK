package Exception_handling;

import java.util.Scanner;

public class Arithmetic_catch {
    public static void main(String[] args){
        try{
            int num = 100/0;
            System.out.println(num);
        }
        catch (ArithmeticException e){
            System.out.println("Cannot divide by zero");
        }
        finally {
            System.out.println("Thank You !");
        }
    }
}
