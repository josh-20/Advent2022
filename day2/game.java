import java.io.File;  
import java.util.Scanner;
public class game {
    public static int game(String p1, String p2){
        int sum = 0;
        if (p1.equals("A") && (p2.equals("Y") || p2.equals("X") || p2.equals("Z"))){
            if(p2.equals("Y"))  sum += 2 + 6;
            if(p2.equals("X"))  sum += 1 + 3;
            if(p2.equals("Z"))  sum += 3 + 0;
        }
        if (p1.equals("B") && (p2.equals("Y") || p2.equals("X") || p2.equals("Z"))){
            if(p2.equals("Y"))  sum += 2 + 3;
            if(p2.equals("X"))  sum += 1 + 0;
            if(p2.equals("Z"))  sum += 3 + 6;
        }
        if (p1.equals("C") && (p2.equals("Y") || p2.equals("X") || p2.equals("Z"))){
            if(p2.equals("Y"))  sum += 2 + 0;
            if(p2.equals("X"))  sum += 1 + 6;
            if(p2.equals("Z"))  sum += 3 + 3;
        }
        return sum;
    }
    // x means to lose
    // Y meands to draw
    //z means to win
    public static int loseGame(String p1, String p2){
        int sum = 0;
        if (p1.equals("A") && (p2.equals("Y") || p2.equals("X") || p2.equals("Z"))){
            if(p2.equals("Y"))  sum += 1 + 3; // tie
            if(p2.equals("X"))  sum += 3 + 0; // lose
            if(p2.equals("Z"))  sum += 2 + 6; // win
        }
        if (p1.equals("B") && (p2.equals("Y") || p2.equals("X") || p2.equals("Z"))){
            if(p2.equals("Y"))  sum += 2 + 3; 
            if(p2.equals("X"))  sum += 1 + 0;
            if(p2.equals("Z"))  sum += 3 + 6;
        }
        if (p1.equals("C") && (p2.equals("Y") || p2.equals("X") || p2.equals("Z"))){
            if(p2.equals("Y"))  sum += 3 + 3;
            if(p2.equals("X"))  sum += 2 + 0;
            if(p2.equals("Z"))  sum += 1 + 6;
        }
        return sum;

    }
    public static void main(String[] args) {
        int score = 0;
        int score2 = 0;
        try {
            File file = new File("puzzle2.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(" ");
                score += game(data[0], data[1]);
                score2 += loseGame(data[0], data[1]);
            }
            scanner.close();
        } catch (Exception e) {
           System.out.println("Something wen wrong with the file");
        }
        System.out.println(score);
        System.out.println(score2);
    }
}
