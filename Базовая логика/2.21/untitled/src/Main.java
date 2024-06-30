import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите стоку");
        String str=in.nextLine();
        System.out.println("Введите подстоку");
        String substr=in.nextLine();
        System.out.printf("Подстрока '%s' входит в строку %d раз \n", substr, str.split(substr, -1).length-1);

        System.out.println("Введите стоку");
        String str2=in.nextLine();

        String newstr=str2.replaceAll("бяка", "БАН");
        newstr=newstr.replaceAll("кака", "БАН");
        System.out.printf("Зацензуренное сообщение: %s \n", newstr);

        System.out.println("Введите дату в виде дд.мм.гггг");
        String indate= in.nextLine();
        String[] datepars=indate.split("\\.");
        System.out.printf("%s-%s-%s \n", datepars[2], datepars[1], datepars[0]);


        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = inputFormat.parse(indate);
        String formattedDate = outputFormat.format(date);
        System.out.println("Преобразованная дата: " + formattedDate);
    }
}