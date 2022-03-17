package ArrayNString;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        int[] arr=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int count = 0;
        int sum = 0;

        for(int i=0;i<n;i++){
            sum =0;
            if(arr[i]<0){
                count++;
            }
            for(int j=i;j<n;j++){
                sum = arr[j]+sum;
                if(sum<0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
