package day1;
import java.io.File;  
import java.util.Scanner;
public class calc{
    public static void main(String[] args) {
        int sum = 0;
        int max = 0;
        int second = 0;
        int third = 0;
        try {
            File file = new File("puzzle1.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                if(data.equals("")){
                    if(sum > max){
                        third = second;
                        second = max;
                        max = sum;
                    }else if(sum > second){
                        third = second;
                        second = sum;
                    }else if(sum > third){
                        third = sum;
                    }
                    sum = 0;
                }else{
                    sum += Integer.parseInt(data);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("File dosen't exist");
        }
        System.out.println(max + second + third);
    }
}
