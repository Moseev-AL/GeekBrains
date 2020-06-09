
public class Employee {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int age;
    private double salary;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String fio, String position, String email, String phone, int age, double salary) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
    }

    public void printInfo(){
        System.out.printf("Информация о сотруднике %s:%n", this.getFio());
        System.out.printf("Возраст: %d%n", this.getAge());
        System.out.printf("Должность: %s%n", this.getPosition());
        System.out.printf("Email: %s%n", this.getEmail());
        System.out.printf("Телефон: %s%n", this.getPhone());
        System.out.printf("Зарплата: %5.2f%n", this.getSalary());
        System.out.println();
    }
}