package Collections;

import java.util.*;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string 1");
        String str1 = sc.nextLine();
        System.out.println("Enter string 2");
        String str2 = sc.nextLine();

        if(checkAnagram(str1,str2)){
            System.out.println("Anagram");
        }
        else {
            System.out.println("Not Anagram");
        }
    }
    public static boolean checkAnagram(String str1, String str2){
        str1 = str1.replaceAll("\\s","").toLowerCase();
        str2 = str2.replaceAll("\\s","").toLowerCase();

        if(str1.length()!=str2.length()) return false;

        List<Character>list1 = new ArrayList<Character>();
        List<Character>list2 = new ArrayList<Character>();

        for (int i=0;i<str1.length();i++){
            list1.add(str1.charAt(i));
        }
        for (int i=0;i<str2.length();i++){
            list2.add(str2.charAt(i));
        }
        Collections.sort(list1);
        Collections.sort(list2);

        if(list1.equals(list2)) return true;
        else return false;
    }
}
