public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n<= food){
        food -= n;
        return true;
        }else {
            return false;
        }

    }
    public void addFood(int n) {
        food += n;
        System.out.println("В тарелку добавлено " + n + " еды");
    }

    public void info() {
        System.out.println("В тарелке " + food + " еды");
    }
}