package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;

public class Reverse_string {
    public static void main(String[] args){
        List<String> list =new ArrayList<>(Arrays.asList("hashedin"," by"," deloitte","2022"));
        Collections.reverse(list);
        System.out.println(list);
    }
}
