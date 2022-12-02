import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class calc{
    public static int sum(List<Elf> list){
        int max = 0;
        for (Elf i : list){
            System.out.println(i.calories);
            int totalCal = i.sum();
            if(totalCal > max){
                max = totalCal;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        List<Integer> calories = new ArrayList<>();
        List<Elf> elfList = new ArrayList<>();
        try{
            File myFile = new File("puzzle1.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.equals("")){
                    for (int i : calories){
                        System.out.println("elf " + i);
                    }
                    System.out.println("--------- Next Elf ----------------");
                    Elf elf = new Elf(calories);
                    elfList.add(elf);
                    calories.clear();
                }else{
                    calories.add(Integer.parseInt(data));

                }
            }
            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("error");
            e.printStackTrace();
        }
        System.out.println(sum(elfList));
    }
}
