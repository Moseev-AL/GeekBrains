public class Cat extends Animal {
    private static int cnt;
    public Cat(String name) {
        super(name);
        cnt++;
        System.out.println("У нас уже " + cnt +" котов");
    }

    @Override
    public void run(int length) {
        if (length <= 200) {
            System.out.println(name + " пробежал " + length + " метров");
        } else {
            System.out.println("Слишком длинная дистанция для " + name);
        }
    }

    @Override
    public void sweem(int length) {
        System.out.println("Кот не умеет плавать");
    }

}