//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.stream.IntStream;

class ArithmeticProgression {
    
    public static long getArithmeticProgressionSum(int a, int b) {
        return IntStream.range(a, b).asLongStream().sum();
    }
}

public class Main {
    public static void main(String[] args)
    {
        int a=10000000;
        int b=1000000000;
        long result = ArithmeticProgression.getArithmeticProgressionSum(a, b );
        System.out.println("Сумма чисел между " + a + " и " + b + ": " + result);
    }
}

