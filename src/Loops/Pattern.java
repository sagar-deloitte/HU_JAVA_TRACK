package Loops;

import java.util.Scanner;

public class Pattern {
    private static Scanner sc;
    public static void main(String[] args){
        sc= new Scanner(System.in);
        System.out.println("Enter the number of rows you want to print");
        int n =sc.nextInt();
        int i,j,k;
        for(i=1;i<=n;i++){
            for(j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(i=n-1;i>0;i--) {
            for (j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (k= 1; k <=i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
