import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        // Ввод первой даты
        System.out.println("Введите дату в формате dd.MM.yyyy:");
        String inputDate = scanner.nextLine();
        Date date1 = null;

        date1 = sdf.parse(inputDate);

        // Создание календаря для манипуляций с датой
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);

        // Увеличение даты на 45 дней
        calendar.add(Calendar.DAY_OF_YEAR, 45);
        System.out.println("Дата после увеличения на 45 дней: " + sdf.format(calendar.getTime()));

        // Сдвиг даты на начало года
        calendar.setTime(date1);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        System.out.println("Дата после сдвига на начало года: " + sdf.format(calendar.getTime()));

        calendar.setTime(date1);
        int workingDaysAdded = 0;
        while (workingDaysAdded < 10) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workingDaysAdded++;
            }
        }
        System.out.println("Дата после увеличения на 10 рабочих дней: " + sdf.format(calendar.getTime()));

        System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
        String inputDate2 = scanner.nextLine();
        Date date2 = null;

        date2 = sdf.parse(inputDate2);

        // Подсчет количества рабочих дней между первой и второй датами
        int workingDaysCount = calculateWorkingDays(date1, date2);
        System.out.println("Количество рабочих дней между введенными датами: " + workingDaysCount);

        scanner.close();
    }

    private static int calculateWorkingDays(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(startDate);
        end.setTime(endDate);
        if(start.after(end))
        {
            Calendar temp = start;
            start=end;
            end=temp;
        }

        int workingDays = 0;

        while (start.before(end)) {
            start.add(Calendar.DAY_OF_YEAR, 1);
            int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workingDays++;
            }
        }
        return workingDays;
    }
}
