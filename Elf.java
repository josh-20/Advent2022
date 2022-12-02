import java.util.List;
class Elf{
    List<Integer> calories;
    Elf(List<Integer> calories){
        this.calories = calories;
    }
    public int sum(){
        int num = 0;
        for (int i : this.calories){
            num += i;
        }
        return num;
    }
}