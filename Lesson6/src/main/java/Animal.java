public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void animalInfo() {
        System.out.println("Животное: " + name);
    }

    public abstract void run(int length);

    public abstract void sweem(int length);

}