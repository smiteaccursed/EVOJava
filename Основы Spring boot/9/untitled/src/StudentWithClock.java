
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StudentWithClock extends Student {
    @Override
    public void learn() {
        super.learn();
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Текущее время: " + currentTime);
    }
}