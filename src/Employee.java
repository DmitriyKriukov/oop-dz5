public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String position;
    private int age;

    public Employee(int id, String firstName, String lastName, String position, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ". Имя: " + firstName +
                ", Фамилия: " + lastName +
                ", Должность: " + position +
                ", Возраст: " + age;
    }
}
