import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.List;

public class ruckSack {
    public static int getCharSum(String comp1, String comp2){
        int value = 0;
        for(int i = 0; i < comp1.length(); i++){
            if(comp2.indexOf(comp1.charAt(i)) != -1 ){
                if (Character.isUpperCase(comp1.charAt(i))){
                    value += (int)comp1.charAt(i) - 38;
                    
                }else{
                    value += (int)comp1.charAt(i) - 96;
                }
                break;
            }
        }
        return value;
    }

    public static int locateBadge(String group1, String group2, String group3){
        int value = 0;
        for(int i = 0; i < group1.length(); i++){
            if(group2.indexOf(group1.charAt(i)) != -1 ){
                if (group3.indexOf(group1.charAt(i)) != -1){ 
                    if (Character.isUpperCase(group1.charAt(i))){
                        value += (int)group1.charAt(i) - 38;
                        
                    }else{
                        value += (int)group1.charAt(i) - 96;
                    }
                    break;
                }
            }
        }
        return value;

    }

    public static void main(String[] args) {
        int sum = 0;
        int badgeSum = 0;
        List<String> groups = new ArrayList<>();
        // for uppercase priority we sub 38 from ascii value
        // for lowercase we subtract 96
        try {
            File file = new File("items.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] containers = {data.substring(0,data.length() / 2), data.substring(data.length() / 2 )};
                sum += getCharSum(containers[0],containers[1]);  
                groups.add(data);
                if(groups.size() == 3){
                    badgeSum += locateBadge(groups.get(0), groups.get(1), groups.get(2));
                    groups.clear();
                }
            }           
            scanner.close();
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        System.out.println("Priority Items Sum: " + sum);
        System.out.println("badges Sum: " + badgeSum);
    }    
}


