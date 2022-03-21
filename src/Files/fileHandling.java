package Files;
import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class fileHandling {
    public static void main(String[] args){
        String file = "src\\StudentData.csv";
        String result = "Src\\SelectedStudents.csv";
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));
            while((line= reader.readLine()) != null){
                String[] row = line.split(",");
                for(String index : row){
                    
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(result));
                        writer.write(index);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
