import java.security.spec.ECPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Company {
    private String name;
    private List<Employee> employeeList;
    private static int id;

    public Company(String name) {
        this.name = name;
        employeeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public String addEmployee(String firstName, String lastName, String position, int age) {
        employeeList.add(new Employee(++id, firstName, lastName, position, age));
        return "Сотрудник добавлен";
    }

    public String showEmployeeList() {
        StringBuilder res = new StringBuilder("Сотрудники компании " + this.name + ":\n");
        if (employeeList.isEmpty()) {
            return "Список сотрудников пуст";
        } else {
            for (Employee employee : employeeList) {
                res.append(employee).append("\n");
            }
        }
        return res.toString();
    }

    public Employee showEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public String removeEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeList.remove(employee);
                return "Сотрудник удален";
            }
        }
        return "Сотрудник не найден";
    }

    public String changeEmployeeFirstName(Employee employee, String firstName) {
        employee.setFirstName(firstName);
        return "Имя изменено";
    }

    public String changeEmployeeLastName(Employee employee, String lastName) {
        employee.setLastName(lastName);
        return "Фамилия изменена";
    }

    public String changeEmployeePosition(Employee employee, String position) {
        employee.setPosition(position);
        return "Должность изменена";
    }

    public String changeEmployeeAge(Employee employee, int age) {
        employee.setAge(age);
        return "Возраст изменен";
    }

}
