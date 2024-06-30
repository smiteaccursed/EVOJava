import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[20];
        int[] un;
        un = new int[16];
        Random random = new Random();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(15) + 1;
            un[arr[i]]++;
        }
        System.out.println(Arrays.toString(arr));
        for(int j=0; j< un.length; j++)
        {
            if(un[j]>1)
                System.out.printf("Число '%d' встречается %d раз \n", j, un[j]);
        }
    }
}