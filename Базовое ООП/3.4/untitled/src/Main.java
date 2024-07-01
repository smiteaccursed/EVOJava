import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class User
{
    private String name;
    private int age;

    public User(String name, int age)
    {
        this.name=name;
        setAge(age);
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int a)
    {
        if (a>0)
            this.age=a;
        else
        {
            System.out.println("Ошибка ввода, будет присвоин 0 как возраст");
            this.age=0;
        }
    }
    public void setName(String n)
    {
        this.name=n;
    }
    public String toString() {
        String ageString;
        if (age % 100 >= 11 && age % 100 <= 14) {
            ageString = "лет";
        } else {
            ageString = switch (age % 10) {
                case 1 -> "год";
                case 2, 3, 4 -> "года";
                default -> "лет";
            };
        }
        return name + ", " + age + " " + ageString;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        String name1, name2;
        int age1,age2;
        Scanner in= new Scanner(System.in);
        System.out.println("Введите имя первого пользователя");
        name1=in.nextLine();
        System.out.println("Введите возраст первого пользователя");
        age1=in.nextInt();
        in.nextLine();
        System.out.println("Введите имя второго пользователя");
        name2=in.nextLine();
        System.out.println("Введите возраст второго пользователя");
        age2=in.nextInt();
        User user1=new User(name1, age1);
        User user2=new User(name2, age2);

        if (user1.getAge()< user2.getAge())
        {
            System.out.println(user1.toString());
        } else if (user1.getAge()> user2.getAge()) {
            System.out.println(user2.toString());
        }
        else
        {
            System.out.println(user1.toString());
            System.out.println(user2.toString());
        }
    }
}