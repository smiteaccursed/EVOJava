import java.util.stream.IntStream;
import java.lang.Math;

public class Student implements Learner {
    @Override
    public void learn() {
        System.out.println("Я учусь. .zZ");
        IntStream.range(0, 1000000).forEach(Math::log);
        System.out.println("Я закончил учиться");
    }
}