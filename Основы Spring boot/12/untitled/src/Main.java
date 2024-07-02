import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a ;
        double b ;
        Scanner in= new Scanner(System.in);
        System.out.println("Введите a");
        a=in.nextInt();
        in.nextLine();
        System.out.println("Введите b");
        b=in.nextInt();
        in.nextLine();

        Calculator calculator = new Calculator(new Adder());
        System.out.print("Результат a+b: ");
        calculator.calc(a, b);

        calculator = new Calculator(new Subtractor());
        System.out.print("Результат a-b: ");
        calculator.calc(a, b);

        calculator = new Calculator(new Divider());
        System.out.print("Результат a/b: ");
        calculator.calc(a, b);
        calculator = new Calculator(new Multiplier());
        System.out.print("Результат a*b: ");
        calculator.calc(a, b);

    }
}

class Adder implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a + b;
    }
}

class Subtractor implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a - b;
    }
}
class Divider implements Operation{
    @Override
    public double getResult(double a, double b)
    {
        return a/b;
    }
}
class Multiplier implements Operation{
    @Override
    public double getResult(double a, double b)
    {
        return a*b;
    }
}

interface Operation {
    double getResult(double a, double b);
}

class Calculator {
    Operation operation;
    public Calculator(Operation operation) {
        this.operation = operation;
    }
    public void calc(double a, double b) {
        System.out.println(operation.getResult(a, b));
    }
}