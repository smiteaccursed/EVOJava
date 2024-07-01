import java.util.ArrayList;
import java.util.Comparator;
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
        ArrayList<User> users = new ArrayList<>();
        String name;
        int age;
        Scanner in= new Scanner(System.in);

        for(int i=0;i<5; i++)
        {
            System.out.printf("Введите имя %d пользователя: ", i+1);
            name=in.nextLine();
            System.out.printf("Введите возраст %d пользователя: ", i+1);
            age=in.nextInt();
            in.nextLine();
            users.add(new User(name, age));
        }
        users.sort(new Comparator<User>()
        {
            @Override
            public int compare(User u1, User u2) {
                if(u1.getAge()> u2.getAge())
                {
                    return 1;
                } else if (u1.getAge()==u2.getAge())
                {
                    return  0;
                    
                }
                else
                    return -1;
            }
        });
        for(int j=0; j<5; j++)
        {
            System.out.printf("%d) %s \n", j+1, users.get(j).toString());
        }
    }
}