

public class Main {

      public static void main(String[] args) {
          Dog dogTuzik = new Dog("Тузик");
          Cat catBarsik = new Cat("Барсик");

          Dog dogBobik = new Dog("Бобик");
          Cat catCat = new Cat("Кот");

          dogTuzik.run(200);
          dogTuzik.sweem(10);
          catBarsik.run(100);
          catBarsik.sweem(200);

          // Дополнительное ограничение на дистанцию - перегрузка метода run
          dogBobik.run(200, 100);
      }
}
