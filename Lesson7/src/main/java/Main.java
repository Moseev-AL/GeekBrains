
public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Barsik0", 5);
        cats[1] = new Cat("Barsik1", 15);
        cats[2] = new Cat("Barsik2", 25);
        cats[3] = new Cat("Barsik3", 2);
        cats[4] = new Cat("Barsik4", 7);

        Plate plate = new Plate(50);
        plate.info();
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].eat(plate)){
                System.out.println(cats[i].getName() + " наелся");
            }else {
                System.out.println(cats[i].getName() + " не хватило еды");
            }
        }
        plate.info();

        plate.addFood(30);

        plate.info();
    }
}