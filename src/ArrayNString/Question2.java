package ArrayNString;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the first string");
        String str1 = sc1.nextLine();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter the first string");
        String str2 = sc2.nextLine();

        String ans = new String();

        int str1Length = str1.length();
        int str2Length = str2.length();
        int length = Math.min(str1Length,str2Length);

        ans+=str2.charAt(0);
        ans+=str1.charAt(0);

        for(int i=1;i<length;i++){
            ans += str1.charAt(i);
            ans += str2.charAt(i);
        }
        if(str1Length>str2Length){
            for(int i= str2Length; i<str1Length;i++){
                ans += str1.charAt(i);
            }
        }
        if(str2Length>str1Length){
            for(int i= str1Length; i<str2Length;i++){
                ans += str2.charAt(i);
            }
        }
        for(int i=0; i<ans.length();i++){
            System.out.print(ans.charAt(i));
        }
    }
}
