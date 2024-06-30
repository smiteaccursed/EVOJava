import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 3 числа");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if(a%5==0)
            System.out.printf("a=%d", a);
        if(b%5==0)
            System.out.printf("b=%d", b);
        if(c%5==0)
            System.out.printf("c=%d", c);
        if(a%5!=0&&b%5!=0&&c%5!=0)
            System.out.println("Не числа, кратного 5");

        System.out.printf("Результат целочисленного деления a на b: %d \n", a/b);
        System.out.printf("Результат деления a на b: %f \n", (double)a/b);
        System.out.printf("Результат деления a на b с округлением в большую сторону: %d \n", Math.ceilDiv(a, b));
        System.out.printf("Результат деления a на b с округлением в меньшую сторону: %d \n", Math.floorDiv(a, b));
        System.out.printf("Результат деления a на b с математическим округлением: %d \n", Math.round((double)a/b));
        System.out.printf("Остаток от деления b на с: %d \n", b%c);
        System.out.printf("Наименьшее из a и b: %d \n", Math.min(a,b));
        System.out.printf("Наибольшее из b и c: %d \n", Math.max(b,c));

    }
}