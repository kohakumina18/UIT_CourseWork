package LAB03;
import java.util.ArrayList;
import java.util.List;

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Student extends User {
    private int age;

    public Student(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + age +
                '}';
    }
}

class Lecturer extends User {
    private double salary;

    public Lecturer(int id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class PersonManager<T extends User> {
    private List<T> personList;

    public PersonManager() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(T person) {
        personList.add(person);
    }

    public void displayPersons() {
        for (T person : personList) {
            System.out.println(person);
        }
    }
}

public class GENERIC_cAU03 {
	public static void main(String[] args) {
        PersonManager<Student> studentManager = new PersonManager<>();
        studentManager.addPerson(new Student(1, "John", 20));
        studentManager.addPerson(new Student(2, "Alice", 22));

        PersonManager<Lecturer> lecturerManager = new PersonManager<>();
        lecturerManager.addPerson(new Lecturer(101, "Dr. Smith", 5000));
        lecturerManager.addPerson(new Lecturer(102, "Prof. Johnson", 7000));

        System.out.println("Danh sách sinh viên:");
        studentManager.displayPersons();

        System.out.println("\nDanh sách giảng viên:");
        lecturerManager.displayPersons();
    }
}
