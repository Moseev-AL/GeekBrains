

public class Main {

      public static void main(String[] args) {
          Employee[] empArray = new Employee[5];
          empArray[0] = new Employee("Иванов ИИ", "Руководитель", "Ivanov@mail.ru", "+79111234567", 30, 50000);
          empArray[1] = new Employee("Петров АА", "Студент", "Petrov@mail.ru", "+79111234567", 20, 10000);
          empArray[2] = new Employee("Сидоров ББ", "Сотрудник", "Sidirov@mail.ru", "+79111234567", 50, 40000);
          empArray[3] = new Employee("Перцев ВВ", "Инженер", "Percev@mail.ru", "+79111234567", 40, 30000);
          empArray[4] = new Employee("Стручков ГГ", "Студент", "Struchkov@mail.ru", "+79111234567", 35, 20000);

          printEmployes(empArray);
    }

    private static void printEmployes(Employee[] empArray) {
        for (Employee item: empArray) {
            if (item.getAge() >= 40)
                item.printInfo();
        }

    }
}
