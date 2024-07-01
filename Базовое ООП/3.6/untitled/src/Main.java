import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        HashMap<Integer, List<User>> users = new HashMap<>();
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
            
            if(users.containsKey(age))
            {
                users.get(age).add(new User(name, age));
            }
            else
            {
                List<User> temp = new ArrayList<>();
                temp.add(new User(name, age));
                users.put(age, temp);
            }
        }

        System.out.println("Введите возраст");
        int age2=in.nextInt();
        in.nextLine();
        List<User> res=users.get(age2);
        if(res!=null)
        {
            res.forEach(System.out::println);
        }
        else
        {
            System.out.println("Нет пользователей такого возраста");
        }

    }
}

class User
{
    private String name;
    private Integer age;

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
