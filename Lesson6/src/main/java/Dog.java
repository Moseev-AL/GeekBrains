public class Dog extends Animal{
    private static int cnt;
    public Dog(String name) {
        super(name);
        cnt++;
        System.out.println("У нас уже " + cnt +" котов");
    }

    public void run(int length, int maxLength){
        if (length<= maxLength) {
            System.out.println(name + " пробежал " + length + " метров");
        } else {
            System.out.println("Слишком длинная дистанция для " + name);
        }
    }

    public void run(int length){
        if (length<= 500) {
            System.out.println(name + " пробежал " + length + " метров");
        } else {
            System.out.println("Слишком длинная дистанция для " + name);
        }
    }

    @Override
    public void sweem(int length){
        if (length<= 10) {
            System.out.println(name +" проплыл " + length + " метров");
        } else {
            System.out.println("Слишком длинная дистанция для " + name);
        }
    }
}
