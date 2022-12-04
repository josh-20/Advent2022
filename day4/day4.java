import java.util.Scanner;
import java.io.File;



class day4{
    public static int checkIfContains(String pair1, String pair2){
        String[] range1 = pair1.split("-");
        String[] range2 = pair2.split("-");

        //System.out.println("First pair: " + range1[0] + " , " + range1[1]);
        //System.out.println("Second pair: " + range2[0] + " , " + range2[1]);

        if (Integer.parseInt(range1[0]) <= Integer.parseInt(range2[0]) && Integer.parseInt(range1[1]) >= Integer.parseInt(range2[1])){
            //System.out.println("Pair 2 is inside pair 1");
            return 1;
        }else if (Integer.parseInt(range1[0]) >= Integer.parseInt(range2[0]) && Integer.parseInt(range1[1]) <= Integer.parseInt(range2[1])){
            //System.out.println("Pair 1 is inside pair 2");
            return 1;
        }else{
            return 0;
        } 
    }
    public static int checkForOverlap(String pair1, String pair2){
        String[] range1 = pair1.split("-");
        String[] range2 = pair2.split("-");

        if (Integer.parseInt(range1[1]) < Integer.parseInt(range2[0])){
            //System.out.println("Pair 2 is inside pair 1");
            return 0;
        }else if (Integer.parseInt(range1[0]) > Integer.parseInt(range2[1])){
            //System.out.println("Pair 1 is inside pair 2");
            return 0;
        }else if(Integer.parseInt(range1[0]) < Integer.parseInt(range2[0]) && (Integer.parseInt(range1[1]) <= Integer.parseInt(range2[1]) && Integer.parseInt(range1[1]) >= Integer.parseInt(range2[0]))){
            return 1;
        }else if(Integer.parseInt(range1[1]) > Integer.parseInt(range2[1]) && (Integer.parseInt(range1[0]) <= Integer.parseInt(range2[1]) && Integer.parseInt(range1[0]) >= Integer.parseInt(range2[0]))){
            return 1;
        }else return 1;

    }
    public static void main(String[] args) {
        int fullyContains = 0;
        int overLap = 0;
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] pairs = data.split(",");
                fullyContains += checkIfContains(pairs[0],pairs[1]);
                overLap += checkForOverlap(pairs[0], pairs[1]);
            }
            scanner.close();  
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        System.out.println("pairs: " + fullyContains);
        System.out.println("OverLap pairs: " + overLap);
    }
}